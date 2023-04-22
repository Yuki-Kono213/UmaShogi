package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

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

				executeUpdate(args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11]);
			}else if("updateRace".equals(command)) {

				executeUpdateRace(args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10]);
			}else if("updateMoney".equals(command)) {
				System.out.println(args[1]);
				executeUpdateMoney(args[1],args[2],args[3],args[4], args[5]);
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
		
		private void executeUpdate(String name, String url, String payCash, String returnCash, String glass, String range, String stage
				, String grade, String hande, String female, String condition)
				throws SQLException{
				boolean glassTrue = true;
				if(glass.contains("ダ")) {
					glassTrue = false;
				}
				System.out.println(female);
				boolean femaleTrue = false;
				if(female.equals("true")) {
					femaleTrue = true;
				}
				// SQL文を発行
				int updateCount = _statement.executeUpdate("UPDATE "+ TABLE_NAME + " SET (PAY, RETURN, GLASS, RANGE, STAGE, GRADE, HANDE, FEMALE, CONDITION) = " 
						+  "('"+Integer.parseInt(payCash)+"','"+Integer.parseInt(returnCash)+"','"+glassTrue+"'"
								+ ",'"+Integer.parseInt(range)+"','"+stage+"', '"+grade+"', '"+hande+"','"+femaleTrue+"', '"+condition+"') WHERE RACEURL = '"+url+"'");
				System.out.println(glassTrue + range + stage);
				
			}
		private void executeUpdateRace(String name, String url, String glass, String range, String stage
				, String grade, String hande, String female, String condition, String newHorse)
				throws SQLException{
				boolean glassTrue = true;
				if(glass.contains("ダ")) {
					glassTrue = false;
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
				int updateCount = _statement.executeUpdate("UPDATE "+ TABLE_NAME + " SET (GLASS, RANGE, STAGE, GRADE, HANDE, FEMALE, CONDITION, NEWHORSE) = " 
						+  "('"+glassTrue+"'"
								+ ",'"+Integer.parseInt(range)+"','"+stage+"', '"+grade+"', '"+hande+"','"+femaleTrue+"', '"+condition+"','"+newHorseTrue+"') WHERE RACEURL = '"+url+"'");
				System.out.println(glassTrue + range + stage);
				
			}
		
		private void executeUpdateMoney(String url, String wide3, String wide4, String wide5, String wide6) 
				throws SQLException{
				// SQL文を発行
				int updateCount = _statement.executeUpdate("UPDATE "+ TABLE_NAME + " SET (WIDE3,WIDE4,WIDE5,WIDE6) = " 
						+  "('"+Integer.parseInt(wide3)+"','"+Integer.parseInt(wide4)+"','"+Integer.parseInt(wide5)+"','"+Integer.parseInt(wide6)+"') WHERE RACEURL = '"+url+"'");
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
		
	


}
