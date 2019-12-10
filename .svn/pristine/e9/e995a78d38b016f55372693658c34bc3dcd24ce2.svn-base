/*package com.prakat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prakat.model.TenonByWCAG;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prakat.dao.impl.TenonApiDaoImpl;
import com.prakat.globalservice.MailService;
import com.prakat.model.EQualityLabsVo;
import com.prakat.response.ResponseURL;
import com.prakat.service.EQualityLabsService;
import com.prakat.service.impl.TenonApiReportServiceImpl;

@Controller
@Configuration
@PropertySource("classpath:tenonapi.properties")
public class TenonApiController {

	@Autowired
	TenonApiDaoImpl dao;
	@Autowired
	TenonApiReportServiceImpl tenonService;
	@Autowired
	Environment env;
	@Autowired
	private MailService mailService;
	@Autowired
	EQualityLabsService equalityLabsServiceImpl;

	private static final Logger logger = Logger.getLogger(TenonApiController.class);

	@RequestMapping(value = "getReportForFreeUser", method = RequestMethod.POST)
	public String getResponseFromURL(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {

		String domainUrl = request.getParameter("domainUrl");
		String apiName = request.getParameter("apiName");
		String apiKey = "d508e3232d61d9b1c69feee768408752";
		String tenonApiURL = env.getProperty("tenonApiUrl");
		// String authorizeKey = env.getProperty("authorizeKey");

		// String tenonApiURL = "https://tenon.io/api/";
		List<TenonByWCAG> tenonApiVos = tenonService.getTenonReportServiceByWCAG(tenonApiURL, domainUrl, apiKey);
		logger.debug("size after adding --" + tenonApiVos.size());
		modelMap.addAttribute("weburls", tenonApiVos);
		getTenonreport(modelMap, httpresponse);
		return "tenon_report";
	}

	public void getTenonreport(ModelMap modelMap, HttpServletResponse response) throws IOException {
		List<TenonByWCAG> tenonApisList = (List<TenonByWCAG>) modelMap.get("weburls");
		tenonService.CreateWorkBookByWCAG(tenonApisList, response);
		logger.debug("Your excel file has been generated");
	}

	@RequestMapping(value = "getReportForProUser", method = RequestMethod.POST)
	public String getExcelReportForProUser(HttpServletRequest request, ModelMap modelMap,
			HttpServletResponse httpresponse) throws Exception {

		String domainUrl = request.getParameter("domainUrl");
		String apiName = request.getParameter("apiName");
		String apiKey = "d508e3232d61d9b1c69feee768408752";
		String tenonApiURL = env.getProperty("tenonApiUrl");
		// String authorizeKey = env.getProperty("authorizeKey");

		// String tenonApiURL = "https://tenon.io/api/";
		List<TenonByWCAG> tenonApiVos = tenonService.getTenonReportServiceByWCAG(tenonApiURL, domainUrl, apiKey);
		logger.debug("size after adding --" + tenonApiVos.size());
		modelMap.addAttribute("weburls", tenonApiVos);
		getTenonreport(modelMap, httpresponse);
		return "tenon_report";
	}

	@RequestMapping(value = "getReportForCustomizedClient", method = RequestMethod.POST)
	public String getReportForCustomizedClient(HttpServletRequest request, ModelMap modelMap,
			HttpServletResponse httpresponse) throws Exception {

		String domainUrl = request.getParameter("domainUrl");
		String apiName = request.getParameter("apiName");
		String apiKey = "d508e3232d61d9b1c69feee768408752";
		String tenonApiURL = env.getProperty("tenonApiUrl");
		// String authorizeKey = env.getProperty("authorizeKey");

		// String tenonApiURL = "https://tenon.io/api/";
		List<TenonByWCAG> tenonApiVos = tenonService.getTenonReportServiceByWCAG(tenonApiURL, domainUrl, apiKey);
		logger.debug("size after adding --" + tenonApiVos.size());
		modelMap.addAttribute("weburls", tenonApiVos);
		getTenonreport(modelMap, httpresponse);
		return "tenon_report";
	}

	@RequestMapping(value = "/tenon_report", method = RequestMethod.GET)
	public String getApiCheckerReport(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "tenon_report";
	}
}
*/