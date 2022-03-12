package com.helloworld;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class DataUtils {

	public static final String[] ALPHABET = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
			"p", "q", "r", "s", "t", "u", "v", "x", "y", "w", "z" };
	
	public static final String[] ALPHABET_KR = {"ㅏ","ㄱ","ㅑ","ㄴ","ㅓ","ㄷ","ㅗ","ㄹ","ㅛ","ㅁ","ㅜ","ㅂ","ㅠ","ㅅ","ㅡ","ㅇ","ㅣ","ㅈ","애","ㅊ","얘","ㅋ","에","ㅌ","예","ㅍ","와","ㅎ","왜","ㄲ","외","ㄸ","워","ㅃ","웨","ㅆ","위","ㅉ","의"};
	
	public static final String[] ALPHABET_HI = {"अ","क","आ","ख","इ","ग","ई","घ","उ","ङ","ऊ","च","ए","छ","ऐ","ज","ओ","झ","औ","ञ","ऋ","ट","ॠ","ठ","ऌ","ड","ॡ","ढ","अ","ं","ण","अ","ः","त","अ","ँ","थ","द","ध","न","प","फ","ब","भ","म","य","र","ल","व","श","ष","स","ह","क","़","ख","़","ग","़","ज","़","फ","़","ड","़","ढ","़","क","्","ष","त","्","र","ज","्","ञ","श","्","र"};
	
	public static final String[] ALPHABET_PL = {"a","b","ą","c","e","ć","ę","c","z","i","d","y","d","ź","o","d","ż","u","d","z","ó","f","g","h","c","h","j","k","l","m","n","ł","ń","p","r","s","ś","s","z","t","w","z","ź","ż","r","z"};
	
	public static final String[] ALPHABET_GR = {"α","β","ε","γ","η","δ","ι","ζ","ο","θ","υ","κ","ω","λ","μ","μ","ξ","π","ρ","σ","ς","τ","φ","χ","ψ"};
	
	public static final String[] ALPHABET_UA = {"а","б","в","г","ґ","д","е","є","ж","з","и","і","ї","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ь","ю","я"};
	
	public static final String[] ALPHABET_TR = {"a","b","c","ç","d","e","f","g","ğ","h","ı","i","j","k","l","m","n","o","ö","p","r","s","ş","t","u","ü","v","y","z"};
	
	public static final String[] ALPHABET_AR = {"غ","ظ","ض","ذ","خ","ث","ت","ش","ر","ق","ص","ف","ع","س","ن","م","ل","ك","ي","ط","ح","ز","و","ه","د","ج","ب","ا","ش","غ","ظ","ذ","خ","ث","ت","س","ر","ق","ض","ف","ع","ص","ن","م","ل","ك","ي","ط","ح","ز","و","ه","د","ج","ب","ا","ي","و","ه","ن","م","ل","ك","ق","ف","غ","ع","ظ","ط","ض","ص","ش","س","ز","ر","ذ","د","خ","ح","ج","ث","ت","ب","ا","ي","و","ه","ش","س","ق","ف","غ","ع","ض","ص","ن","م","ل","ك","ظ","ط","ز","ر","ذ","د","خ","ح","ج","ث","ت","ب","ا"};
	
	public static final String[] ALPHABET_RS = {"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я"};
	
	public static final String[] ALPHABET_JP = {"あ","い","う","え","お"," ","か","き","く","け","こ","が","ぎ","ぐ","げ","ご"," ","さ"," ","し","す","せ","そ","ざ","じ","ず","ぜ","ぞ","た","ち","つ","て","と"," ","だ","ぢ"," ","づ","で","ど"," ","な","に","ぬ","ね","の"," ","は","ひ","ふ","へ","ほ"," ","ば","び","ぶ","べ","ぼ"," ","ぱ","ぴ","ぷ","ぺ","ぽ","ま","み","む","め","も","や","ゆ"," ","よ","ら","り","る"," ","れ","ろ","わ","を","ん","ア","イ","ウ","エ","オ","カ","キ","ク","ケ","コ","キ","ャ","キ","ュ","キ","ョ","サ","シ","ス","セ","ソ","シ","ャ","シ","ュ","シ","ョ","タ","チ","ツ","テ","ト","チ","ャ","チ","ュ","チ","ョ","ナ","ニ","ヌ","ネ","ノ","ニ","ャ","ニ","ュ","ニ","ョ","ハ","ヒ","フ","ヘ","ホ","ヒ","ャ","ヒ","ュ","ヒ","ョ","マ","ミ","ム","メ","モ","ミ","ャ","ミ","ュ","ミ","ョ","ヤ","ユ","ヨ","ラ","リ","ル","レ","ロ","リ","ャ","リ","ュ","リ","ョ","ラ","゚","リ","゚","ル","゚","レ","゚","ロ","゚","ワ","ギ","グ","ゲ","ゴ","ギ","ャ","ギ","ュ","ギ","ョ","ン","ジ","ズ","ゼ","ゾ","ジ","ャ","ジ","ュ","ジ","ョ"," ","ガ","ヂ","ヅ","デ","ド","ヂ","ャ","ヂ","ュ","ヂ","ョ"," ","ザ","ビ","ブ","ベ","ボ","ビ","ャ","ビ","ュ","ビ","ョ"," ","ダ","ピ","プ","ペ","ポ","ピ","ャ","ピ","ュ","ピ","ョ"," ","バ","ヴ","ヴ","ャ","ヴ","ュ","ヴ","ョ"," ","パ"};
	
	public static final String  languages[] = { "tiếng anh", "tiếng việt", "tây ban nha", "bồ đào nha", "pháp", "đức", "ý", "ba lan",
			"hà lan", "nga", "thổ nhĩ kỳ", "ukraina", "hindi", "indonesia", "hy lạp", "nhật", "hàn" };
	
	
	public static final String locations[] = { "US", "UK", "Vietnam", "France", "Germany", "Italy", "Spain", "Mexico", "Peru",
			"Colombia", "Turkey", "Korea", "Japan", "Polan", "Greek", "Netherlands", "Russia", "Ukraian",
			"Indonesia", "India", "Portugal", "Brazil" };
	
	public static String[] getAlphabet(String languageCode) {
		if (languageCode.equalsIgnoreCase("ko")) {
			return ALPHABET_KR;
		} 
		if (languageCode.equalsIgnoreCase("hi")) {
			return ALPHABET_HI;
		}
		if (languageCode.equalsIgnoreCase("pl")) {
			return ALPHABET_PL;
		}
		if (languageCode.equalsIgnoreCase("el")) {
			return ALPHABET_GR;
		}
		if (languageCode.equalsIgnoreCase("uk")) {
			return ALPHABET_UA;
		}
		if (languageCode.equalsIgnoreCase("tr")) {
			return ALPHABET_TR;
		}
		if (languageCode.equalsIgnoreCase("ar")) {
			return ALPHABET_AR;
		}
		if (languageCode.equalsIgnoreCase("ru")) {
			return ALPHABET_RS;
		}
		if (languageCode.equalsIgnoreCase("ja")) {
			return ALPHABET_JP;
		}
		return ALPHABET;
	}

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
