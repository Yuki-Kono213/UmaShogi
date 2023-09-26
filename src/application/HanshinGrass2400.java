package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HanshinGrass2400 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2400;
		raceGround = "芝";
		excludeLast3furlong = 111.7;
		first3furlong = 37.6;
		last3furlong = 35.2;
		textString = "好走脚質：先行・差し\r\n好走枠　：1～4枠\r\n"
				+ "外回りの長距離戦ということでペースは緩みやすく、"
				+ "決め手勝負になりやすい。逃げ馬は回収率が100％を下回っており、"
				+ "期待値の低いコースであるといえる。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
	}
	
}
