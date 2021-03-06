package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
		private static Integer race_ID;
		
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
				executeInsert(args[1],args[2]);
			}else if("update".equals(command)) {

				executeUpdate(args[1]);
			}
		}

		public ObservableList<String> ReturnPaymentList(int id) throws ClassNotFoundException, SQLException 
		{
			ObservableList<String> items =FXCollections.observableArrayList();
			ResultSet resultSet = null;
			try {
				create();
				String SQL;
				if(id > 0) {
					SQL = "SELECT * FROM " + TABLE_NAME + " WHERE CLIENT_ID = '"+id+"'";
				}
				else 
				{
					return null;
				}
				resultSet = _statement.executeQuery(SQL);
				boolean br = resultSet.first();
				if(br == false) {
					return items;
				}
				do{
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
					Date date = new Date(resultSet.getLong("PUBLISHED_AT"));
					String addname = formatter.format(date);
					items.add(addname);
				}while(resultSet.next());
			}
			catch(Exception ex){

			      System.out.println(ex);
				
			}
			finally {
				close();
				resultSet.close();
			}
			return items;
		}
		
		public Integer GetRaceID(String url) throws SQLException 
		{
			race_ID = -1;
			ResultSet resultSetID = null;
			try {
				create();
				String SQLID = "SELECT ID FROM " + TABLE_NAME +" WHERE RACEURL = '"+url+"'";
				resultSetID = _statement.executeQuery(SQLID);
				resultSetID.last();
				System.out.println(resultSetID);
				race_ID = resultSetID.getInt("ID");
			}
			catch(Exception ex)
			{
				
			}finally{
				if(resultSetID != null) {
					resultSetID.close();
				}
				close();
			}
			return race_ID;
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
		
		private void executeUpdate(String name)
				throws SQLException{
				// SQL文を発行
				int updateCount = _statement.executeUpdate("Name " + TABLE_NAME 
						+  "('"+name+"')");
				System.out.println("Update: " + updateCount);
				
			}
		
		/**
		 * INSERT処理を実行します。
		 * @param id
		 * @param name
		 * @param password
		 */
		private void executeInsert(String name, String url)
			throws SQLException{
			// SQL文を発行
			int updateCount = _statement.executeUpdate("INSERT INTO " + TABLE_NAME + 
					" (NAME, RACEURL) VALUES "
					+ "('"+name+"','"+url+"')");
			System.out.println("Insert: " + updateCount);
			
		}
		
	


}
