package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NakayamaGrass3600 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 3600;
		raceGround = "芝";
		excludeLast3furlong = 188.9;
		first3furlong = 37.3;
		last3furlong = 35.9;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：6～8枠\r\n"
				+ "ステイヤーズSのみで施行。内回りの長距離戦で後方待機組は差し届かない。"
				+ "好位からの競馬が理想。枠順は6～8枠が好成績で、"
				+ "外目をゆったりと追走できる方が好結果につながる。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(6,7,8));
	}
	
}
