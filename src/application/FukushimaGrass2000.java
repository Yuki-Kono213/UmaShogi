package application;

import java.util.ArrayList;
import java.util.Arrays;

public class FukushimaGrass2000 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2000;
		raceGround = "芝";
		excludeLast3furlong = 85.1;
		first3furlong = 35.5;
		last3furlong = 36.1;
		textString = "好走脚質：先行・差し\r\n好走枠　：5～6枠\r\n"
				+ "1800m同様、決め手が意外と重要なコースだが、わずかにこちらの方が先行有利。"
				+ "また、特徴として中から外目の枠の好走が目立ち、"
				+ "特に5～6枠が好成績。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(5,6));
	}
	
}
