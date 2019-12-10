package com.prakat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prakat.dao.EQualityLabsDAO;
import com.prakat.model.UserDetailsVo;
import com.prakat.service.EQualityLabsService;

@Service
public class EQualityLabsServiceImpl implements EQualityLabsService {
	
	@Autowired
	private EQualityLabsDAO equalityLabsDAOImpl;

	@Override
	@Transactional
	public int getRegisteredUserId(UserDetailsVo userDetailsVO) {
		return equalityLabsDAOImpl.getRegisteredUserId(userDetailsVO);
	}
	
	@Override
	@Transactional
	public boolean saveRegisteredUserDetails(UserDetailsVo userDetailsVO) {
		return equalityLabsDAOImpl.saveRegisteredUserDetails(userDetailsVO);
	}

	@Override
	@Transactional
	public UserDetailsVo checkLoggedInUserId(UserDetailsVo userDetailsVO) {
		return equalityLabsDAOImpl.checkLoggedInUserId(userDetailsVO);
	}

	@Override
	@Transactional
	public UserDetailsVo fetchRegisteredUserDetails(String email) {
		return equalityLabsDAOImpl.fetchRegisteredUserDetails(email);
	}

	@Override
	@Transactional
	public boolean upateUserDetails(UserDetailsVo userDetailsVO) {
		return equalityLabsDAOImpl.upateUserDetails(userDetailsVO);
	}

	
	@Override
	@Transactional
	public boolean userMasterRegistrationUpdatePassword(UserDetailsVo userDetailsVO) throws Exception {
		return equalityLabsDAOImpl.userMasterRegistrationUpdatePassword(userDetailsVO);
	}

	@Override
	@Transactional
	public boolean savepersonalInfoDetails(UserDetailsVo userDetailsVO) {
		// TODO Auto-generated method stub
		 return equalityLabsDAOImpl.savepersonalInfoDetails(userDetailsVO);
	}

	@Override
	@Transactional
	public boolean userMasterChanagePassword(UserDetailsVo userDetailsVO) throws Exception {
		// TODO Auto-generated method stub
		return equalityLabsDAOImpl.userMasterChanagePassword(userDetailsVO);
	}

	@Override
	public boolean userExists(String email) throws Exception {
		// TODO Auto-generated method stub
		return equalityLabsDAOImpl.userExists(email);
	}
	
	
}
