/*
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prakat.model.EQualityLabsVo;
import com.prakat.response.ResponseURL;

public class Pa11yApiController {

	
	private final static String apiURL = "GetResponseFromURL";

	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@RequestMapping(value = apiURL, method = RequestMethod.POST headers = "Content-Type=application/x-www-form-urlencoded")
	@ResponseBody
	public ResponseEntity  getResponseFromPa11y(@RequestParam final String url, @RequestParam final String key)
			throws Exception {
	String ACheckerRequestAPIUrl = "http://pa11y.org/tasks";
	ResponseURL rs = getLinksFromWeb(url);
	List<EQualityLabsVo> equalityLabs = new ArrayList<EQualityLabsVo>();
    List<String> urls= rs.getSetOfURL();
    urls.add(url);
	for(String urlName : rs.getSetOfURL())
	{
		String urlParameters = "id="+key+"&uri="+urlName;

		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		try{
		URL url11 = new URL(ACheckerRequestAPIUrl);
		HttpURLConnection conn = (HttpURLConnection) url11.openConnection();
		conn.setDoOutput(true);
		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
		//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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
		logger.debug("-------reposne from apichecker--"+response.toString());
		rd.close();
		}
		
		EQualityLabsVo equalityLab = new EQualityLabsVo();
		JSONObject json = new JSONObject(response.toString());
		JSONObject json1 = (json.getJSONObject("request"));
	//	logger.debug(json1.getString("url"));
		equalityLab.setUrl(json1.getString("url"));
		JSONArray array = json.getJSONArray("resultSet");

		for (int i = 0; i < array.length(); i++) {
			equalityLab.setBpID(array.getJSONObject(i).getString("bpID"));
			equalityLab.setCertainty(array.getJSONObject(i).getString("certainty"));
			equalityLab.setErrorDescription(array.getJSONObject(i).getString("errorDescription"));
			equalityLab.setErrorSnippet(array.getJSONObject(i).getString("errorSnippet"));
			equalityLab.setErrorTitle(array.getJSONObject(i).getString("errorSnippet"));
			equalityLab.setIssueID(array.getJSONObject(i).getString("issueID"));
			equalityLab.setPosition(array.getJSONObject(i).getString("position"));
			equalityLab.setPriority(array.getJSONObject(i).getString("priority"));
			equalityLab.setRef(array.getJSONObject(i).getString("ref"));
			equalityLab.setResultTitle(array.getJSONObject(i).getString("resultTitle"));
			equalityLab.setSignature(array.getJSONObject(i).getString("signature"));
			equalityLab.setStandards(array.getJSONObject(i).getString("standards"));
			equalityLab.settID(array.getJSONObject(i).getString("tID"));
			equalityLab.setViewPortLocation(array.getJSONObject(i).getString("viewPortLocation"));
			equalityLab.setViewPortLocation(array.getJSONObject(i).getString("viewPortLocation"));

		}
		
		JSONObject resultSummary = json.getJSONObject("resultSummary");
		JSONObject issues = resultSummary.getJSONObject("issues");
		//logger.debug("errors---"+issues.getString("totalErrors"));
		equalityLab.setTotalErrors(issues.getString("totalErrors"));
		equalityLab.setTotalIssues(issues.getString("totalIssues"));
		equalityLab.setTotalWarnings(issues.getString("totalWarnings"));

		JSONObject testResult = resultSummary.getJSONObject("tests");
		equalityLab.setTotalNoOfTests(testResult.getString("total"));
		equalityLab.setFailedTests(testResult.getString("failing"));
		equalityLab.setPassedTests(testResult.getString("passing"));
		equalityLabs.add(equalityLab);
		
		
		JSONObject issuesByLevel = resultSummary.getJSONObject("issuesByLevel");
		JSONObject issuesByLevelAA = issuesByLevel.getJSONObject("AA");

		equalityLab.setPctBylevelAA(issuesByLevelAA.getString("pct"));
		equalityLab.setCountBylevelAA(issuesByLevelAA.getString("count"));
		
		JSONObject issuesByLevelA = issuesByLevel.getJSONObject("A");
		equalityLab.setPctBylevelA(issuesByLevelA.getString("pct"));
		equalityLab.setCountBylevelA(issuesByLevelA.getString("count"));
		
		
		JSONObject issuesByLevelAAA = issuesByLevel.getJSONObject("AAA");
		equalityLab.setPctBylevelAAA(issuesByLevelAAA.getString("pct"));
		equalityLab.setCountBylevelAAA(issuesByLevelAAA.getString("count"));
		equalityLabs.add(equalityLab);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}

		//logger.debug("printing the list elements" + equalityLabs.toString());
		//logger.debug("printing the size of elements" + equalityLabs.size());

	}
	code for saving the list object to database
	//equalityLabsDao.save(equalityLabs);
	 * 
	 

	return  new ResponseEntity<>(equalityLabs, HttpStatus.OK);

	}
	public static ResponseURL getLinksFromWeb(String url) {
		List<String> setOfUrl = null;
		ResponseURL responseToReturn = new ResponseURL();
		try {
			setOfUrl = new HashSet<String>();
			Document doc = Jsoup.connect(url).get();
			Elements elements = doc.select("a");
			for (Element element : elements) {
				// logger.debug(element.absUrl("href"));
				String internalLink = element.absUrl("href");
				if(internalLink.startsWith("http://")) {
					internalLink = internalLink.replace("http://","");
				}
				else if(internalLink.startsWith("https://")) {
					internalLink = internalLink.replace("https://","");
				}
				else if(internalLink.contains("://")) {
					internalLink = internalLink.substring(internalLink.indexOf("://")+3, internalLink.length());
				}
				else if(internalLink.startsWith("/")) {
					internalLink = url + internalLink;
				}
				
				int split = element.absUrl("href").split("/", -1).length - 1;
				if (split > 3 && split < 5 && !element.absUrl("href").contains("#")) {
					if (!setOfUrl.contains(element.absUrl("href"))) {
						// logger.debug("split = " + split);
						// logger.debug(element.absUrl("href"));
						setOfUrl.add(element.absUrl("href"));
						// String FirstlevelUrl = element.absUrl("href");

						// getLinksFromWeb(FirstlevelUrl);
					}
				}
			}
			logger.debug("-----------" + setOfUrl.size());
			responseToReturn.setSetOfURL(setOfUrl);
			responseToReturn.setSize(setOfUrl.size());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseToReturn;

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "https://www.bankofscotland.co.uk/";
		// String url = "http://www.halifax.co.uk/loans/";
		String key = "3b14c52d8a79f5df3f2195fb78cbe8379a199a86";
		Pa11yApiController pa = new Pa11yApiController();
		ResponseEntity ec=	pa.getResponseFromPa11y(url, key);
		logger.debug(ec.getStatusCode());
		
	}

}
*/