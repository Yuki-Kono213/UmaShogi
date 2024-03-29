package application;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import javax.lang.model.element.NestingKind;
import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.h2.util.SmallLRUCache;
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
	private Label lblPastReturn;
	@FXML
	private Label lblPastCount;
	@FXML
	private Label lblPastPercentage;
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
	private TableView<HorseData> table;
	@FXML
	private TableColumn<HorseData, String> numberTable;
	@FXML
	private TableColumn<HorseData, String> jikuTable;
	@FXML
	private TableColumn<HorseData, String> nameTable;
	@FXML
	private TableColumn<HorseData, String> indexTable;
	@FXML
	private TableColumn<HorseData, String> anaIndexTable;
	@FXML
	private TableColumn<HorseData, String> dateTable;
	@FXML
	private TableColumn<HorseData, String> raceLevelTable;
	@FXML
	private TableColumn<HorseData, String> raceStageTable;
	@FXML
	private TableColumn<HorseData, String> rangeTable;
	@FXML
	private TableColumn<HorseData, String> rangeTable2;
	@FXML
	private TableColumn<HorseData, String> weatherTable;
	@FXML
	private TableColumn<HorseData, String> stageTable;
	@FXML
	private TableColumn<HorseData, String> raceNameTable;
	@FXML
	private TableColumn<HorseData, String> expectTable;
	@FXML
	private TableColumn<HorseData, String> resultTable;
	@FXML
	private TableColumn<HorseData, String> jockeyTable;
	@FXML
	private TableColumn<HorseData, String> jockeyWeightTable;
	@FXML
	private TableColumn<HorseData, String> horseCountTable;
	@FXML
	private TableColumn<HorseData, String> startNoTable;
	@FXML
	private TableColumn<HorseData, String> frameNoTable;
	@FXML
	private TableColumn<HorseData, String> timeTable;
	@FXML
	private TableColumn<HorseData, String> behindTable;
	@FXML
	private TableColumn<HorseData, String> paceTable;
	@FXML
	private TableColumn<HorseData, String> lastTable;
	@FXML
	private TableColumn<HorseData, String> sameRangeTimeTable;
	@FXML
	private TableColumn<HorseData, String> weightTable;
	@FXML
	private TableColumn<HorseData, String> runRankTable;
	@FXML
	private TableColumn<HorseData, String> topHorseTable;
	@FXML
	private TableColumn<HorseData, String> analysisTable;
	@FXML
	private TableColumn<HorseData, String> multipleTable;
	@FXML
	private TableColumn<HorseData, String> pastRaceTable;
	@FXML
	private TableColumn<HorseData, String> numberTable1;
	@FXML
	private TableColumn<HorseData, String> nameTable1;
	@FXML
	private TableColumn<HorseData, String> grassGoodRaceResult;
	@FXML
	private TableColumn<HorseData, String> grassBitHeavyRaceResult;
	@FXML
	private TableColumn<HorseData, String> grassHeavyRaceResult;
	@FXML
	private TableColumn<HorseData, String> grassBadRaceResult;
	@FXML
	private TableColumn<HorseData, String> dirtGoodRaceResult;
	@FXML
	private TableColumn<HorseData, String> dirtBitHeavyRaceResult;
	@FXML
	private TableColumn<HorseData, String> dirtHeavyRaceResult;
	@FXML
	private TableColumn<HorseData, String> dirtBadRaceResult;
	@FXML
	private TableColumn<HorseData, String> pastMaxSpeed;
	@FXML
	private TableColumn<HorseData, String> pastMaxSpeedDifference;
	@FXML
	private TableColumn<HorseData, String> pastMaxSpeed2;
	@FXML
	private TableColumn<HorseData, String> pastMaxPace;
	@FXML
	private TableColumn<HorseData, String> pastMaxSpeedLast;
	@FXML
	private TableColumn<HorseData, String> straightSlope;
	@FXML
	private TableColumn<HorseData, String> straightDistance;
	@FXML
	private TableColumn<HorseData, String> cornerShape;
	@FXML
	private TableColumn<HorseData, String> rotationSide;
	@FXML
	private TableColumn<HorseData, String> rotationSize;
	@FXML
	private TableColumn<HorseData, String> grassStart;
	@FXML
	private TableColumn<HorseData, String> raceGround;
	@FXML
	private TableColumn<HorseData, Double> first3furlong;
	@FXML
	private TableColumn<HorseData, Double> middle;
	@FXML
	private TableColumn<HorseData, Double> last3furlong;
	@FXML
	private TableColumn<HorseData, String> beforeJockeyTrait;
	@FXML
	private TableColumn<HorseData, String> nowJockeyTrait;

	@FXML
	private TableColumn<HorseData, String> nameTable2;
	@FXML
	private TableColumn<HorseData, String> indexTable1;
	@FXML
	private TableColumn<HorseData, String> anaIndexTable1;
	@FXML
	private Button raceLevelbtn;

	@FXML
	private Button buttonOpenPaddock;
	@FXML
	private Button buttonOpenPaddock1;
	@FXML
	private Button buttonOpenPaddock2;
	@FXML
	private Button buttonOpenPaddock3;

	@FXML
	private Button buttonOpenPaddock4;
	@FXML
	private Button buttonOpenPaddock5;

	@FXML
	private Button buttonOpenPaddock6;
	@FXML
	private Button buttonOpenPaddock7;

	@FXML
	private TextField txtPaddockURL;
	@FXML
	private TextField txtPaddockURL1;
	@FXML
	private TextField txtPaddockURL2;
	@FXML
	private TextField txtPaddockURL3;
	@FXML
	private TextField txtPaddockURL4;
	@FXML
	private TextField txtPaddockURL5;
	@FXML
	private TextField txtPaddockURL6;
	@FXML
	private TextField txtPaddockURL7;

	@FXML
	private TextField txtRaceURL;
	@FXML
	private TextField txtRaceURL1;
	@FXML
	private TextField txtRaceURL2;
	@FXML
	private TextField txtRaceURL3;
	@FXML
	private TextField txtRaceURL4;
	@FXML
	private TextField txtRaceURL5;
	@FXML
	private TextField txtRaceURL6;
	@FXML
	private TextField txtRaceURL7;

	@FXML
	private TextField txtResultURL;
	@FXML
	private TextField txtResultURL1;
	@FXML
	private TextField txtResultURL2;
	@FXML
	private TextField txtResultURL3;
	@FXML
	private TextField txtResultURL4;
	@FXML
	private TextField txtResultURL5;
	@FXML
	private TextField txtResultURL6;
	@FXML
	private TextField txtResultURL7;

	@FXML
	private Button buttonOpenRace;
	@FXML
	private Button buttonOpenRace1;
	@FXML
	private Button buttonOpenRace2;
	@FXML
	private Button buttonOpenRace3;
	@FXML
	private Button buttonOpenRace4;
	@FXML
	private Button buttonOpenRace5;
	@FXML
	private Button buttonOpenRace6;
	@FXML
	private Button buttonOpenRace7;

	@FXML
	private Label labelRace;
	@FXML
	private Label labelRace1;
	@FXML
	private Label labelRace2;
	@FXML
	private Label labelRace3;
	@FXML
	private Label labelRace4;
	@FXML
	private Label labelRace5;
	@FXML
	private Label labelRace6;
	@FXML
	private Label labelRace7;
	@FXML
	private TextArea txtExplainRace;

	@FXML
	private TextField txtThisRaceURL;
	@FXML
	private TextField txtThisPaddockURL;

	@FXML
	private Button buttonThisRace;
	@FXML
	private Button buttonThisPaddock;

	@FXML
	private TextField txtPay;

	@FXML
	private TextField txtReturn;
	@FXML
	private Label lblRecovery;

	@FXML
	private Label lblRecoveryToday; 
	@FXML
	private Label lblWinWideThree;
	@FXML
	private Label lblWinWideFour;
	@FXML
	private Label lblWinWideFive;
	@FXML
	private Label lblWinWideSix;
	@FXML
	private Label lblWinWideFiveNagashi;

	@FXML
<<<<<<< HEAD
	private Label lblWinAnaHorseThree;
	@FXML
	private Label lblWinAnaHorseFour;
	@FXML
	private Label lblWinAnaHorseFive;
	@FXML
	private Label lblWinAnaHorseSix;
	@FXML
	private Label lblWinAnaHorseFiveNagashi;
