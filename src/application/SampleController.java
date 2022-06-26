package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//Javaでスクレイピングを行う
public class SampleController {

	@FXML
	private Label horseLabel1;
	@FXML
	private Label horseLabel2;
	@FXML
	private Label horseLabel3;
	@FXML
	private Label horseLabel4;
	@FXML
	private Label horseLabel5;
	@FXML
	private Label horseLabel6;
	@FXML
	private Label horseLabel7;
	@FXML
	private Label horseLabel8;
	@FXML
	private Label horseLabel9;
	@FXML
	private Label horseLabel10;
	@FXML
	private Label horseLabel11;
	@FXML
	private Label horseLabel12;
	@FXML
	private Label horseLabel13;
	@FXML
	private Label horseLabel14;
	@FXML
	private Label horseLabel15;
	@FXML
	private Label horseLabel16;
	@FXML
	private Label horseLabel17;
	@FXML
	private Label horseLabel18;
	@FXML
	private Label horseLabel19;
	@FXML
	private Label horseLabel20;
	@FXML
	private TextField textURL;
	@FXML
	private TextField textRaceName;
	@FXML
	private TextArea frame4;
	@FXML
	private TextArea frame3;
	@FXML
	private TextArea frame2;
	@FXML
	private TextArea frame1;
	@FXML
	private TextArea frame8;
	@FXML
	private TextArea frame7;
	@FXML
	private TextArea frame6;
	@FXML
	private TextArea frame5;
	@FXML
	private TextArea frame12;
	@FXML
	private TextArea frame11;
	@FXML
	private TextArea frame10;
	@FXML
	private TextArea frame9;
	@FXML
	private TextArea frame16;
	@FXML
	private TextArea frame15;
	@FXML
	private TextArea frame14;
	@FXML
	private TextArea frame13;
	@FXML
	private TextField textRaceRange;
	@FXML
	private TextField textRaceStage;
	@FXML
	private TableView <HorseData> table;
	@FXML
	private TableColumn <HorseData,String> numberTable;
	@FXML
	private TableColumn <HorseData,String> dateTable;
	@FXML
	private TableColumn <HorseData,String> raceStageTable;
	@FXML
	private TableColumn <HorseData,String> rangeTable;
	@FXML
	private TableColumn <HorseData,String> weatherTable;
	@FXML
	private TableColumn <HorseData,String> stageTable;
	@FXML
	private TableColumn <HorseData,String> raceNameTable;
	@FXML
	private TableColumn <HorseData,String> expectTable;
	@FXML
	private TableColumn <HorseData,String> resultTable;
	@FXML
	private TableColumn <HorseData,String> jockeyTable;
	@FXML
	private TableColumn <HorseData,String> jockeyWeightTable;
	@FXML
	private TableColumn <HorseData,String> horseCountTable;
	@FXML
	private TableColumn <HorseData,String> startNoTable;
	@FXML
	private TableColumn <HorseData,String> frameNoTable;
	@FXML
	private TableColumn <HorseData,String> timeTable;
	@FXML
	private TableColumn <HorseData,String> behindTable;
	@FXML
	private TableColumn <HorseData,String> paceTable;
	@FXML
	private TableColumn <HorseData,String> lastTable;
	@FXML
	private TableColumn <HorseData,String> weightTable;
	@FXML
	private TableColumn <HorseData,String> runRankTable;
	@FXML
	private TableColumn <HorseData,String> topHorseTable;
	@FXML
	private TableColumn <HorseData,String> analysisTable;
	Map<String,Integer> RankMap = new HashMap<>(){
		{
			put("①", 1);
			put("②", 2);
			put("③", 3);
			put("④", 4);
			put("⑤", 5);
			put("⑥", 6);
			put("⑦", 7);
			put("⑧", 8);
			put("⑨", 9);
			put("⑩", 10);
			put("⑪", 11);
			put("⑫", 12);
			put("⑬", 13);
			put("⑭", 14);
			put("⑮", 15);
			put("⑯", 16);
			put("⑰", 17);
			put("⑱", 18);
			put("－", 19);
		}
	};
	
