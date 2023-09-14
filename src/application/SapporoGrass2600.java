package application;

import java.util.ArrayList;
import java.util.Arrays;

public class SapporoGrass2600 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "大回り";
		cornerShape = "O字";
		grassStart = "";
		range = 2600;
		raceGround = "芝";
		excludeLast3furlong = 126.0;
		first3furlong = 37.7;
		last3furlong = 36.4;
		textString = "好走脚質：先行・差し\r\n好走枠　：6～8枠\r\n"
				+ "長距離戦で道中のポジションも変わりやすいので、この条件なら外枠の不利はない。"
				+ "むしろ成績的には6～8枠の方が好成績。"
				+ "動きやすい外目を追走している馬のほうが狙いやすい。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(6,7,8));
	}
	
}
