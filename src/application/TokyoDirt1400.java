package application;

import java.util.ArrayList;
import java.util.Arrays;

public class TokyoDirt1400 extends RaceCourse {
	{
		straightDistance = "長い";
		straightSlope = "やや坂";
		rotationSide = "左回り";
		rotationSize = "大回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1400;
		raceGround = "ダート";
		excludeLast3furlong = 48.8;
		first3furlong = 36.0;
		last3furlong = 37.3;
		textString = "好走脚質：先行・差し\r\n好走枠　：3～8枠\r\n"
				+ "上がり1位馬の勝率が高く、ダート戦ながら決め手が重要となるコース。"
				+ "特にクラスが上がるほど、その傾向が強まる。"
				+ "ダート戦では異質な条件といえる。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(3,4,5,6,7,8));
	}
	
}
