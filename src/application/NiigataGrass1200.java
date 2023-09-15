package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NiigataGrass1200 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "左回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1200;
		raceGround = "芝";
		first3furlong = 34.2;
		last3furlong = 35.1;
		textString = "好走脚質：逃げ・差し\r\n好走枠　：3～4枠\r\n"
				+ "クラスによって脚質傾向が異なるのが特徴。"
				+ "下級条件は逃げ先行が有利。上級条件では好位～中団からの差しも届く。"
				+ "こちらも追い込み馬は共通して苦戦傾向にある。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(3,4));
	}
	
}
