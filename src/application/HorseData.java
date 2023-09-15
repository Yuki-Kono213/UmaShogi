package application;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HorseData 
{

	private double thisRaceJockeyWeight;
	
	private String no;
	private String name;
	private String raceStage;
	private String date;
	private String range;
	private String weather;
	private String stage;
	private String raceName;
	private String expect;
	private String result;
	private String jockey;
	private String jockeyWeight;
	private String horseCount;
	private String startNo;
	private String frameNo;
	private String time;
	private String behind;
	private String pace;
	private String last;
	private String sameRangeTime;
	private String weight;
	private String runRank;
	private String topHorse;
	private String analysis;
	private String goodRace;
	private String pastRace;
	private String address;
	private Double rate;
	
	private String raceLevel;


	private String grassGoodRaceResult;
	private String grassBitHeavyRaceResult;
	private String grassHeavyRaceResult;
	private String grassBadRaceResult;
	private String dirtGoodRaceResult;
	private String dirtBitHeavyRaceResult;
	private String dirtHeavyRaceResult;
	private String dirtBadRaceResult;
	
	private String pastMaxSpeed;
	private String pastMaxPace;
	private String pastMaxSpeedDifference;
	private String pastMaxSpeedLast;
	private String index;

	private String cornerShape;
	private String grassStart;
	private String raceGround;
	private String rotationSide;
	private String rotationSize;
	private String straightDistance;
	private String straightSlope;
	
	private int timeOrigin;
	private int rangeOrigin;
	private int score;
	private double timeHosei;
	private double gradeDiff;
	private RaceCourse courseThisRace;
	private RaceCourse courseMaxRace;
	private RaceCourse courseBeforeRace;
	private double excludeLast3furlong;
	private double first3furlong;
	private double last3furlong;
	private String beforeJockeyTrait;
	private String nowJockeyTrait;
	private int actualyTime;
	private int thisRaceFrame;
	private String condition;
	{this.index = "0";}
	  public HorseData(String no, String name, String analysis, List<String> horseString, List<String>pastRaceCondition, int raceRange, String maxRaceField, String address,
			  String raceLevel, Double thisWeight, String cornerShape, String grassStart,String  raceGround, String rotationSide, String rotationSize, String straightDistance, 
			  String straightSlope, String thisRaceJockey, String condition, int frame, Double rate) {
		  	 
		  	 this.raceLevel = raceLevel;
			 this.no = no;
			 this.name = name;
			 this.date =horseString.get(0);
			 this.raceStage = horseString.get(1);
			 this.range = horseString.get(2);
			 this.weather = horseString.get(3);
			 this.stage = horseString.get(4);
			 this.raceName = horseString.get(5);
			 this.expect = horseString.get(6);
			 this.result = horseString.get(7);
			 this.jockey = horseString.get(8);
			 this.beforeJockeyTrait =  this.jockey;
			 this.jockeyWeight = horseString.get(9);
			 this.horseCount = horseString.get(10);
			 this.frameNo = horseString.get(11);
			 this.startNo = horseString.get(12);
			 this.time = horseString.get(13);
			 this.behind = horseString.get(14);
			 this.pace = horseString.get(15) + horseString.get(16) + horseString.get(17);
			 this.last =  horseString.get(18);
			 this.weight =  horseString.get(19);
			 this.runRank = Util.RankTableMap.get(horseString.get(horseString.size() - 7)) +  Util.RankTableMap.get(horseString.get(horseString.size() - 6)) 
				+ Util.RankTableMap.get(horseString.get(horseString.size() - 5))+  Util.RankTableMap.get(horseString.get(horseString.size() - 4));
			 this.topHorse = horseString.get(horseString.size() - 3);
			 this.analysis = analysis;
			 rangeOrigin = Integer.parseInt(horseString.get(2).substring(1,5));
			 actualyTime = (Integer.parseInt(this.time.substring(0,1)) * 600 +  Integer.parseInt(this.time.substring(2,4)) * 10 + Integer.parseInt(this.time.substring(5,6)));
			 timeOrigin = (Integer.parseInt(this.time.substring(0,1)) * 600 +  Integer.parseInt(this.time.substring(2,4)) * 10 + Integer.parseInt(this.time.substring(5,6)));
			 timeOrigin *= ((double)raceRange / rangeOrigin);
					
			 this.sameRangeTime = Integer.toString((timeOrigin  / 600)) + ":" + String.format("%02d",timeOrigin  % 600 / 10) + "." + Integer.toString(timeOrigin  % 10);
			 this.goodRace = horseString.get(horseString.size() - 2);
			 this.pastRace = horseString.get(horseString.size() - 1);
			 this.grassGoodRaceResult = pastRaceCondition.get(0);
			 this.grassBitHeavyRaceResult = pastRaceCondition.get(1);
			 this.grassHeavyRaceResult = pastRaceCondition.get(2);
			 this.grassBadRaceResult = pastRaceCondition.get(3);
			 this.dirtGoodRaceResult = pastRaceCondition.get(4);
			 this.dirtBitHeavyRaceResult = pastRaceCondition.get(5);
			 this.dirtHeavyRaceResult = pastRaceCondition.get(6);
			 this.dirtBadRaceResult = pastRaceCondition.get(7);
			 this.pastMaxSpeed = pastRaceCondition.get(8);
			 this.pastMaxPace = pastRaceCondition.get(9);
			 this.pastMaxSpeedLast = pastRaceCondition.get(10);
			 this.address = address;
			 this.thisRaceJockeyWeight = thisWeight;
			 this.cornerShape = cornerShape;
			 this.grassStart = grassStart;
			 this.raceGround = raceGround;
			 this.rotationSide = rotationSide;
			 this.rotationSize = rotationSize;
			 this.straightDistance = straightDistance;
			 this.straightSlope = straightSlope;
			 if(this.runRank.replace("　", "").length() > 0) {
				 this.first3furlong =  Double.parseDouble(horseString.get(15)) + Double.parseDouble((Util.RankMap.get(this.runRank.replace("　", "").substring(0,1))).toString()) / 10 - 0.1;
			 }
			 else {
				 this.first3furlong = Double.parseDouble(horseString.get(15));
			 }
			 if(Integer.parseInt(this.range.substring(1,5)) % 200 != 0 && Integer.parseInt(this.range.substring(1,5)) % 100 == 0) {
				 this.first3furlong = this.first3furlong / 5 * 6;
			 }else if(Integer.parseInt(this.range.substring(1,5)) % 200 != 0 && Integer.parseInt(this.range.substring(1,5)) % 50 == 0) {
				 this.first3furlong = this.first3furlong / 55 * 60;
			 }
			 this.last3furlong =  Double.parseDouble(this.last);
			 double time = Double.parseDouble(this.time.split(":")[0]) * 60 + Double.parseDouble(this.time.split(":")[1]);
			 this.excludeLast3furlong =  time - Double.parseDouble(this.last);
			 CourseCondition(this.stage, this.range);
			 this.nowJockeyTrait = thisRaceJockey;
			 this.courseBeforeRace = RaceCourseUtil.ReturnRaceCourse(this.raceStage,this.range,this.raceName);
			 this.courseMaxRace = RaceCourseUtil.ReturnRaceCourse(this.pastMaxSpeed,this.range,this.raceName);
			 this.courseThisRace = SampleController.rc;
			 this.pastMaxSpeedDifference = pastRaceCondition.get(11);
//			 this.condition = condition;
			 this.thisRaceFrame = frame;
			 this.rate = rate;
			 calcIndex(raceRange, maxRaceField);
	  }
	  public HorseData(String raceLevel) {

			 this.raceLevel = raceLevel;
	  }
	  
	  public void CourseCondition(String stage, String range) {
		  
		  if(range.contains("芝")) {
				
			  if(stage.contains("稍"))
			  	{
					this.first3furlong -= 0.3;
					this.last3furlong -= 0.3;
					this.excludeLast3furlong -= 0.3 * (Integer.parseInt(range.replace("芝", "")) - 600) / 600;
			  	}
				else if(stage.contains("重"))
				{
					this.first3furlong -= 0.6;
					this.last3furlong -= 0.6;
					this.excludeLast3furlong -= 0.6 * (Integer.parseInt(range.replace("芝", "")) - 600) / 600;
				}
				else if(stage.contains("不"))
				{
					this.first3furlong -= 0.9;
					this.last3furlong -= 0.9;
					this.excludeLast3furlong -= 0.9 * (Integer.parseInt(range.replace("芝", "")) - 600) / 600;
				}
		  }if(range.contains("ダ")) {
				
			  if(stage.contains("稍"))
			  	{
					this.first3furlong += 0.3;
					this.last3furlong += 0.3;
					this.excludeLast3furlong += 0.3 * (Integer.parseInt(range.replace("ダ", "")) - 600) / 600;
			  	}
				else if(stage.contains("重"))
				{
					this.first3furlong += 0.6;
					this.last3furlong += 0.6;
					this.excludeLast3furlong += 0.6 * (Integer.parseInt(range.replace("ダ", "")) - 600) / 600;
				}
				else if(stage.contains("不"))
				{
					this.first3furlong += 0.9;
					this.last3furlong += 0.9;
					this.excludeLast3furlong += 0.9 * (Integer.parseInt(range.replace("ダ", "")) - 600) / 600;
				}
		  }
	  }

		double thisRaceGradeDiff = 1.0;
	public void calcIndex(int raceRange, String maxRaceField) {

		if(rate == 0.0 && (((LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY && SampleController.staticRaceDate.getDayOfWeek() != DayOfWeek.SUNDAY) || 
			(LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY &&  SampleController.staticRaceDate.getDayOfWeek() != DayOfWeek.SATURDAY)) 
			||	SampleController.staticRaceDate.isBefore(LocalDate.now()))) {
			this.index = "0";
			return;
		}
		int base = 0;
		score = 0;
		
//		if(analysis.contains("やや有利")) {
//			base = 50;
//		}
//		else if(analysis.contains("やや不利"))
//		{
//			base = -50;
//		}
//		else if(analysis.contains("有利"))
//		{
//			base = 100;
//		}
//		else if(analysis.contains("不利"))
//		{
//			base = -100;
//		}
		
		
		if(SampleController.matchDate.isBefore(LocalDate
				.parse(this.date, DateTimeFormatter.ofPattern("yyyy/[]M/[]d")).plusMonths(6)) && SampleController.rdm.grass) {
			score += 200;
			
		}
		else if(SampleController.matchDate.isBefore(LocalDate
				.parse(this.date, DateTimeFormatter.ofPattern("yyyy/[]M/[]d")).plusMonths(6)) && !SampleController.rdm.grass) {
			score += 300;
			
		}
		
		if(this.courseThisRace.goodRaceFrame.contains(thisRaceFrame)) {
			//score -= 100;
		}

		
		if(SampleController.grassDirt.equals("芝") && 
				(SampleController.condition.contains("良") || SampleController.condition.contains("稍"))
				&& SampleController.raceDateCount < 5 && this.courseThisRace.startDistance.contains("長い")) {
			//score += thisRaceFrame * 10;
		}
		else if(SampleController.grassDirt.equals("芝") && 
				(SampleController.condition.contains("良") || SampleController.condition.contains("稍"))
				&& SampleController.raceDateCount < 5 && this.courseThisRace.startDistance.contains("普通") ) {
			//score += thisRaceFrame * 30;
		}
		else if(SampleController.grassDirt.equals("芝") && 
				(SampleController.condition.contains("良") || SampleController.condition.contains("稍"))
				&& SampleController.raceDateCount < 5 && this.courseThisRace.startDistance.contains("短い")) {
			//score += thisRaceFrame * 40;
		}
		
		if((SampleController.grassDirt.equals("ダ") ||
				(SampleController.grassDirt.equals("芝")
				&&(SampleController.condition.contains("重") || SampleController.condition.contains("不"))) || SampleController.raceDateCount > 9 )
			 && this.courseThisRace.startDistance.contains("長い")){
			//score += (8 - thisRaceFrame) * 40;
		}else if((SampleController.grassDirt.equals("ダ") ||
				(SampleController.grassDirt.equals("芝")
				&&(SampleController.condition.contains("重") || SampleController.condition.contains("不"))) || SampleController.raceDateCount > 9 )
			 && this.courseThisRace.startDistance.contains("普通")){
			//score += (8 - thisRaceFrame) * 30;
		}else if((SampleController.grassDirt.equals("ダ") ||
				(SampleController.grassDirt.equals("芝")
				&&(SampleController.condition.contains("重") || SampleController.condition.contains("不"))) || SampleController.raceDateCount > 9 )
			 && this.courseThisRace.startDistance.contains("短い")){
			//score += (8 - thisRaceFrame) * 10;
		}
		
		if(SampleController.grassStartBool && SampleController.condition.contains("良")) {
			if(thisRaceFrame > 0 && thisRaceFrame < 3) {
				score += 0;
			}
			else if(thisRaceFrame > 2 && thisRaceFrame < 5) {
				score -= 100;
			}
			else if(thisRaceFrame > 4 && thisRaceFrame < 7) {
				score -= 200;
			}	
			else if(thisRaceFrame > 6 && thisRaceFrame < 9) {
				score -= 300;
			}
			
		}
		
		int rangeDiff = 0;
		if(raceRange > rangeOrigin) {
			rangeDiff = (raceRange - rangeOrigin);
			if(rangeDiff > 2000) {
				rangeDiff = 2000;
			}
		}
		else if(raceRange < rangeOrigin)
		{
			rangeDiff = (int)((raceRange - rangeOrigin) * 14 / 10);
			if(rangeDiff < -1300 && raceRange > 1600) {
				rangeDiff = -1300;
			}
			else if(rangeDiff < -800 && raceRange <= 1600) {
				rangeDiff = -800;
			}
		}
		else {
			//rangeDiff = -100;
		}
		thisRaceGradeDiff = 1.0;
		if(SampleController.grade.contains("1勝"))
		{
			thisRaceGradeDiff = 1.05;
		}
		else if(SampleController.grade.contains("2勝"))
		{
			thisRaceGradeDiff = 1.10;
		}
		else if(SampleController.grade.contains("3勝"))
		{
			thisRaceGradeDiff = 1.15;
		}
		else if(SampleController.grade.contains("オープン") || SampleController.grade.contains("OP") || SampleController.grade.contains("Ｌ") )
		{
			thisRaceGradeDiff = 1.2;
		}
		else if(SampleController.grade.contains("ＧⅢ") || SampleController.grade.contains("重賞"))
		{
			thisRaceGradeDiff = 1.3;
		}
		else if(SampleController.grade.contains("ＧⅡ"))
		{
			thisRaceGradeDiff = 1.4;
		}
		else if(SampleController.grade.contains("ＧⅠ"))
		{
			thisRaceGradeDiff = 1.5;
		}
		gradeDiff = 1.0;
		if(this.raceName.contains("1勝"))
		{
			gradeDiff = 1.05;
		}
		else if(this.raceName.contains("2勝"))
		{
			gradeDiff = 1.10;
		}
		else if(this.raceName.contains("3勝"))
		{
			gradeDiff = 1.15;
		}
		else if(this.raceName.contains("オープン") ||this.raceName.contains("OP") || this.raceName.contains("Ｌ") )
		{
			gradeDiff = 1.2;
		}
		else if(this.raceName.contains("ＧⅢ") || this.raceName.contains("重賞"))
		{
			gradeDiff = 1.3;
		}
		else if(this.raceName.contains("ＧⅡ"))
		{
			gradeDiff = 1.4;
		}
		else if(this.raceName.contains("ＧⅠ"))
		{
			gradeDiff = 1.5;
		}

		score -= 800 * gradeDiff;
		if(this.analysis.contains("勝利")) {

			double totalscore = Double.parseDouble(this.behind) * 180000 / ((double)rangeOrigin * 100 /  raceRange) / gradeDiff * 1600 / raceRange ;
			
			score -= totalscore;

			
		}
		else 
		{
			Double differance = Double.parseDouble(this.behind);
			double totalscore = differance * 120000 / ((double)rangeOrigin * 100 /  raceRange) / gradeDiff * 1600 / raceRange;
			
			if(totalscore > 2000) {
				totalscore = 2000;
			}
			score += totalscore;
		}

		timeHosei = 1.0; 
		int raceRate = 10;
		//int falongRate = 300;
		int falongRate = 200;
		int jockeyRate = 50;
		if(raceRange < 1500) {
			jockeyRate = 80;
			falongRate = 400;
		}
		else if(raceRange >= 1500 && raceRange <= 2000) {
			jockeyRate = 60;
			//falongRate = 300;
		}
		if(range.contains("ダ")) {
			dirtHosei(this.stage, rangeOrigin, raceRate);
		}
		else 
		{
			grassHosei(this.stage, rangeOrigin, raceRate);
		}
		score += ((timeOrigin) * timeHosei) * raceRate * 1600 / raceRange  + rangeDiff * timeHosei;

		if(this.courseBeforeRace.excludeLast3furlong == 0.0) {
			Double firstDifference = this.first3furlong - this.courseBeforeRace.first3furlong;
			Double finalDifference = this.last3furlong - this.courseBeforeRace.last3furlong;

			
			if(this.courseThisRace.textString.contains("：逃げ")) {

				firstDifference += (this.first3furlong - this.courseBeforeRace.first3furlong);
			}
			if(this.courseThisRace.textString.contains("：差し") || this.courseThisRace.textString.contains("・差し") ) {

				finalDifference += calcAgariTime(maxRaceField, range);
			}
			if(this.courseThisRace.textString.contains("・追い込み") ) {
				finalDifference += calcAgariTime(maxRaceField, range);
			}
			if((this.courseThisRace.courseName.contains("阪神ダート1200") 
					) && thisRaceGradeDiff >= 1.10) {
				finalDifference += calcAgariTime(maxRaceField, range);
			}

			if(rangeOrigin > raceRange && rangeOrigin - raceRange > 650 && finalDifference > 0.4) 
			{
				finalDifference = 0.4;
				if(firstDifference + finalDifference <= -0.4) {

					//firstDifference /= 2;
				}
				
			}
			else if(rangeOrigin > raceRange && rangeOrigin - raceRange > 350 && finalDifference > 0.6) 
			{
				finalDifference = 0.6;
				if(firstDifference + finalDifference <= -0.60) {

					//firstDifference /= 2;
				}
				
			}
			else if(rangeOrigin > raceRange && finalDifference > 0.8) 
			{
				finalDifference = 0.8;
				if(firstDifference + finalDifference <= -0.8) {

					//firstDifference /= 2;
				}
			}
			
			if(firstDifference > 1.5 && raceRange > 1400) {
				firstDifference = 1.5;
			}
			else if(firstDifference > 1.0) {
				firstDifference = 1.0;
			}
			if(finalDifference > 1.5 && raceRange > 1400) {
				finalDifference = 1.5;
			}
			else if(finalDifference > 1.0) {
				finalDifference = 1.0;
			}
			score += (firstDifference + finalDifference)* falongRate;

		}
		else {
			Double firstDifference = this.excludeLast3furlong - this.courseBeforeRace.excludeLast3furlong;
			Double finalDifference = this.last3furlong - this.courseBeforeRace.last3furlong;

			if(this.courseThisRace.textString.contains("：逃げ")) {

				firstDifference += (this.first3furlong - this.courseBeforeRace.first3furlong);
			}
			if(this.courseThisRace.textString.contains("：差し") || this.courseThisRace.textString.contains("・差し") ) {

				finalDifference += calcAgariTime(maxRaceField, range);
			}
			if(this.courseThisRace.textString.contains("・追い込み") ) {
				finalDifference += calcAgariTime(maxRaceField, range);
			}
			if((this.courseThisRace.courseName.contains("阪神ダート1200") 
					) && thisRaceGradeDiff >= 1.10) {
				finalDifference += calcAgariTime(maxRaceField, range);
			}
			
			if(rangeOrigin > raceRange && rangeOrigin - raceRange > 650 && finalDifference > 0.4) 
			{
				finalDifference = 0.4;
				if(firstDifference + finalDifference <= -0.4) {

					//firstDifference /= 2;
				}
				
			}
			else if(rangeOrigin > raceRange && rangeOrigin - raceRange > 350 && finalDifference > 0.6) 
			{
				finalDifference = 0.6;
				if(firstDifference + finalDifference <= -0.60) {

					//firstDifference /= 2;
				}
				
			}
			else if(rangeOrigin > raceRange && finalDifference > 0.8) 
			{
				finalDifference = 0.8;
				if(firstDifference + finalDifference <= -0.8) {

					//firstDifference /= 2;
				}
			}
			
			if(firstDifference > 1.5 && raceRange > 1400) {
				firstDifference = 1.5;
			}
			else if(firstDifference > 1.0) {
				firstDifference = 1.0;
			}
			if(finalDifference > 1.5 && raceRange > 1400) {
				finalDifference = 1.5;
			}
			else if(finalDifference > 1.0) {
				finalDifference = 1.0;
			}
			score += (firstDifference + finalDifference )* falongRate;
					
		}
		score -= (Double.parseDouble(this.jockeyWeight) * jockeyRate);
		score += (this.thisRaceJockeyWeight * jockeyRate);

		if(!this.pastMaxSpeed.contains(":") || ((timeOrigin) * timeHosei) * raceRate * 1600 / raceRange  + rangeDiff * timeHosei + 100 < 
				(Integer.parseInt(this.pastMaxSpeed.substring(0,1)) * 600 +  Integer.parseInt(this.pastMaxSpeed.substring(2,4)) * 10 + Integer.parseInt(this.pastMaxSpeed.substring(5,6))) * timeHosei * raceRate * 1600 / raceRange)
		{
			if(range.contains("ダ")) {
				dirtHosei(this.stage, rangeOrigin, raceRate);
			}
			else 
			{
				grassHosei(this.stage,rangeOrigin, raceRate);
			}
			score += ((timeOrigin) * timeHosei) * raceRate * 1600 / raceRange  + rangeDiff * timeHosei;

			if(raceRange < 1600) {
				score += ((timeOrigin) * timeHosei) * raceRate * 1600 / raceRange  + rangeDiff * timeHosei;
			}
			else if(raceRange == 1600) {
				score += ((timeOrigin) * timeHosei) * raceRate * 1600 / raceRange  + rangeDiff * timeHosei / 1.5;
			}
			//if(this.pastMaxSpeedDifference != null) {score += Double.parseDouble(this.pastMaxSpeedDifference) * 30 * raceRate;}
		}
		else {
			if(maxRaceField.contains("ダ")) {
				dirtHosei(this.pastMaxSpeed, raceRange, raceRate);
			}
			else 
			{
				grassHosei(this.pastMaxSpeed, raceRange, raceRate);
			}
			
			score += (Integer.parseInt(this.pastMaxSpeed.substring(0,1)) * 600 +  Integer.parseInt(this.pastMaxSpeed.substring(2,4)) * 10 + Integer.parseInt(this.pastMaxSpeed.substring(5,6))) * timeHosei * raceRate * 1600 / raceRange;

			if(raceRange < 1600) {
				score += (Integer.parseInt(this.pastMaxSpeed.substring(0,1)) * 600 +  Integer.parseInt(this.pastMaxSpeed.substring(2,4)) * 10 + Integer.parseInt(this.pastMaxSpeed.substring(5,6))) * timeHosei * raceRate * 1600 / raceRange;

			}
			else if(raceRange == 1600) {
				score += (Integer.parseInt(this.pastMaxSpeed.substring(0,1)) * 600 +  Integer.parseInt(this.pastMaxSpeed.substring(2,4)) * 10 + Integer.parseInt(this.pastMaxSpeed.substring(5,6))) * timeHosei * raceRate * 1600 / raceRange / 1.5;
			}
	
		}

		//boolean goodRank = false;
		int pastRaceScore = 0;
		String pastRaceString = removeNumeric(this.pastRace);
		double rateWin = 1.0;
		for(int i= 0; i < 5; i++)
		{
			if(i <  pastRaceString.length() && pastRaceString.substring(i,i+1).equals("①")) {
				rateWin += 0.2;
			}
			if(i <  pastRaceString.length() && !pastRaceString.substring(i,i+1).equals("－")) {
				pastRaceScore += (Util.RankMap.get(pastRaceString.substring(i,i+1)) + 15) * (20 - i * 4) * rateWin;
			}
			else {
				pastRaceScore += (Util.RankMap.get(pastRaceString.substring(0,1)) + 15) * (20 - i * 4) * rateWin;
			}
			
		}
		score += pastRaceScore;
		System.out.println(this.name + pastRaceScore);
		int grade = 2;
		if(thisRaceGradeDiff >= 1.20) {
			grade = 4;
		}
		else if(thisRaceGradeDiff >= 1.05){
			grade = 3;
		}
		
		int hosei = (Integer.parseInt(this.pastRace.substring(5,9)) - Integer.parseInt(this.pastRace.substring(0,4)));
		if(hosei > 500) {
			hosei = 500;
		}
		hosei -= (Integer.parseInt(this.pastRace.substring(0,4)) -6000)* grade;
		if(hosei < -1000 * grade) {
			hosei = -1000 * grade;
		}	
		System.out.println(this.name + hosei);
		score += hosei;
		totalscore = 0;
		if(thisRaceGradeDiff >= 1.05) {
			CalcCourseAptitude(this.cornerShape.split("-"));
			CalcCourseAptitude(this.grassStart.split("-"));
			CalcCourseAptitude(this.raceGround.split("-"));
			CalcCourseAptitude(this.rotationSide.split("-"));
			CalcCourseAptitude(this.rotationSize.split("-"));
			CalcCourseAptitude(this.straightDistance.split("-"));
			CalcCourseAptitude(this.straightSlope.split("-"));
		}

		System.out.println(this.name + totalscore);

		//score += (Integer.parseInt(this.result) - Integer.parseInt(this.expect)) * 20; 

		score += base;
		calcCondition();
		int percentage =  (int)(Double.parseDouble(this.goodRace)) * 10;
		if(gradeDiff == 1.0) {
			//percentage /= 2;
		}
		score -= percentage;
		score = 100000 - score;
		this.index = String.valueOf(score);
	}
	public static String removeNumeric(String str) {
        return str.replaceAll("[\\d]", "");
    }
	int totalscore;
	private Double calcAgariTime(String maxRaceField, String raceRange) {
		double difference = 0.0;
		if(!this.pastMaxSpeedLast.equals("一年未走")) {
			RaceCourse rc = RaceCourseUtil.ReturnRaceCourse(this.pastMaxSpeed, range +  String.valueOf(raceRange), "");

			Double pastFinalTime = Double.parseDouble(this.pastMaxSpeedLast) - rc.last3furlong;
			if(maxRaceField.contains("芝")) {

				if(this.pastMaxSpeed.contains("稍")) {
					pastFinalTime -= 0.3;
				}
				else if(this.pastMaxSpeed.contains("重")) {
					pastFinalTime -= 0.6;
				}
				else if(this.pastMaxSpeed.contains("不")) {
					pastFinalTime -= 0.9;
				}
			}
			else if(maxRaceField.contains("ダ")) {

				if(this.pastMaxSpeed.contains("稍")) {
					pastFinalTime += 0.3;
				}
				else if(this.pastMaxSpeed.contains("重")) {
					pastFinalTime += 0.6;
				}
				else if(this.pastMaxSpeed.contains("不")) {
					pastFinalTime += 0.9;
				}
			}
			if( pastFinalTime  > (this.last3furlong - this.courseBeforeRace.last3furlong)) {
				pastFinalTime = this.last3furlong - this.courseBeforeRace.last3furlong;
			}
			difference += (pastFinalTime);
		}
		else {
			difference += (this.last3furlong - this.courseBeforeRace.last3furlong);
		}
		
		return difference;
	}
	private void calcCondition() {

		if(thisRaceGradeDiff > 1.0 && SampleController.rdm.grass && this.grassGoodRaceResult.contains("出走なし") && this.grassBitHeavyRaceResult.contains("出走なし")
			&& this.grassHeavyRaceResult.contains("出走なし") && this.grassBadRaceResult.contains("出走なし")) {
			score += 200;
		}

		if(thisRaceGradeDiff > 1.0 && !SampleController.rdm.grass && this.dirtGoodRaceResult.contains("出走なし") && this.dirtBitHeavyRaceResult.contains("出走なし")
			&& this.dirtHeavyRaceResult.contains("出走なし") && this.dirtBadRaceResult.contains("出走なし")) {
			score += 200;
		}
		if(SampleController.rdm.grass && SampleController.condition.contains("良") && this.grassGoodRaceResult.contains("①")) {
			score -= 400;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("良") && this.grassGoodRaceResult.contains("②")) {
			score -= 300;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("良") && this.grassGoodRaceResult.contains("③")) {
			score -= 200;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("不") && this.grassBadRaceResult.contains("①")) {
			score -= 400;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("不") && this.grassBadRaceResult.contains("②")) {
			score -= 300;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("不") && this.grassBadRaceResult.contains("③")) {
			score -= 200;
		}else if(SampleController.rdm.grass && SampleController.condition.contains("重") && this.grassHeavyRaceResult.contains("①")) {
			score -= 400;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("重") && this.grassHeavyRaceResult.contains("②")) {
			score -= 300;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("重") && this.grassHeavyRaceResult.contains("③")) {
			score -= 200;
		}else if(SampleController.rdm.grass && SampleController.condition.contains("稍") && this.grassBitHeavyRaceResult.contains("①")) {
			score -= 400;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("稍") && this.grassBitHeavyRaceResult.contains("②")) {
			score -= 300;
		}
		else if(SampleController.rdm.grass && SampleController.condition.contains("稍") && this.grassBitHeavyRaceResult.contains("③")) {
			score -= 200;
		}
		
		if(!SampleController.rdm.grass &&  SampleController.condition.contains("良") && this.dirtGoodRaceResult.contains("①")) {
			score -= 400;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("良") && this.dirtGoodRaceResult.contains("②")) {
			score -= 300;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("良") && this.dirtGoodRaceResult.contains("③")) {
			score -= 200;
		}else if(!SampleController.rdm.grass && SampleController.condition.contains("不") && this.dirtBadRaceResult.contains("①")) {
			score -= 400;
		}
		else if(!SampleController.rdm.grass && SampleController.condition.contains("不") && this.dirtBadRaceResult.contains("②")) {
			score -= 300;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("不") && this.dirtBadRaceResult.contains("③")) {
			score -= 200;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("重") && this.dirtHeavyRaceResult.contains("①")) {
			score -= 400;
		}else if(!SampleController.rdm.grass &&  SampleController.condition.contains("重") && this.dirtHeavyRaceResult.contains("②")) {
			score -= 300;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("重") && this.dirtHeavyRaceResult.contains("③")) {
			score -= 200;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("稍") && this.dirtBitHeavyRaceResult.contains("①")) {
			score -= 400;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("稍") && this.dirtBitHeavyRaceResult.contains("②")) {
			score -= 300;
		}
		else if(!SampleController.rdm.grass &&  SampleController.condition.contains("稍") && this.dirtBitHeavyRaceResult.contains("③")) {
			score -= 200;
		}
		
	}
	
	private void dirtHosei(String stage, int raceRange, int coefficient) {

		timeHosei = 0.955;
		if(stage.contains("稍"))
		{
			score += 30 * ((double)raceRange / 600 ) * coefficient / 10;
		}
		else if(stage.contains("重"))
		{
			score += 60 * ((double)raceRange / 600 ) * coefficient / 10;
		}
		else if(stage.contains("不"))
		{
			score += 90 * ((double)raceRange / 600 ) * coefficient / 10;
		}
	}
	
	private void grassHosei(String stage, int raceRange, int coefficient) {

		timeHosei = 1.0;
		if(stage.contains("稍"))
		{
			score -= 30 * ((double)raceRange / 600 ) * coefficient/ 10;
		}
		else if(stage.contains("重"))
		{
			score -= 60* ((double)raceRange / 600 ) * coefficient/ 10;
		}
		else if(stage.contains("不"))
		{
			score -= 90 * ((double)raceRange / 600 ) * coefficient/ 10;
		}
	}
	private void CalcCourseAptitude(String[] courseHorse) 
	{
		int[]calcHorse = new int[]{Integer.parseInt(courseHorse[0]), Integer.parseInt(courseHorse[1]),Integer.parseInt(courseHorse[2]), Integer.parseInt(courseHorse[3])};
		for(int i = 0 ; i < calcHorse.length; i++) {
			if(calcHorse[i] > 10) {
				calcHorse[i] = 10;
			}
		}
		int cnt = 0;
		cnt += calcHorse[0] * 50;
		cnt += calcHorse[1] * 30;
		cnt += calcHorse[2] * 20;
		
		if(thisRaceGradeDiff <= 1.05) {
			//cnt /= 2;
		}
		cnt *= 10;
		cnt /= (calcHorse[0] + calcHorse[1] + calcHorse[2] + calcHorse[3] + 1);
		score -= cnt;
		totalscore -= cnt;
	}
	  /* getter,setterがないとTableViewに反映されない */
	  public String getAddress(){ return address; }
	  public void setAddress(String address){ this.address = address; } 
	  public String getRaceLevel(){ return raceLevel; }
	  public void setRaceLevel(String raceLevel){ this.raceLevel = raceLevel; }
	  
	  public String getNo(){ return no; }
	  public void setNo(String no){ this.no = no; }
	  public String getName(){ return name; }
	  public void setName(String name){ this.name = name; }
	  public String getRaceStage(){ return raceStage; }
	  public void setRaceStage(String raceStage){ this.raceStage = raceStage; }
	  public String getDate(){ return date; }
	  public void setDate(String date){ this.date = date; }
	  public String getRange(){ return range; }
	  public void setRange(String range){ this.range = range; }
	  public String getWeather(){ return weather; }
	  public void setWeather(String weather){ this.weather = weather; }
	  public String getStage(){ return stage; }
	  public void setStage(String stage){ this.stage = stage; }
	  public String getRaceName(){ return raceName; }
	  public void setRaceName(String raceName){ this.raceName = raceName; }
	  public String getExpect(){ return expect; }
	  public void setExpect(String expect){ this.expect = expect; }
	  public String getResult(){ return result; }
	  public void setResult(String result){ this.result = result; }
	  public String getJockey(){ return jockey; }
	  public void setJockey(String jockey){ this.jockey = jockey; }
	  public String getJockeyWeight(){ return jockeyWeight; }
	  public void setJockeyWeight(String jockeyWeight){ this.jockeyWeight = jockeyWeight; }
	  public String getStartNo(){ return startNo; }
	  public void setStartNo(String startNo){ this.startNo = startNo; }
	  public String getFrameNo(){ return frameNo; }
	  public void setFrameNo(String frameNo){ this.frameNo = frameNo; }
	  public String getTime(){ return time; }
	  public void setTime(String time){ this.time = time; }
	  public String getBehind(){ return behind; }
	  public void setBehind(String behind){ this.behind = behind; }
	  public String getPace(){ return pace; }
	  public void setPace(String pace){ this.pace = pace; }
	  public String getLast(){ return last; }
	  public void setLast(String last){ this.last = last; }
	  public String getSameRangeTime(){ return sameRangeTime; }
	  public void setSameRangeTime(String sameRangeTime){ this.sameRangeTime = sameRangeTime; }
	  public String getWeight(){ return weight; }
	  public void setWeight(String weight){ this.weight = weight; }
	  public String getRunRank(){ return runRank; }
	  public void setRunRank(String runRank){ this.runRank = runRank; }
	  public String getTopHorse(){ return topHorse; }
	  public void setTopHorse(String topHorse){ this.topHorse = topHorse; }
	  public String getAnalysis(){ return analysis; }
	  public void setAnalysis(String analysis){ this.analysis = analysis; }
	  public String getHorseCount(){ return horseCount; }
	  public void setHorseCount(String horseCount){ this.horseCount = horseCount; }
	  public String getGoodRace(){ return goodRace; }
	  public void setGoodRace(String goodRace){ this.goodRace = goodRace; }
	  public String getPastRace(){ return pastRace; }
	  public void setPastRace(String pastRace){ this.pastRace = pastRace; }
	  public String getGrassGoodRaceResult(){ return grassGoodRaceResult; }
	  public void setGrassGoodRaceResult(String grassGoodRaceResult){ this.grassGoodRaceResult = grassGoodRaceResult; }
	  public String getGrassBitHeavyRaceResult(){ return grassBitHeavyRaceResult; }
	  public void setGrassBitHeavyRaceResult(String grassBitHeavyRaceResult){ this.grassBitHeavyRaceResult = grassBitHeavyRaceResult; }
	  public String getGrassHeavyRaceResult(){ return grassHeavyRaceResult; }
	  public void setGrassHeavyRaceResult(String grassHeavyRaceResult){ this.grassHeavyRaceResult = grassHeavyRaceResult; }
	  public String getGrassBadRaceResult(){ return grassBadRaceResult; }
	  public void setGrassBadRaceResult(String grassBadRaceResult){ this.grassBadRaceResult = grassBadRaceResult; }
	  public String getDirtGoodRaceResult(){ return dirtGoodRaceResult; }
	  public void setDirtGoodRaceResult(String dirtGoodRaceResult){ this.dirtGoodRaceResult = dirtGoodRaceResult; }
	  public String getDirtBitHeavyRaceResult(){ return dirtBitHeavyRaceResult; }
	  public void setDirtBitHeavyRaceResult(String dirtBitHeavyRaceResult){ this.dirtBitHeavyRaceResult = dirtBitHeavyRaceResult; }
	  public String getDirtHeavyRaceResult(){ return dirtHeavyRaceResult; }
	  public void setDirtHeavyRaceResult(String dirtHeavyRaceResult){ this.dirtHeavyRaceResult = dirtHeavyRaceResult; }
	  public String getDirtBadRaceResult(){ return dirtBadRaceResult; }
	  public void setDirtBadRaceResult(String dirtBadRaceResult){ this.dirtBadRaceResult = dirtBadRaceResult; }
	  
	  public String getPastMaxSpeed(){ return pastMaxSpeed; }
	  public void setPastMaxSpeed(String pastMaxSpeed){ this.pastMaxSpeed = pastMaxSpeed; }
	  public String getPastMaxSpeedDifference(){ return pastMaxSpeedDifference; }
	  public void setPastMaxSpeedDifference(String pastMaxSpeedDiffence){ this.pastMaxSpeedDifference = pastMaxSpeedDifference; }
	  public String getPastMaxPace(){ return pastMaxPace; }
	  public void setPastMaxPace(String pastMaxPace){ this.pastMaxPace = pastMaxPace; }
	  public String getPastMaxSpeedLast(){ return pastMaxSpeedLast; }
	  public void setPastMaxSpeedLast(String pastMaxSpeedLast){ this.pastMaxSpeedLast = pastMaxSpeedLast; }
	  public String getIndex(){ return index; }
	  public void setIndex(String index){ this.index = index; }

	  public String getBeforeJockeyTrait(){ return Jockey.jockeyStart.getOrDefault(this.beforeJockeyTrait, "")+ Jockey.firstMove.getOrDefault(this.beforeJockeyTrait, "") + Jockey.jockeySikake.getOrDefault(this.beforeJockeyTrait, "") + 
			  Jockey.jockeySinro.getOrDefault(this.beforeJockeyTrait, "") ; }
	  public void setBeforeJockeyTrait(String beforeRaceJockey){ this.beforeJockeyTrait = beforeRaceJockey; }
	  public String getNowJockeyTrait(){ return Jockey.jockeyStart.getOrDefault(this.nowJockeyTrait, "") + Jockey.firstMove.getOrDefault(this.nowJockeyTrait, "")+ Jockey.jockeySikake.getOrDefault(this.nowJockeyTrait, "") + 
			  Jockey.jockeySinro.getOrDefault(this.nowJockeyTrait, "") ; }
	  public void setNowJockeyTrait(String nowRaceJockey){ this.nowJockeyTrait = nowRaceJockey; }
	  
	  public String getCornerShape(){ return cornerShape; }
	  public void setCornerShape(String cornerShape){ this.cornerShape = cornerShape; }
	  public String getGrassStart(){ return grassStart; }
	  public void setGrassStart(String grassStart){ this.grassStart = grassStart; }
	  public String getRaceGround(){ return raceGround; }
	  public void setRaceGround(String raceGround){ this.raceGround = raceGround; }
	  public String getRotationSide(){ return rotationSide; }
	  public void setRotationSide(String rotationSide){ this.rotationSide = rotationSide; }
	  public String getRotationSize(){ return rotationSize; }
	  public void setRotationSize(String rotationSize){ this.rotationSize = rotationSize; }
	  public String getStraightDistance(){ return straightDistance; }
	  public void setsSraightDistance(String straightDistance){ this.straightDistance = straightDistance; }
	  public String getStraightSlope(){ return straightSlope; }
	  public void setStraightSlope(String straightSlope){ this.straightSlope = straightSlope ; }
	  public Double getFirst3furlong(){ return Math.round((( this.first3furlong - courseBeforeRace.first3furlong) * 1000.0)) /1000.0; }
	  public void setFirst3furlong(String first3furlong){ this.first3furlong = Double.parseDouble(first3furlong) ; }
	  public Double getLast3furlong(){ return Math.round(((this.last3furlong - courseBeforeRace.last3furlong) * 1000.0)) /1000.0; }
	  public void setLast3furlong(String last3furlong){ this.last3furlong = Double.parseDouble(last3furlong) ; }
	  public Double getExcludeLast3furlong(){if(courseBeforeRace.range > 1300) { return  Math.round(((this.excludeLast3furlong - courseBeforeRace.excludeLast3furlong) * 1000.0)) /1000.0; }
	  return null;}
	  public void setExcludeLast3furlong(String excludeLast3furlong){ this.excludeLast3furlong = Double.parseDouble(excludeLast3furlong); }
}