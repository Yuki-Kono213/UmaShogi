package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NiigataGrass1600 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "左回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1600;
		raceGround = "芝";
		excludeLast3furlong = 60.7;
		first3furlong = 35.8;	
		last3furlong = 34.1;
		textString = "好走脚質：先行・差し\r\n好走枠　：5～8枠\r\n"
				+ "やや外枠有利で差しや追い込みも決まりやすいが、"
				+ "1800m程ではない。好位～中団から速い上がりタイムを出せる馬が理想。"
				+ "逃げ切りは重賞・OPで発生。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(5,6,7,8));
	}
	
}
