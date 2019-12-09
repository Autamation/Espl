package com.prakat.service.impl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
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
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import com.java.exception.EQualityLabsException;
import com.prakat.dao.impl.TenonApiDaoImpl;
import com.prakat.model.EQualityLabsVo;
import com.prakat.model.ResultsetVo;
import com.prakat.model.TenonApiVo;
import com.prakat.model.TenonByWCAG;
import com.prakat.response.ResponseURL;
import com.prakat.service.TenonApiReportService;
import com.prakat.util.EQualityLabsUtil;
import com.prakat.util.EmailSender;

public class TenonApiReportServiceImpl implements TenonApiReportService {

	@Autowired
	TenonApiDaoImpl dao;

	@Autowired
	EQualityLabsUtil util;

	@Autowired
	private EmailSender emailSender;

	static Logger logger = Logger.getLogger(TenonApiReportServiceImpl.class.getName());

	public List<TenonByWCAG> getTenonReportServiceByWCAGForFreeUser(String tenonApiURL, String url, String key,
			String emailId, int userId) throws MalformedURLException, URISyntaxException, EQualityLabsException {

		// ResponseURL rs = getLinksFromWeb(url);

		List<TenonByWCAG> tenonByWCAGs = new ArrayList<TenonByWCAG>();
		TenonByWCAG tenonByWCAG = null;
		List<TenonApiVo> tenonApiVos = new ArrayList<TenonApiVo>();
		TenonApiVo tenonApiVo = null;
		List<String> urls = new ArrayList<String>();

		urls.add(url);
		// for (String urlName : rs.getSetOfURL()) {
		// for (String urlName : url) {

		tenonByWCAG = new TenonByWCAG();

		String urlParameters = "key=" + key + "&url=" + url;

		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		try {
			URL url11 = new URL(tenonApiURL);
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
			InputStream is = conn.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();

			JSONObject json = new JSONObject(response.toString());
			JSONObject json1 = (json.getJSONObject("request"));
			logger.debug(json1.getString("url"));
			tenonByWCAG.setUrl(json1.getString("url"));
			JSONArray array = json.getJSONArray("resultSet");
			if (array.length() == 0) {
				tenonApiVo = new TenonApiVo();

				tenonApiVos.add(tenonApiVo);
			} else {
				for (int i = 0; i < array.length(); i++) {
					tenonApiVo = new TenonApiVo();
					String Standards = array.getJSONObject(i).getString("standards").replace("\"", "");
					TenonApiVo tenonApidetails = util.GetDetailsFromWCAG(Standards);
					tenonApiVo.setGuideline_Description(tenonApidetails.getGuideline_Description());
					tenonApiVo.setWCAG_Level(tenonApidetails.getWCAG_Level());
					tenonApiVo.setWCAG_Principle(tenonApidetails.getWCAG_Principle());
					tenonApiVo.setPrinciple_Description(tenonApidetails.getPrinciple_Description());
					tenonApiVo.setWCAG_Sublevel(tenonApidetails.getWCAG_Sublevel());
					tenonApiVo.setSublevel_Description(tenonApidetails.getSublevel_Description());
					tenonApiVo.setWCAG_Criteria(tenonApidetails.getWCAG_Criteria());
					tenonApiVo.setWCAG_Guideline(tenonApidetails.getWCAG_Guideline());
					tenonApiVo.setWCAG_Criteria(
							tenonApidetails.getWCAG_Level() + "." + tenonApidetails.getWCAG_Principle() + "."
									+ tenonApidetails.getWCAG_Guideline() + "_" + tenonApidetails.getWCAG_Sublevel());
					tenonApiVos.add(tenonApiVo);
				}

				logger.debug("printing tenon lists size--" + tenonApiVos.size());
				tenonByWCAG.setResultSetObj(tenonApiVos);
				tenonByWCAG.setUserId(userId);
				JSONObject resultSummary = json.getJSONObject("resultSummary");
				JSONObject issues = resultSummary.getJSONObject("issues");
				tenonByWCAG.setTotalErrors(issues.getString("totalErrors"));
				tenonByWCAG.setTotalIssues(issues.getString("totalIssues"));
				tenonByWCAG.setTotalWarnings(issues.getString("totalWarnings"));

				JSONObject testResult = resultSummary.getJSONObject("tests");
				tenonByWCAG.setTotalNoOfTests(testResult.getString("total"));
				tenonByWCAG.setFailedTests(testResult.getString("failing"));
				tenonByWCAG.setPassedTests(testResult.getString("passing"));

				JSONObject issuesByLevel = resultSummary.getJSONObject("issuesByLevel");
				JSONObject issuesByLevelAA = issuesByLevel.getJSONObject("AA");

				tenonByWCAG.setPctBylevelAA(issuesByLevelAA.getString("pct"));
				tenonByWCAG.setCountBylevelAA(issuesByLevelAA.getString("count"));

				JSONObject issuesByLevelA = issuesByLevel.getJSONObject("A");
				tenonByWCAG.setPctBylevelA(issuesByLevelA.getString("pct"));
				tenonByWCAG.setCountBylevelA(issuesByLevelA.getString("count"));

				JSONObject issuesByLevelAAA = issuesByLevel.getJSONObject("AAA");
				tenonByWCAG.setPctBylevelAAA(issuesByLevelAAA.getString("pct"));
				tenonByWCAG.setCountBylevelAAA(issuesByLevelAAA.getString("count"));
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			logger.debug(dateFormat.format(date)); // 2016/11/16 12:08:43
			dao.saveDetailsOfAllUrl(tenonByWCAG);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			if (e.getMessage().equals("Server returned HTTP response code: 400 for URL: https://tenon.io/api/")) {
				throw new EQualityLabsException("Server returned HTTP response code: 400 for URL: https://tenon.io/api/");  

				/*tenonApiVo = new TenonApiVo();
				tenonApiVos.add(tenonApiVo);
				tenonByWCAG.setUrl("Server returned HTTP response code: 400 for URL: https://tenon.io/api/");
				tenonByWCAG.setResultSetObj(tenonApiVos);*/
			}

			if (e.getMessage().equals("Server returned HTTP response code: 402 for URL: https://tenon.io/api/")) {
				throw new EQualityLabsException("Server returned HTTP response code: 402 for URL: https://tenon.io/api/");  

				/*tenonApiVo = new TenonApiVo();
				tenonApiVos.add(tenonApiVo);
				tenonByWCAG.setUrl("Server returned HTTP response code: 402 for URL: https://tenon.io/api/");
				tenonByWCAG.setResultSetObj(tenonApiVos);*/
			}
			if (e.getMessage().equals("Server returned HTTP response code: 401 for URL: https://tenon.io/api/")) {
				throw new EQualityLabsException("Server returned HTTP response code: 402 for URL: https://tenon.io/api/");  

				/*tenonApiVo = new TenonApiVo();
				tenonApiVos.add(tenonApiVo);
				tenonByWCAG.setUrl("Server returned HTTP response code: 401 for URL: https://tenon.io/api/");
				tenonByWCAG.setResultSetObj(tenonApiVos);*/
			}
		}
		tenonByWCAGs.add(tenonByWCAG);

		return tenonByWCAGs;

	}

	// code for scanning the zero level url,and 1 level url
	public ResponseURL getLinksFromWeb(String url) throws MalformedURLException, URISyntaxException {
		ResponseURL responseToReturn = null;
		List<String> setOfUrl = null;
		try {
			setOfUrl = new ArrayList<String>();
			// url = url.replaceAll(" ", "%20");
			String Domain = getBaseDomain(url);
			responseToReturn = new ResponseURL();

			/*
			 * UrlValidator urlValidator = new UrlValidator();
			 * if(urlValidator.isValid(url)){
			 */
			Document doc = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.timeout(100000).ignoreContentType(true).referrer("http://www.google.com").get();
			Elements elements = doc.select("a");
			for (Element element : elements) {
				// logger.debug("0 level url--" + element.absUrl("href"));
				if (!element.absUrl("href").contains("#") && !element.absUrl("href").equals("")
						&& !setOfUrl.contains(element.absUrl("href")) && !element.absUrl("href").contains("mailto")) {
					String DomainOfZeroLevel = getBaseDomain(element.absUrl("href"));
					if (Domain.equals(DomainOfZeroLevel)) {
						setOfUrl.add(element.absUrl("href"));
					}
				}
			}
			// List<String> firstlevelUrl = new ArrayList<String>(setOfUrl);

			// for (int i = 1; i < firstlevelUrl.size(); i++) {
			/*
			 * String levelFirstUrl = firstlevelUrl.get(i).replaceAll(" ",
			 * "%20"); URL firstLevelUrl = new URL(levelurl); // this would
			 * check for // the protocol firstLevelUrl.toURI(); String
			 * DomainOfFirstLevelUrl = checkDomain(levelFirstUrl);
			 * 
			 * if (Domain.equals(DomainOfFirstLevelUrl)) { doc =
			 * Jsoup.connect(levelFirstUrl)
			 * .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0"
			 * ) .timeout(1000000).referrer("http://www.google.com").
			 * ignoreContentType(true).get(); Elements FirstLevelelements =
			 * doc.select("a"); for (Element element : FirstLevelelements) {
			 * //logger.debug("first Level urls--" + element.absUrl("href")); if
			 * (!element.absUrl("href").contains("#") &&
			 * !element.absUrl("href").equals("") &&
			 * !setOfUrl.contains(element.absUrl("href")) &&
			 * !element.absUrl("href").contains("mailto")) {
			 * setOfUrl.add(element.absUrl("href")); }
			 * 
			 * } }
			 * 
			 * 
			 */
			// }
			for (int i = 0; i < setOfUrl.size(); i++) {
				logger.debug("---list elements-------" + setOfUrl.get(i));
			}
			logger.debug("-----------" + setOfUrl.size());
			responseToReturn.setSetOfURL(setOfUrl);
			responseToReturn.setSize(setOfUrl.size());

		}

		catch (MalformedURLException e) {
			e.printStackTrace();

		}

		catch (HttpStatusException e) {
			e.printStackTrace();
		} catch (IOException e) {

			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return responseToReturn;

	}

	/*
	 * private String checkDomain(String url) { // TODO Auto-generated method
	 * stub String domain = ""; try { URI uri = new URI(url); domain =
	 * uri.getHost(); } catch(URISyntaxException e) { domain ="illegal"; }
	 * return domain.startsWith("www.") ? domain.substring(4) : domain; }
	 */

	public static String getHost(String url) {
		if (url == null || url.length() == 0)
			return "";

		int doubleslash = url.indexOf("//");
		if (doubleslash == -1)
			doubleslash = 0;
		else
			doubleslash += 2;

		int end = url.indexOf('/', doubleslash);
		end = end >= 0 ? end : url.length();

		int port = url.indexOf(':', doubleslash);
		end = (port > 0 && port < end) ? port : end;

		return url.substring(doubleslash, end);
	}

	public static String getBaseDomain(String url) {
		String host = getHost(url);

		int startIndex = 0;
		int nextIndex = host.indexOf('.');
		int lastIndex = host.lastIndexOf('.');
		while (nextIndex < lastIndex) {
			startIndex = nextIndex + 1;
			nextIndex = host.indexOf('.', startIndex);
		}
		if (startIndex > 0) {
			return host.substring(startIndex);
		} else {
			return host;
		}
	}

	public void CreateWorkBook(List<EQualityLabsVo> equalityLabs, HttpServletResponse response) throws IOException {
		// response.setHeader("Content-Disposition", "attachment;
		// filename=\"tenon_api.xls\"");

		// create a new Excel sheet
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Tenon Accesbility Report Details");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		// font.setFontHeight((short)(7.5*20));
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

		for (int i = 0; i < equalityLabs.size(); i++) {
			EQualityLabsVo vo = equalityLabs.get(i);
			if (vo.getUrl() != null) {
				XSSFRow reportDetails = sheet.createRow(1);
				reportDetails.createCell(2).setCellValue("Project name:");
				reportDetails.createCell(4).setCellValue("Count of issues by level A:");
				reportDetails.createCell(5).setCellValue(vo.getCountBylevelA());

				reportDetails.createCell(3).setCellValue("EQuality Project");

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
				urldetails.createCell(5).setCellValue(vo.getCountBylevelAA());

				urldetails.getCell(2).setCellStyle(pstyle);
				urldetails.getCell(4).setCellStyle(pstyle);

				urldetails.createCell(3).setCellValue(vo.getUrl());
				urldetails.getCell(3).setCellStyle(ustyle);

				XSSFRow date = sheet.createRow(3);
				date.createCell(2).setCellValue("Date Created:  ");
				date.createCell(4).setCellValue("Count of issues by level AAA:");
				date.createCell(5).setCellValue(vo.getCountBylevelAAA());

				date.getCell(2).setCellStyle(pstyle);
				date.getCell(4).setCellStyle(pstyle);

				date.createCell(3).setCellValue(vo.getCreateDate());

				date.getCell(3).setCellStyle(ustyle);

				XSSFRow totaltest = sheet.createRow(4);
				totaltest.createCell(2).setCellValue("Total no of Success criterion:    ");
				totaltest.createCell(4).setCellValue("Total no of Issues ");
				totaltest.createCell(5).setCellValue(vo.getTotalIssues());

				totaltest.getCell(2).setCellStyle(pstyle);
				totaltest.getCell(4).setCellStyle(pstyle);

				totaltest.createCell(3).setCellValue(vo.getTotalNoOfTests());
				totaltest.getCell(3).setCellStyle(ustyle);

				XSSFRow failedTest = sheet.createRow(5);

				failedTest.createCell(2).setCellValue("No of Failed criterion:    ");
				failedTest.createCell(4).setCellValue("Total no of Errors ");
				failedTest.createCell(5).setCellValue(vo.getTotalErrors());

				failedTest.getCell(2).setCellStyle(pstyle);
				failedTest.getCell(4).setCellStyle(pstyle);

				failedTest.createCell(3).setCellValue(vo.getFailedTests());
				failedTest.getCell(3).setCellStyle(ustyle);

				XSSFRow passedTest = sheet.createRow(6);
				passedTest.createCell(2).setCellValue("No of Passed criterion:     ");
				passedTest.createCell(4).setCellValue("Total no of Warnings ");
				passedTest.createCell(5).setCellValue(vo.getTotalWarnings());

				passedTest.getCell(2).setCellStyle(pstyle);
				passedTest.getCell(4).setCellStyle(pstyle);

				passedTest.createCell(3).setCellValue(vo.getPassedTests());
				passedTest.getCell(3).setCellStyle(ustyle);

				break;
			}
		}

		XSSFRow header = sheet.createRow(7);

		header.createCell(0).setCellValue("Url");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("ErrorDescription");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("WCAG Standards");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("ErrorSnippet");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Position");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("ResultTitle");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Priority");
		header.getCell(6).setCellStyle(style);

		// create data rows
		int rowCount = 8;
		List<ResultsetVo> res = new ArrayList<ResultsetVo>();
		for (EQualityLabsVo urlvo : equalityLabs) {
			XSSFRow aRow = sheet.createRow(rowCount++);

			if (urlvo.getUrl() != null) {
				res = urlvo.getResultSetObj();
				for (ResultsetVo result : res) {

					aRow = sheet.createRow(rowCount++);
					aRow.createCell(0).setCellValue(urlvo.getUrl());
					aRow.createCell(1).setCellValue(result.getErrorDescription());
					aRow.createCell(2).setCellValue(result.getStandards());

					aRow.createCell(3).setCellValue(result.getErrorSnippet());
					aRow.createCell(4).setCellValue(result.getPosition());

					aRow.createCell(5).setCellValue(result.getResultTitle());

					aRow.createCell(6).setCellValue(result.getPriority());

				}

			} else {

				aRow.createCell(0).setCellValue("");
				aRow.createCell(1).setCellValue("");
				aRow.createCell(2).setCellValue("");
				aRow.createCell(3).setCellValue("");
				aRow.createCell(4).setCellValue("");
				aRow.createCell(5).setCellValue("");
				aRow.createCell(6).setCellValue("");
				aRow.createCell(7).setCellValue("");

			}
		}

		File xls = new File("tenon_api.xls");
		FileInputStream in = new FileInputStream(xls);
		OutputStream out = response.getOutputStream();
		workbook.write(out);
		in.close();
		out.close();

	}

	public boolean CreateMultipleWorkBookByWCAG(List<TenonByWCAG> tenonByWCAGs, HttpServletRequest request,
			HttpServletResponse response, String emailId) throws IOException {
		Date exclDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		// create a new Excel sheet
		XSSFWorkbook workbook = new XSSFWorkbook();

		CellStyle wstyle = workbook.createCellStyle();
		Font wfont = workbook.createFont();
		wfont.setFontName("Arial");
		wstyle.setFillForegroundColor(HSSFColor.BLUE.index);
		wstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		wfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		wfont.setColor(HSSFColor.WHITE.index);
		wstyle.setFont(wfont);

		boolean isMailSent = false;
		for (int i = 0; i < tenonByWCAGs.size(); i++) {
			TenonByWCAG vo = tenonByWCAGs.get(i);
			XSSFSheet Excelsheet = workbook.createSheet("Accessibility_Issues" + "_" + i + dateFormat.format(exclDate));

			if (vo.getUrl() != null) {
				Excelsheet.setDefaultColumnWidth(30);
				// create style for header cells
				CellStyle style = workbook.createCellStyle();
				Font font = workbook.createFont();
				font.setFontName("Arial");
				style.setFillForegroundColor(HSSFColor.BLUE.index);
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				font.setColor(HSSFColor.WHITE.index);
				style.setFont(font);
				Excelsheet.autoSizeColumn(50);
				Excelsheet.setColumnWidth(0, 10000);
				Excelsheet.setColumnWidth(1, 10000);
				Excelsheet.setColumnWidth(2, 7000);
				Excelsheet.setColumnWidth(3, 7000);
				Excelsheet.setColumnWidth(4, 7000);
				Excelsheet.setColumnWidth(5, 7000);
				Excelsheet.setColumnWidth(6, 7000);
				Excelsheet.setColumnWidth(7, 7000);
				Excelsheet.setColumnWidth(8, 7000);
				Excelsheet.setColumnWidth(9, 7000);
				Excelsheet.setColumnWidth(10, 7000);

				// create header row
				XSSFRow reportHeader = Excelsheet.createRow(0);
				reportHeader.createCell(3).setCellValue("Report Details");
				CellStyle rstyle = workbook.createCellStyle();
				rstyle.setFillForegroundColor(HSSFColor.BROWN.index);
				rstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				rstyle.setBorderBottom((short) 12);
				rstyle.setBorderTop((short) 12);
				rstyle.setWrapText(true);
				rstyle.setFont(font);

				reportHeader.getCell(3).setCellStyle(rstyle);
				XSSFRow reportDetails = Excelsheet.createRow(1);
				reportDetails.createCell(2).setCellValue("Project name:");
				reportDetails.createCell(4).setCellValue("Count of issues by level A:");
				reportDetails.createCell(5).setCellValue(vo.getCountBylevelA());

				reportDetails.createCell(3).setCellValue("EQuality Labs");

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

				XSSFRow urldetails = Excelsheet.createRow(2);
				urldetails.createCell(2).setCellValue("URL:");
				urldetails.createCell(4).setCellValue("Count of issues by level AA:");
				urldetails.createCell(5).setCellValue(vo.getCountBylevelAA());
				urldetails.getCell(2).setCellStyle(pstyle);
				urldetails.getCell(4).setCellStyle(pstyle);
				urldetails.createCell(3).setCellValue(vo.getUrl());
				urldetails.getCell(3).setCellStyle(ustyle);

				XSSFRow date = Excelsheet.createRow(3);
				date.createCell(2).setCellValue("Date Created:  ");
				date.createCell(4).setCellValue("Count of issues by level AAA:");
				date.createCell(5).setCellValue(vo.getCountBylevelAAA());
				date.getCell(2).setCellStyle(pstyle);
				date.getCell(4).setCellStyle(pstyle);
				// date.createCell(3).setCellValue(vo.getCreateDate());
				date.createCell(3).setCellValue(dateFormat.format(exclDate));
				date.getCell(3).setCellStyle(ustyle);

				XSSFRow totaltest = Excelsheet.createRow(4);
				totaltest.createCell(2).setCellValue("Total no of Success criterion:    ");
				totaltest.createCell(4).setCellValue("Total no of Issues ");
				totaltest.createCell(5).setCellValue(vo.getTotalIssues());
				totaltest.getCell(2).setCellStyle(pstyle);
				totaltest.getCell(4).setCellStyle(pstyle);
				totaltest.createCell(3).setCellValue(vo.getTotalNoOfTests());
				totaltest.getCell(3).setCellStyle(ustyle);

				XSSFRow failedTest = Excelsheet.createRow(5);

				failedTest.createCell(2).setCellValue("No of Failed criterion:    ");
				failedTest.createCell(4).setCellValue("Total no of Errors ");
				failedTest.createCell(5).setCellValue(vo.getTotalErrors());
				failedTest.getCell(2).setCellStyle(pstyle);
				failedTest.getCell(4).setCellStyle(pstyle);
				failedTest.createCell(3).setCellValue(vo.getFailedTests());
				failedTest.getCell(3).setCellStyle(ustyle);

				XSSFRow passedTest = Excelsheet.createRow(6);
				passedTest.createCell(2).setCellValue("No of Passed criterion:     ");
				passedTest.createCell(4).setCellValue("Total no of Warnings ");
				passedTest.createCell(5).setCellValue(vo.getTotalWarnings());
				passedTest.getCell(2).setCellStyle(pstyle);
				passedTest.getCell(4).setCellStyle(pstyle);
				passedTest.createCell(3).setCellValue(vo.getPassedTests());
				passedTest.getCell(3).setCellStyle(ustyle);

				XSSFRow header = Excelsheet.createRow(7);

				header.createCell(0).setCellValue("Url");
				header.getCell(0).setCellStyle(style);

				header.createCell(1).setCellValue("WCAG Criteria");
				header.getCell(1).setCellStyle(style);

				header.createCell(2).setCellValue("Level");
				header.getCell(2).setCellStyle(style);

				header.createCell(3).setCellValue("WCAG Principle");
				header.getCell(3).setCellStyle(style);

				header.createCell(4).setCellValue("Principle description");
				header.getCell(4).setCellStyle(style);

				header.createCell(5).setCellValue("WCAG Guideline");
				header.getCell(5).setCellStyle(style);

				header.createCell(6).setCellValue("Guideline Description");
				header.getCell(6).setCellStyle(style);

				header.createCell(7).setCellValue("WCAG_Sublevel");
				header.getCell(7).setCellStyle(style);

				header.createCell(8).setCellValue("Sublevel Description");
				header.getCell(8).setCellStyle(style);
				// create data rows
				int rowCount = 8;
				List<TenonApiVo> res = vo.getResultSetObj();
				XSSFRow aRow = Excelsheet.createRow(rowCount++);
				if (vo.getUrl() != null && res!=null) {
					for (TenonApiVo result : res) {
						aRow = Excelsheet.createRow(rowCount++);
						aRow.createCell(0).setCellValue(vo.getUrl());
						aRow.createCell(1).setCellValue(result.getWCAG_Criteria());
						aRow.createCell(2).setCellValue(result.getWCAG_Level());
						aRow.createCell(3).setCellValue(result.getWCAG_Principle());
						aRow.createCell(4).setCellValue(result.getPrinciple_Description());
						aRow.createCell(5).setCellValue(result.getWCAG_Guideline());
						aRow.createCell(6).setCellValue(result.getGuideline_Description());
						aRow.createCell(7).setCellValue(result.getWCAG_Sublevel());
						aRow.createCell(8).setCellValue(result.getSublevel_Description());

					}

				} else {
					// XSSFRow aRow = Excelsheet.createRow(rowCount++);

					aRow.createCell(0).setCellValue("");
					aRow.createCell(1).setCellValue("");
					aRow.createCell(2).setCellValue("");
					aRow.createCell(3).setCellValue("");
					aRow.createCell(4).setCellValue("");
					aRow.createCell(5).setCellValue("");
					aRow.createCell(6).setCellValue("");
					aRow.createCell(7).setCellValue("");

				}
				XSSFSheet pieSheet = workbook.createSheet("Pie Sheet for " + i + "_" + dateFormat.format(exclDate));

				CellStyle estyle = workbook.createCellStyle();
				estyle.setFillForegroundColor(HSSFColor.LAVENDER.index);
				estyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				estyle.setFont(font);

				CellStyle istyle = workbook.createCellStyle();
				istyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
				istyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				istyle.setFont(font);

				CellStyle kstyle = workbook.createCellStyle();
				kstyle.setFillForegroundColor(HSSFColor.OLIVE_GREEN.index);
				kstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				kstyle.setFont(font);

				int count = 28;
				XSSFRow row = pieSheet.createRow(count++);
				row.createCell(4).setCellValue("totalErrors");
				row.getCell(4).setCellStyle(estyle);
				row.createCell(5).setCellValue(vo.getTotalErrors());

				row = pieSheet.createRow(count++);
				row.createCell(4).setCellValue("totalIssues");
				row.getCell(4).setCellStyle(istyle);
				row.createCell(5).setCellValue(vo.getTotalIssues());

				row = pieSheet.createRow(count++);
				row.createCell(4).setCellValue("totalWarning");
				row.getCell(4).setCellStyle(wstyle);
				row.createCell(5).setCellValue(vo.getTotalWarnings());

				DefaultPieDataset dataset = createPieChartForProUser(tenonByWCAGs);
				JFreeChart myPieChart = ChartFactory.createPieChart3D("Report details", dataset, true, true, true);
				int width = 640;
				int height = 480;
				float quality = 1;
				final PiePlot3D plot = (PiePlot3D) myPieChart.getPlot();
				// PiePlot plot = (PiePlot) myPieChart.getPlot();
				plot.setSimpleLabels(true);
				plot.setStartAngle(270);
				plot.setForegroundAlpha(0.60f);
				plot.setInteriorGap(0.02);
				plot.setLabelGenerator(new StandardPieSectionLabelGenerator(" {2}", NumberFormat.getNumberInstance(),
						NumberFormat.getPercentInstance()));

				ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
				ChartUtilities.writeChartAsJPEG(chart_out, quality, myPieChart, width, height);

				BufferedImage bufferedImage = myPieChart.createBufferedImage(width, height);
				saveToFile(bufferedImage, request);

				chart_out.close();

				int my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);
				chart_out.close();
				XSSFDrawing drawing = pieSheet.createDrawingPatriarch();
				ClientAnchor my_anchor = new XSSFClientAnchor();
				my_anchor.setCol1(3);
				my_anchor.setRow1(3);
				XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
				my_picture.resize();

			}

		}
		// DefaultPieDataset dataset = createPieChartForProUser(tenonByWCAGs);
		DefaultCategoryDataset dataset1 = createBarChartForProUser(tenonByWCAGs);

		JFreeChart barChart = ChartFactory.createBarChart("Accessibity issues summary", "error statistic", "Issues",
				dataset1, PlotOrientation.VERTICAL, true, true, false);
		int width1 = 640; /* Width of the image */
		int height1 = 480; /* Height of the image */
		File BarChart = new File("BarChartReport.jpeg");
		ChartUtilities.saveChartAsJPEG(BarChart, barChart, width1, height1);
		BufferedImage bufferedImage1 = barChart.createBufferedImage(width1, height1);
		savebarChartToFile(bufferedImage1, request);

		String filename = "tenon_api" + "_" + dateFormat.format(exclDate) + ".xls";
		// FileOutputStream o = new FileOutputStream(afileName);
		File xls = new File(filename);
		if (xls.createNewFile()) {
			logger.debug("File is created!");
		} else {
			logger.debug("File already exists.");
		}

		isMailSent = emailSender.sendMail(filename, workbook, emailId);
		return isMailSent;

	}

