package application;

import java.util.ArrayList;
import java.util.Arrays;

public class ChukyoDirt1900 extends RaceCourse {
	{
		straightDistance = "長い";
		straightSlope = "急坂";
		rotationSide = "左回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 1900;
		raceGround = "ダート";
		excludeLast3furlong = 82.8;
		first3furlong = 37.4;
		last3furlong = 38.6;
		textString = "好走脚質：先行・差し\r\n好走枠　：3～5枠\r\n"
				+ "スタート直後から上り坂で1コーナーまでの距離が長い。"
				+ "そのためレース前半から勢いがついてペースが速くなりやすい。"
				+ "先行馬よりも差し馬の方が優勢で、決め手を評価。";
		startDistance = "普通";

		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(3,4,5));
	}
	
}
