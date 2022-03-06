package com.helloworld;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class DataUtils {

	public static final String[] ALPHABET = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
			"p", "q", "r", "s", "t", "u", "v", "x", "y", "w", "z" };

	public static List<String> parseData(String data) {
		ArrayList<String> results = new ArrayList<String>();
		JSONArray array = new JSONArray(data.substring(5));
		try {
			JSONArray dataArray = new JSONArray(
					new JSONArray(new JSONArray(array.optString(2)).optString(0)).optString(0));
			for (int i = 0; i < dataArray.length(); i++) {
				String sugguestionComponent = new JSONArray(dataArray.optString(i)).optString(0);
				results.add(sugguestionComponent);
				System.out.println("Sugguest: " + sugguestionComponent);

			}
		} catch (JSONException e) {
			return results;
		}
		return results;

	}
}
