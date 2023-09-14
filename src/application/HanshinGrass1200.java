package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HanshinGrass1200 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1200;
		raceGround = "芝";
		first3furlong = 34.2;
		last3furlong = 34.8;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～5枠\r\n"
				+ "3～4コーナーがかなり緩やかな造りになっているため、"
				+ "外枠は遠心力が強く外々を回らされる。"
				+ "そのため外目の枠が不利で、内枠中心に組み立てたい。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	}
	
}
