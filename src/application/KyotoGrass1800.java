package application;

import java.util.ArrayList;
import java.util.Arrays;

public class KyotoGrass1800 extends RaceCourse {
	{
		straightDistance = "長い";
		straightSlope = "平坦";
		rotationSide = "右回り";
		rotationSize = "大回り";
		cornerShape = "U字";
		grassStart = "";
		range = 1800;
		raceGround = "芝";
		excludeLast3furlong = 72.4;
		first3furlong = 35.7;
		last3furlong = 35.0;
		textString = "好走脚質：逃げ・先行\r\n好走枠　：1～3枠\r\n"
				+ "1番人気の勝率が高いように、極端なペースにはなりづらく、"
				+ "直線も長いためどの馬も力を発揮しやすい。"
				+ "馬の能力が問われるコースといっていいだろう。";
		startDistance = "長い";
		goodRaceFrame = new ArrayList<Integer>(Arrays.asList(1,2,3));
	}
	
}
