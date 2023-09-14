package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NiigataGrass2400 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "左回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2400;
		raceGround = "芝";
		excludeLast3furlong = 112.6;
		first3furlong = 35.9;
		last3furlong = 35.8;
		textString = "好走脚質：先行・差し\r\n好走枠　：2～4枠\r\n"
				+ "長距離戦ということで同中のペースは緩みやすいが、直線が短くなる内回りコース。"
				+ "ゆえに直線一気も通用せず、先行馬が最も有利に。"
				+ "立ち回りが重要で、2～4枠が好成績を残している。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(2,3,4));
	}
	
}
