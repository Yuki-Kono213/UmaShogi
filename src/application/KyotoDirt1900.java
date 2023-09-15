package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KyotoDirt1900 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "";
		cornerShape = "O字";
		grassStart = "";
		range = 1900;
		raceGround = "ダート";
		excludeLast3furlong = 82.2;
		first3furlong = 37.3;
		last3furlong = 37.9;
		textString = "好走脚質：先行・差し\r\n好走枠　：4～8枠\r\n"
				+ "ダート長距離戦はラップに特徴があり、"
				+ "100m延びるだけで適正が大きく異なる。"
				+ "速い上がりが必要になり、決め手が問われるコースといえる。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(4,5,6,7,8));
	}
	
}
