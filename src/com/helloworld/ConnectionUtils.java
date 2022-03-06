package com.helloworld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;




public class ConnectionUtils {
	
	private static final String PLACE_HOLDER = "___PH___";


	public static String getSugguestion(String language, String country, String keyword) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		System.out.println("Searching: "+keyword);
		String address = String.format("https://play.google.com/_/PlayStoreUi/data/batchexecute?rpcids=IJ4APc&f.sid=-697906427155521722&bl=boq_playuiserver_20190903.08_p0&hl=%s&gl=%s&authuser&soc-app=121&soc-platform=1&soc-device=1&_reqid=1065213", language, country);
		String rawData = "f.req=%5B%5B%5B%22IJ4APc%22%2C%22%5B%5Bnull%2C%5B%5C%22$___PH___%5C%22%5D%2C%5B10%5D%2C%5B2%5D%2C4%5D%5D%22%5D%5D%5D".replace(PLACE_HOLDER, keyword);
		return post(address, rawData);
	}
	
	
	private static String post(String address, String rawData) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		//For Charles API Debug
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }

        } };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) { return true; }
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		
        //Create request
		URL obj = new URL("https://play.google.com/_/PlayStoreUi/data/batchexecute?rpcids=IJ4APc&f.sid=-697906427155521722&bl=boq_playuiserver_20190903.08_p0&hl=en&gl=us&authuser&soc-app=121&soc-platform=1&soc-device=1&_reqid=1065213");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty ("Cookie", "NID=511=HA0kQrN_YwuSNvqnh1R_ZZ4O7MIoNaS4z8gey8eXdOHXPU9eaG3DVk63HzP_vghMJu-sjT5ng6eU6_vlsQ2FzhyVMiOMmguxSdG1LrgQ14wcCmmB7ajT8PKX9Zi2gBx7bU0rOHwgYenQIXxxS8Ur1P1qt6GKV6h6Kmb5ZldhKNE");
		con.setDoOutput(true);

		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
		writer.write(rawData);
		writer.close();
		wr.close();

		int responseCode = con.getResponseCode();
		

		if (responseCode  == 200) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream(), Charset.forName("UTF-8")));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				
			}
			in.close();
			return response.toString();
			
			
		} else {
			return "";
		}
		
	}
	
	
	
	
}
