package application;

import java.util.ArrayList;
import java.util.Arrays;

public class HakodateGrass1800 extends RaceCourse {
	{
		straightDistance = "短い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "小回り";
		cornerShape = "O字";
		grassStart = "";
		range = 1800;
		raceGround = "芝";
		excludeLast3furlong = 73.3;
		first3furlong = 36.3;
		last3furlong = 35.6;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～6枠\r\n"
				+ "直線が短くゴール前は下り坂。いくら中距離戦とはいえ、"
				+ "物理的に差し馬が届く要素が少なく、逃げ馬や先行馬にとって競馬がしやすいコース。"
				+ "外枠も距離損が大きいので注意。";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
	}
	
}
