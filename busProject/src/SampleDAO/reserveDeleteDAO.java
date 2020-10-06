package SampleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import DBConnect.DBConnect;
import SampleDTO.reserveCheckDTO;
import SampleDTO.reserveDTO;

public class reserveDeleteDAO {
	DBConnect dbconnect = null;
	
	private Statement ST;
	private Connection CN;
	private PreparedStatement PST;
	private ResultSet RS;
	
	private String msg;
	
	//DB연결
	public reserveDeleteDAO() { 
		dbconnect = new DBConnect();
		CN = dbconnect.getConnection();
	}//end
	
	public void dbdelete(String code, int timeno, int routeno, String id) {
		try {		
			msg = "delete from busSeat where s_id=? and s_timeno=? and s_routeno=? and s_code=?";
			PST = CN.prepareStatement(msg);
			PST.setString(1, id); 
			PST.setInt(2, timeno);
			PST.setInt(3, routeno);
			PST.setString(4, code);
			PST.executeUpdate();
			
			msg = "update busTime set t_seatRmd=t_seatRmd+1 where t_timeNo=? and t_routeNo=?";
			PST = CN.prepareStatement(msg);
			PST.setInt(1, timeno);
			PST.setInt(2, routeno);
			PST.executeUpdate();			
		}catch (Exception e) {System.out.println(e);}
	}//end
}//class edn
