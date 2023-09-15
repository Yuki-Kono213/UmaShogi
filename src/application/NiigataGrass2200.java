package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NiigataGrass2200 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "左回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2200;
		raceGround = "芝";
		excludeLast3furlong = 98.8;
		first3furlong = 35.7;
		last3furlong = 35.5;
		textString = "好走脚質：先行・差し\r\n好走枠 ：5～6枠\r\n"
				+ "内回りの中距離戦で直線は短くなるため、"
				+ "外回りと比較すると先行馬にとって有利な条件に。"
				+ "決め手よりも、立ち回りやポジション取りが重要となる。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(5,6));
	}
	
}
