package application;

import java.util.ArrayList;
import java.util.Arrays;

public class NakayamaGrass1800 extends RaceCourse {
	{
		straightDistance = "";
		straightSlope = "急坂";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 1800;
		raceGround = "芝";
		excludeLast3furlong = 73.9;
		first3furlong = 36.6;
		last3furlong = 35.4;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：2～5枠\r\n"
				+ "小回りかつ直線の短いコースのため、逃げ馬と先行馬がやはり中心に。"
				+ "枠も内目が優勢だが、ゴチャつきやすい1枠だけはマイナス。"
				+ "立ち回りの差がカギになる。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(2,3,4,5));
	}
	
}
