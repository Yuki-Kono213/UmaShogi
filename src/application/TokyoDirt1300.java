package application;

import java.util.ArrayList;
import java.util.Arrays;

public class TokyoDirt1300 extends RaceCourse {
	{
		courseName = "東京ダート1300";
		straightDistance = "長い";
		straightSlope = "やや坂";
		rotationSide = "左回り";
		rotationSize = "大回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1300;
		raceGround = "ダート";
		excludeLast3furlong = 42.6;
		first3furlong = 36.0;
		last3furlong = 37.1;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～4枠\r\n"
				+ "ダ―ト短距離戦にしては逃げ馬の成績が圧倒的というわけではなく、"
				+ "必ずしも逃げる必要がない5番手以内が理想。"
				+ "好位から上がり上位の脚が使える馬がベスト。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
	}
	
}
