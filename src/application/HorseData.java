package application;
import java.util.List;

import javax.imageio.ImageTranscoder;

import javafx.scene.layout.BorderWidths;

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
	
	private String raceLevel;


	private String glassGoodRaceResult;
	private String glassBitHeavyRaceResult;
	private String glassHeavyRaceResult;
	private String glassBadRaceResult;
	private String dirtGoodRaceResult;
	private String dirtBitHeavyRaceResult;
	private String dirtHeavyRaceResult;
	private String dirtBadRaceResult;
	
	private String pastMaxSpeed;
	private String pastMaxPace;
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
	private RaceCourse courseBeforeRace;
	private double excludeLast3furlong;
	private double first3furlong;
	private double last3furlong;
	
	  public HorseData(String no, String name, String analysis, List<String> horseString, List<String>pastRaceCondition, int raceRange, String maxRaceField, String address,
			  String raceLevel, Double thisWeight, String cornerShape, String grassStart,String  raceGround, String rotationSide, String rotationSize, String straightDistance, String straightSlope) {

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
			 timeOrigin = (Integer.parseInt(this.time.substring(0,1)) * 600 +  Integer.parseInt(this.time.substring(2,4)) * 10 + Integer.parseInt(this.time.substring(5,6)));
			 timeOrigin *= ((double)raceRange / rangeOrigin);
					
			 this.sameRangeTime = Integer.toString((timeOrigin  / 600)) + ":" + String.format("%02d",timeOrigin  % 600 / 10) + "." + Integer.toString(timeOrigin  % 10);
			 this.goodRace = horseString.get(horseString.size() - 2);
			 this.pastRace = horseString.get(horseString.size() - 1);
			 this.glassGoodRaceResult = pastRaceCondition.get(0);
			 this.glassBitHeavyRaceResult = pastRaceCondition.get(1);
			 this.glassHeavyRaceResult = pastRaceCondition.get(2);
			 this.glassBadRaceResult = pastRaceCondition.get(3);
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
				 //this.first3furlong = Double.parseDouble(horseString.get(15));
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
			 this.courseBeforeRace = RaceCourseUtil.ReturnRaceCourse(this.raceStage,this.range,this.raceName);
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

	public void calcIndex(int raceRange, String maxRaceField) {

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
		
		int rangeDiff = 0;
		if(raceRange > rangeOrigin) {
			rangeDiff = (raceRange - rangeOrigin);
		}
		else
		{
			rangeDiff = -(int)(Math.sqrt(((rangeOrigin - raceRange))) * 20);
			
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
		else if(this.raceName.contains("OP") || this.raceName.contains("Ｌ") )
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
		
		if(this.analysis.contains("勝利")) {

			score -= 200 * gradeDiff;
			score -= Double.parseDouble(this.behind) * 2 * ((double)raceRange * 100 /  rangeOrigin) * gradeDiff * 1600 / raceRange ;
		}
		else 
		{
			score -= 300 * gradeDiff;
			score += Double.parseDouble(this.behind) * 27000 / ((double)rangeOrigin * 100 /  raceRange) / gradeDiff * 1600 / raceRange ;
		}

		timeHosei = 1.0; 
		if(range.contains("ダ")) {
			dirtHosei(this.stage, rangeOrigin, 1);
		}
		else 
		{
			glassHosei(this.stage, rangeOrigin, 1);
		}

		score += ((timeOrigin) * timeHosei) * 10 * 1600 / raceRange  + rangeDiff * timeHosei;
		
		int jockeyRate = 20;
		if(raceRange < 1600) {
			jockeyRate = 30;
		}
		score -= (Double.parseDouble(this.jockeyWeight) * jockeyRate);
		score += (this.thisRaceJockeyWeight * jockeyRate);

		if(this.pastMaxSpeed.contains(":"))
		{
			if(maxRaceField.contains("ダ")) {
				dirtHosei(this.pastMaxSpeed, raceRange, 1);
			}
			else 
			{
				glassHosei(this.pastMaxSpeed, raceRange, 1);
			}
			
			score += (Integer.parseInt(this.pastMaxSpeed.substring(0,1)) * 600 +  Integer.parseInt(this.pastMaxSpeed.substring(2,4)) * 10 + Integer.parseInt(this.pastMaxSpeed.substring(5,6))) * timeHosei * 10 * 1600 / raceRange;
		}
		else {
			if(range.contains("ダ")) {
				dirtHosei(this.stage, rangeOrigin, 1);
			}
			else 
			{
				glassHosei(this.stage,rangeOrigin, 1);
			}
			score += ((timeOrigin) * timeHosei)  * 10 * 1600 / raceRange  + rangeDiff * timeHosei;
		}


		//boolean goodRank = false;
		int pastRaceScore = 0;
		String pastRaceString = removeNumeric(this.pastRace);
		for(int i= 0; i < 5; i++)
		{
			if(i <  pastRaceString.length() && !pastRaceString.substring(i,i+1).equals("－")) {
				pastRaceScore += (Util.RankMap.get(pastRaceString.substring(i,i+1)) + 10) * 3 *  (((double)10 - i) / 3);
			}
			else {
				pastRaceScore += 15 * 3 * (((double)10 - i) / 3 );
			}
			
		}
		score += pastRaceScore;
		int grade = 1;
		if(gradeDiff < 1.10) {
			grade = 2;
		}
		score += (Integer.parseInt(this.pastRace.substring(5,9)) - Integer.parseInt(this.pastRace.substring(0,4))) / grade;
		CalcCourseAptitude(this.cornerShape.split("-"));
		CalcCourseAptitude(this.grassStart.split("-"));
		//CalcCourseAptitude(this.raceGround.split("-"));
		CalcCourseAptitude(this.rotationSide.split("-"));
		CalcCourseAptitude(this.rotationSize.split("-"));
		CalcCourseAptitude(this.straightDistance.split("-"));
		CalcCourseAptitude(this.straightSlope.split("-"));


		//score += (Integer.parseInt(this.result) - Integer.parseInt(this.expect)) * 20; 

		score += base;

		score -= (int)(Double.parseDouble(this.goodRace)) * 5;
		score = 100000 - score;
		this.index = String.valueOf(score);
	}
	public static String removeNumeric(String str) {
        return str.replaceAll("[\\d]", "");
    }
	private void dirtHosei(String stage, int raceRange, int coefficient) {

		timeHosei = 0.94;
		if(stage.contains("稍"))
		{
			score += 30 * ((double)raceRange / 600 ) * coefficient;
		}
		else if(stage.contains("重"))
		{
			score += 60 * ((double)raceRange / 600 ) * coefficient;
		}
		else if(stage.contains("不"))
		{
			score += 90 * ((double)raceRange / 600 ) * coefficient;
		}
	}
	
	private void glassHosei(String stage, int raceRange, int coefficient) {

		timeHosei = 1.0;
		if(stage.contains("稍"))
		{
			score -= 30 * ((double)raceRange / 600 ) * coefficient;
		}
		else if(stage.contains("重"))
		{
			score -= 60* ((double)raceRange / 600 ) * coefficient;
		}
		else if(stage.contains("不"))
		{
			score -= 90 * ((double)raceRange / 600 ) * coefficient;
		}
	}
		
	private void CalcCourseAptitude(String[] courseHorse) 
	{
		int[]calcHorse = new int[]{Integer.parseInt(courseHorse[0]), Integer.parseInt(courseHorse[1]),Integer.parseInt(courseHorse[2]), Integer.parseInt(courseHorse[3])};
		for(int i = 0 ; i < calcHorse.length; i++) {
			if(calcHorse[i] > 20) {
				//calcHorse[i] = 20;
			}
		}
		int cnt = 0;
		cnt += calcHorse[0] * 60;
		cnt += calcHorse[1] * 40;
		cnt += calcHorse[2] * 30;
		cnt -= calcHorse[3] * 30;
		if(gradeDiff < 1.10) {
			cnt /= 2;
		}
		
		//if((calcHorse[0] + calcHorse[1] + calcHorse[2] + calcHorse[3]) != 0) {
		//}
		cnt *= 10;
		cnt /= (calcHorse[0] + calcHorse[1] + calcHorse[2] + calcHorse[3] + 2);
		System.out.println(this.name + cnt);
		score -= cnt;
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
	  public String getGlassGoodRaceResult(){ return glassGoodRaceResult; }
	  public void setGlassGoodRaceResult(String glassGoodRaceResult){ this.glassGoodRaceResult = glassGoodRaceResult; }
	  public String getGlassBitHeavyRaceResult(){ return glassBitHeavyRaceResult; }
	  public void setGlassBitHeavyRaceResult(String glassBitHeavyRaceResult){ this.glassBitHeavyRaceResult = glassBitHeavyRaceResult; }
	  public String getGlassHeavyRaceResult(){ return glassHeavyRaceResult; }
	  public void setGlassHeavyRaceResult(String glassHeavyRaceResult){ this.glassHeavyRaceResult = glassHeavyRaceResult; }
	  public String getGlassBadRaceResult(){ return glassBadRaceResult; }
	  public void setGlassBadRaceResult(String glassBadRaceResult){ this.glassBadRaceResult = glassBadRaceResult; }
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
	  public String getPastMaxPace(){ return pastMaxPace; }
	  public void setPastMaxPace(String pastMaxPace){ this.pastMaxPace = pastMaxPace; }
	  public String getPastMaxSpeedLast(){ return pastMaxSpeedLast; }
	  public void setPastMaxSpeedLast(String pastMaxSpeedLast){ this.pastMaxSpeedLast = pastMaxSpeedLast; }
	  public String getIndex(){ return index; }
	  public void setIndex(String index){ this.index = index; }

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
	  public String getFirst3furlong(){ return String.valueOf(Math.round((( this.first3furlong - courseBeforeRace.first3furlong) * 1000.0)) /1000.0); }
	  public void setFirst3furlong(String first3furlong){ this.first3furlong = Double.parseDouble(first3furlong) ; }
	  public String getLast3furlong(){ return String.valueOf(Math.round(((this.last3furlong - courseBeforeRace.last3furlong) * 1000.0)) /1000.0); }
	  public void setLast3furlong(String last3furlong){ this.last3furlong = Double.parseDouble(last3furlong) ; }
	  public String getExcludeLast3furlong(){if(courseBeforeRace.range > 1300) { return  String.valueOf(Math.round(((this.excludeLast3furlong - courseBeforeRace.excludeLast3furlong) * 1000.0)) /1000.0); }
	  return "";}
	  public void setExcludeLast3furlong(String excludeLast3furlong){ this.excludeLast3furlong = Double.parseDouble(excludeLast3furlong); }
}