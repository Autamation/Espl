package com.prakat.util;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.java.exception.EQualityLabsException;
import com.prakat.model.TenonApiVo;
import com.prakat.response.ResponseURL;

public class EQualityLabsUtil {
	static Logger logger = Logger.getLogger(EQualityLabsUtil.class.getName());

	private static final String PRINCIPAL_1 = "Perceivable";

	private static final String PRINCIPAL_2 = "Operable";

	private static final String PRINCIPAL_3 = " Understandable";

	private static final String PRINCIPAL_4 = "Robust";

	private static final String GUIDLINE_1_1 = "Text Alternatives";
	private static final String GUIDLINE_1_2 = "Time-based Media";
	private static final String GUIDLINE_1_3 = "Adaptable";
	private static final String GUIDLINE_1_4 = "Distinguishable";
	private static final String GUIDLINE_2_1 = "Keyboard Accessible";
	private static final String GUIDLINE_2_2 = "Enough Time";
	private static final String GUIDLINE_2_3 = "Seizures";
	private static final String GUIDLINE_2_4 = "Navigable";
	private static final String GUIDLINE_3_1 = "Readable";
	private static final String GUIDLINE_3_2 = "Predictable";
	private static final String GUIDLINE_3_3 = "Input Assistance";
	private static final String GUIDLINE_4_1 = "Compatible";

