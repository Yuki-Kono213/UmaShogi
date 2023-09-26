package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NakayamaDirt2400 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2400;
		raceGround = "ダート";
		excludeLast3furlong = 118.5;
		first3furlong = 38.6;
		last3furlong = 39.3;
		textString = "好走脚質：先行・差し\r\n好走枠　：1～6枠\r\n"
				+ "距離2400mとダートでは長丁場。さらに直線には急坂が待ち構え、"
				+ "道中はいかにスタミナを温存できるかが勝負の分かれ目に。"
				+ "距離損が多い外枠は軽視。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
	}
	
}
