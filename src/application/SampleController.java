package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

		Label[] labelArray = {
				horseLabel1,
				horseLabel1,
				horseLabel2,
				horseLabel3,
				horseLabel4,
				horseLabel5,
				horseLabel6,
				horseLabel7,
				horseLabel8,
				horseLabel9,
				horseLabel10,
				horseLabel11,
				horseLabel12,
				horseLabel13,
				horseLabel14,
				horseLabel15,
				horseLabel16,
				horseLabel17,
				horseLabel18,
				horseLabel19,
				horseLabel20

		};
		try {
			// jsoupを使用して当ブログのトップページへアクセス
			Document doc = Jsoup.connect(textURL.getText()).get();


			Element rate = doc.select(".seirei.std9").get(1);
			Elements rateElements = rate.getAllElements();
			Elements rateSpanElements = rateElements.select("span");

			Elements horseURLElements  = doc.select("div[class~=BameiWrap.*] > a");

			Elements stageElements  = doc.select("#topicPath ul li");
			textRaceStage.setText(stageElements.get(3).text().split("競馬")[0]);
			Elements horseElements  = doc.select("a.tategaki.bamei");
			Elements beforeElements  = doc.select(".zensou.std11 span,.BeforRaces.past1");
			Elements frameElements  = doc.select(".wakuban td:matchesOwn([1-8])");
			Elements RangeElements  = doc.select(".classCourseSyokin.clearfix li");
			textRaceName.setText(doc.select(".raceTitle.fL").get(0).text());
			String[] Range = RangeElements.get(1).text().split(" ");
			textRaceRange.setText(Range[0]);
			List<Horse> horseList = new ArrayList<Horse>();

			//System.out.println( beforeElements );
			Integer cnt = 0;
			for(Label l : labelArray) {
				l.setText(strArray[cnt]);
				cnt++;

			}

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
			System.out.println(raceExist);
			int hosei = 0; 
			for (int i = 0; i <  horseElements.size()/2; i++) {
				try {
					String name = horseElements.get(i).text();
					if(name != "" && horseList.stream().noneMatch(a -> a.name.equals(name))) {
						Horse h = new Horse();
						h.name = horseElements.get(i).text();

						if(rateSpanElements.size() != 0 && !rateSpanElements.get(i*2 + hosei).text().equals("除外") ) {
							h.rate = Double.parseDouble(rateSpanElements.get(i *2 + hosei).text());
						}
						else if(rateSpanElements.size() != 0 && rateSpanElements.get(i*2 + hosei).text().equals("除外"))
						{
							hosei--;
						}
						String[] pos = beforeElements.get(i).text().split("");
						try {
							System.out.println(pos[pos.length-1]);
							h.position = RankMap.get(pos[pos.length-1]);
						}
						catch (Exception e)
						{
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
							if(!raceExist || horseText == null) {
								String address = "https://www.keibalab.jp" + horseURLElements.get(i).attr("href");
								Document horseData = Jsoup.connect(address).get();
								Elements HorseElements = horseData.select(".sortobject tr");
	
								labelArray[h.number].setText(strArray[h.number] +  HorseElements.get(0).text());
								h.pastRace = labelArray[h.number].getText();
								new HorseDB().UseHorseDataBase(new String[] {"insert", h.name, raceID.toString(), Integer.toString(h.position),
										h.pastRace,  Integer.toString(h.frame)});
	
								Thread.sleep(1000);
							}
							else 
							{
								labelArray[h.number].setText(horseText);
								
							}
						}
						catch(Exception e) {

							e.printStackTrace();
						}
					}


				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
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
