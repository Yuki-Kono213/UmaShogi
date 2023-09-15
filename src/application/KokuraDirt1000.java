package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KokuraDirt1000 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1000;
		raceGround = "ダート";
		first3furlong = 34.3;
		last3furlong = 36.2;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～6枠\r\n"
				+ "スタートから下り坂というコースレイアウトで、前半からスピードに乗せやすい。"
				+ "ハイペースも誘発しそうだが、直線は平坦で短い。"
				+ "そのまま押し切れるコースでダッシュ力が重要となる。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
	
	}
	
}
