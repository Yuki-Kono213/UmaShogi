package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KyotoDirt1800 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "";
		cornerShape = "O字";
		grassStart = "";
		range = 1800;
		raceGround = "ダート";
		excludeLast3furlong = 75.4;
		first3furlong = 37.1;
		last3furlong = 38.1;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～4枠\r\n"
				+ "基本、逃げ・先行が有利で隊列通りの決着になりやすい。"
				+ "ただしマクリが決まるコースでもあり、好走率は逃げ馬と同等。"
				+ "道中で動ける馬がいれば要注意。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
	}
	
}
