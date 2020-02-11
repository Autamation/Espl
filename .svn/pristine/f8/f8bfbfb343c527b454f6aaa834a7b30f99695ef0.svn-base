package com.prakat.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.java.exception.EQualityLabsException;
import com.prakat.dao.impl.EQualityLabsDAOImpl;
import com.prakat.dao.impl.TenonApiDaoImpl;
import com.prakat.globalservice.MailService;
import com.prakat.model.EQualityLabsVo;
import com.prakat.model.TenonByWCAG;
import com.prakat.model.UserDetailsVo;
import com.prakat.response.ResponseURL;
import com.prakat.service.EQualityLabsService;
import com.prakat.service.impl.TenonApiReportServiceImpl;
import com.prakat.util.AES256EncryptionDecryption;
import com.prakat.util.EQualityLabsUtil;

@Controller
@SessionAttributes({ "userId", "email", "userName", "user", "loggedInUserType" })

@PropertySource("classpath:tenonapi.properties")
public class EQualityLabsController {

	@Autowired
	TenonApiDaoImpl dao;
	@Autowired
	EQualityLabsDAOImpl equalitydaoimpl;
	@Autowired
	TenonApiReportServiceImpl tenonService;
	@Autowired
	Environment env;
	@Autowired
	private MailService mailService;
	@Autowired
	EQualityLabsService equalityLabsServiceImpl;
	@Autowired
	EQualityLabsUtil util;

	static Logger logger = Logger.getLogger(EQualityLabsController.class.getName());

	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@RequestMapping(value = "processReqestForFreeuser", method = RequestMethod.POST)
	public String processFreeUserRequest(HttpServletRequest request, HttpSession session, ModelMap modelMap,
			HttpServletResponse httpresponse) throws Exception {
		String emailId = (String) session.getAttribute("emailId");
		/*if (emailId==null) {
			return "login";
		}*/
		
		String domainUrl = request.getParameter("domainUrl");
		
	
		if (util.isValidUrl(domainUrl)) {
			String tenonApiURL = env.getProperty("tenonApiUrl");
			String apiKey = env.getProperty("tenonApiAuthorizeKey");

			UserDetailsVo userDetails = equalityLabsServiceImpl.fetchRegisteredUserDetails(emailId);
			int userId = userDetails.getUserId();
			List<TenonByWCAG> tenonApiVos = tenonService.getTenonReportServiceByWCAGForFreeUser(tenonApiURL, domainUrl,
					apiKey, emailId, userId);
			
		
			if(!tenonApiVos.isEmpty()){
			
			logger.debug("size after adding --" + tenonApiVos.size());
			modelMap.addAttribute("weburls", tenonApiVos);
			
			}
			else
			{	for (TenonByWCAG vo : tenonApiVos) {
				vo.setTotalErrors(vo.getFailedTests());
				vo.setTotalErrors(vo.getPassedTests());
				vo.setTotalErrors(vo.getTotalNoOfTests());
				tenonApiVos.add(vo);
			}
				modelMap.addAttribute("weburls", tenonApiVos);
             }
			getTenonreportForFreeUser(modelMap, httpresponse, request, emailId);
			}
		
		else {
		  modelMap.addAttribute("weburls", "");
			}
		
		return  "tenon_report";
	}
		
	

