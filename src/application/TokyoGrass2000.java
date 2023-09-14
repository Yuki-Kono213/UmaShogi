package application;

import java.util.ArrayList;
import java.util.Arrays;

public class TokyoGrass2000 extends RaceCourse {
	{
		straightDistance = "長い";
		straightSlope = "やや坂";
		rotationSide = "左回り";
		rotationSize = "大回り";
		cornerShape = "U字";
		grassStart = "";
		range = 2000;
		raceGround = "芝";
		excludeLast3furlong = 86.1;
		first3furlong = 36.9;
		last3furlong = 34.6;
		textString = "好走脚質：先行・差し\r\n好走枠　：1～5枠\r\n"
				+ "スタート後すぐにコーナーという関係で、外枠の不利が顕著。"
				+ "特に14番より外になるとガクッと成績が落ちるので、"
				+ "人気馬でも割り引いて考えたい。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	}
	
}
