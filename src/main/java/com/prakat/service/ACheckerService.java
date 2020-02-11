package com.prakat.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import com.prakat.model.ACheckerVo;

public interface ACheckerService {
	public List<ACheckerVo> getACheckerReportService(String tenonApiURL,String url, String key) throws MalformedURLException, URISyntaxException;

}
