package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.concurrent.locks.Condition;

public class RaceDB {


		
		/**
		 * テーブル名。
		 */
		private static final String TABLE_NAME = "RACE";

		/**
		 * テスト処理を実行します。
		 * @param args
		 */
		public void UseRaceDataBase(String[] args) {
			
			try{
				// オブジェクトを生成
				create();
				
				// データ操作
				execute(args);
			}catch(Throwable t) {
				t.printStackTrace();
			}finally{
				// オブジェクトを破棄
				close();
			}
		}
		
		public int CalcTodayCount(LocalDate time) throws SQLException 
		{
			int count = 0;
			ResultSet resultSet = null;
			try {

				create();
				ZonedDateTime zdt = time.atStartOfDay(ZoneOffset.ofHours(+9));
				long beginlong = zdt.toInstant().toEpochMilli();

				LocalDate endTime = time.plusDays(1);   
				zdt = endTime.atStartOfDay(ZoneOffset.ofHours(+9));
				long endlong = zdt.toInstant().toEpochMilli();
				

			      System.out.println(beginlong);
			      System.out.println(endlong);
				
				resultSet = _statement.executeQuery("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE PUBLISHED_AT BETWEEN "
						+ " '"+beginlong+"' AND '"+endlong+"' ");
				resultSet.first();
				count = resultSet.getInt(1) + 1;
				if(resultSet.getInt(1) <= 0) {
						count = 1;	
				};
			}
			catch(Exception ex){
				

			      System.out.println(ex);
			      System.out.println(_connection);
			}
			finally {
				close();
				resultSet.close();
			}
			
			return count;
			
		}
		
		/**
		 * Connectionオブジェクトを保持します。
		 */
		private Connection _connection;
		
		/**
		 * Statementオブジェクトを保持します。
		 */
		private Statement _statement;
		
 		/**
		 * 構築します。
		 */
		public RaceDB() {
			_connection = null;
			_statement = null;
		}
		
		/**
		 * オブジェクトを生成します。
		 */
		public void create()
			throws ClassNotFoundException, SQLException{
			// 下準備
			Class.forName("org.h2.Driver");
			_connection = DriverManager.getConnection("jdbc:h2:./UmaShogi", "sa", "9685");
			_statement = _connection.createStatement();
		}
		
		/**
		 * 各種オブジェクトを閉じます。
		 */
		public void close() {
			if(_statement != null) {
				try{
					_statement.close();
				}catch(SQLException e) {
					;
				}
				_statement = null;
			}
			if(_connection != null) {
				try{
					_connection.close();
				}catch(SQLException e) {
					;
				}
				_connection = null;
			}
		}
		
