package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HanshinGrass2000 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 2000;
		raceGround = "芝";
		excludeLast3furlong = 85.3;
		first3furlong = 36.4;
		last3furlong = 35.4;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：5～7枠\r\n"
				+ "直線の短い内回りコースというのもあるが、逃げ馬と先行馬がこの距離では狙い。"
				+ "スタート後すぐにコーナーに入るので、"
				+ "ペースは上がりづらくスローになりやすい。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(5,6,7));
	}
	
}
