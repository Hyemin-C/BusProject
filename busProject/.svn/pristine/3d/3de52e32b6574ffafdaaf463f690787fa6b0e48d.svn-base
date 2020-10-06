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

public class seatDAO {
	DBConnect dbconnect = null;
	
	private Statement ST;
	private Connection CN;
	private PreparedStatement PST;
	private ResultSet RS;
	
	private String msg;
	
	//DB연결
	public seatDAO() { 
		dbconnect = new DBConnect();
		CN = dbconnect.getConnection();
	}//end
	
	public void dbseat() {
		try {			
			msg = "select r_routeno from busroute where r_depart=? and r_arrival=?";
			PST = CN.prepareStatement(msg);
			RS = PST.executeQuery();
		}catch (Exception e) {System.out.println(e);}
	}
}
