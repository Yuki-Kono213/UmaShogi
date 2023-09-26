package application;

import java.util.ArrayList;
import java.util.Arrays;

public class SapporoGrass1500 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "大回り";
		cornerShape = "特殊";
		grassStart = "";
		range = 1500;
		raceGround = "芝";
		excludeLast3furlong = 53.8;
		first3furlong = 35.7;
		last3furlong = 35.6;
		textString = "好走脚質：先行・差し\r\n好走枠　：1～6枠\r\n"
				+ "1500mという札幌競馬場のみで行われる距離設定。"
				+ "マイルに近く、決め手が重要になるコースといえる。"
				+ "先行、もしくはある程度のポジションが取れる差し馬が優勢。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
	}
	
}
