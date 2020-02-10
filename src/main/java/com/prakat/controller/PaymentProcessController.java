package com.prakat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prakat.dao.impl.EQualityLabsDAOImpl;
import com.prakat.model.PaymentVo;
import com.prakat.model.UserDetailsVo;
import com.prakat.service.impl.PaymentProcessServiceIml;

@Controller
public class PaymentProcessController {

@Autowired
PaymentProcessServiceIml paymentProcessServiceIml;

@Autowired
EQualityLabsDAOImpl equalitydaoimpl;

static Logger logger = Logger.getLogger(PaymentProcessController.class.getName());

@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
public @ResponseBody String savePaymentDetails(HttpServletRequest request, HttpSession session, ModelMap modelMap,HttpServletResponse response) throws Exception {
boolean paymentDetails = false;
boolean isPaymentsaved = false;
	PaymentVo paymentVo = new PaymentVo();
	
	String email=request.getParameter("clientaccount_email");
	String totalAmount=request.getParameter("totalAmount");
	String paymentType=request.getParameter("paymentType");
	UserDetailsVo userDetails =equalitydaoimpl.fetchRegisteredUserDetails(email);;

	int userId = equalitydaoimpl.getUserIdFromRegisteredEmail(email) ;
		paymentVo.setCreatedBy(userDetails.getFirstName());
		paymentVo.setFeeAmount((Double.parseDouble(totalAmount)));
		paymentVo.setFeeType(paymentType);
		paymentVo.setUserId(userId);
		paymentVo.setMsg("Transaction is done Successfully");
		paymentVo.setTransactionId(0101L);
		paymentVo.setUserComment("Kishorkumar");
		//paymentVo.setModifiedDate("01/01/2017");
		paymentVo.setFeeAmount(2000.0);
		
		isPaymentsaved = paymentProcessServiceIml.savePaymentDetails(paymentVo);
	
		if(isPaymentsaved)
		{
			paymentDetails = true;
		}
	
	
	//logger.info("Enetered into PaymentProcessController::::::::::::::::::::::::");

	return paymentDetails ? "success" : "failure";
	
	

}


}
