package application;

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
	
	
	  public HorseData(String no, String name, String date, String raceStage, String range,String weather,String stage,String raceName,String expect,String result,String jockey,String jockeyWeight,
			  String horseCount,String frameNo,String startNo,String time,String behind,String pace,String last,String weight,String runRank,String topHorse,String analysis, String goodRace, String pastRace
			  ,String glassGoodRaceResult, String glassBitHeavyRaceResult,String glassHeavyRaceResult,  String glassBadRaceResult
			  ,String dirtGoodRaceResult,  String dirtBitHeavyRaceResult, String dirtHeavyRaceResult, String dirtBadRaceResult) {

			 this.no = no;
			 this.name = name;
			 this.raceStage = raceStage;
			 this.date = date;
			 this.range = range;
			 this.weather = weather;
			 this.stage = stage;
			 this.raceName = raceName;
			 this.expect = expect;
			 this.result = result;
			 this.jockey = jockey;
			 this.jockeyWeight = jockeyWeight;
			 this.horseCount = horseCount;
			 this.startNo = startNo;
			 this.frameNo = frameNo;
			 this.time = time;
			 this.behind = behind;
			 this.pace = pace;
			 this.last = last;
			 this.weight = weight;
			 this.runRank = runRank;
			 this.topHorse = topHorse;
			 this.analysis = analysis;
			 this.goodRace = goodRace;
			 this.pastRace = pastRace;
			 this.glassGoodRaceResult = glassGoodRaceResult;
			 this.glassBitHeavyRaceResult = glassBitHeavyRaceResult;
			 this.glassHeavyRaceResult = glassHeavyRaceResult;
			 this.glassBadRaceResult = glassBadRaceResult;
			 this.dirtGoodRaceResult = dirtGoodRaceResult;
			 this.dirtBitHeavyRaceResult = dirtBitHeavyRaceResult;
			 this.dirtHeavyRaceResult = dirtHeavyRaceResult;
			 this.dirtBadRaceResult = dirtBadRaceResult;
	  }
	  /* getter,setterがないとTableViewに反映されない */
	  public String getNo(){ return no; }
	  public void setNo(String no){ this.no = no; }
	  public String getName(){ return name; }
	  public void setName(String name){ this.name = name; }
	  public String getRaceStage(){ return raceStage; }
	  public void setRaseStage(String raceStage){ this.raceStage = raceStage; }
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
}