	Map<String,String> RankTableMap = new HashMap<>(){
		{

			put("1", "①");
			put("2", "②");
			put("3", "③");
			put("4", "④");
			put("5", "⑤");
			put("6", "⑥");
			put("7", "⑦");
			put("8", "⑧");
			put("9", "⑨");
			put("10", "⑩");
			put("11", "⑪");
			put("12", "⑫");
			put("13", "⑬");
			put("14", "⑭");
			put("15", "⑮");
			put("16", "⑯");
			put("17", "⑰");
			put("18", "⑱");
			put("　", "　");
		}
	};


	public void ClearText() 
	{
		frame1.clear();
		frame2.clear();
		frame3.clear();
		frame4.clear();
		frame5.clear();
		frame6.clear();
		frame7.clear();
		frame8.clear();
		frame9.clear();
		frame10.clear();
		frame11.clear();
		frame12.clear();
		frame13.clear();
		frame14.clear();
		frame15.clear();
		frame16.clear();
	}

	public void SaveRace() 
	{


	}
	String[] strArray = {
			"⓪",
			"①",
			"②",
			"③",
			"④", 
			"⑤", 
			"⑥", 
			"⑦",
			"⑧",
			"⑨",
			"⑩",
			"⑪",
			"⑫",
			"⑬",
			"⑭",
			"⑮",
			"⑯",
			"⑰",
			"⑱",
			"⑲",
			"⑳"

	};

	public void GetURL() {
		

		numberTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("no"));
		
		dateTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("date"));
		
		raceStageTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("raceStage"));
		
		rangeTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("range"));
		
		weatherTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("weather"));
		
		stageTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("stage"));
		
		raceNameTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("raceName"));
		
		expectTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("expect"));
		
		resultTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("result"));
		
		jockeyTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("jockey"));
		
		jockeyWeightTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("jockeyWeight"));

		horseCountTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("horseCount"));
		
		startNoTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("startNo"));
		
		frameNoTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("frameNo"));
		
		timeTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("time"));
		
		behindTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("behind"));
		
		paceTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pace"));
		
		lastTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("last"));
		
		weightTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("weight"));
		
		runRankTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("runRank"));
		
		topHorseTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("topHorse"));
		
		analysisTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("analysis"));
		try {
			System.out.println(textURL.getText(textURL.getText().length() - 1, textURL.getText().length()));
			// jsoupを使用して当ブログのトップページへアクセス
			if(textURL.getText(textURL.getText().length() - 1, textURL.getText().length()).equals("/")) 
			{
				textURL.setText(textURL.getText() + "umabashira.html");
			}
			Document doc = Jsoup.connect(textURL.getText()).get();


			Element rate = doc.select(".seirei.std9").get(1);
			Elements rateElements = rate.getAllElements();
			Elements rateSpanElements = rateElements.select("td");

			Elements horseURLElements  = doc.select("div[class~=BameiWrap.*] > a");

			Elements stageElements  = doc.select("#topicPath ul li");
			Elements horseElements  = doc.select("a.tategaki.bamei");
			Elements beforeElements  = doc.select(".zensou.std11 span,.BeforRaces");
			Elements frameElements  = doc.select(".wakuban td:matchesOwn([1-8])");
			Elements RangeElements  = doc.select(".classCourseSyokin.clearfix li");
			textRaceName.setText(doc.select(".raceTitle.fL").get(0).text());
			String[] Range = RangeElements.get(1).text().split(" ");
			textRaceRange.setText(Range[0]);
			List<Horse> horseList = new ArrayList<Horse>();

			//System.out.println( beforeElements );

			RaceDB rdb = new RaceDB();
			Integer raceID = rdb.GetRaceID(textURL.getText());
			boolean raceExist = true;
			if(raceID == -1) {
				RaceDataManager rdm = new RaceDataManager(); 
				if(RangeElements.get(0).text().contains("芝")) {
					rdm.glass = true;
				}
				else {
					rdm.glass = false;
				}

				rdm.RaceURL = textURL.getText();
				rdm.RaceName = textRaceName.getText();

				rdb.UseRaceDataBase( new String[] {"insert",rdm.RaceName, rdm.RaceURL});

				raceID = rdb.GetRaceID(textURL.getText());
				raceExist = false;
			}
			int hosei = 0; 
			int j = 0;
			for (int i = 0; i <  horseElements.size()/2; i++) {
				j = i + 18 - horseElements.size()/2;
				try {
					String name = horseElements.get(i).text();
					//if(name != "" && horseList.stream().noneMatch(a -> a.name.equals(name))) {
						Horse h = new Horse();
						h.name = horseElements.get(i).text();
						

						if(rateSpanElements.size() != 0 && !rateSpanElements.get(j).text().equals("除外") && 
								!rateSpanElements.get(j).text().isEmpty()) {
							System.out.println(j + rateSpanElements.get(j).text());
							h.rate = Double.parseDouble(rateSpanElements.get(j).select("span").get(0).text());
						}
						try {
							for(int i2 = 0; i2 < 6; i2++) {
								String[] pos = beforeElements.get(i + i2 * horseElements.size() / 2 ).text().split("");
								if(!pos[pos.length-1].equals("－")) {
									h.position = RankMap.get(pos[pos.length-1]);
									break;
								}
							}
						}
						catch (Exception e)
						{

						}
						if(h.position == 0) {
							h.position = 19;
						}
						h.frame = Integer.parseInt(frameElements.get(i).text());
						h.number = Math.abs(horseElements.size()/2 -i);
						horseList.add(h);
						SetTextField(h);


						try {

							HorseDB hdb = new HorseDB();
							hdb.create();
							String horseText = hdb.returnPastRace(h.name, raceID);
							if(!raceExist || horseText.isEmpty() || horseText.equals("null")) {
								String address = "https://www.keibalab.jp" + horseURLElements.get(i).attr("href");
								Document horseData = Jsoup.connect(address).get();
								Elements HorseElements = horseData.select(".sortobject tr");
								for(int i2 = 0; i2 < 10; i2++) {
									if(HorseElements.get(i2).text().split(" ").length > 22) {
										h.pastRace =  HorseElements.get(i2).text();
										break;
									}
								}
								new HorseDB().UseHorseDataBase(new String[] {"insert", h.name, raceID.toString(), Integer.toString(h.position),
										h.pastRace,  Integer.toString(h.frame)});

								List<String> horseString = new ArrayList<String>(Arrays.asList(horseText.split(" ")));
								

								if(horseString.get(19).equals("B")) {
									horseString.remove(19);
								}
								table.getItems().add(new HorseData(strArray[h.number],horseString.get(0),horseString.get(1),horseString.get(2),horseString.get(3),horseString.get(4),horseString.get(5),
										horseString.get(6),horseString.get(7),horseString.get(8),horseString.get(9),horseString.get(10),horseString.get(11),horseString.get(12),horseString.get(13),
										horseString.get(14), horseString.get(15) + horseString.get(16) + horseString.get(17), horseString.get(18), horseString.get(19),  
										RankTableMap.get(horseString.get(horseString.size() - 5)) + RankTableMap.get(horseString.get(horseString.size() - 4)) 
												+RankTableMap.get(horseString.get(horseString.size() - 3))+ RankTableMap.get(horseString.get(horseString.size() - 2)), horseString.get(horseString.size() - 1), RacePointCheck((strArray[h.number] +  h.pastRace ), h)));
								Thread.sleep(1000);
							}
							else 
							{

								List<String> horseString = new ArrayList<String>(Arrays.asList(horseText.split(" ")));
								
								if(horseString.get(19).equals("B")) {
									horseString.remove(19);
								}

							
								
								table.getItems().add(new HorseData(strArray[h.number],horseString.get(0),horseString.get(1),horseString.get(2),horseString.get(3),horseString.get(4),horseString.get(5),
									horseString.get(6),horseString.get(7),horseString.get(8),horseString.get(9),horseString.get(10),horseString.get(11),horseString.get(12),horseString.get(13),
									horseString.get(14), horseString.get(15) + horseString.get(16) + horseString.get(17), horseString.get(18), horseString.get(19),  
									RankTableMap.get(horseString.get(horseString.size() - 5)) + RankTableMap.get(horseString.get(horseString.size() - 4)) 
											+RankTableMap.get(horseString.get(horseString.size() - 3))+ RankTableMap.get(horseString.get(horseString.size() - 2)), horseString.get(horseString.size() - 1), RacePointCheck(horseText, h)));

								
							}
						}
						catch(Exception e) {

							e.printStackTrace();
						}
					//}


				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String RacePointCheck(String s, Horse h) 
	{
		String text = "";
		if(s.contains(("H")) && h.position < 5) 
		{
			text += "不利";
		}
		else if(s.contains(("H")) && h.position < 9) 
		{
			text += "やや不利";
		}
		else if(s.contains(("S")) && h.position > 12)
		{
			text += "不利";	
		}
		else if(s.contains(("S")) && h.position > 6)
		{
			text += "やや不利";	
		}
		else if(s.contains(("S")) && h.position < 5) 
		{
			text += "有利";
		}
		else if(s.contains(("S")) && h.position < 9) 
		{
			text += "やや有利";
		}
		else if(s.contains(("H")) && h.position > 12)
		{
			text += "有利";	
		}
		else if(s.contains(("H")) && h.position > 8)
		{
			text += "やや有利";	
		}
		else if(s.contains(("M")))
		{
			text += "互角";	
		}
		
		String[] array = s.split(" ");
		
		if(array[7].equals("1")) 
		{
			text += "勝利";
			
		}
		else if(Double.parseDouble(array[14]) < 0.2) 
		{
			text += "惜敗";
			
		}
		else if(Double.parseDouble(array[14]) < 0.3) 
		{
			text += "敗戦";
			
		}else if(Double.parseDouble(array[14]) < 0.5) 
		{
			text += "敗北";
			
		}else if(Double.parseDouble(array[14]) < 1.0) 
		{
			text += "大敗";
			
		}
		else 
		{
			text += "惨敗";
		}
			return text;
	}
	
	
	private void SetTextField(Horse h) 
	{
		if(h.frame == 1 || h.frame == 2) 
		{
			if(h.position < 5) 
			{
				frame1.insertText(0, h.number + h.name + h.rate + "\r\n");

			}
			else if(h.position < 9) 
			{
				frame5.insertText(0, h.number + h.name  + h.rate + "\r\n");

			}
			else if(h.position < 13) 
			{
				frame9.insertText(0, h.number + h.name  + h.rate + "\r\n");

			}
			else if(h.position < 19) 
			{
				frame13.insertText(0, h.number + h.name + h.rate  + "\r\n");

			}
			else
			{
				frame13.insertText(0, h.number + h.name  + "?" +  h.rate +"\r\n");

			}

		}
		else if(h.frame == 3 || h.frame == 4) 
		{
			if(h.position < 5) 
			{
				frame2.insertText(0, h.number + h.name  + h.rate + "\r\n");

			}
			else if(h.position < 9) 
			{
				frame6.insertText(0, h.number + h.name + h.rate  + "\r\n");

			}
			else if(h.position < 13) 
			{
				frame10.insertText(0, h.number + h.name + h.rate + "\r\n");

			}
			else if(h.position < 19) 
			{
				frame14.insertText(0, h.number + h.name + h.rate + "\r\n");
			}
			else
			{
				frame14.insertText(0, h.number + h.name + "?" + h.rate + "\r\n");
			}

		}
		else if(h.frame == 5 || h.frame == 6) 
		{
			if(h.position < 5) 
			{
				frame3.insertText(0, h.number + h.name + h.rate + "\r\n");

			}
			else if(h.position < 9) 
			{
				frame7.insertText(0, h.number + h.name +  h.rate +"\r\n");

			}
			else if(h.position < 13) 
			{
				frame11.insertText(0, h.number + h.name + h.rate + "\r\n");

			}
			else if(h.position < 19) 
			{
				frame15.insertText(0, h.number + h.name +  h.rate +"\r\n");
			}
			else
			{
				frame15.insertText(0, h.number + h.name + "?" +  h.rate +"\r\n");
			}

		}else if(h.frame == 7 || h.frame == 8) 
		{
			if(h.position < 5) 
			{
				frame4.insertText(0, h.number + h.name +  h.rate +"\r\n");

			}
			else if(h.position < 9) 
			{
				frame8.insertText(0, h.number + h.name +  h.rate +"\r\n");

			}
			else if(h.position < 13) 
			{
				frame12.insertText(0, h.number + h.name +  h.rate +"\r\n");

			}
			else if(h.position < 19) 
			{
				frame16.insertText(0, h.number + h.name +  h.rate +"\r\n");
			}
			else
			{
				frame16.insertText(0, h.number + h.name + "?" + h.rate + "\r\n");
			}
		}

	}

}
