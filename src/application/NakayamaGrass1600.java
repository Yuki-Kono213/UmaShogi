package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NakayamaGrass1600 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "特殊";
		grassStart = "";
		range = 1600;
		raceGround = "芝";
		excludeLast3furlong = 59.6;
		first3furlong = 35.3;
		last3furlong = 35.3;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～5枠\r\n"
				+ "スタート後にすぐコーナーに差しかかる当コースは、"
				+ "8枠が物理的に不利な条件。外目の枠は軽視して考えたい。"
				+ "脚質は差しも届くが、基本は逃げ・先行から。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	}
	
}
