package application;

import java.util.ArrayList;
import java.util.Arrays;

public class FukushimaGrass1800 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 1800;
		raceGround = "芝";
		excludeLast3furlong = 72.8;
		first3furlong = 35.8;
		last3furlong = 35.8;
		textString = "好走脚質：先行・差し\r\n好走枠　：4～7枠\r\n"
				+ "直線の短い小回りコースで逃げ馬の活躍をイメージしがちだが、"
				+ "実際に活躍するのは先行と差し。"
				+ "ペースが速くなりやすく差しが決まりやすい。";
		startDistance = "普通";

		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(4,5,6,7));
	}
	
}
