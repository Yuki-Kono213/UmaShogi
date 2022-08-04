package application;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//Javaでスクレイピングを行う
public class SampleController {

	private int raceRange = 0;
	@FXML
	private TextField textURL;
	@FXML
	private Label labelRaceName;
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
	private Label labelRaceRange;
	@FXML
	private Label labelRaceStage;
	@FXML
	private Label labelRaceDate;
	@FXML
	private TableView <HorseData> table;
	@FXML
	private TableColumn <HorseData,String> numberTable;
	@FXML
	private TableColumn <HorseData,String> nameTable;
	@FXML
	private TableColumn <HorseData,String> indexTable;
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
	private TableColumn <HorseData,String> sameRangeTimeTable;
	@FXML
	private TableColumn <HorseData,String> weightTable;
	@FXML
	private TableColumn <HorseData,String> runRankTable;
	@FXML
	private TableColumn <HorseData,String> topHorseTable;
	@FXML
	private TableColumn <HorseData,String> analysisTable;
	@FXML
	private TableColumn <HorseData,String> multipleTable;
	@FXML
	private TableColumn <HorseData,String> pastRaceTable;
	@FXML
	private TableColumn <HorseData,String> numberTable1;
	@FXML
	private TableColumn <HorseData,String> nameTable1;
	@FXML
	private TableColumn <HorseData,String> glassGoodRaceResult;
	@FXML
	private TableColumn <HorseData,String> glassBitHeavyRaceResult;
	@FXML
	private TableColumn <HorseData,String> glassHeavyRaceResult;
	@FXML
	private TableColumn <HorseData,String> glassBadRaceResult;
	@FXML
	private TableColumn <HorseData,String> dirtGoodRaceResult;
	@FXML
	private TableColumn <HorseData,String> dirtBitHeavyRaceResult;
	@FXML
	private TableColumn <HorseData,String> dirtHeavyRaceResult;
	@FXML
	private TableColumn <HorseData,String> dirtBadRaceResult;
	@FXML
	private TableColumn <HorseData,String> pastMaxSpeed;
	@FXML
	private TableColumn <HorseData,String> pastMaxPace;
	@FXML
	private TableColumn <HorseData,String> pastMaxSpeedLast;
	@FXML
	private TextField txtPaddockURL;
	@FXML
	private TextField txtPaddockURL1;
	
	@FXML
	private Button buttonOpenPaddock;
	@FXML
	private Button buttonOpenPaddock1;
	
	@FXML
	private TextField txtRaceURL;
	@FXML
	private TextField txtRaceURL1;
	
	@FXML
	private Button buttonOpenRace;
	@FXML
	private Button buttonOpenRace1;
	

	@FXML
	private TextField txtThisRaceURL;
	@FXML
	private TextField txtThisPaddockURL;
	
	@FXML
	private Button buttonThisRace;
	@FXML
	private Button buttonThisPaddock;
	
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
	
	Map<String,String> raceURL = new HashMap<>(){
		{
			put("1", "1");
			put("2", "2");
			put("3", "3");
			put("4", "4");
			put("5", "5");
			put("6", "6");
			put("7", "7");
			put("8", "8");
			put("9", "9");
			put("01", "1");
			put("02", "2");
			put("03", "3");
			put("04", "4");
			put("05", "5");
			put("06", "6");
			put("07", "7");
			put("08", "8");
			put("09", "9");
			put("10", "a");
			put("11", "b");
			put("12", "c");
		}
	};
	
	Map<String,String> stageURL = new HashMap<>(){
		{
			put("札幌", "1");
			put("函館", "2");
			put("福島", "3");
			put("新潟", "4");
			put("東京", "5");
			put("中山", "6");
			put("中京", "7");
			put("京都", "8");
			put("阪神", "9");
			put("小倉", "a");
		}
	};
	
	
	Map<String,String> stageKeibaRaboURL = new HashMap<>(){
		{
			put("札幌", "01");
			put("函館", "02");
			put("福島", "03");
			put("新潟", "04");
			put("東京", "05");
			put("中山", "06");
			put("中京", "07");
			put("京都", "08");
			put("阪神", "09");
			put("小倉", "10");
		}
	};
	
