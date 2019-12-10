package com.prakat.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prakat.model.EQualityLabsVo;
import com.prakat.response.ResponseURL;

public class GeTReponseFromURL {
	static Logger logger = Logger.getLogger(GeTReponseFromURL.class.getName());

	private final static String apiURL = "GetResponseFromURL";

	@Autowired
	EQualityLabsVo equalityLabsVo;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String url = "https://www.bankofscotland.co.uk/helpcentre/money-worries/?WT.ac=BoS/Nav/MoneyWorries";
	//	String url = "http://prakat.com/home.html";
		// String url = "http://www.halifax.co.uk/loans/";
		// String key = "9927c26eece3c7b18e7194800a100932";
		String key = "8f856fd375d555452a78609f302d2136";
		//GeTReponseFromURL g = new GeTReponseFromURL();
		//GeTReponseFromURL.getLinksFromWeb(url);
		GeTReponseFromURL gt = new GeTReponseFromURL();
		gt.getResponseTAO();

		// List<EQualityLabsVo> ls=
	}
	
	/*private static String checkDomain(String url) throws URISyntaxException {
		// TODO Auto-generated method stub
		URI uri = new URI(url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}*/

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

	public static void getLinksFromWeb(String url) throws URISyntaxException {
		
		

		List<String> setOfUrl = null;
		try {
			setOfUrl = new ArrayList<String>();
			String Domain = getBaseDomain(url);
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
		//	List<String> firstlevelUrl = new ArrayList<String>(setOfUrl);

		/*	for (int i = 1; i < firstlevelUrl.size(); i++) {
				String levelFirstUrl = firstlevelUrl.get(i).replaceAll(" ", "%20");
				URL firstLevelUrl = new URL(levelurl); // this would check for
														// the protocol
				firstLevelUrl.toURI();
				String DomainOfFirstLevelUrl = getBaseDomain(levelFirstUrl);

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
				

			}*/
			for(int i=0;i<setOfUrl.size();i++)
			{
				logger.debug("---list elements-------" + setOfUrl.get(i));
			}
			logger.debug("-----------" + setOfUrl.size());

		}

		catch (MalformedURLException e) {
			e.printStackTrace();

		}
		catch (SocketException e) {
			e.printStackTrace();

		}

		catch (HttpStatusException e) {
			e.printStackTrace();
		} catch (IOException e) {

			logger.debug(e.getMessage());
			e.printStackTrace();
		}
	//	return responseToReturn;

	
	
	
	
	
	}

	
		public void getResponseTAO() throws Exception {
			BufferedReader rd = null;

		//	String asstURL ="http://119.82.97.217/TAO/taoResultServer/QtiRestResults/getLatest"; 
			//String asstURL="http://119.82.97.217/TAO/taoDelivery/DeliveryServer/runDeliveryExecution?deliveryExecution=http%3A%2F%2F192.168.1.114%2FTAO%2FPrakatTAO.rdf%23i15149589676658168";
			//String asstURL="http://119.82.97.217/TAO/taoDelivery/DeliveryServer/index";
			
			String asstURL="http://kishoreuser:kishore@119.82.97.217/TAO/tao/Main/login";
			
			//String urlParameters = ;
			byte[] postData = asstURL.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			InputStream is = null;
			URL url11 = new URL(asstURL);
			
			
			HttpURLConnection conn = (HttpURLConnection) url11.openConnection();
			String encoded = Base64.getEncoder().encodeToString(("kishoreuser"+":"+"kishore").getBytes(StandardCharsets.UTF_8)); 
			//conn.setRequestProperty("Authorization", "Basic "+encoded);

			//String encoded = Base64.encodeToString(("kishoreuser" + ":" + "kishore").getBytes("UTF-8")); 
			conn.setRequestProperty("Authorization", "Basic " + encoded);
			
			//Java 8
			//String encoded = Base64.getEncoder().encodeToString(("PrakatAdmin"+":"+"Prakat@123").getBytes(StandardCharsets.UTF_8));
			int encodedDataLength = encoded.getBytes().length;

			conn.setRequestProperty("Authorization", "Basic "+encoded);
			conn.setDoOutput(true);
			//conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("testtaker", "kishoreuser");
			conn.setRequestProperty("delivery", "Delivery of 8BAK-C Wellbeing Inventory");

			
			//application/json
		//	conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

		    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
		//	conn.setUseCaches(false);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(postData);
			// Get Response
			is = conn.getInputStream();
			rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();

			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			// logger.debug("-------reposne from apichecker--" +
			System.out.println(response.toString());
		}
			
		

	}

