package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HanshinGrass2200 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 2200;
		raceGround = "芝";
		excludeLast3furlong = 98.6;
		first3furlong = 35.7;
		last3furlong = 35.6;
		textString = "好走脚質：先行・差し\r\n好走枠　：2～4枠\r\n"
				+ "スタート後、コーナーまで距離があるので先行争いが激化しやすい。"
				+ "また、そこでゴチャつくためか1枠の成績が異常に悪く、"
				+ "その点は考慮しておきたい。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(2,3,4));
	}
	
}
