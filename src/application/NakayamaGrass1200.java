package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NakayamaGrass1200 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1200;
		raceGround = "芝";
		first3furlong = 33.5;
		last3furlong = 34.9;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：4～8枠\r\n"
				+ "直線の短いスプリント戦ではあるが、距離損のない内枠よりも外目の枠の方が優勢。"
				+ "むしろ短い直線でゴチャつく方が不利で、"
				+ "外目でゆったりと運ぶほうが好成績の傾向。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(4,5,6,7,8));
	}
	
}
