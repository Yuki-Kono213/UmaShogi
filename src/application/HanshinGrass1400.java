package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HanshinGrass1400 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1400;
		raceGround = "芝";
		excludeLast3furlong = 46.7;
		first3furlong = 34.5;
		last3furlong = 35.3;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～3枠\r\n"
				+ "3～4コーナーが緩やかな阪神競馬場は外枠不利。"
				+ "特に1400mではより顕著に表れており、"
				+ "1～3枠重視で。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3));
	}
	
}