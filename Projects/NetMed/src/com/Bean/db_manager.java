package com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.apache.commons.configuration.*; 

public class db_manager {
	public String erro;
	String sDBDriver = "com.mysql.jdbc.Driver";
	String sConnStr = "jdbc:mysql://localhost:3306/netmed";
	Connection connect = null;
	ResultSet rs = null;
	/*
    public static void dbConfigure() throws ConfigurationException {
        
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new PropertiesConfiguration("test1.properties"));
        
        String username = config.getString("username");
        String password = config.getString("password");
} 
*/
	
	
	
	public db_manager() {
    	try {
			Class.forName(sDBDriver); 
		}
		catch(java.lang.ClassNotFoundException e) {
			System.err.println( e.getMessage());
		}
    }
	public ResultSet query(String sql) {
		try {
			connect = DriverManager.getConnection(sConnStr,"root","xianggen"); 
			Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} 
		catch(SQLException ex) { 
			System.err.println(erro=ex.getMessage());
		}
		return rs;
	}
	public int update(String sql) {
		int result = 0;
		try {
			connect = DriverManager.getConnection(sConnStr,"root","xianggen"); 
			Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} 
		catch(SQLException ex) { 
			System.err.println(erro=ex.getMessage());
		}
		return result;
	}
	public void dbclose(){
		try{
			connect.close();
		}catch(Exception e){}
		
	}
}
