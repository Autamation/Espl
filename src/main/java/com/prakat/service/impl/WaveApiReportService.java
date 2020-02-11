package com.prakat.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakat.dao.impl.TenonApiDaoImpl;
import com.prakat.model.TenonByWCAG;
import com.prakat.model.WaveApiByWCAG;

@Service
public class WaveApiReportService {
	@Autowired
	TenonApiDaoImpl dao;

	public List<WaveApiByWCAG> waveApiMethod(String waveApiKey, String waveApiUrl, String url, int userId) {

		List<WaveApiByWCAG> waveByWCAGs = new ArrayList<WaveApiByWCAG>();
		WaveApiByWCAG waveByWCAG = null;

		String urlParameter = "key=" + waveApiKey + "&url=" + url;
		System.out.println("ulr parameter is" + urlParameter);

		byte[] postData = urlParameter.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		waveByWCAG = new WaveApiByWCAG();
		try {
			URL url11 = new URL(waveApiUrl);
			System.out.println("url in try block" + url11);
			HttpURLConnection conn = (HttpURLConnection) url11.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			// Get Response
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(postData);

			InputStream is = conn.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println("inside while request");
				response.append(line);
				response.append('\r');
			}
			rd.close();

			JSONObject json = new JSONObject(response.toString());
			JSONObject json1 = (json.getJSONObject("categories"));
			// JSONArray array = json.getJSONArray("items");
			// ----dataa are write into wave api wcag class----///
			waveByWCAG.setUserId(userId);
			// ---feature---///
			JSONObject categories = json.getJSONObject("categories");
			JSONObject feature = categories.getJSONObject("feature");
			waveByWCAG.setFeatureCount(feature.getInt("count"));
			waveByWCAG.setFeatureDescription(feature.getString("description"));
			// ---end----///

			// ------aria--------///
			JSONObject aria = categories.getJSONObject("aria");
			waveByWCAG.setAriaCount(aria.getInt("count"));
			waveByWCAG.setAriaDescription(aria.getString("description"));
			// --end---//
			// ------alert------////
			JSONObject alert = categories.getJSONObject("alert");
			waveByWCAG.setAlertCount(alert.getInt("count"));
			waveByWCAG.setAlertDescription(alert.getString("description"));
			// --end---//
			// ----contrast----///
			JSONObject contrast = categories.getJSONObject("contrast");
			waveByWCAG.setContrastCount(contrast.getInt("count"));
			waveByWCAG.setContrastDescription(contrast.getString("description"));
			// --end---//
			// -----error-----//
			JSONObject error = categories.getJSONObject("error");
			waveByWCAG.setErrorCount(error.getInt("count"));
			waveByWCAG.setContrastDescription(error.getString("description"));
			// --end--//
			// ---structure---///
			JSONObject structure = categories.getJSONObject("structure");
			waveByWCAG.setStructureCount(structure.getInt("count"));
			waveByWCAG.setStructureDescription(structure.getString("description"));
			// ---end---//
			dao.saveDetailsOfAllUrlWaveApi(waveByWCAG);
		}

		catch (Exception e) {
			System.out.println(e);
		}
		waveByWCAGs.add(waveByWCAG);

		return waveByWCAGs;

	}

}
