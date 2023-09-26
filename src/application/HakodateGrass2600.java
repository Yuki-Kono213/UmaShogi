package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HakodateGrass2600 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2600;
		raceGround = "芝";
		excludeLast3furlong = 125.9;
		first3furlong = 37.6;
		last3furlong = 36.0;
		textString = "好走脚質：先行・差し\r\n好走枠　：2～5枠\r\n"
				+ "他の競馬場の芝コースと比較して、やや差し馬も届くコース。"
				+ "とはいえ、基本的には先行有利は変わらず、4コーナー5番手以内が理想。"
				+ "差し馬も中盤までに押し上げられる馬を。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(2,3,4,5));
	}
	
}
