package SampleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import DBConnect.DBConnect;
import SampleDTO.reserveDTO;

public class reserveDAO {
	DBConnect dbconnect = null;
	
	private Statement ST;
	private Connection CN;
	private PreparedStatement PST;
	private ResultSet RS;
	
	private String msg;
	
	//DB연결
	public reserveDAO() { 
		dbconnect = new DBConnect();
		CN = dbconnect.getConnection();
	}//end
	
	public int dbtimeO(String departO, String arrivalO) {
		int routeNo = 0;
		try {			
			msg = "select r_routeno from busroute where r_depart=? and r_arrival=?";
			PST = CN.prepareStatement(msg);
			PST.setString(1, departO); 
			PST.setString(2, arrivalO);
			RS = PST.executeQuery();
			if(RS.next()) {
				routeNo = RS.getInt("r_routeno");
			}
		}catch (Exception e) {System.out.println(e);}
		return routeNo;
	}//end
	
	public ArrayList<reserveDTO> dbtimeO(String dateO, String levelO, int routeNo1) {
		ArrayList<reserveDTO> list = new ArrayList<reserveDTO>();
		try {
			String a = "select t_timeno, t_routeno, ";
			String b = " to_char(t_depart,'yyyy/mm/dd hh24:mi') as depart, ";
			String c = " to_char(t_arrival,'yyyy/mm/dd hh24:mi') as arrival, ";
			String d = " t_company, t_rank, t_seat, t_seatrmd, t_platform ";
			String e = " from bustime where t_routeno=? and t_depart between ? and ";
			String f = " to_char(to_date(?,'yyyy/mm/dd')+1, 'yyyy/mm/dd') ";
			String g = " and t_rank=?";
			msg = a+b+c+d+e+f+g;
			PST = CN.prepareStatement(msg);
			PST.setInt(1, routeNo1);
			PST.setString(2, dateO);
			PST.setString(3, dateO);
			PST.setString(4, levelO);
			RS = PST.executeQuery();
			while(RS.next()) {
				reserveDTO rdto = new reserveDTO();
				rdto.setTimeno(RS.getInt("t_timeno"));
				rdto.setRouteno(RS.getInt("t_routeno"));
				rdto.setDepart(RS.getString("depart"));
				rdto.setArrival(RS.getString("arrival"));
				rdto.setCompany(RS.getString("t_company"));
				rdto.setRank(RS.getString("t_rank"));
				rdto.setSeat(RS.getInt("t_seat"));
				rdto.setSeatrmd(RS.getInt("t_seatrmd"));
				rdto.setPlatform(RS.getInt("t_platform"));
				rdto.setData(1);
				list.add(rdto);
			}//while end								
		}catch(Exception e) {System.out.println(e);}
		return list;		
	}//end
	
	public ArrayList<reserveDTO> dbtimeR1(String dateR1, String levelR, int routeNo1) {
		ArrayList<reserveDTO> list = new ArrayList<reserveDTO>();
		try {
			String a = "select t_timeno, t_routeno, ";
			String b = " to_char(t_depart,'yyyy/mm/dd hh24:mi') as depart, ";
			String c = " to_char(t_arrival,'yyyy/mm/dd hh24:mi') as arrival, ";
			String d = " t_company, t_rank, t_seat, t_seatrmd, t_platform ";
			String e = " from bustime where t_routeno=? and t_depart between ? and ";
			String f = " to_char(to_date(?,'yyyy/mm/dd')+1, 'yyyy/mm/dd') ";
			String g = " and t_rank=?";
			msg = a+b+c+d+e+f+g;
			PST = CN.prepareStatement(msg);
			PST.setInt(1, routeNo1);
			PST.setString(2, dateR1);
			PST.setString(3, dateR1);
			PST.setString(4, levelR);
			RS = PST.executeQuery();
			while(RS.next()) {
				reserveDTO rdto = new reserveDTO();
				rdto.setTimeno(RS.getInt("t_timeno"));
				rdto.setRouteno(RS.getInt("t_routeno"));
				rdto.setDepart(RS.getString("depart"));
				rdto.setArrival(RS.getString("arrival"));
				rdto.setCompany(RS.getString("t_company"));
				rdto.setRank(RS.getString("t_rank"));
				rdto.setSeat(RS.getInt("t_seat"));
				rdto.setSeatrmd(RS.getInt("t_seatrmd"));
				rdto.setPlatform(RS.getInt("t_platform"));
				rdto.setData(2);
				list.add(rdto);
			}//while end	
		}catch(Exception e) {System.out.println(e);}
		return list;		
	}//end
	