	public TenonApiVo GetDetailsFromWCAG(String wcag) {
		TenonApiVo tenonApiVo = new TenonApiVo();
		String split[] = wcag.split(",");
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			if (s.startsWith(" Level A:")) {
				logger.debug(split[i]);
				if ((split[i]).equals(" Level A: 4.1.2 Name")) {
					split[i] = "Level A: 4.1.2 Name,  Role,  Value";
				}
				String guideline[] = split[i].split(":");
				logger.info("Level name----" + "WCAG2A");
				tenonApiVo.setWCAG_Level("WCAG2A");
				logger.info("Sublevel description ----" + guideline[1].substring(7));
				tenonApiVo.setSublevel_Description(guideline[1].substring(7).replace("]", ""));
				logger.info("guidline A--" + guideline[1].substring(0, 4));
				checkGuideline(guideline[1].substring(0, 4), tenonApiVo);
				tenonApiVo.setWCAG_Guideline(guideline[1].substring(0, 4));
				tenonApiVo.setWCAG_Sublevel(guideline[1].substring(0, 6));
				checkPrincipal(guideline[1].substring(0, 5), tenonApiVo);

				continue;
			}
			if (s.startsWith(" Level AA:")) {
				logger.debug(split[i]);
				String guideline[] = split[i].split(":");
				tenonApiVo.setWCAG_Level("WCAG2AA");
				tenonApiVo.setSublevel_Description(guideline[1].substring(7).replace("]", ""));
				checkGuideline(guideline[1].substring(0, 4), tenonApiVo);
				tenonApiVo.setWCAG_Guideline(guideline[1].substring(0, 4));
				tenonApiVo.setWCAG_Sublevel(guideline[1].substring(0, 6));
				checkPrincipal(guideline[1].substring(0, 5), tenonApiVo);

				continue;
			}
			if (s.startsWith(" Level AAA:")) {
				logger.debug(split[i]);
				String guideline[] = split[i].split(":");
				tenonApiVo.setWCAG_Level("WCAG2AAA");
				tenonApiVo.setSublevel_Description(guideline[1].substring(7).replace("]", ""));
				checkGuideline(guideline[1].substring(0, 4), tenonApiVo);
				tenonApiVo.setWCAG_Guideline(guideline[1].substring(0, 4));
				tenonApiVo.setWCAG_Sublevel(guideline[1].substring(0, 6));
				checkPrincipal(guideline[1].substring(0, 5), tenonApiVo);

				continue;
			}
		}
		return tenonApiVo;

	}

	private void checkGuideline(String guideline, TenonApiVo tenonApiVo) {
		if (guideline.startsWith(" 1.1")) {

			tenonApiVo.setGuideline_Description(GUIDLINE_1_1);
		}

		if (guideline.startsWith(" 1.2")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_1_2);
		}

		if (guideline.startsWith(" 1.3")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_1_3);

		}
		if (guideline.startsWith(" 1.4")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_1_4);

		}
		if (guideline.startsWith(" 2.1")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_2_1);

		}
		if (guideline.startsWith(" 2.2")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_2_2);

		}
		if (guideline.startsWith(" 2.3")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_2_3);

		}
		if (guideline.startsWith(" 2.4")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_2_4);

		}
		if (guideline.startsWith(" 3.1")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_3_1);

		}
		if (guideline.startsWith(" 3.2")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_3_2);

		}
		if (guideline.startsWith(" 3.3")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_3_3);

		}
		if (guideline.startsWith(" 4.1")) {
			tenonApiVo.setGuideline_Description(GUIDLINE_4_1);

		}

	}

	private void checkPrincipal(String guideline, TenonApiVo tenonApiVo) {
		if (guideline.startsWith(" 1")) {
			tenonApiVo.setPrinciple_Description(PRINCIPAL_1);
			tenonApiVo.setWCAG_Principle("Principal1");
		}
		if (guideline.startsWith(" 2")) {
			tenonApiVo.setPrinciple_Description(PRINCIPAL_2);
			tenonApiVo.setWCAG_Principle("Principal2");

		}
		if (guideline.startsWith(" 3")) {
			tenonApiVo.setPrinciple_Description(PRINCIPAL_3);
			tenonApiVo.setWCAG_Principle("Principal3");

		}
		if (guideline.startsWith(" 4")) {
			tenonApiVo.setPrinciple_Description(PRINCIPAL_4);
			tenonApiVo.setWCAG_Principle("Principal4");

		}

	}

	public static void main(String[] args) {
		EQualityLabsUtil e = new EQualityLabsUtil();
		// e.getWorkbook();
		String wcag = "[Web Content Accessibility Guidelines (WCAG) 2.0, Level A: 1.3.1 Info and Relationships,Web Content Accessibility Guidelines (WCAG) 2.0, Level AAA: 2.4.10 Section Headings,Web Content Accessibility Guidelines (WCAG) 2.0, Level A: 4.1.2 Name, Role, Value]";

		e.GetDetailsFromWCAG(wcag);
		// createFile();
	}

	public static void createFile() {
		try {

			File file = new File("e:\\newfile.txt");

			if (file.createNewFile()) {
				logger.debug("File is created!");
			} else {
				logger.debug("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ResponseURL getLinksFromWeb(String url) throws MalformedURLException, URISyntaxException {
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
			org.jsoup.nodes.Document doc = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.timeout(100000).ignoreContentType(true).referrer("http://www.google.com").get();
			Elements elements = doc.select("a");
			for (Element element : elements) {
				// logger.debug("0 level url--" + element.absUrl("href"));
				if (!element.absUrl("href").contains("#") && !element.absUrl("href").equals("")
						&& !setOfUrl.contains(element.absUrl("href")) && !element.absUrl("href").contains("mailto")) {
					String DomainOfZeroLevel = getBaseDomain(element.absUrl("href"));
					if (Domain.equals(DomainOfZeroLevel)) {
						setOfUrl.add(element.absUrl("href"));
					}
				}
			}
			List<String> firstlevelUrl = new ArrayList<String>(setOfUrl);

			// for (int i = 1; i < firstlevelUrl.size(); i++) {
			/*
			 * String levelFirstUrl = firstlevelUrl.get(i).replaceAll(" ",
			 * "%20"); URL firstLevelUrl = new URL(levelurl); // this would
			 * check for // the protocol firstLevelUrl.toURI(); String
			 * DomainOfFirstLevelUrl = checkDomain(levelFirstUrl);
			 * 
			 * if (Domain.equals(DomainOfFirstLevelUrl)) { doc =
			 * Jsoup.connect(levelFirstUrl)
			 * .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0"
			 * ) .timeout(1000000).referrer("http://www.google.com").
			 * ignoreContentType(true).get(); Elements FirstLevelelements =
			 * doc.select("a"); for (Element element : FirstLevelelements) {
			 * //logger.debug("first Level urls--" + element.absUrl("href")); if
			 * (!element.absUrl("href").contains("#") &&
			 * !element.absUrl("href").equals("") &&
			 * !setOfUrl.contains(element.absUrl("href")) &&
			 * !element.absUrl("href").contains("mailto")) {
			 * setOfUrl.add(element.absUrl("href")); }
			 * 
			 * } }
			 * 
			 * 
			 */
			// }
			for (int i = 0; i < setOfUrl.size(); i++) {
				logger.debug("---list elements-------" + setOfUrl.get(i));
			}
			logger.debug("-----------" + setOfUrl.size());
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

	public static String getHost(String url) {
		if (url == null || url.length() == 0)
			return "";

		int doubleslash = url.indexOf("//");
		if (doubleslash == -1)
			doubleslash = 0;
		else
			doubleslash += 2;

		int end = url.indexOf('/', doubleslash);
		end = end >= 0 ? end : url.length();

		int port = url.indexOf(':', doubleslash);
		end = (port > 0 && port < end) ? port : end;

		return url.substring(doubleslash, end);
	}

	public boolean isValidUrl(String domainUrl) throws IOException, EQualityLabsException {

		try {
			URL u = new URL(domainUrl);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setRequestMethod("GET");
			huc.connect();
			int code = 0;
			code = huc.getResponseCode();
			if (code == 200) {

				return true;
			}
			if (code == 403) {
				throw new EQualityLabsException("HTTP error fetching URL,Status=403,Forbidden");
			}

		}

		catch (UnknownHostException ex) {
			throw new EQualityLabsException("UnknownHostException:--" + ex.getMessage());
		} catch (IOException e) {
			throw new EQualityLabsException("IOException:--" + e.getMessage());

		} catch (Exception exc) {
			throw new EQualityLabsException("Generic exception " + exc.getMessage());

		}
		return false;
	}

}
