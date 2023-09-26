package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KyotoGrass1200 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1200;
		raceGround = "芝";
		first3furlong = 34.2;
		last3furlong = 34.4;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～2枠\r\n"
				+ "スタート後の上り坂の影響でペースは緩みやすく、"
				+ "かつ後半は下り坂で直線は平坦。"
				+ "逃げ馬が残りやすく内で立ち回った馬も好成績を残している。";
		startDistance = "普通";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2));
	}
	
}
