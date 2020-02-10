package com.prakat.dao;

import java.util.List;

import com.prakat.model.EQualityLabsVo;
import com.prakat.model.UserDetailsVo;

public interface EQualityLabsDAO {

	
public void save(List<EQualityLabsVo> equalityLabs) ;
boolean saveRegisteredUserDetails(UserDetailsVo userDetailsVO);
UserDetailsVo checkLoggedInUserId(UserDetailsVo userDetailsVO);
UserDetailsVo fetchRegisteredUserDetails(String userId);
boolean upateUserDetails(UserDetailsVo userDetailsVO);
//void save(List<EQualityLabsVo> equalityLabs);
int getRegisteredUserId(UserDetailsVo userDetailsVO);
boolean userMasterRegistrationUpdatePassword(UserDetailsVo UserDetailsVO) throws Exception;
boolean userMasterChanagePassword(UserDetailsVo user) throws Exception;
boolean savepersonalInfoDetails(UserDetailsVo userDetailsVO);
public boolean userExists(String email) throws Exception;	

}
