package com.object.disoriented;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.util.Log;

public class DB {

	private Connection conn;
	
	public DB(){

		conn = null;
		String url = "jdbc:mysql://128.61.105.48/3ps";
		String dbName = "3ps";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "gt"; 
		//Log.v(TAG,url+dbName+driver+userName);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userName,"");
			System.out.println("Connected to the database "+dbName);
			conn.close();
			System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}