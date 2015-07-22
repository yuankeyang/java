package com.yang.webservices;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import javax.sql.DataSource;

import net.sf.json.JSONObject;


public class GetInfoService {
	public String getInfo(String sno) throws SQLException, NamingException{
		
		Connection connect = null;
		ResultSet rs = null;
		//新建Context
		Context ctx=new InitialContext();
		//查找数据�?
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mypool");
		//connect = DriverManager.getConnection(sConnStr,"root","xianggen");
		connect=ds.getConnection();
		Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="select * from student where Sno='"+sno+"'";
		rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		// 取得结果集列�?
		int columnCount=rsmd.getColumnCount();
		Map<String, Object> data = null;
		
		JSONObject json=new JSONObject();
		//循环结果�?
		 while (rs.next()) {
             data = new HashMap<String, Object>();
             // 每循环一条将列名和列值存入Map
             for (int i = 1; i < columnCount; i++) {
                 data.put(rsmd.getColumnLabel(i), rs.getObject(rsmd
                         .getColumnLabel(i)));
             }
             // 将整条数据的Map存入到json�?
             json.putAll(data);
         }
		 return json.toString();
	}
}