	public ArrayList<reserveDTO> dbtimeR2(String dateR2, String levelR2, int routeNo2) {
		ArrayList<reserveDTO> list = new ArrayList<reserveDTO>();		
		try {
			String a = "select t_timeno, t_routeno, ";
			String b = " to_char(t_depart,'yyyy/mm/dd hh24:mi') as depart, ";
			String c = " to_char(t_arrival,'yyyy/mm/dd hh24:mi') as arrival, ";
			String d = " t_company, t_rank, t_seat, t_seatrmd, t_platform ";
			String e = " from bustime where t_routeno=? and t_depart between ? and ";
			String f = " to_char(to_date(?,'yyyy/mm/dd')+1, 'yyyy/mm/dd') ";
			String g = " and t_rank = ? ";			
			msg = a+b+c+d+e+f+g;
			PST = CN.prepareStatement(msg);
			PST.setInt(1, routeNo2);
			PST.setString(2, dateR2);
			PST.setString(3, dateR2);
			PST.setString(4, levelR2);
			RS = PST.executeQuery();
			while(RS.next()) {
				reserveDTO rdto = new reserveDTO();				
				rdto.setTimeno(RS.getInt("t_timeno"));
				rdto.setRouteno(RS.getInt("t_routeno"));
				rdto.setDepart(RS.getString("depart"));
				rdto.setArrival(RS.getString("arrival"));
				rdto.setCompany(RS.getString("t_company"));
				rdto.setRank(RS.getString("t_rank"));
				rdto.setSeat(RS.getInt("t_seat"));
				rdto.setSeatrmd(RS.getInt("t_seatrmd"));
				rdto.setPlatform(RS.getInt("t_platform"));
				rdto.setData(3);
				list.add(rdto);
			}//while end				
		}catch(Exception e) {System.out.println(e);}
		return list;		
	}
	
	public ArrayList<reserveDTO> dbtimeCheckT (String dateT,String levelO,int routeNo3){
		ArrayList<reserveDTO> list = new ArrayList<reserveDTO>();
		try {
			String a = "select t_timeno, t_routeno, ";
			String b = " to_char(t_depart,' hh24:mi') as depart, ";
			String c = " to_char(t_arrival,'hh24:mi') as arrival, ";
			String d = " t_company, t_rank, t_seat, t_seatrmd ";
			String e = " from bustime where t_routeno=? and t_depart between ? and ";
			String f = " to_char(to_date(?,'yyyy/mm/dd')+1, 'yyyy/mm/dd') ";
			String g = " and t_rank = ? ";			
			msg = a+b+c+d+e+f+g;
			PST = CN.prepareStatement(msg);
			PST.setInt(1, routeNo3);
			PST.setString(2, dateT);
			PST.setString(3, dateT);
			PST.setString(4, levelO);
			RS =PST.executeQuery();
			while(RS.next()) {
				reserveDTO rdto = new reserveDTO();
				rdto.setTimeno(RS.getInt("t_timeno"));
				rdto.setRouteno(RS.getInt("t_routeno"));
				rdto.setDepart(RS.getString("depart"));
				rdto.setArrival(RS.getString("arrival"));
				rdto.setCompany(RS.getString("t_company"));
				rdto.setRank(RS.getString("t_rank"));
				rdto.setSeat(RS.getInt("t_seat"));
				rdto.setSeatrmd(RS.getInt("t_seatrmd"));
				rdto.setData(1);
				list.add(rdto);
			}//while end	
		}catch(Exception e){System.out.println("에러:" + e);}
	 return list;
  }
	
}//end