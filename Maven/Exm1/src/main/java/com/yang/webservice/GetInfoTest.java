package com.yang.webservice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;
import javax.jws.WebParam;
import javax.xml.ws.Endpoint;

import net.sf.json.JSONObject;
@WebService(targetNamespace="http://webservice.yang.com")
public class GetInfoTest {
	public JSONObject getInfo(@WebParam(name="sno",
			targetNamespace="http://webservice.yang.com",
			mode = WebParam.Mode.IN) String sno) throws SQLException{
		String sDBDriver = "com.mysql.jdbc.Driver";
		String sConnStr = "jdbc:mysql://localhost:3306/tms_db";
		try {
			Class.forName(sDBDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connect = null;
		ResultSet rs = null;
		connect = DriverManager.getConnection(sConnStr,"root","xianggen");
		Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="select * from student where Sno='"+sno+"'";
		rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		// ȡ�ý��������
		int columnCount=rsmd.getColumnCount();
		Map<String, Object> data = null;
		
		JSONObject json=new JSONObject();
		//ѭ�������
		 while (rs.next()) {
             data = new HashMap<String, Object>();
             // ÿѭ��һ������������ֵ����Map
             for (int i = 1; i < columnCount; i++) {
                 data.put(rsmd.getColumnLabel(i), rs.getObject(rsmd
                         .getColumnLabel(i)));
             }
             // ���������ݵ�Map���뵽json��
             json.putAll(data);
         }
		 return json;
	}
	@SuppressWarnings("restriction")
	public static void main(String[] args) { 
        Endpoint.publish("http://localhost:8083/webservice/GetInfoTestService", new GetInfoTest()); 
    } 
}
