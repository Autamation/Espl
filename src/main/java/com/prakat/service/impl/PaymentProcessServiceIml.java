package com.prakat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.mysql.cj.api.mysqla.io.PacketPayload;
import com.prakat.dao.impl.PaymentProcessDAOIml;
import com.prakat.model.PaymentVo;
import com.prakat.service.PaymentProcesService;

@Service
public class PaymentProcessServiceIml implements PaymentProcesService {
	
	@Autowired
	PaymentProcessDAOIml paymentProcessServiceDAOIml;
	
	@Override
	@Transactional
	public boolean savePaymentDetails(PaymentVo paymentVo) {
		// TODO Auto-generated method stub
		return paymentProcessServiceDAOIml.savePaymentDetails(paymentVo);
	}

}
