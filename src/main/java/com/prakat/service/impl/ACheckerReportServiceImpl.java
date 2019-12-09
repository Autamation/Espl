package com.prakat.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;

import com.prakat.dao.impl.TenonApiDaoImpl;
import com.prakat.model.ACheckerVo;
import com.prakat.model.AcheckerResultsetVo;

import com.prakat.service.ACheckerService;
import com.prakat.util.EmailSender;

public class ACheckerReportServiceImpl implements ACheckerService {

	@Autowired
	private EmailSender emailSender;

	static Logger logger = Logger.getLogger(ACheckerReportServiceImpl.class.getName());

	@Override
	public List<ACheckerVo> getACheckerReportService(String acheckerRequestAPIUrl, String url, String key)
			throws MalformedURLException, URISyntaxException {

		List<ACheckerVo> acheckerObjs = new ArrayList<ACheckerVo>();
		ACheckerVo acheckerObj = null;
		List<AcheckerResultsetVo> acheckerResultObjs = new ArrayList<AcheckerResultsetVo>();
		AcheckerResultsetVo acheckerResultObj = null;
		BufferedReader rd = null;
		int PRETTY_PRINT_INDENT_FACTOR = 4;

		String urlParameters = "id=" + key + "&uri=" + url + "&output=" + "rest";

		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		InputStream is = null;
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

		try {
			acheckerObj = new ACheckerVo();
			URL url11 = new URL(acheckerRequestAPIUrl);
			HttpURLConnection conn = (HttpURLConnection) url11.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");

			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);

			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(postData);
			// Get Response
			is = conn.getInputStream();
			rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();

			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			// logger.debug("-------reposne from apichecker--" +
			// response.toString());

			JSONObject xmlJSONObj = XML.toJSONObject(response.toString());
			String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			logger.debug(jsonPrettyPrintString);
			JSONObject json = new JSONObject(jsonPrettyPrintString);
			JSONObject json1 = (json.getJSONObject("resultset"));
			JSONObject json2 = (json1.getJSONObject("results"));
			logger.debug(json2);

			JSONArray array = json2.getJSONArray("result");

			for (int i = 0; i < array.length(); i++) {
				acheckerResultObj = new AcheckerResultsetVo();
				acheckerResultObj.setColumnNum((array.getJSONObject(i).getString("columnNum")));
				// logger.debug((array.getJSONObject(i).getString("decisionFail")));
				// logger.debug((array.getJSONObject(i).getString("decisionPass")));
				acheckerResultObj.setErrorMsg((array.getJSONObject(i).getString("errorMsg")));
				acheckerResultObj.setErrorSourceCode((array.getJSONObject(i).getString("errorSourceCode")));
				acheckerResultObj.setLineNum((array.getJSONObject(i).getString("lineNum")));
				acheckerResultObj.setResultType((array.getJSONObject(i).getString("resultType")));
				// logger.debug((array.getJSONObject(i).getString("sequenceID")));
				acheckerResultObjs.add(acheckerResultObj);
			}
			JSONObject summaryObj = (json1.getJSONObject("summary"));

			acheckerObj.setNumOfErrors((summaryObj.getString("NumOfErrors")));
			acheckerObj.setNumOfLikelyProblems((summaryObj.getString("NumOfLikelyProblems")));
			acheckerObj.setNumOfPotentialProblems((summaryObj.getString("NumOfPotentialProblems")));
			acheckerObj.setGuidelines((summaryObj.getString("guidelines")));
			acheckerObj.setSessionID((summaryObj.getString("sessionID")));
			acheckerObj.setStatus((summaryObj.getString("status")));
			acheckerObj.setAchekerObj(acheckerResultObjs);
			acheckerObjs.add(acheckerObj);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}

