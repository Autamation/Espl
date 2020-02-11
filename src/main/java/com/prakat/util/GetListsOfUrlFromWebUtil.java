package com.prakat.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.prakat.response.ResponseURL;

public class GetListsOfUrlFromWebUtil {
	static Logger logger = Logger.getLogger(GetListsOfUrlFromWebUtil.class.getName());

	
	public static ResponseURL getLinksFromWeb(String url) {
		List<String> setOfUrl = null;
		ResponseURL responseToReturn = new ResponseURL();
		try {
			setOfUrl = new ArrayList<String>();
			Document doc = Jsoup.connect(url).get();
			Elements elements = doc.select("a");
			for (Element element : elements) {
				// logger.debug(element.absUrl("href"));
			/*	String internalLink = element.absUrl("href");
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
				*/
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
	
	
}
