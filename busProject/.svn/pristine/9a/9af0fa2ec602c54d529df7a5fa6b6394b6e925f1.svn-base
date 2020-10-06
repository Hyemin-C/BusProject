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

public class infoDAO {
	DBConnect dbconnect = null;
	
	private Statement ST;
	private Connection CN;
	private PreparedStatement PST;
	private ResultSet RS;
	
	private String msg;
	//DB연결
	public infoDAO() { 
		dbconnect = new DBConnect();
		CN = dbconnect.getConnection();
	}//end
	
	public void dbseatO(infoDTO infodto) {
		try {
			msg = "insert into busSeat values(s_seatNo.nextval,?,?,?,?,?,?,?)";			
			PST = CN.prepareStatement(msg);
			PST.setInt(1, infodto.getBusRoute());
			PST.setInt(2, infodto.getBusList());
			PST.setString(3, infodto.getUserid());
			PST.setString(4, infodto.getSeatList());
			PST.setInt(5, infodto.getBusFare());
			PST.setInt(6, infodto.getBusAdult());
			PST.setInt(7, infodto.getBusStudent());
			PST.executeUpdate();
		}catch(Exception e) {System.out.println(e);}		
	}//end
	
	public void dbtimeO(infoDTO infodto) {
		try {
			msg = "update busTime set t_seatRmd = t_seatRmd-1 where t_timeNo = ? and t_routeNo = ?";
			PST = CN.prepareStatement(msg);
			PST.setInt(1, infodto.getBusList());
			PST.setInt(2, infodto.getBusRoute());
			PST.executeUpdate();
		}catch (Exception e) {System.out.println(e);}
	}//end
	
	public void dbseatR(infoDTO infodto) {
		try {
			msg = "insert into busSeat values(s_seatNo.nextval,?,?,?,?,?,?,?)";			
			PST = CN.prepareStatement(msg);
			PST.setInt(1, infodto.getPrebusRoute());
			PST.setInt(2, infodto.getPrebusList());
			PST.setString(3, infodto.getPreuserid());
			PST.setString(4, infodto.getPreseatSel());
			PST.setInt(5, infodto.getPrefare());
			PST.setInt(6, infodto.getPrebusAdult());
			PST.setInt(7, infodto.getPrebusStudent());
			PST.executeUpdate();
		}catch(Exception e) {System.out.println(e);}		
	}//end
	
	public void dbtimeR(infoDTO infodto) {
		try {
			msg = "update busTime set t_seatRmd = t_seatRmd-1 where t_timeNo = ? and t_routeNo = ?";
			PST = CN.prepareStatement(msg);
			PST.setInt(1, infodto.getPrebusList());
			PST.setInt(2, infodto.getPrebusRoute());
			PST.executeUpdate();
		}catch (Exception e) {System.out.println(e);}
	}//end
}