	public boolean CreateWorkBookByWCAGForFreeUser(List<TenonByWCAG> tenonApisList, HttpServletRequest request,
			HttpServletResponse response, String emailId) throws IOException {
		Date exclDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		// create a new Excel sheet
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Tenon Accesbility Report Details");
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
		sheet.autoSizeColumn(50);
		sheet.setColumnWidth(0, 10000);
		sheet.setColumnWidth(1, 10000);
		sheet.setColumnWidth(2, 7000);
		sheet.setColumnWidth(3, 7000);
		sheet.setColumnWidth(4, 7000);
		sheet.setColumnWidth(5, 7000);
		sheet.setColumnWidth(6, 7000);
		sheet.setColumnWidth(7, 7000);
		sheet.setColumnWidth(8, 7000);
		sheet.setColumnWidth(9, 7000);
		sheet.setColumnWidth(10, 7000);

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

		for (int i = 0; i < tenonApisList.size(); i++) {
			TenonByWCAG vo = tenonApisList.get(i);
			if (vo.getUrl() != null) {
				XSSFRow reportDetails = sheet.createRow(1);
				reportDetails.createCell(2).setCellValue("Project name:");
				reportDetails.createCell(4).setCellValue("Count of issues by level A:");
				reportDetails.createCell(5).setCellValue(vo.getCountBylevelA());

				reportDetails.createCell(3).setCellValue("EQuality Labs");

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
				urldetails.createCell(5).setCellValue(vo.getCountBylevelAA());
				urldetails.getCell(2).setCellStyle(pstyle);
				urldetails.getCell(4).setCellStyle(pstyle);
				urldetails.createCell(3).setCellValue(vo.getUrl());
				urldetails.getCell(3).setCellStyle(ustyle);

				XSSFRow date = sheet.createRow(3);
				date.createCell(2).setCellValue("Date Created:  ");
				date.createCell(4).setCellValue("Count of issues by level AAA:");
				date.createCell(5).setCellValue(vo.getCountBylevelAAA());
				date.getCell(2).setCellStyle(pstyle);
				date.getCell(4).setCellStyle(pstyle);
				// date.createCell(3).setCellValue(vo.getCreateDate());
				date.createCell(3).setCellValue(dateFormat.format(exclDate));
				date.getCell(3).setCellStyle(ustyle);

				XSSFRow totaltest = sheet.createRow(4);
				totaltest.createCell(2).setCellValue("Total no of Success criterion:    ");
				totaltest.createCell(4).setCellValue("Total no of Issues ");
				totaltest.createCell(5).setCellValue(vo.getTotalIssues());
				totaltest.getCell(2).setCellStyle(pstyle);
				totaltest.getCell(4).setCellStyle(pstyle);
				totaltest.createCell(3).setCellValue(vo.getTotalNoOfTests());
				totaltest.getCell(3).setCellStyle(ustyle);

				XSSFRow failedTest = sheet.createRow(5);
				failedTest.createCell(2).setCellValue("No of Failed criterion:    ");
				failedTest.createCell(4).setCellValue("Total no of Errors ");
				failedTest.createCell(5).setCellValue(vo.getTotalErrors());
				failedTest.getCell(2).setCellStyle(pstyle);
				failedTest.getCell(4).setCellStyle(pstyle);
				failedTest.createCell(3).setCellValue(vo.getFailedTests());
				failedTest.getCell(3).setCellStyle(ustyle);

				XSSFRow passedTest = sheet.createRow(6);
				passedTest.createCell(2).setCellValue("No of Passed criterion:     ");
				passedTest.createCell(4).setCellValue("Total no of Warnings ");
				passedTest.createCell(5).setCellValue(vo.getTotalWarnings());
				passedTest.getCell(2).setCellStyle(pstyle);
				passedTest.getCell(4).setCellStyle(pstyle);
				passedTest.createCell(3).setCellValue(vo.getPassedTests());
				passedTest.getCell(3).setCellStyle(ustyle);

				// workbook = new XSSFWorkbook();
				XSSFSheet pieSheet = workbook.createSheet("Pie Sheet" + "_" + i + dateFormat.format(exclDate));
				sheet.setColumnWidth(0, 10000);

				CellStyle estyle = workbook.createCellStyle();
				estyle.setFillForegroundColor(HSSFColor.LAVENDER.index);
				estyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				estyle.setFont(font);

				CellStyle istyle = workbook.createCellStyle();
				istyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
				istyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				istyle.setFont(font);

				CellStyle wstyle = workbook.createCellStyle();
				wstyle.setFillForegroundColor(HSSFColor.BROWN.index);
				wstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				wstyle.setFont(font);

				int rowCount = 28;
				XSSFRow aRow = pieSheet.createRow(rowCount++);
				aRow.createCell(4).setCellValue("totalErrors");
				aRow.getCell(4).setCellStyle(estyle);
				aRow.createCell(5).setCellValue(vo.getTotalErrors());

				aRow = pieSheet.createRow(rowCount++);
				aRow.createCell(4).setCellValue("totalIssues");
				aRow.getCell(4).setCellStyle(istyle);
				aRow.createCell(5).setCellValue(vo.getTotalIssues());

				aRow = pieSheet.createRow(rowCount++);
				aRow.createCell(4).setCellValue("totalWarning");
				aRow.getCell(4).setCellStyle(wstyle);
				aRow.createCell(5).setCellValue(vo.getTotalWarnings());

				DefaultPieDataset dataset = new DefaultPieDataset();
				dataset.setValue("Total no of success criterion", ((vo.getTotalNoOfTests()) != null ? Integer.parseInt(vo.getTotalNoOfTests()) : 0));
				dataset.setValue("No of failed test", ((vo.getFailedTests()) != null ? Integer.parseInt(vo.getFailedTests()) : 0));
				dataset.setValue("No of passed test", ((vo.getPassedTests()) != null ? Integer.parseInt(vo.getPassedTests()) : 0));
				
				pieSheet.autoSizeColumn(50);
				JFreeChart myPieChart = ChartFactory.createPieChart3D("Report details", dataset, true, true, true);

				int width = 640;
				int height = 480;
				float quality = 1;
				final PiePlot plot = (PiePlot) myPieChart.getPlot();
				plot.setStartAngle(270);
				plot.setForegroundAlpha(0.60f);
				plot.setInteriorGap(0.02);
				plot.setLabelGenerator(new StandardPieSectionLabelGenerator(" {2}", NumberFormat.getNumberInstance(),
						NumberFormat.getPercentInstance()));

				ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
				ChartUtilities.writeChartAsJPEG(chart_out, quality, myPieChart, width, height);

				/*
				 * File imageFile = new File("E:\\LineChart.png");
				 * ChartUtilities.saveChartAsJPEG((imageFile), myPieChart, 400,
				 * 300);
				 */
				BufferedImage bufferedImage = myPieChart.createBufferedImage(width, height);
				saveToFile(bufferedImage, request);
				int my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);
				chart_out.close();
				XSSFDrawing drawing = pieSheet.createDrawingPatriarch();
				ClientAnchor my_anchor = new XSSFClientAnchor();
				my_anchor.setCol1(3);
				my_anchor.setRow1(3);
				XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
				my_picture.resize();

				// break;
			}
		}

