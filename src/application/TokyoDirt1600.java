package application;

import java.util.ArrayList;
import java.util.Arrays;

public class TokyoDirt1600 extends RaceCourse {
	{
		straightDistance = "長い";
		straightSlope = "やや坂";
		rotationSide = "左回り";
		rotationSize = "大回り";
		cornerShape = "U字";
		grassStart = "芝スタート";
		range = 1600;
		raceGround = "ダート";
		excludeLast3furlong = 61.4;
		first3furlong = 35.9;
		last3furlong = 37.4;
		textString = "好走脚質：先行・差し\r\n好走枠　：6～8枠\r\n"
				+ "中央ダートでは唯一のダートマイル戦。傾向としては芝スタートで外枠優勢。"
				+ "あとは上がり上位馬の好走が目立つ。"
				+ "唯一の条件ということで、リピーター馬も狙いとなる。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(6,7,8));
	}
	
}
