package SampleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import DBConnect.DBConnect;
import SampleDTO.infoDTO;
import SampleDTO.reserveDTO;

public class timeDAO {
	DBConnect dbconnect = null;
	
	private Statement ST;
	private Connection CN;
	private PreparedStatement PST;
	private ResultSet RS;
	
	private String msg;
	//DB연결
	public timeDAO() { 
		dbconnect = new DBConnect();
		CN = dbconnect.getConnection();
	}//end
	
	public ArrayList<Integer> dbcode(String routeno ,String timeno) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			msg = "select s_code from busSeat where s_routeno="+routeno+" and s_timeno="+timeno;			
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while(RS.next()) {
				int code = RS.getInt("s_code");
				list.add(code);
			}//while end
		}catch(Exception e) {System.out.println(e);}		
		return list;
	}//end
	
}//class end
