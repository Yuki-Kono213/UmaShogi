package application;
import java.util.List;

public class HorseData 
{
	
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

	int timeOrigin;
	int rangeOrigin;
	private int score;
	double timeHosei;
	
	  public HorseData(String no, String name, String analysis, List<String> horseString, List<String>pastRaceCondition, int raceRange, String maxRaceField) {

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
			 timeOrigin  = timeOrigin  * raceRange / rangeOrigin;
					
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
			 calcIndex(raceRange, maxRaceField);
	  }
	  

	public void calcIndex(int raceRange, String maxRaceField) {

		double base = 1.0;
		score = 0;
		
		if(analysis.contains("やや有利")) {
			base = 1.0005;
		}
		else if(analysis.contains("やや不利"))
		{
			base = 0.9995;
		}
		else if(analysis.contains("有利"))
		{
			base = 1.001;
		}
		else if(analysis.contains("不利"))
		{
			base = 0.999;
		}
		
		int rangeDiff = (raceRange - rangeOrigin) / 20;
		double gradeDiff = 0.6;
		if(this.raceName.contains("1勝"))
		{
			gradeDiff = 0.8;
		}
		else if(this.raceName.contains("2勝"))
		{
			gradeDiff = 1.0;
		}
		else if(this.raceName.contains("3勝"))
		{
			gradeDiff = 1.2;
		}
		else if(this.raceName.contains("OP") || this.raceName.contains("L") )
		{
			gradeDiff = 1.4;
		}
		else if(this.raceName.contains("ＧⅢ"))
		{
			gradeDiff = 1.6;
		}
		else if(this.raceName.contains("ＧⅡ"))
		{
			gradeDiff = 1.8;
		}
		else if(this.raceName.contains("ＧⅠ"))
		{
			gradeDiff = 2.0;
		}
		
		if(this.analysis.contains("勝利")) {
			if(Double.parseDouble(this.behind) == 0.0) {
				score -= 1000 * gradeDiff;
			}
			else 
			{
				score -= Double.parseDouble(this.behind) * 20000 / (rangeOrigin * 100 / raceRange) + 1000 * gradeDiff;
			}
			
		}
		else 
		{
			score += Double.parseDouble(this.behind) * 60000 / (rangeOrigin * 100 / raceRange)  - 1000 * gradeDiff;
		}

		timeHosei = 1.0; 

		if(range.contains("ダ")) {
			dirtHosei(this.stage);
		}
		else 
		{
			glassHosei(this.stage);
		}

		score += (timeOrigin * timeHosei + rangeDiff) * 10;
		score += (Double.parseDouble(this.jockeyWeight) * 20);
		if(this.pastMaxSpeed.contains(":") && 
		Integer.parseInt(this.pastMaxSpeed.substring(0,1)) * 600 +  Integer.parseInt(this.pastMaxSpeed.substring(2,4)) * 10 + Integer.parseInt(this.pastMaxSpeed.substring(5,6)) < timeOrigin + rangeDiff + 20)
		{
			if(maxRaceField.contains("ダ")) {
				dirtHosei(this.pastMaxSpeed);
			}
			else 
			{
				glassHosei(this.pastMaxSpeed);
			}
			
			score += (Integer.parseInt(this.pastMaxSpeed.substring(0,1)) * 600 +  Integer.parseInt(this.pastMaxSpeed.substring(2,4)) * 10 + Integer.parseInt(this.pastMaxSpeed.substring(5,6))) * timeHosei * 10;
		}
		else {
			if(range.contains("ダ")) {
				dirtHosei(this.stage);
			}
			else 
			{
				glassHosei(this.stage);
			}
			score += (timeOrigin * timeHosei + rangeDiff) * 10 + 200;
		}
		
		int pastRaceScore = 0;
		for(int i= 0; i < this.pastRace.length(); i++)
		{
			pastRaceScore += Util.RankMap.get(this.pastRace.substring(i,i+1)) * 10;
		
		}
		
		

		score += pastRaceScore * (double)(5 / this.pastRace.length());

		System.out.println( pastRaceScore * (double)(5 / this.pastRace.length()));
		
		score *= base;
		 
		score = 100000 - score;
			
		this.index = String.valueOf(score);
	}
	
	private void dirtHosei(String stage) {

		timeHosei = 0.97;
		if(this.stage.contains("稍"))
		{
			score += 30;
		}
		else if(this.stage.contains("重"))
		{
			score += 60;
		}
		else if(this.stage.contains("不"))
		{
			score += 90;
		}
	}
	
	private void glassHosei(String stage) {

		timeHosei = 1.0;
		if(this.stage.contains("稍"))
		{
			score -= 30;
		}
		else if(this.stage.contains("重"))
		{
			score -= 60;
		}
		else if(this.stage.contains("不"))
		{
			score -= 90;
		}
	}
		
	  /* getter,setterがないとTableViewに反映されない */
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

}