		return acheckerObjs;

	}

	public void CreateWorkBookForAChecker(List<ACheckerVo> acheckerobjs, HttpServletResponse httpresponse)
			throws IOException, MessagingException {
		Date exclDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		String afileName = "tenon_api" + "_" + dateFormat.format(exclDate) + ".xls";

		// response.setHeader("Content-Disposition", "attachment;
		// filename=\"tenon_api.xls\"");
	//	httpresponse.setHeader("Content-Disposition", "attachment;  filename=" + afileName);

		// create a new Excel sheet
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("AChecker Accesbility Report Details");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		XSSFRow reportHeader = sheet.createRow(0);
		reportHeader.createCell(3).setCellValue("Report Details");
		CellStyle rstyle = workbook.createCellStyle();
		rstyle.setFillForegroundColor(HSSFColor.BROWN.index);
		rstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		rstyle.setBorderBottom((short) 12);
		rstyle.setBorderTop((short) 12);
		rstyle.setWrapText(true);
		rstyle.setFont(font);

		reportHeader.getCell(3).setCellStyle(rstyle);

		int row = 1;
		for (int i = 0; i < acheckerobjs.size(); i++) {
			ACheckerVo vo = acheckerobjs.get(i);
			/* if(vo.getUrl() != null){ */
			XSSFRow reportDetails = sheet.createRow(1);
			reportDetails.createCell(2).setCellValue("Project name:");
			reportDetails.createCell(4).setCellValue("Count of issues by level A:");
			// reportDetails.createCell(5).setCellValue(vo.getCountBylevelA());

			reportDetails.createCell(3).setCellValue("Project name");

			CellStyle pstyle = workbook.createCellStyle();
			pstyle.setFillForegroundColor(HSSFColor.GREEN.index);
			pstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			pstyle.setFont(font);

			CellStyle ustyle = workbook.createCellStyle();
			ustyle.setFillBackgroundColor(HSSFColor.BROWN.index);
			ustyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			reportDetails.getCell(2).setCellStyle(pstyle);
			reportDetails.getCell(4).setCellStyle(pstyle);

			reportDetails.getCell(3).setCellStyle(ustyle);

			XSSFRow urldetails = sheet.createRow(2);
			urldetails.createCell(2).setCellValue("URL:");
			urldetails.createCell(4).setCellValue("Count of issues by level AA:");
			// urldetails.createCell(5).setCellValue(vo.getCountBylevelAA());

			urldetails.getCell(2).setCellStyle(pstyle);
			// urldetails.getCell(4).setCellStyle(pstyle);

			// urldetails.createCell(3).setCellValue(vo.getUrl());
			// urldetails.getCell(3).setCellStyle(ustyle);

			XSSFRow date = sheet.createRow(3);
			date.createCell(2).setCellValue("Date Created:  ");
			date.createCell(4).setCellValue("Count of issues by level AAA:");
			// date.createCell(5).setCellValue(vo.getCountBylevelAAA());

			// date.getCell(2).setCellStyle(pstyle);
			// date.getCell(4).setCellStyle(pstyle);

			// date.createCell(3).setCellValue(vo.getCreateDate());
			// date.getCell(3).setCellStyle(ustyle);

			XSSFRow totaltest = sheet.createRow(4);
			totaltest.createCell(2).setCellValue("Total no of Success criterion:    ");
			totaltest.createCell(4).setCellValue("Total no of Issues ");
			
			XSSFRow failedTest = sheet.createRow(5);

			failedTest.createCell(2).setCellValue("No of Failed criterion:    ");
			failedTest.createCell(4).setCellValue("Total no of Errors ");

			failedTest.getCell(2).setCellStyle(pstyle);

			// failedTest.createCell(3).setCellValue(vo.getFailedTests());
			// failedTest.getCell(3).setCellStyle(ustyle);

			XSSFRow passedTest = sheet.createRow(6);
			passedTest.createCell(2).setCellValue("No of Passed criterion:     ");
			// passedTest.createCell(4).setCellValue("Total no of Warnings ");
			// passedTest.createCell(5).setCellValue(vo.getTotalWarnings());

			passedTest.getCell(2).setCellStyle(pstyle);
			// passedTest.getCell(4).setCellStyle(pstyle);

			// passedTest.createCell(3).setCellValue(vo.getPassedTests());
			// passedTest.getCell(3).setCellStyle(ustyle);

			XSSFSheet pieSheet = workbook.createSheet("Pie Sheet Chart");
			DefaultPieDataset dataset = new DefaultPieDataset();

			dataset.setValue("Total no of success criterion", Integer.parseInt(vo.getNumOfErrors()));
			dataset.setValue("No of failed Criteria", Integer.parseInt(vo.getNumOfLikelyProblems()));
			dataset.setValue("No of passed Criterion", Integer.parseInt(vo.getNumOfPotentialProblems()));

			JFreeChart myPieChart = ChartFactory.createPieChart3D("Report details", dataset, true, true, false);

			int width = 640;
			int height = 480;
			float quality = 1;
			final PiePlot3D plot = (PiePlot3D) myPieChart.getPlot();
			plot.setStartAngle(270);
			plot.setForegroundAlpha(0.60f);
			plot.setInteriorGap(0.02);
			ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
			ChartUtilities.writeChartAsJPEG(chart_out, quality, myPieChart, width, height);

			int my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);
			chart_out.close();
			XSSFDrawing drawing = pieSheet.createDrawingPatriarch();
			ClientAnchor my_anchor = new XSSFClientAnchor();
			my_anchor.setCol1(3);
			my_anchor.setRow1(3);
			XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
			my_picture.resize();

			break;
		}

		XSSFRow header = sheet.createRow(7);

		header.createCell(0).setCellValue("Url");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("column number");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Error message");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("Error Source code");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Line Number");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("Result Type");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Guideline");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("status");
		header.getCell(7).setCellStyle(style);

		// create data rows
		int rowCount = 8;
		List<AcheckerResultsetVo> res = new ArrayList<AcheckerResultsetVo>();
		for (ACheckerVo urlvo : acheckerobjs) {
			XSSFRow aRow = sheet.createRow(rowCount++);

			res = urlvo.getAchekerObj();
			for (AcheckerResultsetVo result : res) {

				aRow = sheet.createRow(rowCount++);
				// aRow.createCell(0).setCellValue(urlvo.getUrl());
				aRow.createCell(1).setCellValue(result.getColumnNum());
				aRow.createCell(2).setCellValue(result.getErrorMsg());

				aRow.createCell(3).setCellValue(result.getErrorSourceCode());
				aRow.createCell(4).setCellValue(result.getLineNum());

				aRow.createCell(5).setCellValue(result.getResultType());
				aRow.createCell(6).setCellValue(urlvo.getGuidelines());

				aRow.createCell(7).setCellValue(urlvo.getStatus());

			}
			
		}

		Date date = new Date();
		String filename = "tenon_api" + "_" + dateFormat.format(exclDate) + ".xls";
		// FileOutputStream o = new FileOutputStream(afileName);
		File xls = new File(filename);
		if (xls.createNewFile()) {
			logger.debug("File is created!"+xls.getAbsolutePath());
		} else {
			logger.debug("File already exists.");
		}
	//	emailSender.sendMail(filename,workbook);
			
		
/*
        FileInputStream in = new FileInputStream(xls);
		OutputStream out = httpresponse.getOutputStream();
		workbook.write(out);
		in.close();
		out.close();*/
				
	}

}
