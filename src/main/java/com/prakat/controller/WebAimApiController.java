package com.prakat.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prakat.model.EQualityLabsVo;
import com.prakat.model.WebAimApiVo;
import com.prakat.response.ResponseURL;

@Controller
public class WebAimApiController {

	static Logger logger = Logger.getLogger(EQualityLabsController.class.getName());

	private final static String WebapiURL = "GetResponseFromWebAimURL";

	/*
	 * @Autowired EQualityLabsVo equalityLabsVo;
	 * 
	 * @Autowired EQualityLabsDAOImpl equalityLabsDao;
	 * 
	 * @Autowired ResponseURL responseToReturn;
	 */
	/**
	 * @param url
	 * @param format
	 * @param reporttype
	 * @throws Exception
	 */
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@RequestMapping(value = WebapiURL, method = RequestMethod.POST /*
																	 * headers =
																	 * "Content-Type=application/x-www-form-urlencoded"
																	 */)
	@ResponseBody
	public ResponseEntity getResponseFromURL(@RequestParam final String url, @RequestParam final String key)
			throws Exception {

		String webAimRequestApi = "http://wave.webaim.org/api/request";
		ResponseURL rs = getLinksFromWeb(url);
		List<WebAimApiVo> webaimlists = new ArrayList<WebAimApiVo>();
		List<String> urls = rs.getSetOfURL();
		urls.add(url);
		/*
		 * for(String urlName : rs.getSetOfURL()) {
		 */
		String urlParameters = "key=" + key + "&url=" + url;

		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		try {
			URL url11 = new URL(webAimRequestApi);
			HttpURLConnection conn = (HttpURLConnection) url11.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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
			rd.close();
			 logger.debug(response.toString());

			WebAimApiVo webaimVo = new WebAimApiVo();
			JSONObject json = new JSONObject(response.toString());
			// logger.debug(response.toString());

			JSONObject statistics = json.getJSONObject("statistics");
			webaimVo.setPageurl(statistics.getString("pageurl"));
			webaimVo.setPagetitle(statistics.getString("pagetitle"));

			JSONObject categories = json.getJSONObject("categories");
			JSONObject alert = categories.getJSONObject("alert");
			webaimVo.setAdescription(alert.getString("description"));
			webaimVo.setAcount(alert.getString("count"));

			JSONObject contrast = categories.getJSONObject("contrast");
			webaimVo.setCdescription(contrast.getString("description"));
			webaimVo.setCcount(contrast.getString("count"));

			JSONObject error = categories.getJSONObject("error");
			webaimVo.setEdescription(error.getString("description"));
			webaimVo.setEcount(error.getString("count"));

			JSONObject feature = categories.getJSONObject("feature");
			webaimVo.setFedescription(feature.getString("description"));
			webaimVo.setFecount(feature.getString("count"));

			JSONObject html5 = categories.getJSONObject("html5");
			webaimVo.setHtmldescription(html5.getString("description"));
			webaimVo.setHtmlcount(html5.getString("count"));

			JSONObject structure = categories.getJSONObject("structure");
			webaimVo.setSdescription(structure.getString("description"));
			webaimVo.setScount(structure.getString("count"));

			webaimlists.add(webaimVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// }
		/*
		 * code for saving the list object to database
		 * //equalityLabsDao.save(equalityLabs);
		 * 
		 */

		return new ResponseEntity<>(webaimlists, HttpStatus.OK);
	}
	public static String getHost(String url){
	    if(url == null || url.length() == 0)
	        return "";

	    int doubleslash = url.indexOf("//");
	    if(doubleslash == -1)
	        doubleslash = 0;
	    else
	        doubleslash += 2;

	    int end = url.indexOf('/', doubleslash);
	    end = end >= 0 ? end : url.length();

	    int port = url.indexOf(':', doubleslash);
	    end = (port > 0 && port < end) ? port : end;

	    return url.substring(doubleslash, end);
	}

	
	public static String getBaseDomain(String url) {
	    String host = getHost(url);

	    int startIndex = 0;
	    int nextIndex = host.indexOf('.');
	    int lastIndex = host.lastIndexOf('.');
	    while (nextIndex < lastIndex) {
	        startIndex = nextIndex + 1;
	        nextIndex = host.indexOf('.', startIndex);
	    }
	    if (startIndex > 0) {
	        return host.substring(startIndex);
	    } else {
	        return host;
	    }
	}
	
	public static void main(String[] args) throws Exception {

		String url = "https://www.bankofscotland.co.uk/";
		String key = "JSiTS8X4833 ";
		WebAimApiController g = new WebAimApiController();
		ResponseEntity ec = g.getResponseFromURL(url, key);
		logger.debug(ec.getStatusCode());

	}

	public static ResponseURL getLinksFromWeb(String url) {

		ResponseURL responseToReturn = null;
		List<String> setOfUrl = null;
		try {
			setOfUrl = new ArrayList<String>();
			// url = url.replaceAll(" ", "%20");
			String Domain = getBaseDomain(url);
			 responseToReturn = new ResponseURL();

			/*
			 * UrlValidator urlValidator = new UrlValidator();
			 * if(urlValidator.isValid(url)){
			 */
				Document doc = Jsoup.connect(url)
						.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
						.timeout(100000).ignoreContentType(true).referrer("http://www.google.com").get();
				Elements elements = doc.select("a");
				for (Element element : elements) {
					//logger.debug("0 level url--" + element.absUrl("href"));
					if (!element.absUrl("href").contains("#") && !element.absUrl("href").equals("")
							&& !setOfUrl.contains(element.absUrl("href")) && !element.absUrl("href").contains("mailto")) {
						String DomainOfZeroLevel = getBaseDomain(element.absUrl("href"));
						if (Domain.equals(DomainOfZeroLevel)) {
						setOfUrl.add(element.absUrl("href"));
					}
				}
			}
			//List<String> firstlevelUrl = new ArrayList<String>(setOfUrl);

		//	for (int i = 1; i < firstlevelUrl.size(); i++) {
				/*
				String levelFirstUrl = firstlevelUrl.get(i).replaceAll(" ", "%20");
				URL firstLevelUrl = new URL(levelurl); // this would check for
														// the protocol
				firstLevelUrl.toURI();
				String DomainOfFirstLevelUrl = checkDomain(levelFirstUrl);

				if (Domain.equals(DomainOfFirstLevelUrl)) {
					doc = Jsoup.connect(levelFirstUrl)
							.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
							.timeout(1000000).referrer("http://www.google.com").ignoreContentType(true).get();
					Elements FirstLevelelements = doc.select("a");
					for (Element element : FirstLevelelements) {
						//logger.debug("first Level urls--" + element.absUrl("href"));
						if (!element.absUrl("href").contains("#") && !element.absUrl("href").equals("")
								&& !setOfUrl.contains(element.absUrl("href")) && !element.absUrl("href").contains("mailto")) {
							setOfUrl.add(element.absUrl("href"));
						}

					}
				}
				

			*/
			//}
			for(int i=0;i<setOfUrl.size();i++)
			{
			//	logger.debug("---list elements-------" + setOfUrl.get(i));
			}
			//logger.debug("-----------" + setOfUrl.size());
			responseToReturn.setSetOfURL(setOfUrl);
			responseToReturn.setSize(setOfUrl.size());


		
}

		catch (MalformedURLException e) {
			e.printStackTrace();

		}
		
		catch (HttpStatusException e) {
			e.printStackTrace();
		} catch (IOException e) {

			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return responseToReturn;
	}
}
