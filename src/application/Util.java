package application;

import java.util.HashMap;
import java.util.Map;

public class Util {
	public static Map<String,Integer> RankMap = new HashMap<>(){
		{
			put("①", 1);
			put("②", 2);
			put("③", 3);
			put("④", 4);
			put("⑤", 5);
			put("⑥", 6);
			put("⑦", 7);
			put("⑧", 8);
			put("⑨", 9);
			put("⑩", 10);
			put("⑪", 11);
			put("⑫", 12);
			put("⑬", 13);
			put("⑭", 14);
			put("⑮", 15);
			put("⑯", 16);
			put("⑰", 17);
			put("⑱", 18);
			put("－", 19);
		}
	};
	
	public static Map<String,String> raceURL = new HashMap<>(){
		{
			put("1", "1");
			put("2", "2");
			put("3", "3");
			put("4", "4");
			put("5", "5");
			put("6", "6");
			put("7", "7");
			put("8", "8");
			put("9", "9");
			put("01", "1");
			put("02", "2");
			put("03", "3");
			put("04", "4");
			put("05", "5");
			put("06", "6");
			put("07", "7");
			put("08", "8");
			put("09", "9");
			put("10", "a");
			put("11", "b");
			put("12", "c");
		}
	};
	
	public static Map<String,String> stageURL = new HashMap<>(){
		{
			put("札幌", "1");
			put("函館", "2");
			put("福島", "3");
			put("新潟", "4");
			put("東京", "5");
			put("中山", "6");
			put("中京", "7");
			put("京都", "8");
			put("阪神", "9");
			put("小倉", "a");
		}
	};
	
	private static Map<String,String> tihouStageURL = new HashMap<>(){
		{
			put("帯広", "0");
			put("門別", "0");
			put("盛岡", "0");
			put("水沢", "0");
			put("浦和", "0");
			put("船橋", "0");
			put("大井", "0");
			put("川崎", "0");
			put("金沢", "0");
			put("笠松", "0");
			put("名古", "0");
			put("園田", "0");
			put("姫路", "0");
			put("高知", "0");
			put("佐賀", "0");
			put("イギ", "0");
			put("ア首", "0");
			put("フラ", "0");
			put("アメ", "0");
			put("香港", "0");
			put("サウ", "0");
			put("オー", "0");
		}
	};
	
	public static Map<String,String> stageKeibaRaboURL = new HashMap<>(){
		{
			put("札幌", "01");
			put("函館", "02");
			put("福島", "03");
			put("新潟", "04");
			put("東京", "05");
			put("中山", "06");
			put("中京", "07");
			put("京都", "08");
			put("阪神", "09");
			put("小倉", "10");
		}
	};
	
	public static Map<String,String> raceKeibaLaboURL = new HashMap<>(){
		{
			put("1", "01");
			put("2", "02");
			put("3", "03");
			put("4", "04");
			put("5", "05");
			put("6", "06");
			put("7", "07");
			put("8", "08");
			put("9", "09");
			put("10", "10");
			put("11", "11");
			put("12", "12");
		}
	};
	
	public static Map<String,String> RankTableMap = new HashMap<>(){
		{

			put("1", "①");
			put("2", "②");
			put("3", "③");
			put("4", "④");
			put("5", "⑤");
			put("6", "⑥");
			put("7", "⑦");
			put("8", "⑧");
			put("9", "⑨");
			put("10", "⑩");
			put("11", "⑪");
			put("12", "⑫");
			put("13", "⑬");
			put("14", "⑭");
			put("15", "⑮");
			put("16", "⑯");
			put("17", "⑰");
			put("18", "⑱");
			put("　", "　");
		}
	};
	

	public static boolean returnDicExist(String name, int cnt) {
		try {
			System.out.println(name);
			if(stageURL.get(name) != null) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception nfex) {
			return false;
		}
	}

	public static boolean returnLocalDicExist(String name, int cnt) {
		try {
			if(tihouStageURL.get(name) == "0") {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception nfex) {
			return false;
		}
	}
	
	public static boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}
	
	public static boolean returnDateCompare(String raceDate,  String targetDate) {
			if(Integer.parseInt(raceDate) > Integer.parseInt(targetDate)) {
				return true;
			}
			else {
				return false;
			}
	}
}