		/**
		 * 実行します。
		 * @param args
		 * @throws SQLException
		 */
		public void execute(String[] args)
			throws SQLException {
			String command = args[0];
			if("select".equals(command)) {
				executeSelect();
			}else if("insert".equals(command)) {
				executeInsert(args[1],args[2],args[3],args[4]);
			}else if("update".equals(command)) {

				executeUpdate(args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13]);
			}else if("updateRace".equals(command)) {

				executeUpdateRace(args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12]);
			}else if("updateMoney".equals(command)) {
				System.out.println(args[1]);
				executeUpdateMoney(args[1],args[2],args[3],args[4], args[5], args[6],args[7],args[8],args[9], args[10], args[11]);
			}
			else if("pastReturn".equals(command)) {
				executeReturnAverageRace(args[1],args[2],args[3],args[4],args[5],args[6],args[7]);
			}
		}
		
		public Integer[] GetRaceID(String url) throws SQLException 
		{
			Integer[] race_Data = {-1,0,0,0}; 
			ResultSet resultSetID = null;
			try {
				create();
				String SQLID = "SELECT * FROM " + TABLE_NAME +" WHERE RACEURL = '"+url+"'";
				resultSetID = _statement.executeQuery(SQLID);
				resultSetID.last();
				race_Data[0] = resultSetID.getInt("ID");
				race_Data[1] = resultSetID.getInt("PAY");
				race_Data[2] = resultSetID.getInt("RETURN");
				Boolean b = resultSetID.getBoolean("COURSECALC");
				if(b)
				{
					race_Data[3] = 1;
				}
			}
			catch(Exception ex)
			{
				
			}finally{
				close();
				if(resultSetID != null) {
					resultSetID.close();
				}
			}
			return race_Data;
		}
		/*
		 * SELECT処理を実行します。
		 */
		private void executeSelect()
			throws SQLException{
			ResultSet resultSet = _statement.executeQuery("SELECT * FROM " + TABLE_NAME);
			try{
				boolean br = resultSet.first();
				if(br == false) {
					return;
				}
				do{
					String id = resultSet.getString("ID");
					String name = resultSet.getString("NAME");
					String password = resultSet.getString("PASSWORD");
					
					System.out.println("id: " + id + ", name: " + name + ", password: " + password);
				}while(resultSet.next());
			}finally{
				resultSet.close();
			}
		}
		
		private void executeUpdate(String name, String url, String payCash, String returnCash, String grass, String range, String stage
				, String grade, String hande, String female, String condition,String age, String count)
				throws SQLException{
				boolean grassTrue = true;
				if(grass.contains("ダ")) {
					grassTrue = false;
				}
				System.out.println(female);
				boolean femaleTrue = false;
				if(female.equals("true")) {
					femaleTrue = true;
				}
				// SQL文を発行
				int updateCount = _statement.executeUpdate("UPDATE "+ TABLE_NAME + " SET (PAY, RETURN, GRASS, RANGE, STAGE, GRADE, HANDE, FEMALE, CONDITION, AGE, COUNT) = " 
						+  "('"+Integer.parseInt(payCash)+"','"+Integer.parseInt(returnCash)+"','"+grassTrue+"'"
								+ ",'"+Integer.parseInt(range)+"','"+stage+"', '"+grade+"', '"+hande+"','"+femaleTrue+"', '"+condition+"','"+age+"' ,'"+Integer.parseInt(count)+"' ) WHERE RACEURL = '"+url+"'");
				System.out.println(grassTrue + range + stage);
				
			}
		private void executeUpdateRace(String name, String url, String grass, String range, String stage
				, String grade, String hande, String female, String condition, String newHorse,String age, String count)
				throws SQLException{
				boolean grassTrue = true;
				if(grass.contains("ダ")) {
					grassTrue = false;
				}
				System.out.println(female);
				boolean femaleTrue = false;
				if(female.equals("true")) {
					femaleTrue = true;
				}
				boolean newHorseTrue = false;
				if(newHorse.equals("true")) {
					newHorseTrue = true;
				}
				// SQL文を発行
				int updateCount = _statement.executeUpdate("UPDATE "+ TABLE_NAME + " SET (GRASS, RANGE, STAGE, GRADE, HANDE, FEMALE, CONDITION, NEWHORSE, AGE, COUNT) = " 
						+  "('"+grassTrue+"'"
								+ ",'"+Integer.parseInt(range)+"','"+stage+"', '"+grade+"', '"+hande+"','"+femaleTrue+"', '"+condition+"','"+newHorseTrue+"','"+age+"' ,'"+Integer.parseInt(count)+"' ) WHERE RACEURL = '"+url+"'");
				System.out.println(grassTrue + range + stage);
				
			}
		
		private void executeUpdateMoney(String url, String wide3, String wide4, String wide5, String wide6, String wide5Nagashi
				, String umaren3, String umaren4, String umaren5, String umaren6, String umaren5Nagashi) 
				throws SQLException{
				// SQL文を発行
				int updateCount = _statement.executeUpdate("UPDATE "+ TABLE_NAME + " SET (WIDE3,WIDE4,WIDE5,WIDE6,WIDE5NAGASHI,UMAREN3,UMAREN4,UMAREN5,UMAREN6,UMAREN5NAGASHI) = " 
						+  "('"+Integer.parseInt(wide3)+"','"+Integer.parseInt(wide4)+"','"+Integer.parseInt(wide5)+"'"
								+ ",'"+Integer.parseInt(wide6)+"','"+Integer.parseInt(wide5Nagashi)+"'" 
								+ ",'"+Integer.parseInt(umaren3)+"','"+Integer.parseInt(umaren4)+"','"+Integer.parseInt(umaren5)+"'"
								+ ",'"+Integer.parseInt(umaren6)+"','"+Integer.parseInt(umaren5Nagashi)+ "') WHERE RACEURL = '"+url+"'");
				}
				
		private void executeReturnAverageRace(String year, String stage, String range, String grass, String count, String condition, String hande)
			throws SQLException{
			try {
				create();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			};
			if(hande.equals("ハンデ")) {
				hande = "";
			}
			else {
				hande = "ハンデ";
			}
			System.out.println(year);
				ResultSet resultSet = _statement.executeQuery(
						"SELECT COUNT( * ), SUM (WIDE3) / COUNT( * ), SUM (WIDE4) / COUNT( * ), SUM (WIDE5) / COUNT( * ), SUM (WIDE6) / COUNT( * ),SUM(WIDE5NAGASHI)/COUNT(*),SUM (UMAREN3) / COUNT( * ), SUM (UMAREN4) / COUNT( * ), SUM (UMAREN5) / COUNT( * ), SUM (UMAREN6) / COUNT( * ),SUM(UMAREN5NAGASHI)/COUNT(*)"
						+ " FROM " +  TABLE_NAME + " WHERE WIDE4 IS NOT NULL"
						+ " AND (RACEURL LIKE '%"+year+"%')AND NOT NAME LIKE '%新馬%'AND NOT NAME LIKE '%2歳%'AND NOT AGE LIKE '%障害%'"
						+ " AND HANDE != '"+hande+"' AND CONDITION = '"+condition+"' AND COUNT = "+Integer.parseInt(count)+" AND STAGE = '"+stage+"'"
						+ " AND RANGE = "+Integer.parseInt(range)+" AND GRASS = "+Boolean.parseBoolean(grass)+"");
				System.out.println(resultSet);
				try{
					boolean br = resultSet.first();
					if(br == false) {
						return;
					}
					do{
						if(resultSet.getInt(1) > 2 || Integer.parseInt(year) > 2022) {
						String Count = String.valueOf(resultSet.getInt(1));
						String wide3 = String.valueOf(resultSet.getInt(2));
						String wide4 = String.valueOf(resultSet.getInt(3));
						String wide5 = String.valueOf(resultSet.getInt(4));
						String wide6 = String.valueOf(resultSet.getInt(5));
						String wide5nagashi = String.valueOf(resultSet.getInt(6));
						String umaren3 = String.valueOf(resultSet.getInt(7));
						String umaren4 = String.valueOf(resultSet.getInt(8));
						String umaren5 = String.valueOf(resultSet.getInt(9));
						String umaren6 = String.valueOf(resultSet.getInt(10));
						String umaren5nagashi = String.valueOf(resultSet.getInt(11));
						SampleController.pastGetStrings = new String[]{Count, wide3, wide4, wide5, wide6, wide5nagashi
								, umaren3, umaren4, umaren5, umaren6, umaren5nagashi};
						}
						else {
							SampleController.pastGetStrings = new String[11];
						}
					}while(resultSet.next());
				}finally{
					resultSet.close();
				}
			
		}
		/**
		 * INSERT処理を実行します。
		 * @param id
		 * @param name
		 * @param password
		 */
		private void executeInsert(String name, String url, String payCash, String returnCash)
			throws SQLException{
			// SQL文を発行
			int updateCount = _statement.executeUpdate("INSERT INTO " + TABLE_NAME + 
					" (NAME, RACEURL, PAY, RETURN, COURSECALC  ) VALUES "
					+ "('"+name+"','"+url+"','"+Integer.parseInt(payCash)+"','"+Integer.parseInt(returnCash)+"','"+Boolean.parseBoolean("true")+"')");
			System.out.println("Insert: " + updateCount);
			
		}
		public String executeReturnMoney(String range, String stage, String year)
			throws SQLException{
			ResultSet resultSet = null;
			try {
				String grass = "true";
				if(range.contains("ダ")) {
					grass = "false";
				}
				range = range.replace("芝", "").replace("ダ", "").replace("m", "");
				create();
				// SQL文を発行
				resultSet = _statement.executeQuery("SELECT SUM(RETURN) *100 / SUM (PAY) FROM RACE WHERE RANGE = " 
				+ range + " AND STAGE = '"+stage+"' AND GRASS = "+grass+" AND (RACEURL LIKE '%"+year+"%' OR RACEURL LIKE '%"+String.valueOf(Integer.parseInt(year) - 1)+"%');"); 
				resultSet.first();
				System.out.println(resultSet);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			String str = resultSet.getString(1);
			resultSet.close();
			System.out.println(str);
			return str;
		}
		
	


}