	@RequestMapping(value = "/processprouser", method = RequestMethod.POST)
	public String proUserPostRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap modelMap) throws Exception {
		String domainUrl = request.getParameter("checkboxValue");
		String[] arr = domainUrl.split(",");
		int limit = 25;
		String emailId = (String) session.getAttribute("emailId");
		if (limit <= 25) {
		for (int i = 0; i < arr.length; i++) {
			ResponseURL rs = util.getLinksFromWeb(arr[i]);
		}

		String apiKey = env.getProperty("tenonApiAuthorizeKey");
		String tenonApiURL = env.getProperty("tenonApiUrl");
		
		UserDetailsVo userDetails = equalityLabsServiceImpl.fetchRegisteredUserDetails(emailId);
        int userId = userDetails.getUserId();
		List<TenonByWCAG> tenonByWCAGs = tenonService.getTenonReportServiceByWCAGForProLevel(tenonApiURL, arr, apiKey,userId,domainUrl);

		/*
		for (TenonByWCAG vo : tenonByWCAGs) {
			modelMap.addAttribute("totalErrors", vo.getTotalErrors());
			modelMap.addAttribute("totalIssues", vo.getTotalIssues());
			modelMap.addAttribute("totalWarning", vo.getTotalWarnings());
		}*/
		 
		logger.debug("size after adding --" + tenonByWCAGs.size());
		modelMap.addAttribute("weburls", tenonByWCAGs);
		getTenonReportForProUser(modelMap, response, request, emailId);
}

		return "tenon_ProUserReport";

	}
	
	
	public void getTenonreportForFreeUser(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request,
			String emailId) throws IOException {
		boolean isMailSent = false;
		List<TenonByWCAG> tenonApisList = (List<TenonByWCAG>) modelMap.get("weburls");
		isMailSent = tenonService.CreateWorkBookByWCAGForFreeUser(tenonApisList, request, response, emailId);
		logger.debug("Your excel file has been generated");
	}

	public void getTenonReportForProUser(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request,
			String emailId) throws IOException {
		boolean isMailSent = false;
		List<TenonByWCAG> tenonApiByWCAGs = (List<TenonByWCAG>) modelMap.get("weburls");
		isMailSent = tenonService.CreateMultipleWorkBookByWCAG(tenonApiByWCAGs, request, response, emailId);
		logger.debug("Your excel file has been generated");
	}

	public void SaveExceltoDB(ModelMap modelMap, HttpServletResponse response) throws IOException {
		List<EQualityLabsVo> equalityLabs = (List<EQualityLabsVo>) modelMap.get("weburls");
		tenonService.CreateWorkBook(equalityLabs, response);
		logger.debug("Your excel file has been generated");
	}

	@RequestMapping(value = "/tenon_report", method = RequestMethod.GET)
	public String getApiCheckerReport(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "tenon_report";
	}
	
	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public String getMyProfilePage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "myProfile";
	}

	/*@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getErrorPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "error";
	}*/

	@RequestMapping(value = "/eQuality_aboutus", method = RequestMethod.GET)
	public String getAboutUs(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "eQuality_aboutus";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getGetIndexPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getGetSignUpPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "signup";
	}

	@RequestMapping(value = "/privacy_policy", method = RequestMethod.GET)
	public String getPrivacyPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "privacy_policy";
	}

	@RequestMapping(value = "/eQuality_contact", method = RequestMethod.GET)
	public String getContactPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "eQuality_contact";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndexPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "index";
	}

	@RequestMapping(value = "/payPal", method = RequestMethod.GET)
	public String getpayPal(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "payPal";
	}
	
	
	@RequestMapping(value = "/myProfileDetails", method = RequestMethod.GET)
	public String getmyProfileDetails(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		
		 String email=request.getParameter("email");	 
		 UserDetailsVo userDetails =equalityLabsServiceImpl.fetchRegisteredUserDetails(email);;
		 modelMap.addAttribute("userDetails", userDetails);
	    	return "myProfile";
	}

	@RequestMapping(value = "/trust_mark", method = RequestMethod.GET)
	public String getTrustMarkpage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "trust_mark";
	}
	
	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public String getResources(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "resources";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTestPage(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse,HttpSession session)
			throws Exception {
		String emailId = (String) session.getAttribute("emailId");
		if (emailId==null) {
			return "login";
		}else {
			return "test";
		}
		
		
	}

	@RequestMapping(value = "/training&Certification", method = RequestMethod.GET)
	public String getTrainingCertificationPage(HttpServletRequest request, ModelMap modelMap,
			HttpServletResponse httpresponse) throws Exception {
		return "training&Certification";
	}

	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String getCommunity(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse)
			throws Exception {
		return "community";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public @ResponseBody String saveRegisteredUserDetails(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Processing EQualityLabsController.saveRegisteredUserDetails()...");
		boolean flag = false;
		boolean mailSent = false;

		UserDetailsVo userDetailsVO = new UserDetailsVo();
		userDetailsVO.setFirstName(request.getParameter("regFirstName"));
		userDetailsVO.setLastName(request.getParameter("regLastName"));
		userDetailsVO.setEmail(request.getParameter("regEmail"));
		userDetailsVO.setContactNumber(request.getParameter("contactNumber"));
		userDetailsVO.setGender(request.getParameter("gender"));
		String pwd = request.getParameter("regPassword");
		if (pwd != null && pwd.length() > 0) {
			pwd = AES256EncryptionDecryption.encrypt(pwd);
		} else {
			pwd = "";
		}
		userDetailsVO.setPassword(pwd);

		if (equalityLabsServiceImpl.getRegisteredUserId(userDetailsVO) == 0) {
			
			flag = equalityLabsServiceImpl.saveRegisteredUserDetails(userDetailsVO);

			if (flag) {
				Long vCode = (long) (Math.random() * 9000) + 1000;
				userDetailsVO.setVerificationCode(vCode.toString());
				flag = equalityLabsServiceImpl.upateUserDetails(userDetailsVO);

				String toAddress = userDetailsVO.getEmail();
				String subject = env.getProperty("registerSubject");
				String msgBody = mailService.prepareMail(userDetailsVO, "Registration");

				mailSent = mailService.sendMail(toAddress, subject, msgBody);
			}
		}

		return flag ? "success" : "failure";
	}
	

@RequestMapping(value = "/Registerlogin", method = RequestMethod.GET)
	public @ResponseBody String registerlogin(HttpServletRequest request, ModelMap modelMap, UserDetailsVo userDetailsVO)
			throws Exception {
		String email=request.getParameter("email");
		boolean userAlreadyExists = equalityLabsServiceImpl.userExists(email);
		return userAlreadyExists ? "success" : "failure";
	}

	@RequestMapping(value = "/loginUserDetails", method = RequestMethod.GET)
	public boolean getLoginUserDetails(HttpServletRequest request, HttpServletResponse response, ModelMap map,HttpSession session, @RequestParam("emailId") String emailId) throws Exception {
		
		String email=request.getParameter("regmail");
		
		UserDetailsVo userDetailsVO = equalityLabsServiceImpl.fetchRegisteredUserDetails(email);
		if (userDetailsVO != null && userDetailsVO.getUserId().toString().length() > 0) {

				return true;
				
		}
		
		return false;
	}
	

	@RequestMapping(value = "/reglogin", method = RequestMethod.GET)
	public String validateLogin(HttpServletRequest request, ModelMap modelMap, @RequestParam("emailid") String emailid,
			@RequestParam("otp") int otp, HttpServletResponse httpresponse) throws Exception {
		return "validate_login";
	}

	@RequestMapping(value = "/reset_password", method = RequestMethod.GET)
	public String resetPassword(HttpServletRequest request, ModelMap modelMap, HttpSession session,
			HttpServletResponse httpresponse) throws Exception {

		return "reset_password";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public @ResponseBody String loginUser(ModelMap map, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {

		logger.info("Processing EQualityLabsController.loginUser()...");
		boolean flag = false;
		UserDetailsVo userDetailsVO = new UserDetailsVo();
		userDetailsVO.setEmail(request.getParameter("userName"));
		userDetailsVO.setPassword(request.getParameter("password"));

		userDetailsVO = equalityLabsServiceImpl.checkLoggedInUserId(userDetailsVO);
		session.setAttribute("username", userDetailsVO.getFirstName() + " " + userDetailsVO.getLastName());
		session.setAttribute("emailId", userDetailsVO.getEmail());
		session.setAttribute("userId", userDetailsVO.getUserId());

		if (userDetailsVO.getUserId() != null) {
			session.setAttribute("userId", userDetailsVO.getUserId());
			flag = true;
		}

		return flag ? "success" : "failure";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String getchangePasswordPage(HttpServletRequest request, HttpServletResponse response, ModelMap map,
			HttpSession session, @RequestParam("emailId") String emailId) throws Exception {
		String receivedEmail = emailId;
		session.setAttribute("emailId", receivedEmail);
		return "myProfile";
		
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public @ResponseBody String changePasswordPage(HttpServletRequest request, ModelMap modelMap, HttpSession session)
			throws Exception {
		boolean passwordUpdated = false;
		String emailId = (String) session.getAttribute("emailId");
		String pwd = request.getParameter("clientaccount_cnfpwd");
		UserDetailsVo userDetails = equalityLabsServiceImpl.fetchRegisteredUserDetails(emailId);
		try {
			if (pwd != null && pwd.length() > 0) {
				pwd = AES256EncryptionDecryption.encrypt(pwd);
			} else {
				pwd = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userDetails.setPassword(pwd);
		 passwordUpdated = equalityLabsServiceImpl.userMasterChanagePassword(userDetails);

		return passwordUpdated ? "success" : "failure";

		/*boolean passwordUpdated = equalityLabsServiceImpl.userMasterChanagePassword(userDetails);
		if (passwordUpdated) {
			modelMap.addAttribute("VTO", env.getProperty("pwdChanged"));
			return new ModelAndView("login");
		} else {
			modelMap.addAttribute("update", env.getProperty("pwdNotUpdated"));
			return new ModelAndView("index");
		}*/
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String getForgotpasswordPage(HttpServletRequest request, HttpServletResponse response, ModelMap map,
			HttpSession session, @RequestParam("emailId") String emailId) throws Exception {
			String receivedEmail = emailId;
			session.setAttribute("emailId", receivedEmail);
			return "forgotpassword";
	}
	
	@RequestMapping(value = "/checkUserName", method = RequestMethod.GET)
	public boolean getUserDetails(HttpServletRequest request, HttpServletResponse response, ModelMap map,HttpSession session, @RequestParam("emailId") String emailId) throws Exception {
		
		String email=request.getParameter("regmail");
		
		UserDetailsVo userDetailsVO = equalityLabsServiceImpl.fetchRegisteredUserDetails(email);
		if (userDetailsVO != null && userDetailsVO.getUserId().toString().length() > 0) {

				return true;
				
		}
		
		return false;
	}
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView confirmPassword(HttpServletRequest request, ModelMap modelMap, HttpSession session)
			throws Exception {

		String emailId = (String) session.getAttribute("emailId");
		String pwd = request.getParameter("password2");
		UserDetailsVo userDetails = equalityLabsServiceImpl.fetchRegisteredUserDetails(emailId);
		try {
			if (pwd != null && pwd.length() > 0) {
				pwd = AES256EncryptionDecryption.encrypt(pwd);
			} else {
				pwd = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userDetails.setPassword(pwd);
		userDetails.setEmail(emailId);

		boolean passwordUpdated = equalityLabsServiceImpl.userMasterRegistrationUpdatePassword(userDetails);
		if (passwordUpdated) {
			modelMap.addAttribute("VTO", env.getProperty("pwdChanged"));
			return new ModelAndView("login");
		} else {
			modelMap.addAttribute("update", env.getProperty("pwdNotUpdated"));
			return new ModelAndView("index");
		}
	}

	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	public  @ResponseBody String contactUs(HttpServletRequest request, ModelMap modelMap, HttpSession session)
			throws Exception {

		logger.info("================>+Enetered into contactUs Page");
		String email = request.getParameter("email");
		String fName =  request.getParameter("fName");
		String message = request.getParameter("message");
		logger.info("================>+Enetered into contactUs Page"+email+fName+message);
		boolean mailSent = false;
		UserDetailsVo userDetailsVO = equalityLabsServiceImpl.fetchRegisteredUserDetails(email);
		if (userDetailsVO != null && userDetailsVO.getUserId().toString().length() > 0) {
			Long vCode = (long) (Math.random() * 9000) + 1000;
			userDetailsVO.setVerificationCode(vCode.toString());
			equalityLabsServiceImpl.upateUserDetails(userDetailsVO);
			String toAddress = email;
			String subject = env.getProperty("resetPwdSubject");
			String msgBody = mailService.prepareMail(userDetailsVO, "ResetPassword");
			mailSent = mailService.sendMail(toAddress, subject, msgBody);
		}
		

		return mailSent ? "success" : "failure";
		
		
			//return new ModelAndView("index");
		
	}
	
	@RequestMapping(value = "/prouser", method = RequestMethod.POST)
	public String getWebUrlsFromPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			 {
		
		String domainUrl = request.getParameter("domainUrl");
		ResponseURL rs;
		try {
			rs = util.getLinksFromWeb(domainUrl);
			List<String> urlLists = rs.getSetOfURL();
			if (!urlLists.isEmpty() && !(urlLists == null)) {
				modelMap.addAttribute("weburls", urlLists);
			}
			else
			{
			modelMap.addAttribute("weburls", "");
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "weburls";
	}

	@RequestMapping(value = "/prousertest", method = RequestMethod.GET)
	public String getProUserTestPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,HttpSession session)
			throws Exception {
		String emailId = (String) session.getAttribute("emailId");

		return "prousertest";
	}


	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public @ResponseBody String sendPasswordMail(HttpServletRequest request, HttpSession session, ModelMap modelMap,

			HttpServletResponse response) throws Exception {

		String email = request.getParameter("email");
		modelMap = new ModelMap();
		logger.info("Processing EQualityLabsController.sendPasswordMail()...");
		boolean mailSent = false;
		UserDetailsVo userDetailsVO = equalityLabsServiceImpl.fetchRegisteredUserDetails(email);
		if (userDetailsVO != null && userDetailsVO.getUserId().toString().length() > 0) {
			Long vCode = (long) (Math.random() * 9000) + 1000;
			userDetailsVO.setVerificationCode(vCode.toString());
			equalityLabsServiceImpl.upateUserDetails(userDetailsVO);
			String toAddress = userDetailsVO.getEmail();
			String subject = env.getProperty("resetPwdSubject");
			String msgBody = mailService.prepareMail(userDetailsVO, "ResetPassword");
			mailSent = mailService.sendMail(toAddress, subject, msgBody);
		}
		boolean userAlreadyExists = equalityLabsServiceImpl.userExists("email");
        if (!userAlreadyExists) {
			
        	session = request.getSession();
        	session.setAttribute("error","User not exist in the database ! Please Register now");
		}

		return mailSent ? "success" : "failure";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		logger.debug("logout()");
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		//String id = (String) request.getAttribute("username");

		return "redirect:login.html";
	}

	public void getDetailsPerUser(ModelMap modelMap, HttpServletResponse response, String emailId) throws IOException {

		logger.debug("Your excel file has been generated");
	}

	@RequestMapping(value = "/personalInfo", method = RequestMethod.POST)
	public @ResponseBody String savepersonalInfoDetails(HttpServletRequest request, HttpServletResponse response)

			throws Exception {
		logger.info("Processing EQualityLabsController.savepersonalInfoDetails()...");
		boolean flag = false;
		String emailId = request.getParameter("clientaccount_email");
		UserDetailsVo userDetails = equalityLabsServiceImpl.fetchRegisteredUserDetails(emailId);
		//UserDetailsVo userDetailsVO = new UserDetailsVo();
		userDetails.setFirstName(request.getParameter("clientaccount_name"));
		userDetails.setLastName(request.getParameter("clientaccount_lname"));
		userDetails.setEmail(request.getParameter("clientaccount_email"));
		userDetails.setJobTitile(request.getParameter("clientaccount_job_title"));
		userDetails.setCompanyName(request.getParameter("clientaccount_company_name"));
		userDetails.setWebsiteUrl(request.getParameter("clientaccount_website"));
		userDetails.setTimeZone(request.getParameter("clientaccount_timezone"));
		userDetails.setCountry(request.getParameter("socialserver_corebundle_clientaccount_country"));
		
		if (equalityLabsServiceImpl.getRegisteredUserId(userDetails) != 0 ) {

			flag = equalityLabsServiceImpl.savepersonalInfoDetails(userDetails);

			
		}

		return flag ? "success" : "failure";
	}
	
	
	@RequestMapping(value = "/PaymentDetails", method = RequestMethod.GET)
	public String processingPaymentDetails(HttpServletRequest request, ModelMap modelMap, HttpServletResponse httpresponse,HttpSession session)
			throws Exception {
		
		String emailId = (String) session.getAttribute("emailId");
		if (emailId==null) {
			return "login";
		}
		else {
			String email=request.getParameter("email");	 
			 UserDetailsVo userDetails =equalityLabsServiceImpl.fetchRegisteredUserDetails(email);;
			 modelMap.addAttribute("userDetails", userDetails);
			 
			 return "paymentDetails";
		}
		 
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
         
        ModelAndView error = new ModelAndView("error");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
 
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 402: {
                errorMsg = "Http Error Code: 402. Bad Request";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
        }
        error.addObject("errorMsg", errorMsg);
        return error;
    }
	 private int getErrorCode(HttpServletRequest httpRequest) {
	        return (Integer) httpRequest
	          .getAttribute("javax.servlet.error.status_code");
	    }
	 
	 
	 @ResponseBody
	 @ExceptionHandler(EQualityLabsException.class)
	 public String myException(EQualityLabsException exception){
	  return "exception caught message="+ exception.getMessage();
	 }
	 
	/* @ResponseBody
	 @ExceptionHandler(MyGlobalException.class)
	 public String myGlobalException(MyGlobalException exception){
	  return "exception caught message="+ exception.getMessage();
	 }*/
}
