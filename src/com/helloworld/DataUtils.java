package com.helloworld;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class DataUtils {

	public static final String[] ALPHABET = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
			"p", "q", "r", "s", "t", "u", "v", "x", "y", "w", "z" };
	
	public static final String  languages[] = { "tiếng anh", "tiếng việt", "tây ban nha", "bồ đào nha", "pháp", "đức", "ý", "ba lan",
			"hà lan", "nga", "thổ nhĩ kỳ", "ukraina", "hindi", "indonesia", "hy lạp", "nhật", "hàn" };
	
	public static final String locations[] = { "US", "UK", "Vietnam", "France", "Germany", "Italy", "Spain", "Mexico", "Peru",
			"Colombia", "Turkey", "Korea", "Japan", "Polan", "Greek", "Netherlands", "Russia", "Ukraian",
			"Indonesia", "India", "Portugal", "Brazil" };

	public static List<String> parseData(String data) {
		ArrayList<String> results = new ArrayList<String>();
		JSONArray array = new JSONArray(data.substring(5));
		try {
			JSONArray dataArray = new JSONArray(
					new JSONArray(new JSONArray(array.optString(2)).optString(0)).optString(0));
			for (int i = 0; i < dataArray.length(); i++) {
				String sugguestionComponent = new JSONArray(dataArray.optString(i)).optString(0);
				results.add(sugguestionComponent);
				//System.out.println("Sugguest: " + sugguestionComponent);

			}
		} catch (JSONException e) {
			return results;
		}
		return results;

	}
	
	public static String getLocationCode(String country) {
		if (country.equalsIgnoreCase(locations[0])) {
			return "us";
		}
		if (country.equalsIgnoreCase(locations[1])) {
			return "gb";
		}
		if (country.equalsIgnoreCase(locations[2])) {
			return "vn";
		}
		if (country.equalsIgnoreCase(locations[3])) {
			return "fr";
		}
		if (country.equalsIgnoreCase(locations[4])) {
			return "de";
		}
		if (country.equalsIgnoreCase(locations[5])) {
			return "it";
		}
		if (country.equalsIgnoreCase(locations[6])) {
			return "es";
		}
		if (country.equalsIgnoreCase(locations[7])) {
			return "mx";
		}
		if (country.equalsIgnoreCase(locations[8])) {
			return "pe";
		}
		if (country.equalsIgnoreCase(locations[9])) {
			return "co";
		}
		if (country.equalsIgnoreCase(locations[10])) {
			return "tr";
		}
		if (country.equalsIgnoreCase(locations[11])) {
			return "kr";
		}
		if (country.equalsIgnoreCase(locations[12])) {
			return "jp";
		}
		if (country.equalsIgnoreCase(locations[13])) {
			return "pl";
		}
		if (country.equalsIgnoreCase(locations[14])) {
			return "gr";
		}
		if (country.equalsIgnoreCase(locations[15])) {
			return "nl";
		}
		if (country.equalsIgnoreCase(locations[16])) {
			return "ru";
		}
		if (country.equalsIgnoreCase(locations[17])) {
			return "ua";
		}
		if (country.equalsIgnoreCase(locations[18])) {
			return "id";
		}
		if (country.equalsIgnoreCase(locations[19])) {
			return "in";
		}
		if (country.equalsIgnoreCase(locations[20])) {
			return "pt";
		}
		if (country.equalsIgnoreCase(locations[21])) {
			return "br";
		}
		return "us";
	}
	
	public static String getLanguageCode(String language) {
		if (language.equalsIgnoreCase(languages[0])) {
			return "en";
		}
		if (language.equalsIgnoreCase(languages[1])) {
			return "vi";
		}
		if (language.equalsIgnoreCase(languages[2])) {
			return "es";
		}
		
		if (language.equalsIgnoreCase(languages[3])) {
			return "pt";
		}
		if (language.equalsIgnoreCase(languages[4])) {
			return "fr";
		}
		if (language.equalsIgnoreCase(languages[5])) {
			return "de";
		}
		if (language.equalsIgnoreCase(languages[6])) {
			return "it";
		}
		if (language.equalsIgnoreCase(languages[7])) {
			return "pl";
		}
		if (language.equalsIgnoreCase(languages[8])) {
			return "nl";
		}
		if (language.equalsIgnoreCase(languages[9])) {
			return "ru";
		}
		if (language.equalsIgnoreCase(languages[10])) {
			return "tr";
		}
		if (language.equalsIgnoreCase(languages[11])) {
			return "uk";
		}
		if (language.equalsIgnoreCase(languages[12])) {
			return "hi";
		}
		if (language.equalsIgnoreCase(languages[13])) {
			return "id";
		}
		if (language.equalsIgnoreCase(languages[14])) {
			return "el";
		}
		if (language.equalsIgnoreCase(languages[15])) {
			return "ja";
		}
		if (language.equalsIgnoreCase(languages[16])) {
			return "ko";
		}
		return "en";
	}
}
