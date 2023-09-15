package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NakayamaGrass2200 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2200;
		raceGround = "芝";
		excludeLast3furlong = 99.9;
		first3furlong = 37.1;
		last3furlong = 35.5;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～4枠\r\n"
				+ "中距離戦のため道中はペースが緩みやすく、"
				+ "外回りで行われるも、直線が短いため後方一気がハマりづらい。"
				+ "内で立ち回る馬が有利で、5枠より外の成績低下が顕著。";
		startDistance = "長い";	
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
	}
	
}
