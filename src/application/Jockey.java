package application;

import java.util.HashMap;
import java.util.Map;

public class Jockey {
	public static Map<String,String> jockeyStart = new HashMap<>(){
		{
			put("福永祐", "ス巧");
			put("川田将", "ス巧");
			put("和田竜", "ス巧");
			put("鮫島克", "ス巧");
			put("松若風", "ス巧");
			put("丸山元", "ス巧");
			put("西村淳", "ス巧");
			put("岩田康", "ス巧");
			put("菱田裕", "ス巧");
			put("松山弘", "ス巧");
			put("坂井瑠", "ス巧");
			put("Mデム", "ス下");
			put("武士沢", "ス下");
			put("太宰啓", "ス下");
			put("横山和", "ス下");
			put("田辺裕", "ス下");
			put("藤田菜", "ス下");
			put("横山典", "ス下");
			put("柴山雄", "ス下");
			put("内田博", "ス下");
			put("田中勝", "ス下");
			put("*", "");
		}
	};
	
	public static Map<String,String> firstMove = new HashMap<>(){
		{
			put("柴田善", "馬抑");
			put("Cルメ", "馬");
			put("横山典", "馬抑");
			put("北村友", "馬");
			put("秋山真", "馬");
			put("福永祐", "馬");
			put("武豊", "馬");
			put("丸田恭", "馬");
			put("武士沢", "馬");
			put("田辺裕", "馬");
			put("木幡巧", "追");
			put("坂井瑠", "追");
			put("野中悠", "追");
			put("木幡初", "追");
			put("加藤祥", "追");
			put("城戸義", "追");
			put("森裕太", "追");
			put("井上敏", "追");
			put("松若風", "追");
			put("酒井学", "追");
			put("勝浦正", "抑");
			put("三浦皇", "抑");
			put("松岡正", "抑");
			put("岩田康", "抑");
			put("藤田菜", "抑");
			put("丸山元", "抑");
			put("戸崎圭", "抑");
			put("津村明", "抑");
			put("*", "");
		}
	};
	
	public static Map<String,String> jockeySikake = new HashMap<>(){
		{
			put("Aシュ", "積");
			put("Cスミ", "積");
			put("Cデム", "積");
			put("Dレー", "積");
			put("Jモレ", "積");
			put("Lデッ", "積");
			put("Mデム", "積");
			put("Oマー", "積");
			put("Wビュ", "積");
			put("石橋脩", "積");
			put("内田博", "積");
			put("亀田温", "積");
			put("川田将", "積");
			put("国分恭", "積");
			put("木幡育", "積");
			put("木幡巧", "積");
			put("木幡初", "積");
			put("齊藤新", "積");
			put("酒井学", "積");
			put("菅原明", "積");
			put("団野大", "積");
			put("富田暁", "積");
			put("西村淳", "積");
			put("浜中俊", "積");
			put("吉田隼", "積");
			put("和田竜", "積");
			put("Cルメ", "控");
			put("Rムー", "控");
			put("池添謙", "控");
			put("岩田望", "控");
			put("岩田康", "控");
			put("大野拓", "控");
			put("荻野極", "控");
			put("勝浦正", "控");
			put("加藤祥", "控");
			put("川須栄", "控");
			put("川又賢", "控");
			put("菊沢一", "控");
			put("北村宏", "控");
			put("北村友", "控");
			put("城戸義", "控");
			put("国分優", "控");
			put("小崎綾", "控");
			put("坂井瑠", "控");
			put("鮫島克", "控");
			put("高倉稜", "控");
			put("武豊", "控");
			put("太宰啓", "控");
			put("田辺裕", "控");
			put("津村明", "控");
			put("戸崎圭", "控");
			put("中井裕", "控");
			put("菱田裕", "控");
			put("福永祐", "控");
			put("藤岡康", "控");
			put("藤岡佑", "控");
			put("古川吉", "控");
			put("松岡正", "控");
			put("松山弘", "控");
			put("松若風", "控");
			put("丸田恭", "控");
			put("丸山元", "控");
			put("三浦皇", "控");
			put("武藤雅", "控");
			put("森裕太", "控");
			put("横山典", "控");
			put("*", "");
		}
	};
	public static Map<String,String> jockeySinro = new HashMap<>(){
		{
			put("Cルメ", "内");
			put("石川裕", "内");
			put("岩田康", "内");
			put("江田照", "内");
			put("大野拓", "内");
			put("荻野琢", "内");
			put("勝浦正", "内");
			put("嘉藤貴", "内");
			put("川田将", "内");
			put("北村宏", "内");
			put("城戸義", "内");
			put("小崎綾", "内");
			put("柴田大", "内");
			put("嶋田純", "内");
			put("杉原誠", "内");
			put("高倉稜", "内");
			put("田中健", "内");
			put("丹内祐", "内");
			put("津村明", "内");
			put("戸崎圭", "内");
			put("中井裕", "内");
			put("長岡禎", "内");
			put("西村太", "内");
			put("浜中俊", "内");
			put("菱田裕", "内");
			put("福永祐", "内");
			put("藤岡康", "内");
			put("藤懸貴", "内");
			put("松山弘", "内");
			put("松若風", "内");
			put("的場勇", "内");
			put("黛弘人", "内");
			put("丸田恭", "内");
			put("丸山元", "内");
			put("三浦皇", "内");
			put("水口優", "内");
			put("宮崎北", "内");
			put("幸英明", "内");
			put("横山和", "内");
			put("横山典", "内");
			put("吉田隼", "内");
			put("和田竜", "内");
			put("Mデム", "外");
			put("石橋脩", "外");
			put("伊藤工", "外");
			put("内田博", "外");
			put("岡田祥", "外");
			put("川須栄", "外");
			put("国分恭", "外");
			put("小牧太", "外");
			put("木幡初", "外");
			put("鮫島良", "外");
			put("柴田善", "外");
			put("柴山雄", "外");
			put("武豊", "外");
			put("田中勝", "外");
			put("田辺裕", "外");
			put("藤岡佑", "外");
			put("武士沢", "外");
			put("古川吉", "外");
			put("吉田豊", "外");
			put("*", "");
			
		}
	};
	
}
