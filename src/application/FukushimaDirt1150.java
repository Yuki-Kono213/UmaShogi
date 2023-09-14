package application;

import java.util.ArrayList;
import java.util.Arrays;

public class FukushimaDirt1150 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "芝スタート";
		range = 1150;
		raceGround = "ダート";
		first3furlong = 34.7;
		last3furlong = 36.3;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：7～8枠\r\n"
				+ "逃げ馬の勝率が高く、圧倒的に有利なコース。"
				+ "追い込み馬はきわめて好走確率が低く、とにかく前に行けることが絶対条件となる。"
				+ "芝スタートで外枠も良績。";
		startDistance = "長い";

		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
	}
	
}