	Map<String,String> raceKeibaLaboURL = new HashMap<>(){
		{
			put("1", "01");
			put("2", "02");
			put("3", "03");
			put("4", "04");
			put("5", "05");
			put("6", "06");
			put("7", "07");
			put("8", "08");
			put("9", "09");
			put("10", "10");
			put("11", "11");
			put("12", "12");
		}
	};
	
	public static Map<String,String> RankTableMap = new HashMap<>(){
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
		
		nameTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("name"));

		indexTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("index"));
		
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
		sameRangeTimeTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("sameRangeTime"));
		
		behindTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("behind"));
		
		paceTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pace"));
		
		lastTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("last"));
		
		weightTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("weight"));
		
		runRankTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("runRank"));
		
		topHorseTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("topHorse"));
		
		analysisTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("analysis"));
		
		multipleTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("goodRace"));
		
		pastRaceTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastRace"));
		
		numberTable1.setCellValueFactory(new PropertyValueFactory<HorseData, String>("no"));
		nameTable1.setCellValueFactory(new PropertyValueFactory<HorseData, String>("name"));
		

		glassGoodRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("glassGoodRaceResult"));
		glassBitHeavyRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("glassBitHeavyRaceResult"));
		glassHeavyRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("glassHeavyRaceResult"));
		glassBadRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("glassBadRaceResult"));
		dirtGoodRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtGoodRaceResult"));
		dirtBitHeavyRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtBitHeavyRaceResult"));
		dirtHeavyRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtHeavyRaceResult"));
		dirtBadRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtBadRaceResult"));
		pastMaxSpeed.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxSpeed"));
		pastMaxPace.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxPace"));
		pastMaxSpeedLast.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxSpeedLast"));

		TextField[] arrayPaddockURL = new TextField[]{txtPaddockURL,txtPaddockURL1};
		Button[] arrayPaddockButton = new Button[]{buttonOpenPaddock,buttonOpenPaddock1};
		TextField[] arrayRaceURL = new TextField[]{txtRaceURL,txtRaceURL1};
		Button[] arrayRaceButton = new Button[]{buttonOpenRace,buttonOpenRace1};
		try {
			table.getItems().clear(); 
			ClearText();
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
			Elements dateElements  = doc.select(".fL.ml10 .bold");
			Elements rangeElements  = doc.select(".classCourseSyokin.clearfix li");
			//Elements conditionElements  = doc.select(".classCourseSyokin.clearfix li");
			labelRaceName.setText(doc.select(".raceTitle.fL").get(0).text());
			labelRaceRange.setText(rangeElements.get(1).text().split(" ")[0]);
			raceRange = Integer.parseInt(rangeElements.get(1).text().split(" ")[0].substring(1,5));
			labelRaceStage.setText(stageElements.get(3).text().split("競馬")[0]);
			labelRaceDate.setText(dateElements.get(0).text().split("\\(")[0]);
			String[] dateString = labelRaceDate.getText().split("/");
			labelRaceDate.setText(String.format("%d/%02d/%02d", Integer.parseInt(dateString[0].replace("/", "")), 
					Integer.parseInt(dateString[1].replace("/", "")), Integer.parseInt(dateString[2].replace("/", ""))));
			List<Horse> horseList = new ArrayList<Horse>();

			String round = dateElements.get(0).text().split("\\) ")[1].substring(0,1);


			String day = dateElements.get(0).text().split("日目")[0].substring(dateElements.get(0).text().split("日目")[0].length() -1 ,dateElements.get(0).text().split("日目")[0].length());
			
			if(day.equals("0")) {
				day = "10";
			}
			
			RaceDB rdb = new RaceDB();
			Integer raceID = rdb.GetRaceID(textURL.getText());
			boolean raceExist = true;
			if(raceID == -1) {
				RaceDataManager rdm = new RaceDataManager(); 
				if(rangeElements.get(0).text().contains("芝")) {
					rdm.glass = true;
				}
				else {
					rdm.glass = false;
				}

				rdm.RaceURL = textURL.getText();
				rdm.RaceName = labelRaceName.getText();

				rdb.UseRaceDataBase( new String[] {"insert",rdm.RaceName, rdm.RaceURL});

				raceID = rdb.GetRaceID(textURL.getText());
				raceExist = false;
			}
			arrayPaddockButton[0].setOnAction( new EventHandler<ActionEvent>() {
			            public void handle(ActionEvent event) {
			 
			            	try {
								new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", arrayPaddockURL[0].getText()).start();
							} catch (IOException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
			            }
			        });
			arrayPaddockButton[1].setOnAction( new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	 
	            	try {
						new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", arrayPaddockURL[1].getText()).start();
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
	            }
	        });
				
			arrayRaceButton[0].setOnAction( new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	 
	            	try {
						new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", arrayRaceURL[0].getText()).start();
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
	            }
	        });
			arrayRaceButton[1].setOnAction( new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent event) {
		
		        	try {
						new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", arrayRaceURL[1].getText()).start();
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
		        }
		    });
			
			buttonThisRace.setOnAction( new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	 
	            	try {
						new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", txtThisRaceURL.getText()).start();
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
	            }
	        });
			buttonThisPaddock.setOnAction( new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent event) {
		
		        	try {
						new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", txtThisPaddockURL.getText()).start();
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
		        }
		    });
			
			 txtThisPaddockURL.setText("https://regist.prc.jp/api/windowopen.aspx?target=race/"
       			 + labelRaceDate.getText().substring(0,4) + "/" + labelRaceDate.getText().substring(0,10).replace("/", "") + "/" + labelRaceDate.getText().substring(2,4) + stageURL.get(labelRaceStage.getText()) 
       			+ raceURL.get(round)+ raceURL.get(day)  + raceURL.get(textURL.getText().substring(42,44))
       	 + "_p&quality=1");
			 txtThisRaceURL.setText("https://regist.prc.jp/api/windowopen.aspx?target=race/"
	       			 + labelRaceDate.getText().substring(0,4) + "/" + labelRaceDate.getText().substring(0,10).replace("/", "") + "/" + labelRaceDate.getText().substring(2,4) + stageURL.get(labelRaceStage.getText()) 
	       			 + raceURL.get(round) + raceURL.get(day)  + raceURL.get(textURL.getText().substring(42,44))
	       	 + "&quality=1");
			
	        String pattern = "#.###";
	        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
			int j = 0;
			for (int i = 0; i <  horseElements.size()/2; i++) {
				j = i + 18 - horseElements.size()/2;
				try {
					//if(name != "" && horseList.stream().noneMatch(a -> a.name.equals(name))) {
						Horse h = new Horse();
						h.name = horseElements.get(i).text();
						

						if(rateSpanElements.size() != 0 && !rateSpanElements.get(j).text().equals("除外") && 
								!rateSpanElements.get(j).text().isEmpty()) {
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
							String[] horseText = hdb.returnPastRace(h.name, raceID);
							if(!raceExist || horseText[0].isEmpty() || 
									LocalDate.parse(labelRaceDate.getText(), DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
									.isBefore(LocalDate.parse(horseText[0].split(" ")[0], DateTimeFormatter.ofPattern("yyyy/[]M/[]d")).plusDays(1)) 
									) {
								String address = "https://www.keibalab.jp" + horseURLElements.get(i).attr("href");
								Document horseData = Jsoup.connect(address).get();
								String pastRace = "";
								Elements HorseElements = horseData.select(".sortobject tr");
								boolean findPastRace = false;
								int pastRaceCount = 0;
								int pastGoodRaceCount = 0;
								String[] pastRaceCondition = new String[] {"","","","","","","",""};
								String pastMaxGoodTime = "1年未走";
								String pastMaxGoodPace = "1年未走";
								String pastMaxGoodLast = "1年未走";
								for(int i2 = 0; i2 < HorseElements.size(); i2++) {
									if(HorseElements.get(i2).text().split(" ").length > 22 && LocalDate.parse(HorseElements.get(i2).text().split(" ")[0], 
											DateTimeFormatter.ofPattern("yyyy/[]M/[]d")).isBefore(LocalDate.parse(labelRaceDate.getText(), DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))) {
										if(!findPastRace) 
										{
											h.pastRace =  HorseElements.get(i2).text();
											findPastRace = true;
										}
										if( ((Integer.parseInt(HorseElements.get(i2).text().split(" ")[10]) > 7 && Integer.parseInt(HorseElements.get(i2).text().split(" ")[7]) < 4 ) ||
												 ((Integer.parseInt(HorseElements.get(i2).text().split(" ")[10]) < 8 && Integer.parseInt(HorseElements.get(i2).text().split(" ")[7]) < 3 ) )))
										{
											pastGoodRaceCount++;
											
										}
										if(pastRaceCount < 5)
										{
											pastRace += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										if(HorseElements.get(i2).text().split(" ")[2].contains("芝") && HorseElements.get(i2).text().split(" ")[4].contains("良") && pastRaceCondition[0].length() < 5) {
											pastRaceCondition[0] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										else if(HorseElements.get(i2).text().split(" ")[2].contains("芝") && HorseElements.get(i2).text().split(" ")[4].contains("稍") && pastRaceCondition[1].length() < 5) {
											pastRaceCondition[1] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										else if(HorseElements.get(i2).text().split(" ")[2].contains("芝") && HorseElements.get(i2).text().split(" ")[4].contains("重") && pastRaceCondition[2].length() < 5) {
											pastRaceCondition[2] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										else if(HorseElements.get(i2).text().split(" ")[2].contains("芝") && HorseElements.get(i2).text().split(" ")[4].contains("不") && pastRaceCondition[3].length() < 5) {
											pastRaceCondition[3] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										else if(HorseElements.get(i2).text().split(" ")[2].contains("ダ") && HorseElements.get(i2).text().split(" ")[4].contains("良") && pastRaceCondition[4].length() < 5) {
											pastRaceCondition[4] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										else if(HorseElements.get(i2).text().split(" ")[2].contains("ダ") && HorseElements.get(i2).text().split(" ")[4].contains("稍") && pastRaceCondition[5].length() < 5) {
											pastRaceCondition[5] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										else if(HorseElements.get(i2).text().split(" ")[2].contains("ダ") && HorseElements.get(i2).text().split(" ")[4].contains("重") && pastRaceCondition[6].length() < 5) {
											pastRaceCondition[6] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										else if(HorseElements.get(i2).text().split(" ")[2].contains("ダ") && HorseElements.get(i2).text().split(" ")[4].contains("不") && pastRaceCondition[7].length() < 5) {
											pastRaceCondition[7] += strArray[Integer.parseInt(HorseElements.get(i2).text().split(" ")[7])];
										}
										
										if(LocalDate.parse(HorseElements.get(i2).text().split(" ")[0],DateTimeFormatter.ofPattern("yyyy/[]M/[]d")).isAfter(LocalDate.now().minusYears(1)) && HorseElements.get(i2).text().split(" ")[2].equals(labelRaceRange.getText().substring(0,5))
												&&  (pastMaxGoodTime.equals("1年未走") || (!pastMaxGoodTime.equals("1年未走") && CalcTime(pastMaxGoodTime, HorseElements.get(i2).text().split(" ")[13])))) {
											pastMaxGoodTime = HorseElements.get(i2).text().split(" ")[13] + HorseElements.get(i2).text().split(" ")[4] + HorseElements.get(i2).text().split(" ")[1];
											
											pastMaxGoodPace = HorseElements.get(i2).text().split(" ")[15] + HorseElements.get(i2).text().split(" ")[16] + HorseElements.get(i2).text().split(" ")[17] ;
											pastMaxGoodLast = HorseElements.get(i2).text().split(" ")[18];
										}
										
										pastRaceCount++;
									}
								}
								
								for(int k = 0; k < 8; k++){
									if(pastRaceCondition[k].isEmpty()) 
									{
										pastRaceCondition[k] = "出走なし";
									}
								}
								h.pastRace += " " + decimalFormat.format((double)pastGoodRaceCount * 100.0 / (double)pastRaceCount) + " " + pastRace;
								h.pastRaceCondition = pastRaceCondition[0] + " " + pastRaceCondition[1] + " " + pastRaceCondition[2] + " " + pastRaceCondition[3] + " " + 
										pastRaceCondition[4] + " " + pastRaceCondition[5] + " " + pastRaceCondition[6] + " " + pastRaceCondition[7] + " " +pastMaxGoodTime
										+ " " + pastMaxGoodPace + " " + pastMaxGoodLast;
								new HorseDB().UseHorseDataBase(new String[] {"insert", h.name, raceID.toString(), Integer.toString(h.position),
										h.pastRace,  Integer.toString(h.frame), h.pastRaceCondition});

								List<String> horseString = new ArrayList<String>(Arrays.asList(h.pastRace.split(" ")));
								List<String> horseConditionString = new ArrayList<String>(Arrays.asList(h.pastRaceCondition.split("[ ]+")));
								
								if(horseString.get(19).equals("B")) {
									horseString.remove(19);
								}
								SetTable(h, horseString, strArray[h.number] +  h.pastRace , horseConditionString);
								Thread.sleep(1000);
							}
							else 
							{

								List<String> horseString = new ArrayList<String>(Arrays.asList(horseText[0].split(" ")));
								List<String> horseConditionString = new ArrayList<String>(Arrays.asList(horseText[1].split("[ ]+")));
								
								if(horseString.get(19).equals("B")) {
									horseString.remove(19);
								}


								
								SetTable(h, horseString, horseText[0], horseConditionString);}
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
		 table.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) ->
	        {

	        	String dateText = newVal.getDate();
	        	String stageText = newVal.getRaceStage();
	        	String rangeText = newVal.getRange();
	        	String nameText;
	        	if(newVal.getRaceName().contains("(")) {
	        		String[] nameArray = toHalfWidth(newVal.getRaceName()).split("\\(");
	        		nameText = nameArray[0].replace("Ｓ", "ステークス");
	        	}
	        	else 
	        	{
	        		nameText = toHalfWidth(newVal.getRaceName()).replace("Ｓ", "ステークス");
	        	}
				try {
					Document laboDoc = Jsoup.connect("https://www.keibalab.jp/db/race/" + dateText.substring(0,10).replace("/","")).get();
					Elements stageel = laboDoc.select(".table-striped.std11");
					String[] singleStageel = new String[2];
					for(int i = 0; i < stageel.size(); i++) {
						if(stageel.get(i).text().contains(stageText.substring(2,4)))
						{
							singleStageel = stageel.get(i).text().split("頭");
							break;
						}
					}

					ArrayList<Integer> raceCnt = new ArrayList<Integer>();
					
					

					for(int i = 0; i < singleStageel.length; i++) {
						if(singleStageel[i].contains(nameText) && singleStageel[i].contains(rangeText))
						{
							raceCnt.add(i + 1);
						}
					}

					for(int i = 0; i < raceCnt.size(); i++) {
						arrayPaddockURL[i].setText("https://regist.prc.jp/api/windowopen.aspx?target=race/"
		        			 + dateText.substring(0,4) + "/" + dateText.substring(0,10).replace("/", "") + "/" + dateText.substring(2,4) + stageURL.get(stageText.substring(2,4)) 
		        			 + raceURL.get(stageText.substring(0,1)) + raceURL.get(stageText.substring(4,stageText.length())) + raceURL.get(raceCnt.get(i).toString())
		        	 + "_p&quality=1");
						arrayRaceURL[i].setText("https://regist.prc.jp/api/windowopen.aspx?target=race/"
			        			 + dateText.substring(0,4) + "/" + dateText.substring(0,10).replace("/", "") + "/" + dateText.substring(2,4) + stageURL.get(stageText.substring(2,4)) 
			        			 + raceURL.get(stageText.substring(0,1)) + raceURL.get(stageText.substring(4,stageText.length())) + raceURL.get(raceCnt.get(i).toString())
			        	 + "&quality=1");
					}
					
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	        });
		Comparator<HorseData> comparator =
				  Comparator.<HorseData, String>comparing(model -> model.getNo());
		FXCollections.sort(table.getItems(), comparator);
	}
	

	public static String toHalfWidth(String s) {
		  StringBuilder sb = new StringBuilder(s);
		  for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);
		    if (0xFF10 <= c && c <= 0xFF19) {
		      sb.setCharAt(i, (char) (c - 0xFEE0));
		    }
		  }
		  return sb.toString();
		}
	
	private void SetTable(Horse h, List<String>horseString, String horseText, List<String>pastRaceCondition) {
		table.getItems().add(new HorseData(strArray[h.number],h.name,RacePointCheck(horseText, h),horseString,pastRaceCondition,raceRange));

		
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
	
	
	private boolean CalcTime(String max, String newRace) 
	{
		int maxTime = Integer.parseInt(max.substring(0,1)) * 600 +  Integer.parseInt(max.substring(2,4)) * 10 + Integer.parseInt(max.substring(5,6));
		int newTime = Integer.parseInt(newRace.substring(0,1)) * 600 +  Integer.parseInt(newRace.substring(2,4)) * 10 + Integer.parseInt(newRace.substring(5,6));
		
		if(newTime < maxTime) {
			return true;
		}
		
		return false;
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
