package application;

import java.util.ArrayList;
import java.util.Arrays;

public class SapporoGrass1200 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "大回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1200;
		raceGround = "芝";
		first3furlong = 34.1;
		last3furlong = 35.3;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～5枠\r\n"
				+ "直線が短くコーナー半径が緩やかな札幌競馬場。"
				+ "遠心力が働く外枠が不利であることと、"
				+ "直線が短いので後方待機組が届かないのが大きな特徴である。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	}
	
}
