package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HakodateGrass1200 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1200;
		raceGround = "芝";
		first3furlong = 34.1;
		last3furlong = 35.2;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～7枠\r\n"
				+ "JRAの中で最も直線の短い競馬場。"
				+ "また、ゴールまで下り坂というコースレイアウトのため、基本的に逃げ～好位で競馬をする馬の活躍が目立つ。"
				+ "8枠は距離ロスが大きく割り引きたい。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
	}
	
}
