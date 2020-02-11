package com.prakat.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.prakat.dao.impl.TenonApiDaoImpl;
import com.prakat.globalservice.MailService;
import com.prakat.model.ACheckerVo;
import com.prakat.model.TenonByWCAG;
import com.prakat.service.EQualityLabsService;
import com.prakat.service.impl.ACheckerReportServiceImpl;

@Controller
public class ACheckerApiController {

	@Autowired
	TenonApiDaoImpl dao;
	@Autowired
	ACheckerReportServiceImpl acheckerService;
	@Autowired
	Environment env;
	@Autowired
	private MailService mailService;
	@Autowired
	EQualityLabsService equalityLabsServiceImpl;
	
	private final static String AChecker_APIURL = "AChecker";

	static Logger logger = Logger.getLogger(EQualityLabsController.class.getName());

	@RequestMapping(value = "getResponseFromAChecker", method = RequestMethod.POST)
	public String getResponseFromAChecker(HttpServletRequest request, ModelMap modelMap,
			HttpServletResponse httpresponse) throws Exception {
		String ACheckerRequestAPIUrl = "https://www.achecker.ca/checkacc.php";
		String key = "3b14c52d8a79f5df3f2195fb78cbe8379a199a86";

		// String urlParameters = "id=" + key + "&uri=" + url + "&output=" +
		// "rest";

		String domainUrl = request.getParameter("domainUrl");
		// String domainUrl = "http://www.halifax.co.uk/loans/";

		String apiKey = "3b14c52d8a79f5df3f2195fb78cbe8379a199a86";
		List<ACheckerVo> aCheckerObjs = acheckerService.getACheckerReportService(ACheckerRequestAPIUrl, domainUrl, key);

		logger.debug("size after adding --" + aCheckerObjs.size());
		modelMap.addAttribute("weburls", aCheckerObjs);
		getAcheckerReport(modelMap, httpresponse);
		return "achecker_report";
	}

	private String getAcheckerReport(ModelMap modelMap, HttpServletResponse httpresponse) throws IOException, MessagingException {
		List<ACheckerVo> aCheckerObjs = (List<ACheckerVo>) modelMap.get("weburls");
		acheckerService.CreateWorkBookForAChecker(aCheckerObjs,httpresponse);
		logger.debug("Your excel file has been generated");
		return "achecker_report";
		
	}

	
	
	@RequestMapping(value = "/achecker_report", method = RequestMethod.GET)
	public String getApiCheckerReport( HttpServletRequest request, ModelMap modelMap,
			HttpServletResponse httpresponse) throws Exception {
		return "achecker_report";
	}
	
	class MyHandler extends DefaultHandler {

	    @Override
	    public void characters(char ch[], int start, int length)
	            throws SAXException {
	        System.out.print(String.copyValueOf(ch, start, length));
	    }

}
}