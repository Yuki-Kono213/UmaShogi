package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KyotoGrass2200 extends RaceCourse {
	{
		straightDistance = "長い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "大回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2200;
		raceGround = "芝";
		excludeLast3furlong = 98.7;
		first3furlong = 36.3;
		last3furlong = 35.1;
		textString = "好走脚質：先行・差し\r\n好走枠　：5～8枠\r\n"
				+ "上がり1位を記録した馬の勝率が高い、決め手が問われるコース。"
				+ "枠順もむしろ外枠の方がよく、"
				+ "いかに速い上がりを使えるかが重要となる。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(5,6,7,8));
	}
	
}