=======
	private Label lblWinUmarenThree;
	@FXML
	private Label lblWinUmarenFour;
	@FXML
	private Label lblWinUmarenFive;
	@FXML
	private Label lblWinUmarenSix;
	@FXML
	private Label lblWinUmarenFiveNagashi;
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi

	private PastRaceResult prr = new PastRaceResult();

	public void ClearText() {
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

	public void SaveRace() {
		if (!txtPay.getText().equals("0") || !txtReturn.getText().equals("0") || reGet) {
			RaceDB rdb = new RaceDB();
			rdb.UseRaceDataBase(
					new String[] { "update", rdm.RaceName, rdm.RaceURL, txtPay.getText(), txtReturn.getText(),
							labelRaceRange.getText().substring(0, 1), labelRaceRange.getText().substring(1, 5),
							labelRaceStage.getText(), grade, hande, String.valueOf(female), condition, raceAge, raceCount });

			rdm.payCash = Integer.parseInt(txtPay.getText());
			rdm.returnCash = Integer.parseInt(txtReturn.getText());
			try {
				lblPastReturn.setText(new RaceDB().executeReturnMoney(
						labelRaceRange.getText(), labelRaceStage.getText() 
								, labelRaceDate.getText().substring(0,4))+ "%");
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			TotalRecoveryCheck();
		}
	}

	public void ViewRace() {

		if(rdm.payCash != 0) {
			txtPay.setText(String.valueOf(rdm.payCash));
			txtReturn.setText(String.valueOf(rdm.returnCash));
			lblRecovery.setText(rdm.returnCash * 100 / rdm.payCash + "%");
			TotalRecoveryCheck();
		}

	}

	private void TotalRecoveryCheck() {
		if (rdm.payCash != 0) {
			lblRecovery.setText(rdm.returnCash * 100 / rdm.payCash + "%");
		} else {
			lblRecovery.setText("100%");
		}
		int payCash = 0;
		int returnCash = 0;

		for (int i = 1; i < 13; i++) {
			Integer[] raceData = { 0, 0, 0 };
			RaceDB rdb = new RaceDB();
			try {
				raceData = rdb.GetRaceID(textURL.getText().substring(0, 42)
						+ Util.raceKeibaLaboURL.get(String.valueOf(i)) + "/umabashira.html");
				payCash += raceData[1];
				returnCash += raceData[2];
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		lblRecoveryToday.setText("100%");
		if (payCash != 0) {
			lblRecoveryToday.setText(returnCash * 100 / payCash + "%");
		}

	}

	String[] strArray = { "⓪", "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩", "⑪", "⑫", "⑬", "⑭", "⑮", "⑯", "⑰", "⑱",
			"⑲", "⑳"

	};

	TextField[] arrayPaddockURL;
	Button[] arrayPaddockButton;
	TextField[] arrayRaceURL;
	Button[] arrayRaceButton;
	Label[] arrayRaceLabel;
	TextField[] arrayResultURL;

	HorseData[] horseDataArray;
	Horse[] horseArray;

	public static String grade;
	private String hande;
	private String raceAge;
	private String raceCount;
	public static String stage;
	private Boolean female;
	public static String condition;
	public static String grassDirt;
	public static RaceDataManager rdm;
	private boolean reGet = false; 
	public void ReGetURL() {
		reGet = true;
		GetURL();
	}
	private boolean newHorse = false;
	public void GetAllURL() {
		reGet = false;
		LocalDate dateObj = LocalDate.now();
		LocalDate raceDate = null;
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		for(int i = 1; i < 13; i++) {
			textURL.setText(textURL.getText(0,42)+ Util.raceKeibaLaboURL.get(String.valueOf(i)) + "/");
			GetURL();
			if(!labelRaceName.getText().contains("障害")&&!labelRaceName.getText().contains("新馬")) {
				try {
					raceDate = LocalDate.parse(labelRaceDate.getText(), DateTimeFormatter.ofPattern("yyyy/[]M/[]d"));
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			Calendar cal3 = Calendar.getInstance();
			SimpleDateFormat sdf3 = new SimpleDateFormat("HH");
			if(raceDate == null) {
				continue;
			}
			if(raceDate.isBefore(dateObj) || 
					raceDate.isEqual(dateObj) && Integer.parseInt(sdf3.format(cal3.getTime())) >= 17) {GetRaceMoney();}
			
		}
	}
	public void GetRaceMoneyFile() {
		JFileChooser filechooser = new JFileChooser();

	    int selected = filechooser.showOpenDialog(filechooser);
	    if (selected == JFileChooser.APPROVE_OPTION){
	      File file = filechooser.getSelectedFile();
	      if (!file.exists()) {
              System.out.print("ファイルが存在しません");
              return;
          }
          try {
        	  reGet = false;
        	  FileReader fileReader = new FileReader(file);
        	  BufferedReader bufferedReader = new BufferedReader(fileReader);
        	  String data;
        	  while ((data = bufferedReader.readLine()) != null && data != "\r\n") {
          		for(int i = 1; i < 13; i++) {
          			textURL.setText(data.substring(0,42)+ Util.raceKeibaLaboURL.get(String.valueOf(i)) + "/");
          			GetURL();
          			if(!labelRaceName.getText().contains("障害")&&!labelRaceName.getText().contains("新馬")) {
          				try {
                  			GetRaceMoney();
                  			System.out.println("a" + i);
          					Thread.sleep(1000);
          				} catch (Exception e) {
          					// TODO 自動生成された catch ブロック
          					e.printStackTrace();
          				}
          			}
          			
          		}
			  }
      		
	          // 最後にファイルを閉じてリソースを開放する
	          bufferedReader.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
       
	    }else if (selected == JFileChooser.CANCEL_OPTION) {
	    }else if (selected == JFileChooser.ERROR_OPTION){
	    }
	}
<<<<<<< HEAD

	ArrayList<HorseData> hDataArrayList = new ArrayList<>();
	ArrayList<HorseData> hDataAnaArrayList = new ArrayList<>();
	
	private void DrawJikuAna() {

		for (HorseData h : horseDataArray) {
			if(h != null) {
				hDataArrayList.add(h);
				hDataAnaArrayList.add(h);
			}
		}
		hDataArrayList.sort((o1, o2) -> Integer.parseInt(o2.getIndex()) - Integer.parseInt(o1.getIndex()));
		hDataAnaArrayList.sort((o1, o2) -> Integer.parseInt(o2.getAnaIndex()) - Integer.parseInt(o1.getAnaIndex()));
		
		String[] horseArrayStrings = new String[6];
		
		horseArrayStrings[0] = hDataArrayList.get(0).getNo();
		horseArrayStrings[1] = hDataArrayList.get(1).getNo();
		int cnt = 2;
		for(int i = 0; i < hDataAnaArrayList.size(); i++) {
			if(!horseArrayStrings[0].equals(hDataAnaArrayList.get(i).getNo()) && !horseArrayStrings[1].equals(hDataAnaArrayList.get(i).getNo())) {
				horseArrayStrings[cnt] = hDataAnaArrayList.get(i).getNo();
				cnt++;
			}
			if(cnt == 6) {
				break;
			}
		}
		

		horseDataArray[Math.abs(Util.RankMap.get(horseArrayStrings[0]) - horseDataArray.length)].setJikuAna("軸1");
		horseDataArray[Math.abs(Util.RankMap.get(horseArrayStrings[1]) - horseDataArray.length)].setJikuAna("軸2");
		horseDataArray[Math.abs(Util.RankMap.get(horseArrayStrings[2]) - horseDataArray.length)].setJikuAna("穴1");
		horseDataArray[Math.abs(Util.RankMap.get(horseArrayStrings[3]) - horseDataArray.length)].setJikuAna("穴2");
		horseDataArray[Math.abs(Util.RankMap.get(horseArrayStrings[4]) - horseDataArray.length)].setJikuAna("穴3");
		horseDataArray[Math.abs(Util.RankMap.get(horseArrayStrings[5]) - horseDataArray.length)].setJikuAna("穴4");
		
		table.getItems().clear();

		for(int i = horseDataArray.length - 1; i > -1; i--){

			table.getItems().add(horseDataArray[i]);
		}
		
		table.sort();
	}
=======
	    
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
	public void GetRaceMoney() {
		try {
			Document doc = Jsoup.connect(textURL.getText().replace("umabashira.html", "") + "raceresult.html").get();
			Elements wide = doc.select(".haraimodoshi tr .tR");
			Elements wideNo = doc.select(".haraimodoshi tr .tC");
			String[]horse3 = null;
			String[]horse4 = null;
			String[]horse5 = null;
			String[]horse6 = null;
<<<<<<< HEAD
			String[]anaHorse3 = new String[3];
			String[]anaHorse4 = new String[4];
			String[]anaHorse5 = new String[5];
			String[]anaHorse6 = new String[6];
			String[]anaHorse5nagashi = new String[5];
			String[]horse5nagashi = new String[5];
			String jikuHorse = hDataArrayList.get(0).getNo();
=======
			String[]horse5nagashi = null;
			hDataArrayList.sort((o1, o2) -> Integer.parseInt(o2.getIndex()) - Integer.parseInt(o1.getIndex()));
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			if(hDataArrayList.size() > 2) {
				horse3 = new String[] {hDataArrayList.get(0).getNo(), hDataArrayList.get(1).getNo(), hDataArrayList.get(2).getNo()};
				//anaHorse3 = new String[] {hDataAnaArrayList.get(0).getNo(), hDataAnaArrayList.get(1).getNo(), hDataAnaArrayList.get(2).getNo()};
				anaHorse3[0] = hDataArrayList.get(0).getNo();
				int cnt = 1;
				for(int i = 0; i < hDataAnaArrayList.size(); i++) {
					if(!anaHorse3[0].equals(hDataAnaArrayList.get(i).getNo())) {
						anaHorse3[cnt] = hDataAnaArrayList.get(i).getNo();
						cnt++;
					}
					if(cnt == 3) {
						break;
					}
				}
				
			}
			if(hDataArrayList.size() > 3) {
				horse4 = new String[] {hDataArrayList.get(0).getNo(), hDataArrayList.get(1).getNo(), hDataArrayList.get(2).getNo()
					,hDataArrayList.get(3).getNo()};
				//anaHorse4 = new String[] {hDataAnaArrayList.get(0).getNo(), hDataAnaArrayList.get(1).getNo(), hDataAnaArrayList.get(2).getNo()
				//		, hDataAnaArrayList.get(3).getNo()};
				
				anaHorse4[0] = hDataArrayList.get(0).getNo();
				anaHorse4[1] = hDataArrayList.get(1).getNo();
				int cnt = 2;
				for(int i = 0; i < hDataAnaArrayList.size(); i++) {
				if(!anaHorse4[0].equals(hDataAnaArrayList.get(i).getNo()) && !anaHorse4[1].equals(hDataAnaArrayList.get(i).getNo())) {
						anaHorse4[cnt] = hDataAnaArrayList.get(i).getNo();
						cnt++;
					}
					if(cnt == 4) {
						break;
					}
				}
			}
		
			if(hDataArrayList.size() > 4) {
				horse5 = new String[] {hDataArrayList.get(0).getNo(), hDataArrayList.get(1).getNo(), hDataArrayList.get(2).getNo()
					,hDataArrayList.get(3).getNo(),hDataArrayList.get(4).getNo()};
				//anaHorse5 = new String[] {hDataAnaArrayList.get(0).getNo(), hDataAnaArrayList.get(1).getNo(), hDataAnaArrayList.get(2).getNo()
				//			, hDataAnaArrayList.get(3).getNo(), hDataAnaArrayList.get(4).getNo()};
					
				anaHorse5[0] = hDataArrayList.get(0).getNo();
				anaHorse5[1] = hDataArrayList.get(1).getNo();
				int cnt = 2;
				for(int i = 0; i < hDataAnaArrayList.size(); i++) {
					if(!anaHorse5[0].equals(hDataAnaArrayList.get(i).getNo()) && !anaHorse5[1].equals(hDataAnaArrayList.get(i).getNo())) {
						anaHorse5[cnt] = hDataAnaArrayList.get(i).getNo();
						cnt++;
					}
					if(cnt == 5) {
						break;
					}
				}
			}
			if(hDataArrayList.size() > 5) {
				horse6 = new String[] {hDataArrayList.get(0).getNo(), hDataArrayList.get(1).getNo(), hDataArrayList.get(2).getNo()
					,hDataArrayList.get(3).getNo(),hDataArrayList.get(4).getNo(),hDataArrayList.get(5).getNo()};
				horse5nagashi = new String[]{ hDataArrayList.get(1).getNo(), hDataArrayList.get(2).getNo()
					,hDataArrayList.get(3).getNo(),hDataArrayList.get(4).getNo(),hDataArrayList.get(5).getNo()};
<<<<<<< HEAD
				//anaHorse6 = new String[] {hDataAnaArrayList.get(0).getNo(), hDataAnaArrayList.get(1).getNo(), hDataAnaArrayList.get(2).getNo()
				//		, hDataAnaArrayList.get(3).getNo(), hDataAnaArrayList.get(4).getNo(), hDataAnaArrayList.get(5).getNo()};
			
				anaHorse6[0] = hDataArrayList.get(0).getNo();
				anaHorse6[1] = hDataArrayList.get(1).getNo();
				int cnt = 2;
				for(int i = 0; i < hDataAnaArrayList.size(); i++) {
					if(!anaHorse6[0].equals(hDataAnaArrayList.get(i).getNo()) && !anaHorse6[1].equals(hDataAnaArrayList.get(i).getNo())) {
						anaHorse6[cnt] = hDataAnaArrayList.get(i).getNo();
						cnt++;
					}
					if(cnt == 6) {
						break;
					}
				}
				cnt = 0;
				for(int i = 0; i < hDataAnaArrayList.size(); i++) {
					if(!jikuHorse.equals(hDataAnaArrayList.get(i).getNo())) {
						anaHorse5nagashi[cnt] = hDataAnaArrayList.get(i).getNo();
						cnt++;
					}
					if(cnt == 5) {
						break;
					}
				}
=======
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			}
			
			
			String[] wideArray = wide.get(3).text().replace(",", "").replace("円","").split(" ");
<<<<<<< HEAD
			//String[] anaHorseArray = wide.get(6).text().replace(",", "").replace("円","").split(" ");
			String[] anaHorseArray = wideArray;
=======
			String[] umarenArray = wide.get(6).text().replace(",", "").replace("円","").split(" ");
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			String[] wideNoArray = wideNo.get(3).text().split(" ");
<<<<<<< HEAD
			String[] anaHorseNoArray = wideNo.get(6).text().split(" ");
=======
			String[] umarenNoArray = wideNo.get(6).text().split(" ");
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			int horse3int = 0;
			int horse4int = 0;
			int horse5int = 0;
			int horse6int = 0;
			int horseNagashi5int = 0;
<<<<<<< HEAD
			int anaHorse3int = 0;
			int anaHorse4int = 0;
			int anaHorse5int = 0;
			int anaHorse6int = 0;
			int anaHorseNagashi5int = 0;
=======
			int horseUmaren3int = 0;
			int horseUmaren4int = 0;
			int horseUmaren5int = 0;
			int horseUmaren6int = 0;
			int horseUmarenNagashi5int = 0;
			String jikuHorse = hDataArrayList.get(0).getNo();
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			for (int i =0; i < wideArray.length; i++) {
				Wide w = new Wide(wideNoArray[i].split("-")[0], wideNoArray[i].split("-")[1], Integer.parseInt(wideArray[i]));
				if(horse3 != null && Arrays.asList(horse3).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse3).contains(Util.RankTableMap.get(w.two)) ) {
					horse3int += w.money;
				}
				
				if(horse4 != null && Arrays.asList(horse4).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse4).contains(Util.RankTableMap.get(w.two)) ) {
					horse4int += w.money;
				}
				
				if(horse5 != null && Arrays.asList(horse5).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse5).contains(Util.RankTableMap.get(w.two)) ) {
					horse5int += w.money;
				}
				if(horse6 != null && Arrays.asList(horse6).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse6).contains(Util.RankTableMap.get(w.two)) ) {
					horse6int += w.money;
				}
				if(horse5nagashi != null && (jikuHorse.contains(Util.RankTableMap.get(w.one)) || jikuHorse.contains(Util.RankTableMap.get(w.two)))
						&& (Arrays.asList(horse5nagashi).contains(Util.RankTableMap.get(w.one))||Arrays.asList(horse5nagashi).contains(Util.RankTableMap.get(w.two)))) {
					horseNagashi5int += w.money;
				}
			}
			
<<<<<<< HEAD
			for (int i =0; i < anaHorseArray.length; i++) {
				Wide w = new Wide(wideNoArray[i].split("-")[0], wideNoArray[i].split("-")[1], Integer.parseInt(anaHorseArray[i]));
				if(anaHorse3 != null && Arrays.asList(anaHorse3).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(anaHorse3).contains(Util.RankTableMap.get(w.two)) ) {
					anaHorse3int += w.money;
				}
				
				if(horse4 != null && Arrays.asList(anaHorse4).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(anaHorse4).contains(Util.RankTableMap.get(w.two)) ) {
					anaHorse4int += w.money;
				}
				
				if(horse5 != null && Arrays.asList(anaHorse5).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(anaHorse5).contains(Util.RankTableMap.get(w.two)) ) {
					anaHorse5int += w.money;
				}
				if(horse6 != null && Arrays.asList(anaHorse6).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(anaHorse6).contains(Util.RankTableMap.get(w.two)) ) {
					anaHorse6int += w.money;
				}
				if(horse5nagashi != null && (jikuHorse.contains(Util.RankTableMap.get(w.one)) || jikuHorse.contains(Util.RankTableMap.get(w.two)))
						&& (Arrays.asList(anaHorse5nagashi).contains(Util.RankTableMap.get(w.one))||Arrays.asList(anaHorse5nagashi).contains(Util.RankTableMap.get(w.two)))) {
					anaHorseNagashi5int += w.money;
=======
			for (int i =0; i < umarenArray.length; i++) {
				Wide w = new Wide(umarenNoArray[i].split("-")[0], umarenNoArray[i].split("-")[1], Integer.parseInt(umarenArray[i]));
				if(horse3 != null && Arrays.asList(horse3).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse3).contains(Util.RankTableMap.get(w.two)) ) {
					horseUmaren3int += w.money;
				}
				
				if(horse4 != null && Arrays.asList(horse4).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse4).contains(Util.RankTableMap.get(w.two)) ) {
					horseUmaren4int += w.money;
				}
				
				if(horse5 != null && Arrays.asList(horse5).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse5).contains(Util.RankTableMap.get(w.two)) ) {
					horseUmaren5int += w.money;
				}
				if(horse6 != null && Arrays.asList(horse6).contains(Util.RankTableMap.get(w.one)) && Arrays.asList(horse6).contains(Util.RankTableMap.get(w.two)) ) {
					horseUmaren6int += w.money;
				}
				if(horse5nagashi != null && (jikuHorse.contains(Util.RankTableMap.get(w.one)) || jikuHorse.contains(Util.RankTableMap.get(w.two)))
						&& (Arrays.asList(horse5nagashi).contains(Util.RankTableMap.get(w.one))||Arrays.asList(horse5nagashi).contains(Util.RankTableMap.get(w.two)))) {
					horseUmarenNagashi5int += w.money;
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
				}
			}
			
			if(horse4 == null) {
				horse4int = horse3int;
			}
			if(horse5 == null) {
				horse5int = horse4int;
			}
			if(horse6 == null) {
				horse6int = horse5int;
			}
			
			lblWinWideThree.setText(String.valueOf(horse3int));
			lblWinWideFour.setText(String.valueOf(horse4int));
			lblWinWideFive.setText(String.valueOf(horse5int));
			lblWinWideSix.setText(String.valueOf(horse6int));
			lblWinWideFiveNagashi.setText(String.valueOf(horseNagashi5int));
<<<<<<< HEAD
			lblWinAnaHorseThree.setText(String.valueOf(anaHorse3int));
			lblWinAnaHorseFour.setText(String.valueOf(anaHorse4int));
			lblWinAnaHorseFive.setText(String.valueOf(anaHorse5int));
			lblWinAnaHorseSix.setText(String.valueOf(anaHorse6int));
			lblWinAnaHorseFiveNagashi.setText(String.valueOf(anaHorseNagashi5int));
=======
			lblWinUmarenThree.setText(String.valueOf(horseUmaren3int));
			lblWinUmarenFour.setText(String.valueOf(horseUmaren4int));
			lblWinUmarenFive.setText(String.valueOf(horseUmaren5int));
			lblWinUmarenSix.setText(String.valueOf(horseUmaren6int));
			lblWinUmarenFiveNagashi.setText(String.valueOf(horseUmarenNagashi5int));
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			new RaceDB().UseRaceDataBase(
					new String[] {"updateMoney", rdm.RaceURL,lblWinWideThree.getText(), lblWinWideFour.getText() 
							, lblWinWideFive.getText() , lblWinWideSix.getText(), lblWinWideFiveNagashi.getText()
<<<<<<< HEAD
							, lblWinAnaHorseThree.getText(), lblWinAnaHorseFour.getText() 
							, lblWinAnaHorseFive.getText() , lblWinAnaHorseSix.getText(), lblWinAnaHorseFiveNagashi.getText() });
			System.out.println(lblWinWideThree.getText() + " " + lblWinWideFour.getText() + " " +
					lblWinWideFive.getText() + " " + lblWinWideSix.getText() + " " +  lblWinWideFiveNagashi.getText());
			System.out.println(lblWinAnaHorseThree.getText() + " " + lblWinAnaHorseFour.getText() + " " +
					lblWinAnaHorseFive.getText() + " " + lblWinAnaHorseSix.getText() + " " +  lblWinAnaHorseFiveNagashi.getText());
=======
							, lblWinUmarenThree.getText(), lblWinUmarenFour.getText() 
							, lblWinUmarenFive.getText() , lblWinUmarenSix.getText(), lblWinUmarenFiveNagashi.getText() });
			System.out.println(lblWinWideThree.getText() + " " + lblWinWideFour.getText() + " " +
					lblWinWideFive.getText() + " " + lblWinWideSix.getText() + " " +  lblWinWideFiveNagashi.getText());
			System.out.println(lblWinUmarenThree.getText() + " " + lblWinUmarenFour.getText() + " " +
					lblWinUmarenFive.getText() + " " + lblWinUmarenSix.getText() + " " +  lblWinUmarenFiveNagashi.getText());
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
	}
	public static String[]pastGetStrings = new String[13];
	public static LocalDate staticRaceDate;
	static int loadcnt = 0;
	public static LocalDate matchDate;
	public static int raceDateCount;
	public static RaceCourse rc;
	String pastRaceTenkai;
	public static boolean grassStartBool;
	public void GetURL() {

		numberTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("no"));

		jikuTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("jikuAna"));
		
		nameTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("name"));

		indexTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("index"));
		
		anaIndexTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("anaIndex"));

		dateTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("date"));

		raceStageTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("raceStage"));

		raceLevelTable.setCellValueFactory(new PropertyValueFactory<HorseData, String>("raceLevel"));

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
		nameTable2.setCellValueFactory(new PropertyValueFactory<HorseData, String>("name"));
		indexTable1.setCellValueFactory(new PropertyValueFactory<HorseData, String>("index"));
		anaIndexTable1.setCellValueFactory(new PropertyValueFactory<HorseData, String>("anaIndex"));
		
		beforeJockeyTrait.setCellValueFactory(new PropertyValueFactory<HorseData, String>("beforeJockeyTrait"));
		nowJockeyTrait.setCellValueFactory(new PropertyValueFactory<HorseData, String>("nowJockeyTrait"));

		grassGoodRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("grassGoodRaceResult"));
		grassBitHeavyRaceResult
				.setCellValueFactory(new PropertyValueFactory<HorseData, String>("grassBitHeavyRaceResult"));
		grassHeavyRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("grassHeavyRaceResult"));
		grassBadRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("grassBadRaceResult"));
		dirtGoodRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtGoodRaceResult"));
		dirtBitHeavyRaceResult
				.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtBitHeavyRaceResult"));
		dirtHeavyRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtHeavyRaceResult"));
		dirtBadRaceResult.setCellValueFactory(new PropertyValueFactory<HorseData, String>("dirtBadRaceResult"));
		pastMaxSpeed.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxSpeed"));
		pastMaxSpeed2.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxSpeed"));
		pastMaxPace.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxPace"));
		pastMaxSpeedLast.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxSpeedLast"));
		pastMaxSpeedDifference.setCellValueFactory(new PropertyValueFactory<HorseData, String>("pastMaxSpeedDifference"));

		straightDistance.setCellValueFactory(new PropertyValueFactory<HorseData, String>("straightDistance"));
		straightSlope.setCellValueFactory(new PropertyValueFactory<HorseData, String>("straightSlope"));
		cornerShape.setCellValueFactory(new PropertyValueFactory<HorseData, String>("cornerShape"));
		rotationSide.setCellValueFactory(new PropertyValueFactory<HorseData, String>("rotationSide"));
		rotationSize.setCellValueFactory(new PropertyValueFactory<HorseData, String>("rotationSize"));
		grassStart.setCellValueFactory(new PropertyValueFactory<HorseData, String>("grassStart"));
		raceGround.setCellValueFactory(new PropertyValueFactory<HorseData, String>("raceGround"));
		first3furlong.setCellValueFactory(new PropertyValueFactory<HorseData, Double>("first3furlong"));
		middle.setCellValueFactory(new PropertyValueFactory<HorseData, Double>("excludeLast3furlong"));
		last3furlong.setCellValueFactory(new PropertyValueFactory<HorseData, Double>("last3furlong"));
		rangeTable2.setCellValueFactory(new PropertyValueFactory<HorseData, String>("range"));

		try {
			table.getItems().clear();
			ClearText();
			// jsoupを使用して当ブログのトップページへアクセス
			textURL.setText(textURL.getText().substring(0, 44) + "/umabashira.html");
			Document doc = Jsoup.connect(textURL.getText()).get();

			Element age = doc.select(".seirei.std9").get(0);
			Element rate = doc.select(".seirei.std9").get(1);
			Elements rateElements = rate.getAllElements();
			Elements rateSpanElements = rateElements.select("td");
			Elements ageElements = age.getAllElements();
			Elements ageSpanElements = ageElements.select("td");

			Elements horseURLElements = doc.select("div[class~=BameiWrap.*] > a");
			Elements stageElements = doc.select("#topicPath ul li");
			Elements jockeyElements = doc.select(".kisyu td");
			Elements horseElements = doc.select("a.tategaki.bamei");
			Elements beforeElements = doc.select(".zensou.std11 span,.BeforRaces");
			Elements frameElements = doc.select(".wakuban td:matchesOwn([1-8])");
			Elements dateElements = doc.select(".fL.ml10 .bold");
			Elements rangeElements = doc.select(".classCourseSyokin.clearfix li");
			Elements conditionElements = doc.select(".raceaboutbox.clearfix li");
			Elements heavyElements = doc.select(".kinryou.std9 td");
			condition = conditionElements.get(1).text();
			if(condition.length() > 1) {
				condition = "良";
			}
			System.out.println("コンディション" + condition);
			labelRaceName.setText(doc.select(".raceTitle.fL").get(0).text());
			grade = null;
			if (labelRaceName.getText().contains("ＧⅠ")) {
				grade = "ＧⅠ";
			} else if (labelRaceName.getText().contains("ＧⅡ")) {
				grade = "ＧⅡ";
			} else if (labelRaceName.getText().contains("ＧⅢ")) {
				grade = "ＧⅢ";
			} else if (labelRaceName.getText().contains("オープン")) {
				grade = "オープン";
			} else if (labelRaceName.getText().contains("3勝")) {
				grade = "3勝";
			} else if (labelRaceName.getText().contains("2勝")) {
				grade = "2勝";
			} else if (labelRaceName.getText().contains("1勝")) {
				grade = "1勝";
			} else if (labelRaceName.getText().contains("未勝利")) {
				grade = "未勝利";
			} else if (labelRaceName.getText().contains("新馬")) {
				grade = "新馬";
			}
			labelRaceRange.setText(rangeElements.get(1).text().split(" ")[0]);
			raceAge = rangeElements.get(0).text().split(" ")[0];
			raceCount = rangeElements.get(1).text().split(" ")[1].split("&")[0].replace("頭", "");
			System.out.println(raceCount + "頭");
			raceRange = Integer.parseInt(rangeElements.get(1).text().split(" ")[0].substring(1, 5));
			if (grade == null) {
				if (rangeElements.get(0).text().contains("オープン")) {
					grade = "オープン";
				} else if (rangeElements.get(0).text().contains("3勝")) {
					grade = "3勝";
				} else if (rangeElements.get(0).text().contains("2勝")) {
					grade = "2勝";
				} else if (rangeElements.get(0).text().contains("1勝")) {
					grade = "1勝";
				}
			}

			if(!grade.equals("新馬") && !labelRaceName.getText().contains("障害") ) {
			if (rangeElements.get(0).text().contains("ハンデ")) {
				hande = "ハンデ";
			} else if (rangeElements.get(0).text().contains("別定")) {
				hande = "別定";
			} else {
				hande = "定量";
			}

			if (rangeElements.get(0).text().contains("牝")) {
				female = true;
			} else {
				female = false;
			}

			labelRaceStage.setText(stageElements.get(3).text().split("競馬")[0]);
			stage = labelRaceStage.getText();
			labelRaceDate.setText(dateElements.get(0).text().split("\\(")[0]);
			raceDateCount = Integer.parseInt(dateElements.get(0).text().split("回")[1].split("日")[0].substring(2));
			System.out.println(raceDateCount + "日目");
			String[] dateString = labelRaceDate.getText().split("/");
			labelRaceDate.setText(String.format("%d/%02d/%02d", Integer.parseInt(dateString[0].replace("/", "")),
					Integer.parseInt(dateString[1].replace("/", "")),
					Integer.parseInt(dateString[2].replace("/", ""))));
			List<Horse> horseList = new ArrayList<Horse>();

			String round = dateElements.get(0).text().split("\\) ")[1].substring(0, 1);

			String day = dateElements.get(0).text().split("日目")[0].substring(
					dateElements.get(0).text().split("日目")[0].length() - 1,
					dateElements.get(0).text().split("日目")[0].length());

			try {
				Integer dayInt = Integer.parseInt(dateElements.get(0).text().split("日目")[0].substring(
						dateElements.get(0).text().split("日目")[0].length() - 2,
						dateElements.get(0).text().split("日目")[0].length()));
				day = dayInt.toString();
			} catch (NumberFormatException ex) {

			}

			RaceDB rdb = new RaceDB();
			rdm = new RaceDataManager();
			boolean raceExist = true;
			Integer[] raceData = rdb.GetRaceID(textURL.getText());

			rdm.RaceURL = textURL.getText();
			rdm.RaceName = labelRaceName.getText();
			Integer raceID = raceData[0];
			if (rangeElements.get(1).text().contains("芝")) {
				rdm.grass = true;
				grassDirt = "芝";
			} else {
				rdm.grass = false;
				grassDirt = "ダ";
			}
			if (raceID == -1 || raceData[3] == 0 || reGet) {
				rdm.payCash =  raceData[1];
				rdm.returnCash =  raceData[2];
				if(raceID == -1 || raceData[3] == 0) {
					rdb.UseRaceDataBase(new String[] { "insert", rdm.RaceName, rdm.RaceURL, "0", "0", "false" });
				}
						raceExist = false;
				raceData = rdb.GetRaceID(textURL.getText());

				raceID = raceData[0];
			} else {
				rdm.payCash = raceData[1];
				rdm.returnCash = raceData[2];
				}
			reGet = false;
			txtPay.setText("0");
			txtReturn.setText("0");
			TotalRecoveryCheck();

			if(!lblRecovery.getText().equals("100%"))lblRecovery.setText("???%");
			arrayPaddockURL = new TextField[] { txtPaddockURL, txtPaddockURL1, txtPaddockURL2, txtPaddockURL3,
					txtPaddockURL4, txtPaddockURL5, txtPaddockURL6, txtPaddockURL7 };
			arrayPaddockButton = new Button[] { buttonOpenPaddock, buttonOpenPaddock1, buttonOpenPaddock2,
					buttonOpenPaddock3, buttonOpenPaddock4, buttonOpenPaddock5, buttonOpenPaddock6,
					buttonOpenPaddock7 };
			arrayRaceURL = new TextField[] { txtRaceURL, txtRaceURL1, txtRaceURL2, txtRaceURL3, txtRaceURL4,
					txtRaceURL5, txtRaceURL6, txtRaceURL7 };
			arrayRaceButton = new Button[] { buttonOpenRace, buttonOpenRace1, buttonOpenRace2, buttonOpenRace3,
					buttonOpenRace4, buttonOpenRace5, buttonOpenRace6, buttonOpenRace7 };
			arrayRaceLabel = new Label[] { labelRace, labelRace1, labelRace2, labelRace3, labelRace4, labelRace5,
					labelRace6, labelRace7 };
			arrayResultURL = new TextField[] { txtResultURL, txtResultURL1, txtResultURL2, txtResultURL3, txtResultURL4,
					txtResultURL5, txtResultURL6, txtResultURL7 };

			if(loadcnt == 0) {SetEventButton();}
			loadcnt++;

			new RaceDB().execute(new String[]{"pastReturn",labelRaceDate.getText().split("/")[0],labelRaceStage.getText(), 
					labelRaceRange.getText().replace("芝", "").replace("ダ","" ).replace("m", ""),
					String.valueOf(rdm.grass),raceCount,condition, hande});
<<<<<<< HEAD
			if(LocalDate.now()
				.isEqual(LocalDate.parse(labelRaceDate.getText(),
						DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))
				||LocalDate.now()
				.isBefore(LocalDate.parse(labelRaceDate.getText(),
						DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))||
				LocalDate.now().isAfter(LocalDate.parse(labelRaceDate.getText(),
						DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))){
				lblPastCount.setText(pastGetStrings[0] + "回");
				lblWinWideThree.setText(pastGetStrings[1]);
				lblWinWideFour.setText(pastGetStrings[2]);
				lblWinWideFive.setText(pastGetStrings[3]);
				lblWinWideSix.setText(pastGetStrings[4]);
				lblWinWideFiveNagashi.setText(pastGetStrings[5]);
				lblWinAnaHorseThree.setText(pastGetStrings[6]);
				lblWinAnaHorseFour.setText(pastGetStrings[7]);
				lblWinAnaHorseFive.setText(pastGetStrings[8]);
				lblWinAnaHorseSix.setText(pastGetStrings[9]);
				lblWinAnaHorseFiveNagashi.setText(pastGetStrings[10]);
				lblPastPercentage.setText(pastGetStrings[11] + "%");
			}
=======
			lblPastCount.setText(pastGetStrings[0] + "回");
			lblWinWideThree.setText(pastGetStrings[1]);
			lblWinWideFour.setText(pastGetStrings[2]);
			lblWinWideFive.setText(pastGetStrings[3]);
			lblWinWideSix.setText(pastGetStrings[4]);
			lblWinWideFiveNagashi.setText(pastGetStrings[5]);
			lblWinUmarenThree.setText(pastGetStrings[6]);
			lblWinUmarenFour.setText(pastGetStrings[7]);
			lblWinUmarenFive.setText(pastGetStrings[8]);
			lblWinUmarenSix.setText(pastGetStrings[9]);
			lblWinUmarenFiveNagashi.setText(pastGetStrings[10]);
			lblPastPercentage.setText(pastGetStrings[11] + "%");
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
			txtThisPaddockURL.setText(
					"https://regist.prc.jp/api/windowopen.aspx?target=race/" + labelRaceDate.getText().substring(0, 4)
							+ "/" + labelRaceDate.getText().substring(0, 10).replace("/", "") + "/"
							+ labelRaceDate.getText().substring(2, 4) + Util.stageURL.get(labelRaceStage.getText())
							+ Util.raceURL.get(round) + Util.raceURL.get(day)
							+ Util.raceURL.get(textURL.getText().substring(42, 44)) + "_p&quality=1");
			txtThisRaceURL.setText(
					"https://regist.prc.jp/api/windowopen.aspx?target=race/" + labelRaceDate.getText().substring(0, 4)
							+ "/" + labelRaceDate.getText().substring(0, 10).replace("/", "") + "/"
							+ labelRaceDate.getText().substring(2, 4) + Util.stageURL.get(labelRaceStage.getText())
							+ Util.raceURL.get(round) + Util.raceURL.get(day)
							+ Util.raceURL.get(textURL.getText().substring(42, 44)) + "&quality=1");

			String pattern = "#.###";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			int j = 0;
			horseDataArray = new HorseData[horseElements.size() / 2];
			horseArray = new Horse[horseElements.size() / 2];
			rc = RaceCourseUtil.ReturnRaceCourse(labelRaceStage.getText(), labelRaceRange.getText(),
					doc.select(".raceTitle.fL").get(0).text());
			straightSlope.setText("直線傾斜" + rc.straightSlope);
			straightDistance.setText("直線長さ" + rc.straightDistance);
			cornerShape.setText("回転形状" + rc.cornerShape);
			rotationSide.setText("回転方向" + rc.rotationSide);
			rotationSize.setText("回転大小" + rc.rotationSize);
			grassStart.setText("芝開始" + rc.grassStart);
			raceGround.setText("芝ダート" + rc.raceGround);
			try {
			lblPastReturn.setText(new RaceDB().executeReturnMoney(
					labelRaceRange.getText(), labelRaceStage.getText() 
					, labelRaceDate.getText().substring(0,4))+ "%");
			}
			catch (Exception e) {
				lblPastReturn.setText("0%");
			}
			txtExplainRace.clear();
			txtExplainRace.setWrapText(true);
			txtExplainRace.setText(rc.textString);

			grassStartBool = false;
			if(rc.grassStart.contains("芝スタート")) {
				grassStartBool = true;
			}
			
			staticRaceDate = LocalDate.parse(labelRaceDate.getText(), DateTimeFormatter.ofPattern("yyyy/[]M/[]d"));
			for (int i = 0; i < horseElements.size() / 2; i++) {
				prr = new PastRaceResult();
				j = i + 18 - horseElements.size() / 2;
				try {
					// if(name != "" && horseList.stream().noneMatch(a -> a.name.equals(name))) {
					String jockey = jockeyElements.get(j).text();
					Horse h = new Horse();
					double jockeyWeight = 0.0;
					h.name = horseElements.get(i).text();
					h.sexAge = ageSpanElements.get(j).select("td").get(0).text().split(" ")[0];
					if (rateSpanElements.size() != 0 && !rateSpanElements.get(j).text().equals("除外")
							&& !rateSpanElements.get(j).text().equals("取消")
							&& !rateSpanElements.get(j).text().isEmpty()) {

						jockeyWeight = Double.parseDouble(heavyElements.get(j).text().replace("▲", "").replace("△", "")
								.replace("★", "").replace("☆", "").replace("◇", ""));
						h.rate = Double.parseDouble(rateSpanElements.get(j).select("span").get(0).text());
					}
					try {
						for (int i2 = 0; i2 < 6; i2++) {
							String[] pos = beforeElements.get(i + i2 * horseElements.size() / 2).text().split("");
							if (!pos[pos.length - 1].equals("－")) {
								h.position = Util.RankMap.get(pos[pos.length - 1]);
								if(h.position == 1) {
									for(int j2 = 0; j2 < pos.length; j2++) {
										if( Util.RankMap.get(pos[j2]) != 1 && !pos[j2].equals("－")) {
											break;
										}
										if(j2 == pos.length - 1) {
											h.position = -1;
										}
									}
								}
								break;
							}
						}
					} catch (Exception e) {

					}
					if (h.position == 0) {
						h.position = 19;
						
					}
					h.number = Math.abs(horseElements.size() / 2 - i);
					if(frameElements.size() > 0) {h.frame = Integer.parseInt(frameElements.get(i).text());
					}else {
						h.frame = (h.number + 1)/ 2;
					}
					horseList.add(h);

					try {
						matchDate = LocalDate
						.parse(labelRaceDate.getText(), DateTimeFormatter.ofPattern("yyyy/[]M/[]d"));
						HorseDB hdb = new HorseDB();
						hdb.create();
						String[] horseText = hdb.returnPastRace(h.name, raceID);
						String address = "https://www.keibalab.jp" + horseURLElements.get(i).attr("href");
						System.out.println(horseText[0].split(" ").length);
						if (!raceExist ||horseText[0].isEmpty() || 
								horseText[1].split("[ ]+").length < 12 || LocalDate
								.parse(labelRaceDate.getText(), DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
								.isBefore(LocalDate
										.parse(horseText[0].split(" ")[0], DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
										.plusDays(1))) {

							Document horseData = Jsoup.connect(address).get();
							String pastRace = "";
							Elements HorseElements = horseData.select(".sortobject tr");
							Elements HorsePastRaceAdressElements = horseData.select(".sortobject tr td a");
							boolean findPastRace = false;
							int pastRaceCount = 0;
							int pastGoodRaceCount = 0;
							String[] pastRaceCondition = new String[] { "", "", "", "", "", "", "", "" };
							String pastMaxGoodTime = "一年未走";
							String pastMaxGoodPace = "一年未走";
							String pastMaxGoodLast = "一年未走";
							String pastMaxGoodDifference = "0.0";
							String pastMaxGoodRaceRivalHorseString = "なし";
							ArrayList<RaceCourse> rcList = new ArrayList<RaceCourse>();
							ArrayList<PastRaceResult> prList = new ArrayList<PastRaceResult>();
							String nowTekisei;
							for (int i2 = 0; i2 < HorseElements.size(); i2++) {

								if (HorseElements.get(i2).text().split(" ").length > 22
										&& !HorseElements.get(i2).text().contains("失")
										&& LocalDate
												.parse(HorseElements.get(i2).text().split(" ")[0],
														DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
												.isBefore(LocalDate.parse(labelRaceDate.getText(),
														DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))) {
									
									RaceCourse rcPast = RaceCourseUtil.ReturnRaceCourse(
											HorseElements.get(i2).text().split(" ")[1],
											HorseElements.get(i2).text().split(" ")[2],
											HorseElements.get(i2).text().split(" ")[5]);
									if(prList.size() < 5) {
										rcList.add(rcPast);
										prList.add(new PastRaceResult());
									}
								}
							}
							for (int i2 = 0; i2 < HorseElements.size(); i2++) {
								
								if (HorseElements.get(i2).text().split(" ").length > 22
										&& !HorseElements.get(i2).text().contains("失")
										&& LocalDate
												.parse(HorseElements.get(i2).text().split(" ")[0],
														DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
												.isBefore(LocalDate.parse(labelRaceDate.getText(),
														DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))) {
									if (HorseElements.get(i2).text().contains("止")) {
										continue;
									}
									if (!findPastRace) {
										h.pastRace = HorseElements.get(i2).text();
										findPastRace = true;	
										Thread.sleep(1000);
										int cnt = 0;
										
										while(cnt < HorsePastRaceAdressElements.size()) {
											if(HorsePastRaceAdressElements.get(cnt).attr("href").split("/")[3].length() > 8
													&& HorsePastRaceAdressElements.get(cnt).attr("href").split("/")[2].contains("race")) {
												String dateFormatString = HorsePastRaceAdressElements.get(cnt).attr("href").split("/")[3].substring(0,8);
												StringBuilder sb = new StringBuilder(dateFormatString);
												sb.insert(4, "/");
												sb.insert(7, "/");
												if(LocalDate
														.parse(sb.toString(),
																DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
														.isBefore(LocalDate.parse(labelRaceDate.getText(),
																DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))) {
													Document raceResult = Jsoup.connect(("https://www.keibalab.jp" + HorsePastRaceAdressElements.get(cnt).attr("href"))).get();
													Elements HorsePastRaceTendElements = raceResult.select(".DbTable .tR");
													int tend = 0;
													for(int c = 0; c < 3; c++) {
														System.out.println(HorsePastRaceTendElements.get(2 + c * 4).text());
														if(HorsePastRaceTendElements.get(2 + c * 4).text().length() > 0) {
															if(Util.RankMap.get(HorsePastRaceTendElements.get(2 + c * 4).text().substring(HorsePastRaceTendElements.get(2 + c * 4).text().length() - 1)) < 5) {
																tend += 1;
															}
															else if(Util.RankMap.get(HorsePastRaceTendElements.get(2 + c * 4).text().substring(HorsePastRaceTendElements.get(2 + c * 4).text().length() - 1)) > 8){
																tend -= 1;
															}
														}
													}
													
													if(tend == 3) {
														 pastRaceTenkai = "かなり先行";
													}else if(tend == 2) {
														 pastRaceTenkai = "先行";
													} else if(tend == 1) {
														 pastRaceTenkai = "やや先行";
													}
													
													if(tend == -3) {
														 pastRaceTenkai = "かなり差し";
													}else if(tend == -2) {
														 pastRaceTenkai = "差し";
													} else if(tend == -1) {
														 pastRaceTenkai = "やや差し";
													}
													break;
													
												}
											}
											
											cnt++;
										}
									
									}
									if ((((Integer.parseInt(HorseElements.get(i2).text().split(" ")[10]) > 7
											&& Integer.parseInt(HorseElements.get(i2).text().split(" ")[7]) < 4)
											|| ((Integer.parseInt(HorseElements.get(i2).text().split(" ")[10]) < 8
													&& Integer.parseInt(
															HorseElements.get(i2).text().split(" ")[7]) < 3))))) {
										pastGoodRaceCount++;

									}
									if (pastRaceCount < 5) {
										pastRace += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									}
									if (HorseElements.get(i2).text().split(" ")[2].contains("芝")
											&& HorseElements.get(i2).text().split(" ")[4].contains("良")
											&& pastRaceCondition[0].length() < 5) {
										pastRaceCondition[0] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									} else if (HorseElements.get(i2).text().split(" ")[2].contains("芝")
											&& HorseElements.get(i2).text().split(" ")[4].contains("稍")
											&& pastRaceCondition[1].length() < 5) {
										pastRaceCondition[1] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									} else if (HorseElements.get(i2).text().split(" ")[2].contains("芝")
											&& HorseElements.get(i2).text().split(" ")[4].contains("重")
											&& pastRaceCondition[2].length() < 5) {
										pastRaceCondition[2] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									} else if (HorseElements.get(i2).text().split(" ")[2].contains("芝")
											&& HorseElements.get(i2).text().split(" ")[4].contains("不")
											&& pastRaceCondition[3].length() < 5) {
										pastRaceCondition[3] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									} else if (HorseElements.get(i2).text().split(" ")[2].contains("ダ")
											&& HorseElements.get(i2).text().split(" ")[4].contains("良")
											&& pastRaceCondition[4].length() < 5) {
										pastRaceCondition[4] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									} else if (HorseElements.get(i2).text().split(" ")[2].contains("ダ")
											&& HorseElements.get(i2).text().split(" ")[4].contains("稍")
											&& pastRaceCondition[5].length() < 5) {
										pastRaceCondition[5] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									} else if (HorseElements.get(i2).text().split(" ")[2].contains("ダ")
											&& HorseElements.get(i2).text().split(" ")[4].contains("重")
											&& pastRaceCondition[6].length() < 5) {
										pastRaceCondition[6] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									} else if (HorseElements.get(i2).text().split(" ")[2].contains("ダ")
											&& HorseElements.get(i2).text().split(" ")[4].contains("不")
											&& pastRaceCondition[7].length() < 5) {
										pastRaceCondition[7] += strArray[Integer
												.parseInt(HorseElements.get(i2).text().split(" ")[7])];
									}
									RaceCourse rcPast = RaceCourseUtil.ReturnRaceCourse(
											HorseElements.get(i2).text().split(" ")[1],
											HorseElements.get(i2).text().split(" ")[2],
											HorseElements.get(i2).text().split(" ")[5]);
									int grade = Integer.parseInt(HorseElements.get(i2).text().split(" ")[7]);
									prr = RCTekiseiCheck(rc, rcPast, prr, grade);
									
									for(int i3 = 0; i3 < prList.size(); i3++) {
										PastRaceResult pastRaceResult = RCTekiseiCheck(rcList.get(i3), rcPast, prList.get(i3), grade);
										prList.set(i3, pastRaceResult);
									}
									if (LocalDate.parse(HorseElements.get(i2).text().split(" ")[0],
											DateTimeFormatter.ofPattern("yyyy/[]M/[]d")).isAfter(
													LocalDate
															.parse(labelRaceDate.getText(),
																	DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
															.minusYears(1))
											&& HorseElements.get(i2).text().split(" ")[2]
													.equals(labelRaceRange.getText().substring(0, 5))
											&& (pastMaxGoodTime.equals("一年未走")
													|| (!pastMaxGoodTime.equals("一年未走") && CalcTime(pastMaxGoodTime,
															HorseElements.get(i2).text().split(" ")[13],
															HorseElements.get(i2).text().split(" ")[4],
															pastMaxGoodTime)))) {
										pastMaxGoodTime = HorseElements.get(i2).text().split(" ")[13]
												+ HorseElements.get(i2).text().split(" ")[4]
												+ HorseElements.get(i2).text().split(" ")[1];

										pastMaxGoodPace = HorseElements.get(i2).text().split(" ")[15]
												+ HorseElements.get(i2).text().split(" ")[16]
												+ HorseElements.get(i2).text().split(" ")[17];
										pastMaxGoodLast = HorseElements.get(i2).text().split(" ")[18];
										pastMaxGoodDifference =  HorseElements.get(i2).text().split(" ")[14];
										pastMaxGoodRaceRivalHorseString = HorseElements.get(i2).text().split(" ")[24];
										if(pastMaxGoodRaceRivalHorseString.contains("(")) {
											pastMaxGoodDifference = "-" + pastMaxGoodDifference;
										}
									}

									pastRaceCount++;
								}
							}
							int cnt = 0;
							int strCnt = 0;
							StringBuilder str = new StringBuilder(String.valueOf(pastRace));
							//(prr.grassStart[0] + prr.grassStart[1] + prr.grassStart[2]+ prr.grassStart[3] + 1);
							nowTekisei = String.valueOf(CalcRaceTekisei(prr));
							str.insert(strCnt, nowTekisei);
							strCnt += String.valueOf(nowTekisei).length();

							for (int k = 0; k < 8; k++) {
								if (pastRaceCondition[k].isEmpty()) {
									pastRaceCondition[k] = "出走なし";
								}
							}
							for (PastRaceResult prr : prList) {
								String tekisei = String.valueOf(CalcRaceTekisei(prr));
								str.insert(strCnt + 1, tekisei);
								strCnt += String.valueOf(tekisei).length() + 1;
								cnt++;
							}
							
							pastRace = String.valueOf(str);
							h.pastRace += " "
									+ decimalFormat.format((double) pastGoodRaceCount * 100.0 / (double) pastRaceCount)
									+ " " + pastRace;
							h.pastRaceCondition = pastRaceCondition[0] + " " + pastRaceCondition[1] + " "
									+ pastRaceCondition[2] + " " + pastRaceCondition[3] + " " + pastRaceCondition[4]
									+ " " + pastRaceCondition[5] + " " + pastRaceCondition[6] + " "
									+ pastRaceCondition[7] + " " + pastMaxGoodTime + " " + pastMaxGoodPace + " "
									+ pastMaxGoodLast + " " + pastMaxGoodDifference;

							List<String> horseString = new ArrayList<String>(Arrays.asList(h.pastRace.split(" ")));
							List<String> horseConditionString = new ArrayList<String>(
									Arrays.asList(h.pastRaceCondition.split("[ ]+")));

							if (horseString.size() > 18 && horseString.get(19).equals("B")) {
								horseString.remove(19);
							}
							String cornerShape = prr.cornerShape[0] + "-" + prr.cornerShape[1] + "-"
									+ prr.cornerShape[2] + "-" + prr.cornerShape[3];
							String grassStart = prr.grassStart[0] + "-" + prr.grassStart[1] + "-" + prr.grassStart[2]
									+ "-" + prr.grassStart[3];
							String raceGround = prr.raceGround[0] + "-" + prr.raceGround[1] + "-" + prr.raceGround[2]
									+ "-" + prr.raceGround[3];
							String rotationSide = prr.rotationSide[0] + "-" + prr.rotationSide[1] + "-"
									+ prr.rotationSide[2] + "-" + prr.rotationSide[3];
							String rotationSize = prr.rotationSize[0] + "-" + prr.rotationSize[1] + "-"
									+ prr.rotationSize[2] + "-" + prr.rotationSize[3];
							String straightDistance = prr.straightDistance[0] + "-" + prr.straightDistance[1] + "-"
									+ prr.straightDistance[2] + "-" + prr.straightDistance[3];
							String straightSlope = prr.straightSlope[0] + "-" + prr.straightSlope[1] + "-"
									+ prr.straightSlope[2] + "-" + prr.straightSlope[3];
							String analysisString =  RacePointCheck(h.pastRace, h);
							new HorseDB().UseHorseDataBase(new String[] { "insert", h.name, raceID.toString(),
									Integer.toString(h.position), h.pastRace, Integer.toString(h.frame),
									h.pastRaceCondition, cornerShape, grassStart, raceGround, rotationSide,
									rotationSize, straightDistance, straightSlope, analysisString});

							SetTable(h, horseString, strArray[h.number] + h.pastRace, horseConditionString, address, i,
									"10000", jockeyWeight, cornerShape, grassStart, raceGround, rotationSide,
									rotationSize, straightDistance, straightSlope, jockey, analysisString);
							RacePointCheck( strArray[h.number] + h.pastRace,h);
							Thread.sleep(2000);
						} else {

							h.pastRace = horseText[0];
							List<String> horseString = new ArrayList<String>(Arrays.asList(horseText[0].split(" ")));
							List<String> horseConditionString = new ArrayList<String>(
									Arrays.asList(horseText[1].split("[ ]+")));

							if (horseString.size() > 18 && horseString.get(19).equals("B")) {
								horseString.remove(19);
							}

							SetTable(h, horseString, horseText[0], horseConditionString, address, i, horseText[2],
									jockeyWeight, horseText[3], horseText[4], horseText[5], horseText[6], horseText[7],
									horseText[8], horseText[9], jockey, horseText[10]);
							RacePointCheck(horseText[0],h);
						}
					} catch (Exception e) {

						e.printStackTrace();
					}
					

					SetTextField(h);
					// }

				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			rdb.UseRaceDataBase(
					new String[] { "updateRace", rdm.RaceName, rdm.RaceURL,
							labelRaceRange.getText().substring(0, 1), labelRaceRange.getText().substring(1, 5),
							labelRaceStage.getText(), grade, hande, String.valueOf(female), condition, String.valueOf(newHorse), raceAge, raceCount  });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		DrawJikuAna();
		RaceDB rdb = new RaceDB();
		Comparator<HorseData> comparator = Comparator.<HorseData, String>comparing(model -> model.getNo());
		FXCollections.sort(table.getItems(), comparator);

	}
	private int CalcRaceTekisei(PastRaceResult prr) {
		int point = 0;
		point += (prr.cornerShape[0] * 20 + prr.cornerShape[1] * 10 + prr.cornerShape[2] * 5 - prr.cornerShape[3] * 5 + 1000);
		//(prr.cornerShape[0] + prr.cornerShape[1] + prr.cornerShape[2]+ prr.cornerShape[3] + 1);

		point += (prr.rotationSide[0] * 20 + prr.rotationSide[1] * 10 + prr.rotationSide[2] * 5 - prr.rotationSide[3] * 5 + 1000);
				//(prr.rotationSide[0] + prr.rotationSide[1] + prr.rotationSide[2]+ prr.rotationSide[3] + 1);
		
		point += (prr.rotationSize[0] * 20 + prr.rotationSize[1] * 10 + prr.rotationSize[2] * 5 - prr.rotationSize[3] * 5  + 1000);
				//(prr.rotationSize[0] + prr.rotationSize[1] + prr.rotationSize[2]+ prr.rotationSize[3] + 1);
		
		point += (prr.straightDistance[0] * 20 + prr.straightDistance[1] * 10 + prr.straightDistance[2] * 5 - prr.straightDistance[3] * 5 + 1000);
				//(prr.straightDistance[0] + prr.straightDistance[1] + prr.straightDistance[2]+ prr.straightDistance[3] + 1);
		
		point += (prr.straightSlope[0] * 20 + prr.straightSlope[1] * 10 + prr.straightSlope[2] * 5 - prr.straightSlope[3] * 5 + 1000);
				//(prr.straightSlope[0] + prr.straightSlope[1] + prr.straightSlope[2]+ prr.straightSlope[3] + 1);
		
		point += (prr.grassStart[0] * 20 + prr.grassStart[1] * 10 + prr.grassStart[2] * 5 - prr.grassStart[3] * 5 + 1000);
				//(prr.grassStart[0] + prr.grassStart[1] + prr.grassStart[2]+ prr.grassStart[3] + 1);
		return point;
	}
	private PastRaceResult RCTekiseiCheck(RaceCourse rc, RaceCourse rcPast, PastRaceResult prr, int grade) {
		
		if (rc.cornerShape != null && rcPast.cornerShape != null) {
			if (rc.cornerShape.equals(rcPast.cornerShape)) {
				if (grade == 1) {
					prr.cornerShape[0]++;
				} else if (grade == 2) {
					prr.cornerShape[1]++;
				} else if (grade == 3) {
					prr.cornerShape[2]++;
				} else {
					prr.cornerShape[3]++;
				}

			}

			if (rc.grassStart.equals(rcPast.grassStart)) {
				if (grade == 1) {
					prr.grassStart[0]++;
				} else if (grade == 2) {
					prr.grassStart[1]++;
				} else if (grade == 3) {
					prr.grassStart[2]++;
				} else {
					prr.grassStart[3]++;
				}

			}

			if (rc.raceGround.equals(rcPast.raceGround)) {
				if (grade == 1) {
					prr.raceGround[0]++;
				} else if (grade == 2) {
					prr.raceGround[1]++;
				} else if (grade == 3) {
					prr.raceGround[2]++;
				} else {
					prr.raceGround[3]++;
				}

			}

			if (rc.rotationSide.equals(rcPast.rotationSide)) {
				if (grade == 1) {
					prr.rotationSide[0]++;
				} else if (grade == 2) {
					prr.rotationSide[1]++;
				} else if (grade == 3) {
					prr.rotationSide[2]++;
				} else {
					prr.rotationSide[3]++;
				}

			}

			if (rc.rotationSize.equals(rcPast.rotationSize)) {
				if (grade == 1) {
					prr.rotationSize[0]++;
				} else if (grade == 2) {
					prr.rotationSize[1]++;
				} else if (grade == 3) {
					prr.rotationSize[2]++;
				} else {
					prr.rotationSize[3]++;
				}

			}

			if (rc.straightDistance.equals(rcPast.straightDistance)) {
				if (grade == 1) {
					prr.straightDistance[0]++;
				} else if (grade == 2) {
					prr.straightDistance[1]++;
				} else if (grade == 3) {
					prr.straightDistance[2]++;
				} else {
					prr.straightDistance[3]++;
				}

			}

			if (rc.straightSlope.equals(rcPast.straightSlope)) {
				if (grade == 1) {
					prr.straightSlope[0]++;
				} else if (grade == 2) {
					prr.straightSlope[1]++;
				} else if (grade == 3) {
					prr.straightSlope[2]++;
				} else {
					prr.straightSlope[3]++;
				}

			}
		}
		return prr;
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
	
	
	private void SetTable(Horse h, List<String> horseString, String horseText, List<String> pastRaceCondition,
			String address, int index, String raceLevel, Double jockeyWeight, String cornerShape, String grassStart,
			String raceGround, String rotationSide, String rotationSize, String straightDistance,
			String straightSlope, String jockey, String analysis) {
		if(analysis == null) {
			analysis =  RacePointCheck(horseText, h);
		}
		HorseData horseData = new HorseData(strArray[h.number], h.name, analysis, horseString,
				pastRaceCondition, raceRange, labelRaceRange.getText(), address, raceLevel, jockeyWeight, cornerShape,
				grassStart, raceGround, rotationSide, rotationSize, straightDistance, straightSlope, jockey, condition
<<<<<<< HEAD
				,h.frame, h.rate, h.position);
		//table.getItems().add(horseData);
=======
				,h.frame, h.rate);
		table.getItems().add(horseData);
>>>>>>> branch 'master' of https://github.com/Yuki-Kono213/UmaShogi
		horseDataArray[index] = horseData;
		horseArray[index] = h;

	}

	public void RaceLevelCount() {

		Document doc;
		try {
			doc = Jsoup.connect(textURL.getText()).get();

			Elements horseURLElements = doc.select("td[class~=hcolor.cyaku.*], td.BeforRaces");
			Elements horseElements = doc.select("a.tategaki.bamei");

			int[] rank1 = new int[2];
			int[] rank2 = new int[2];
			int[] rank3 = new int[2];
			int[] rankOther = new int[2];

			int[] rankCnt = new int[2];
			try {

				for (int i = 0; i < horseElements.size()/2; i++) {
					int horseIndex = horseElements.size() / 2 - i - 1;
					rank1 = new int[2];
					rank2 = new int[2];
					rank3 = new int[2];
					rankOther = new int[2];
					rankCnt = new int[2];
					if(i < horseElements.size()/2) {
						try {
							for (int i2 = 0; i2 < 2; i2++) {
								int index = horseIndex + (horseElements.size() / 2 * i2);
								System.out.println(horseURLElements.get(index).getElementsByTag("a").attr("href") != "");
								if (horseURLElements.get(index).getElementsByTag("a").attr("href") != "" &&
									horseURLElements.get(index).getElementsByTag("a").attr("href").contains("/")) {
									Document raceDoc = Jsoup.connect("https://www.keibalab.jp"
											+ horseURLElements.get(index).getElementsByTag("a").attr("href")
											+ "umabashira.html").get();
									Elements horseDataElements = raceDoc.select("div[class~=BameiWrap] > a");
	
									Elements dateElements = raceDoc.select(".fL.ml10 .bold");
									String[] dateStrings = dateElements.get(0).text().split("\\(")[0].split("/");
									String dateString = (String.format("%d/%02d/%02d",
											Integer.parseInt(dateStrings[0].replace("/", "")),
											Integer.parseInt(dateStrings[1].replace("/", "")),
											Integer.parseInt(dateStrings[2].replace("/", ""))));
									ArrayList<String>horseList = new ArrayList<String>();
									for (int i3 = 0; i3 < horseDataElements.size() / 2; i3++) {
										System.out.println((horseDataElements.get(i3).getElementsByTag("a").attr("href")));
										if((horseDataElements.get(i3).getElementsByTag("a").attr("href")) != "") {
										Document horseDoc = Jsoup
												.connect("https://www.keibalab.jp"
														+ horseDataElements.get(i3).getElementsByTag("a").attr("href")).get();
										Elements horseRaceElements = horseDoc.select(".sortobject tr");
	
										for (int i4 = 0; i4 < horseRaceElements.size(); i4++) {
											if (!horseList.contains(horseRaceElements.get(i4).getElementsByTag("a").attr("href"))
													&&horseRaceElements.get(i4).text().split(" ").length > 22
													&& !horseRaceElements.get(i4).text().contains("失")
													&& LocalDate
															.parse(horseRaceElements.get(i4).text().split(" ")[0],
																	DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
															.isAfter(LocalDate.parse(dateString,
																	DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))
													&& LocalDate
															.parse(horseRaceElements.get(i4).text().split(" ")[0],
																	DateTimeFormatter.ofPattern("yyyy/[]M/[]d"))
															.isBefore(LocalDate.parse(labelRaceDate.getText(),
																	DateTimeFormatter.ofPattern("yyyy/[]M/[]d")))) {
		
													//horseList.add(horseRaceElements.get(i4).getElementsByTag("a").attr("href"));
													//System.out.println(horseRaceElements.get(i4).getElementsByTag("a").attr("href"));
													int rank = Integer.parseInt(horseRaceElements.get(i4).text().split(" ")[7]);
													//System.out.println(horseRaceElements.get(i4).getElementsByTag("a").attr("href"));
													rankCnt[i2]++;
													if (rank == 1) {
														rank1[i2]++;
													} else if (rank == 2) {
														rank2[i2]++;
													} else if (rank == 3) {
														rank3[i2]++;
													} else {
														rankOther[i2]++;
													}
		
												}
											}
										}
	
										Thread.sleep(1000);
									}
	//								
								}
							}
						} catch (Exception e) {
	
						}
					}
					int[] rankPercentage = new int[8];
					if (rankCnt[0] != 0) {
						rankPercentage[0] = rank1[0] * 100 / rankCnt[0];
						rankPercentage[1] = (rank1[0] + rank2[0]) * 100 / rankCnt[0];
						rankPercentage[2] = (rank1[0] + rank2[0] + rank3[0]) * 100 / rankCnt[0];
						rankPercentage[3] = (rankOther[0]) * 100 / rankCnt[0];
					}
					if (rankCnt[1] != 0) {
						rankPercentage[4] = rank1[1] * 100 / rankCnt[1];
						rankPercentage[5] = (rank1[1] + rank2[1]) * 100 / rankCnt[1];
						rankPercentage[6] = (rank1[1] + rank2[1] + rank3[1]) * 100 / rankCnt[1];
						rankPercentage[7] = (rankOther[1]) * 100 / rankCnt[1];
					}
					if ((rankCnt[0] != 0 || rankCnt[1] != 0)&& horseDataArray[horseIndex] != null) {
						horseDataArray[horseIndex].setRaceLevel("①" + String.valueOf(rankPercentage[0]) + "②"
								+ String.valueOf(rankPercentage[1]) + "③" + String.valueOf(rankPercentage[2]) + "他"
								+ String.valueOf(rankPercentage[3]) + "計" + String.valueOf(rankCnt[0]) + "①"
								+ String.valueOf(rankPercentage[4]) + "②" + String.valueOf(rankPercentage[5]) + "③"
								+ String.valueOf(rankPercentage[6]) + "他" + String.valueOf(rankPercentage[7]) + "計"
								+ String.valueOf(rankCnt[1]));
					} else if (horseDataArray[horseIndex] != null) {
						horseDataArray[horseIndex].setRaceLevel("①0②0③0他0計0①0②0③0他0計0");
					}
				}
				for (int i = 0; i < horseElements.size() / 2; i++) {

					if (horseArray[i] != null) {
						new HorseDB().UseHorseDataBase(
								new String[] { "update", horseArray[i].pastRace, horseDataArray[i].getRaceLevel() });
					}
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		table.refresh();

	}

	private String RacePointCheck(String s, Horse h) {
		String text = "";
		if (s.contains(("H")) && h.position < 5) {
			text += "不利";
		} else if (s.contains(("H")) && h.position < 9) {
			text += "やや不利";
		} else if (s.contains(("S")) && h.position > 12) {
			text += "不利";
		} else if (s.contains(("S")) && h.position > 8) {
			text += "やや不利";
		} else if (s.contains(("S")) && h.position < 5) {
			text += "有利";
		} else if (s.contains(("S")) && h.position < 9) {
			text += "やや有利";
		} else if (s.contains(("H")) && h.position > 12) {
			text += "有利";
		} else if (s.contains(("H")) && h.position > 8) {
			text += "やや有利";
		} else if (s.contains(("M"))) {
			text += "互角";
		}

		String[] array = s.split(" ");

		h.win = "";
		
		if (array[7].equals("1")) {
			text += "勝利";
			h.win = "勝";

		} else if (Double.parseDouble(array[14]) < 0.2) {
			text += "惜敗";

		} else if (Double.parseDouble(array[14]) < 0.3) {
			text += "敗戦";

		} else if (Double.parseDouble(array[14]) < 0.5) {
			text += "敗北";

		} else if (Double.parseDouble(array[14]) < 1.0) {
			text += "大敗";

		} else {
			text += "惨敗";
		}
		if(pastRaceTenkai != null) {
			text += pastRaceTenkai;
		}
		pastRaceTenkai = null;
		return text;
	}

	private boolean CalcTime(String max, String newRace, String newCondition, String oldCondition) {
		if ((max.contains("0") || max.contains("1") || max.contains("2") || max.contains("3"))) {
			int maxTime = Integer.parseInt(max.substring(0, 1)) * 600 + Integer.parseInt(max.substring(2, 4)) * 10
					+ Integer.parseInt(max.substring(5, 6));
			int newTime = Integer.parseInt(newRace.substring(0, 1)) * 600
					+ Integer.parseInt(newRace.substring(2, 4)) * 10 + Integer.parseInt(newRace.substring(5, 6));

			if ((newTime < maxTime && newCondition.contains("良"))
					|| (newCondition.contains("良") && !oldCondition.contains("良"))
					|| (newCondition.contains("稍") && !oldCondition.contains("良")&& !oldCondition.contains("稍"))
					|| (newCondition.contains("重") && !oldCondition.contains("良") && !oldCondition.contains("稍")&& !oldCondition.contains("重"))
				|| (newTime < maxTime && newCondition.contains("稍") && !oldCondition.contains("良"))
				|| (newTime < maxTime && newCondition.contains("重") && !oldCondition.contains("良") && !oldCondition.contains("稍"))) {
				return true;
			}
		}
		return false;
	}

	private void SetTextField(Horse h) {
		if (h.frame == 1 || h.frame == 2) {
			if (h.position == -1) {
				frame1.insertText(0, h.number +h.sexAge + "逃" + h.win +  h.name + h.rate + "\r\n");

			} else if (h.position < 5) {
				frame1.insertText(0, h.number +h.sexAge +h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 9) {
				frame5.insertText(0, h.number +h.sexAge +h.win+ h.name + h.rate + "\r\n");

			} else if (h.position < 13) {
				frame9.insertText(0, h.number +h.sexAge +h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 19) {
				frame13.insertText(0,h.number +h.sexAge +h.win + h.name + h.rate + "\r\n");

			} else {
				frame13.insertText(0,h.number +h.sexAge + h.win + h.name + "?" + h.rate + "\r\n");
				newHorse = true;
			}

		} else if (h.frame == 3 || h.frame == 4) {
			if (h.position == -1) {
				frame2.insertText(0,h.number +h.sexAge + "逃" + h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 5) {
				frame2.insertText(0,h.number +h.sexAge + h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 9) {
				frame6.insertText(0,h.number + h.sexAge +h.win  + h.name + h.rate + "\r\n");

			} else if (h.position < 13) {
				frame10.insertText(0, h.number +h.sexAge +h.win  + h.name + h.rate + "\r\n");

			} else if (h.position < 19) {
				frame14.insertText(0,h.number +h.sexAge + h.win + h.name + h.rate + "\r\n");
			} else {
				frame14.insertText(0, h.number +h.sexAge +h.win + h.name + "?" + h.rate + "\r\n");
				newHorse = true;
			}

		} else if (h.frame == 5 || h.frame == 6) {
			if (h.position == -1) {
				frame3.insertText(0, h.number +h.sexAge +"逃" + h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 5) {
				frame3.insertText(0, h.number +h.sexAge +h.win  + h.name + h.rate + "\r\n");

			} else if (h.position < 9) {
				frame7.insertText(0, h.number +h.sexAge +h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 13) {
				frame11.insertText(0, h.number +h.sexAge +h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 19) {
				frame15.insertText(0,h.number +h.sexAge + h.win + h.name + h.rate + "\r\n");
			} else {
				frame15.insertText(0, h.number +h.sexAge +h.win  + h.name + "?" + h.rate + "\r\n");
				newHorse = true;
			}

		} else if (h.frame == 7 || h.frame == 8) {
			if (h.position == -1) {
				frame4.insertText(0, h.number +h.sexAge +"逃" +h.win  + h.name + h.rate + "\r\n");

			} else if (h.position < 5) {
				frame4.insertText(0, h.number +h.sexAge +h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 9) {
				frame8.insertText(0, h.number +h.sexAge +h.win+ h.name + h.rate + "\r\n");

			} else if (h.position < 13) {
				frame12.insertText(0,h.number +h.sexAge +h.win + h.name + h.rate + "\r\n");

			} else if (h.position < 19) {
				frame16.insertText(0,h.number +h.sexAge + h.win + h.name + h.rate + "\r\n");
			} else {
				frame16.insertText(0,h.number +h.sexAge + h.win + h.name + "?" + h.rate + "\r\n");
				newHorse = true;
			}
		}

	}

	private void SetEventButton() {
		table.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {

			String horseAddress = newVal.getAddress();
			String horseDate = labelRaceDate.getText();
			try {
				for (int i = 0; i < arrayPaddockURL.length; i++) {
					arrayPaddockURL[i].setText("");
					arrayRaceURL[i].setText("");
					arrayResultURL[i].setText("");
				}
				Document laboDoc = Jsoup.connect(horseAddress).get();
				Elements roundel = laboDoc.select(".sortobject td");
				Elements stageel = laboDoc.select(".sortobject a");
				int cnt = 0;
				int rowCnt = 0;
				System.out.println(roundel.size());
				for (int i = 0; i < stageel.size(); i++) {
					if (stageel.get(i).attr("href").contains("/db/race/") && cnt * 25 < roundel.size()
							&& !Util.returnLocalDicExist(roundel.get(cnt * 25 + 1).text(), cnt)
							&& roundel.get(cnt * 25 + 1).text().split("回").length > 1
							&& roundel.get(cnt * 25 + 1).text().split("回")[1].length() > 1 && Util.returnDicExist(
									roundel.get(cnt * 25 + 1).text().split("回")[1].substring(0, 2), cnt)) {

						if (Util.returnDateCompare(horseDate.replace("/", ""),
								stageel.get(i).attr("href").split("/")[3].substring(0, 8))) {
							String dateText = stageel.get(i).attr("href").split("/")[3];
							String dayText = "0";
							if (roundel.get(cnt * 25 + 1).text().length() == 6
									&& Util.isNumber(roundel.get(cnt * 25 + 1).text().substring(4, 6))) {
								dayText = Util.raceURL.get(roundel.get(cnt * 25 + 1).text().substring(4, 6));
							} else {
								dayText = Util.raceURL.get(roundel.get(cnt * 25 + 1).text().substring(4, 5));
							}
							arrayRaceLabel[rowCnt].setText(roundel.get(cnt * 25 + 12).text());
							arrayPaddockURL[rowCnt].setText("https://regist.prc.jp/api/windowopen.aspx?target=race/"
									+ dateText.substring(0, 4) + "/" + dateText.substring(0, 8) + "/"
									+ dateText.substring(2, 4) + Util.raceURL.get(dateText.substring(8, 10))
									+ Util.raceURL.get(roundel.get(cnt * 25 + 1).text().split("回")[0]) + dayText
									+ Util.raceURL.get(dateText.substring(10, 12)) + "_p&quality=1");
							arrayRaceURL[rowCnt].setText("https://regist.prc.jp/api/windowopen.aspx?target=race/"
									+ dateText.substring(0, 4) + "/" + dateText.substring(0, 8) + "/"
									+ dateText.substring(2, 4) + Util.raceURL.get(dateText.substring(8, 10))
									+ Util.raceURL.get(roundel.get(cnt * 25 + 1).text().split("回")[0]) + dayText
									+ Util.raceURL.get(dateText.substring(10, 12)) + "&quality=1");
							arrayResultURL[rowCnt].setText(
									"https://www.keibalab.jp" + stageel.get(i).attr("href") + "umabashira.html");

							rowCnt++;
							if (rowCnt == arrayRaceURL.length) {
								break;
							}

						}
						cnt++;
					} else if (cnt * 25 < roundel.size()
							&& Util.returnLocalDicExist(roundel.get(cnt * 25 + 1).text(), cnt)) {
						if (i + 1 < stageel.size() && stageel.get(i).attr("href").split("/")[2].contains("race")
								&& Util.returnDateCompare(horseDate.replace("/", ""),
										stageel.get(i).attr("href").split("/")[3].substring(0, 8))) {
							boolean flag = true;
							while (flag) {
								if (i + 1 < stageel.size()
										&& stageel.get(i).attr("href").split("/")[2].contains("race")) {

									cnt++;

									if (Util.returnDateCompare(horseDate.replace("/", ""),
											stageel.get(i).attr("href").split("/")[3].substring(0, 8))) {
										i--;
										break;
									}

								} else if (i + 1 == stageel.size()) {
									i--;
									break;
								}
								i++;
							}
						} else {
							cnt++;
						}
					}
				}

			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		});
		arrayPaddockButton[0].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[0].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayPaddockButton[1].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[1].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayPaddockButton[2].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[2].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayPaddockButton[3].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[3].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayPaddockButton[4].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[4].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayPaddockButton[5].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[5].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayPaddockButton[6].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[6].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayPaddockButton[7].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayPaddockURL[7].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});

		arrayRaceButton[0].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[0].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayRaceButton[1].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[1].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayRaceButton[2].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[2].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayRaceButton[3].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[3].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayRaceButton[4].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[4].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayRaceButton[5].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[5].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayRaceButton[6].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[6].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		arrayRaceButton[7].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							arrayRaceURL[7].getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});

		buttonThisRace.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							txtThisRaceURL.getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
		buttonThisPaddock.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
							txtThisPaddockURL.getText()).start();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});


	}

}
