package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NiigataGrass1400 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "左回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1400;
		raceGround = "芝";
		excludeLast3furlong = 46.7;
		first3furlong = 34.4;
		last3furlong = 35.5;
		textString = "好走脚質：先行・差し\r\n好走枠　：1～2枠\r\n"
				+ "短距離戦ではあるが、逃げ馬は他のコースと比べても好走率が低い。"
				+ "狙いは先行馬で、特に内から抜け出すことのできる馬に注目。"
				+ "内回り戦は総じて追い込み馬は厳しい。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2));
	}
	
}
