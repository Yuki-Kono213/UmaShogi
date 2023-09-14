package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KokuraGrass1200 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1200;
		raceGround = "芝";
		first3furlong = 33.5;
		last3furlong = 35.2;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～5枠\r\n"
				+ "スタートから下り坂というコースレイアウトのため、前半のペースが速くなりやすい。"
				+ "しかし、直線は平坦で開催前半ならスピードで押し切れる。"
				+ "開催後半になると差しが決まりやすい。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	}
	
}
