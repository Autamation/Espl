package com.prakat.service;

import com.prakat.model.UserDetailsVo;

public interface EQualityLabsService {
	
	int getRegisteredUserId(UserDetailsVo userDetailsVO);
	boolean saveRegisteredUserDetails(UserDetailsVo userDetailsVO);
	UserDetailsVo checkLoggedInUserId(UserDetailsVo userDetailsVO);
	UserDetailsVo fetchRegisteredUserDetails(String userId);
	boolean upateUserDetails(UserDetailsVo userDetailsVO);
	boolean userMasterRegistrationUpdatePassword(UserDetailsVo user) throws Exception;
	boolean userMasterChanagePassword(UserDetailsVo user) throws Exception;
	boolean savepersonalInfoDetails(UserDetailsVo userDetailsVO);
	
	public boolean userExists(String email) throws Exception;
}
