package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KyotoGrass2000 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2000;
		raceGround = "芝";
		excludeLast3furlong = 85.9;
		first3furlong = 36.5;
		last3furlong = 35.1;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：3～4枠\r\n"
				+ "直線の短い内回りコースのため、決め手を生かしたい人気馬が苦戦。"
				+ "中盤までの位置取りが重要になり、"
				+ "前半から中盤でポジションを取れる馬が有利。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(3,4));
	}
	
}