		XSSFRow header = sheet.createRow(7);

		header.createCell(0).setCellValue("Url");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("WCAG Criteria");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Level");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("WCAG Principle");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Principle description");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("WCAG Guideline");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Guideline Description");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("WCAG_Sublevel");
		header.getCell(7).setCellStyle(style);

		header.createCell(8).setCellValue("Sublevel Description");
		header.getCell(8).setCellStyle(style);
		// create data rows
		int rowCount = 8;
		List<TenonApiVo> res = new ArrayList<TenonApiVo>();
		for (TenonByWCAG urlvo : tenonApisList) {
			XSSFRow aRow = sheet.createRow(rowCount++);
			res = urlvo.getResultSetObj();

			if (urlvo.getUrl() != null && res !=null) {
				for (TenonApiVo result : res) {

					aRow = sheet.createRow(rowCount++);
					aRow.createCell(0).setCellValue(urlvo.getUrl());
					aRow.createCell(1).setCellValue(result.getWCAG_Criteria());
					aRow.createCell(2).setCellValue(result.getWCAG_Level());

					aRow.createCell(3).setCellValue(result.getWCAG_Principle());
					aRow.createCell(4).setCellValue(result.getPrinciple_Description());

					aRow.createCell(5).setCellValue(result.getWCAG_Guideline());
					aRow.createCell(6).setCellValue(result.getGuideline_Description());

					aRow.createCell(7).setCellValue(result.getWCAG_Sublevel());
					aRow.createCell(8).setCellValue(result.getSublevel_Description());

				}
				

			} else {

				aRow.createCell(0).setCellValue("");
				aRow.createCell(1).setCellValue("");
				aRow.createCell(2).setCellValue("");
				aRow.createCell(3).setCellValue("");
				aRow.createCell(4).setCellValue("");
				aRow.createCell(5).setCellValue("");
				aRow.createCell(6).setCellValue("");
				aRow.createCell(7).setCellValue("");

			}
		}

		String filename = "tenon_api" + "_" + dateFormat.format(exclDate) + ".xls";
		// FileOutputStream o = new FileOutputStream(afileName);
		File xls = new File(filename);
		if (xls.createNewFile()) {
			logger.debug("File is created!");
		} else {
			logger.debug("File already exists.");
		}
		boolean isMailSent = emailSender.sendMail(filename, workbook, emailId);
		return isMailSent;

	}

	public boolean CreateWorkBookByWCAGForProUser(List<TenonByWCAG> tenonApisList, HttpServletRequest request,
			HttpServletResponse response, String emailId) throws IOException {
		Date exclDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		// create a new Excel sheet
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Tenon Accesbility Report Details");
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
		sheet.autoSizeColumn(50);
		sheet.setColumnWidth(0, 10000);
		sheet.setColumnWidth(1, 10000);
		sheet.setColumnWidth(2, 7000);
		sheet.setColumnWidth(3, 7000);
		sheet.setColumnWidth(4, 7000);
		sheet.setColumnWidth(5, 7000);
		sheet.setColumnWidth(6, 7000);
		sheet.setColumnWidth(7, 7000);
		sheet.setColumnWidth(8, 7000);
		sheet.setColumnWidth(9, 7000);
		sheet.setColumnWidth(10, 7000);

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

		for (int i = 0; i < tenonApisList.size(); i++) {
			TenonByWCAG vo = tenonApisList.get(i);
			if (vo.getUrl() != null) {
				XSSFRow reportDetails = sheet.createRow(1);
				reportDetails.createCell(2).setCellValue("Project name:");
				reportDetails.createCell(4).setCellValue("Count of issues by level A:");
				reportDetails.createCell(5).setCellValue(vo.getCountBylevelA());

				reportDetails.createCell(3).setCellValue("EQuality Labs");

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
				urldetails.createCell(5).setCellValue(vo.getCountBylevelAA());
				urldetails.getCell(2).setCellStyle(pstyle);
				urldetails.getCell(4).setCellStyle(pstyle);
				urldetails.createCell(3).setCellValue(vo.getUrl());
				urldetails.getCell(3).setCellStyle(ustyle);

				XSSFRow date = sheet.createRow(3);
				date.createCell(2).setCellValue("Date Created:  ");
				date.createCell(4).setCellValue("Count of issues by level AAA:");
				date.createCell(5).setCellValue(vo.getCountBylevelAAA());
				date.getCell(2).setCellStyle(pstyle);
				date.getCell(4).setCellStyle(pstyle);
				// date.createCell(3).setCellValue(vo.getCreateDate());
				date.createCell(3).setCellValue(dateFormat.format(exclDate));
				date.getCell(3).setCellStyle(ustyle);

				XSSFRow totaltest = sheet.createRow(4);
				totaltest.createCell(2).setCellValue("Total no of Success criterion:    ");
				totaltest.createCell(4).setCellValue("Total no of Issues ");
				totaltest.createCell(5).setCellValue(vo.getTotalIssues());
				totaltest.getCell(2).setCellStyle(pstyle);
				totaltest.getCell(4).setCellStyle(pstyle);
				totaltest.createCell(3).setCellValue(vo.getTotalNoOfTests());
				totaltest.getCell(3).setCellStyle(ustyle);

				XSSFRow failedTest = sheet.createRow(5);
				failedTest.createCell(2).setCellValue("No of Failed criterion:    ");
				failedTest.createCell(4).setCellValue("Total no of Errors ");
				failedTest.createCell(5).setCellValue(vo.getTotalErrors());
				failedTest.getCell(2).setCellStyle(pstyle);
				failedTest.getCell(4).setCellStyle(pstyle);
				failedTest.createCell(3).setCellValue(vo.getFailedTests());
				failedTest.getCell(3).setCellStyle(ustyle);

				XSSFRow passedTest = sheet.createRow(6);
				passedTest.createCell(2).setCellValue("No of Passed criterion:     ");
				passedTest.createCell(4).setCellValue("Total no of Warnings ");
				passedTest.createCell(5).setCellValue(vo.getTotalWarnings());
				passedTest.getCell(2).setCellStyle(pstyle);
				passedTest.getCell(4).setCellStyle(pstyle);
				passedTest.createCell(3).setCellValue(vo.getPassedTests());
				passedTest.getCell(3).setCellStyle(ustyle);

				// workbook = new XSSFWorkbook();
				XSSFSheet pieSheet = workbook.createSheet("Pie Sheet" + "_" + i + dateFormat.format(exclDate));
				sheet.setColumnWidth(0, 10000);

				CellStyle estyle = workbook.createCellStyle();
				estyle.setFillForegroundColor(HSSFColor.RED.index);
				estyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				estyle.setFont(font);

				CellStyle istyle = workbook.createCellStyle();
				istyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
				istyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				istyle.setFont(font);

				CellStyle wstyle = workbook.createCellStyle();
				wstyle.setFillForegroundColor(HSSFColor.ORANGE.index);
				wstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				wstyle.setFont(font);

				int rowCount = 28;
				XSSFRow aRow = pieSheet.createRow(rowCount++);
				aRow.createCell(4).setCellValue("totalErrors");
				aRow.getCell(4).setCellStyle(estyle);
				aRow.createCell(5).setCellValue(vo.getTotalErrors());

				aRow = pieSheet.createRow(rowCount++);
				aRow.createCell(4).setCellValue("totalIssues");
				aRow.getCell(4).setCellStyle(istyle);
				aRow.createCell(5).setCellValue(vo.getTotalIssues());

				aRow = pieSheet.createRow(rowCount++);
				aRow.createCell(4).setCellValue("totalWarning");
				aRow.getCell(4).setCellStyle(wstyle);
				aRow.createCell(5).setCellValue(vo.getTotalWarnings());

				DefaultPieDataset dataset = new DefaultPieDataset();
				dataset.setValue("Total no of success criterion", Integer.parseInt(vo.getTotalNoOfTests()));
				dataset.setValue("No of failed Criteria", Integer.parseInt(vo.getTotalIssues()));
				dataset.setValue("No of passed Criterion", Integer.parseInt(vo.getTotalWarnings()));
				pieSheet.autoSizeColumn(50);
				JFreeChart myPieChart = ChartFactory.createPieChart3D("Report details", dataset, true, true, true);

				int width = 640;
				int height = 480;
				float quality = 1;
				final PiePlot3D plot = (PiePlot3D) myPieChart.getPlot();
				plot.setStartAngle(270);
				plot.setForegroundAlpha(0.60f);
				plot.setInteriorGap(0.02);
				ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
				ChartUtilities.writeChartAsJPEG(chart_out, quality, myPieChart, width, height);

				/*
				 * File imageFile = new File("E:\\LineChart.png");
				 * ChartUtilities.saveChartAsJPEG((imageFile), myPieChart, 400,
				 * 300);
				 */
				BufferedImage bufferedImage = myPieChart.createBufferedImage(width, height);
				saveToFile(bufferedImage, request);
				int my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);
				chart_out.close();
				XSSFDrawing drawing = pieSheet.createDrawingPatriarch();
				ClientAnchor my_anchor = new XSSFClientAnchor();
				my_anchor.setCol1(3);
				my_anchor.setRow1(3);
				XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
				my_picture.resize();

				// break;
			}
		}

		XSSFRow header = sheet.createRow(7);

		header.createCell(0).setCellValue("Url");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("WCAG Criteria");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Level");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("WCAG Principle");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Principle description");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("WCAG Guideline");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Guideline Description");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("WCAG_Sublevel");
		header.getCell(7).setCellStyle(style);

		header.createCell(8).setCellValue("Sublevel Description");
		header.getCell(8).setCellStyle(style);
		// create data rows
		int rowCount = 8;
		List<TenonApiVo> res = new ArrayList<TenonApiVo>();
		for (TenonByWCAG urlvo : tenonApisList) {
			XSSFRow aRow = sheet.createRow(rowCount++);

			if (urlvo.getUrl() != null) {
				res = urlvo.getResultSetObj();
				for (TenonApiVo result : res) {

					aRow = sheet.createRow(rowCount++);
					aRow.createCell(0).setCellValue(urlvo.getUrl());
					aRow.createCell(1).setCellValue(result.getWCAG_Criteria());
					aRow.createCell(2).setCellValue(result.getWCAG_Level());

					aRow.createCell(3).setCellValue(result.getWCAG_Principle());
					aRow.createCell(4).setCellValue(result.getPrinciple_Description());

					aRow.createCell(5).setCellValue(result.getWCAG_Guideline());
					aRow.createCell(6).setCellValue(result.getGuideline_Description());

					aRow.createCell(7).setCellValue(result.getWCAG_Sublevel());
					aRow.createCell(8).setCellValue(result.getSublevel_Description());

				}

			} else {

				aRow.createCell(0).setCellValue("");
				aRow.createCell(1).setCellValue("");
				aRow.createCell(2).setCellValue("");
				aRow.createCell(3).setCellValue("");
				aRow.createCell(4).setCellValue("");
				aRow.createCell(5).setCellValue("");
				aRow.createCell(6).setCellValue("");
				aRow.createCell(7).setCellValue("");

			}
		}

		String filename = "tenon_api" + "_" + dateFormat.format(exclDate) + ".xls";
		// FileOutputStream o = new FileOutputStream(afileName);
		File xls = new File(filename);
		if (xls.createNewFile()) {
			logger.debug("File is created!");
		} else {
			logger.debug("File already exists.");
		}
		boolean isMailSent = emailSender.sendMail(filename, workbook, emailId);
		return isMailSent;

	}

	public List<TenonByWCAG> getTenonReportServiceByWCAGForProLevel(String tenonApiURL, String[] arr, String apiKey,
			int userId, String domainUrl) {

		ResponseURL rs = getLinksFromWebByProLvel(arr);

		List<TenonByWCAG> tenonByWCAGs = new ArrayList<TenonByWCAG>();
		TenonByWCAG tenonByWCAG = null;
		List<TenonApiVo> tenonApiVos = new ArrayList<TenonApiVo>();
		TenonApiVo tenonApiVo = null;

		for (String urlName : rs.getSetOfURL()) {
			tenonByWCAG = new TenonByWCAG();

			String urlParameters = "key=" + apiKey + "&url=" + urlName;

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			try {
				URL url11 = new URL(tenonApiURL);
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
				InputStream is = conn.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();

				JSONObject json = new JSONObject(response.toString());
				JSONObject json1 = (json.getJSONObject("request"));
				logger.debug(json1.getString("url"));
				tenonByWCAG.setUrl(urlName);
				JSONArray array = json.getJSONArray("resultSet");

				for (int i = 0; i < array.length(); i++) {
					tenonApiVo = new TenonApiVo();
					String Standards = array.getJSONObject(i).getString("standards").replace("\"", "");
					TenonApiVo tenonApidetails = util.GetDetailsFromWCAG(Standards);
					tenonApiVo.setGuideline_Description(tenonApidetails.getGuideline_Description());
					tenonApiVo.setWCAG_Level(tenonApidetails.getWCAG_Level());
					tenonApiVo.setWCAG_Principle(tenonApidetails.getWCAG_Principle());
					tenonApiVo.setPrinciple_Description(tenonApidetails.getPrinciple_Description());
					tenonApiVo.setWCAG_Sublevel(tenonApidetails.getWCAG_Sublevel());
					tenonApiVo.setSublevel_Description(tenonApidetails.getSublevel_Description());
					tenonApiVo.setWCAG_Criteria(tenonApidetails.getWCAG_Criteria());
					tenonApiVo.setWCAG_Guideline(tenonApidetails.getWCAG_Guideline());
					tenonApiVo.setWCAG_Criteria(
							tenonApidetails.getWCAG_Level() + "." + tenonApidetails.getWCAG_Principle() + "."
									+ tenonApidetails.getWCAG_Guideline() + "_" + tenonApidetails.getWCAG_Sublevel());
					tenonApiVos.add(tenonApiVo);
				}

				logger.debug("printing tenon lists size--" + tenonApiVos.size());
				tenonByWCAG.setResultSetObj(tenonApiVos);
				tenonByWCAG.setUserId(userId);
				JSONObject resultSummary = json.getJSONObject("resultSummary");
				JSONObject issues = resultSummary.getJSONObject("issues");
				tenonByWCAG.setTotalErrors(issues.getString("totalErrors"));
				tenonByWCAG.setTotalIssues(issues.getString("totalIssues"));
				tenonByWCAG.setTotalWarnings(issues.getString("totalWarnings"));

				JSONObject testResult = resultSummary.getJSONObject("tests");
				tenonByWCAG.setTotalNoOfTests(testResult.getString("total"));
				tenonByWCAG.setFailedTests(testResult.getString("failing"));
				tenonByWCAG.setPassedTests(testResult.getString("passing"));

				JSONObject issuesByLevel = resultSummary.getJSONObject("issuesByLevel");
				JSONObject issuesByLevelAA = issuesByLevel.getJSONObject("AA");

				tenonByWCAG.setPctBylevelAA(issuesByLevelAA.getString("pct"));
				tenonByWCAG.setCountBylevelAA(issuesByLevelAA.getString("count"));

				JSONObject issuesByLevelA = issuesByLevel.getJSONObject("A");
				tenonByWCAG.setPctBylevelA(issuesByLevelA.getString("pct"));
				tenonByWCAG.setCountBylevelA(issuesByLevelA.getString("count"));

				JSONObject issuesByLevelAAA = issuesByLevel.getJSONObject("AAA");
				tenonByWCAG.setPctBylevelAAA(issuesByLevelAAA.getString("pct"));
				tenonByWCAG.setCountBylevelAAA(issuesByLevelAAA.getString("count"));
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				logger.debug(dateFormat.format(date)); // 2016/11/16 12:08:43
				// tenonByWCAG.setCreateDate(dateFormat.format(date));

			} catch (Exception e) {
				logger.debug(e.getMessage());
				if (e.getMessage().equals("Server returned HTTP response code 400 for URL: https://tenon.io/api/")) {
					tenonApiVo = new TenonApiVo();
					tenonByWCAG.setTotalNoOfTests(null);
					tenonByWCAG.setFailedTests(null);
					tenonByWCAG.setPassedTests(null);
					tenonByWCAG.setCountBylevelA(null);
					tenonByWCAG.setCountBylevelAA(null);
					tenonByWCAG.setCountBylevelAAA(null);
					tenonApiVos.add(tenonApiVo);
					tenonByWCAG.setUrl("There is issue with retriving response from tenon api as Server returned HTTP response code 400 for URL: https://tenon.io/api/");
					tenonByWCAG.setResultSetObj(tenonApiVos);

				}

				if (e.getMessage().equals("Server returned HTTP response code: 402 for URL: https://tenon.io/api/")) {
					tenonApiVo = new TenonApiVo();
					tenonByWCAG.setTotalNoOfTests(null);
					tenonByWCAG.setFailedTests(null);
					tenonByWCAG.setPassedTests(null);
					tenonByWCAG.setCountBylevelA(null);
					tenonByWCAG.setCountBylevelAA(null);
					tenonByWCAG.setCountBylevelAAA(null);
					tenonApiVos.add(tenonApiVo);
					tenonByWCAG.setUrl("There is issue with retriving response from tenon api as Server returned HTTP response code 402 for URL: https://tenon.io/api/");
					tenonByWCAG.setResultSetObj(tenonApiVos);

				}
			}

			tenonByWCAGs.add(tenonByWCAG);
			try {
				dao.updateDB(tenonByWCAGs, userId);
			} catch (Exception e) {
				logger.info("Error received while saving data to the db for given url.." + tenonByWCAG.getUrl()
						+ "for userId " + userId);
				// e.printStackTrace();
			}

		}
		return tenonByWCAGs;

	}

	private ResponseURL getLinksFromWebByProLvel(String[] arr) {

		ResponseURL responseToReturn = null;
		List<String> setOfUrl = null;
		try {
			setOfUrl = new ArrayList<String>();

			responseToReturn = new ResponseURL();

			for (int i = 0; i < arr.length; i++) {
				setOfUrl.add(arr[i]);

			}
			logger.debug("-----------" + setOfUrl.size());
			responseToReturn.setSetOfURL(setOfUrl);
			responseToReturn.setSize(setOfUrl.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseToReturn;
	}

	public static void saveToFile(BufferedImage img, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/static/Images") + "/myPieChart.png";
		File outputFile = new FileSystemResource(new File(path)).getFile();
		ImageIO.write(img, "png", outputFile);
	}

	public static void savebarChartToFile(BufferedImage img, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/static/Images") + "/BarChartReport.png";
		File outputFile = new FileSystemResource(new File(path)).getFile();
		ImageIO.write(img, "png", outputFile);
	}

	public void updateDB(List<TenonByWCAG> tenonApiObj, int userId) {
		dao.updateDB(tenonApiObj, userId);
	}

	public DefaultCategoryDataset createBarChartForProUser(List<TenonByWCAG> tenonByWCAGs)
			throws IOException, NumberFormatException {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		for (int i = 0; i < tenonByWCAGs.size(); i++) {
			TenonByWCAG vo = tenonByWCAGs.get(i);

			/*
			 * dataset1.addValue(Integer.parseInt(vo.getTotalNoOfTests()),vo.
			 * getUrl(), "Total no of test" );
			 * dataset1.addValue(Integer.parseInt(vo.getFailedTests()),
			 * vo.getUrl(),"No of failed test");
			 * dataset1.addValue(Integer.parseInt(vo.getPassedTests()),vo.getUrl
			 * (), "No of passed test");
			 */
			dataset1.addValue((vo.getFailedTests()) != null ? Integer.parseInt(vo.getFailedTests()) : 0, vo.getUrl(),
					"No of failed test");
			dataset1.addValue((vo.getCountBylevelA()) != null ? Integer.parseInt(vo.getCountBylevelA()) : 0,
					vo.getUrl(), "Level A issues");
			dataset1.addValue((vo.getCountBylevelAA()) != null ? Integer.parseInt(vo.getCountBylevelAA()) : 0,
					vo.getUrl(), "Level AA issues");
			dataset1.addValue((vo.getCountBylevelAAA()) != null ? Integer.parseInt(vo.getCountBylevelAAA()) : 0,
					vo.getUrl(), "Level AAA issues");

		}

		return dataset1;
	}

	private DefaultPieDataset createPieChartForProUser(List<TenonByWCAG> tenonByWCAGs) {
		DefaultPieDataset dataset = new DefaultPieDataset();

		try {

			for (int i = 0; i < tenonByWCAGs.size(); i++) {
				TenonByWCAG vo = tenonByWCAGs.get(i);

				dataset.setValue("No of Passed Criteria",
						(vo.getPassedTests()) != null ? Integer.parseInt(vo.getPassedTests()) : 0);
				dataset.setValue("No of failed Criteria",
						(vo.getFailedTests()) != null ? Integer.parseInt(vo.getFailedTests()) : 0);
				dataset.setValue("No of issues by level A",
						(vo.getCountBylevelA()) != null ? Integer.parseInt(vo.getCountBylevelA()) : 0);
				dataset.setValue("No of issues by level AA",
						(vo.getCountBylevelAA()) != null ? Integer.parseInt(vo.getCountBylevelAA()) : 0);
				dataset.setValue("No of issues by level AAA",
						(vo.getCountBylevelAAA()) != null ? Integer.parseInt(vo.getCountBylevelAAA()) : 0);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataset;
	}
}
