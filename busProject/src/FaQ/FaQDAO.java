package FaQ;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DBConnect.DBConnect;

public class FaQDAO {
//	Connection CN ;
//	Statement ST ;
//	PreparedStatement PST;
//	CallableStatement CST;
//	ResultSet RS ;
	
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	DBConnect dbconnect = null;
	
//	String msg;
	  
	public FaQDAO() {
		this.dbconnect = new DBConnect(); 
		con = dbconnect.getConnection();
	}//noticeDAO END
	
	public String noticeSearch(String kef, String kew) {
		String search = "";
		try {
				search = "where "+kef+" like '%"+kew+"%'";
		}catch (Exception e) {
			System.out.println("검색에러: "+e);
			search = "where n_title like '%%'";
		}
		
		return search;
	}//noticeSearch END
	
	public ArrayList<FaQDTO> FaQList(int start, int end, String kef, String kew) {
		ArrayList<FaQDTO> list = new ArrayList<FaQDTO>();
		try {
			String msg = "select * from (select rownum as rn, b.* from (select rownum as newrn, n.* from busNotice n where n_type='FaQ' order by n_noticeno desc) b "+noticeSearch(kef,kew)+") where rn between "+start+" and "+end;
			pstmt = con.prepareStatement(msg);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FaQDTO dto = new FaQDTO();
				dto.setNewrn(rs.getInt("newrn"));
				dto.setRn(rs.getInt("rn"));
				dto.setNo(rs.getInt("n_noticeNo"));
				dto.setId(rs.getString("n_id"));
				dto.setTitle(rs.getString("n_title"));
				dto.setContent(rs.getString("n_content"));
				dto.setDate(rs.getDate("n_date"));
				dto.setEditDate(rs.getDate("n_editDate"));
				dto.setHit(rs.getInt("n_hit"));
				dto.setType(rs.getString("n_type"));
				list.add(dto);
			}
		}catch (Exception e) {System.out.println("리스트에러: "+e);}
		
		return list;
	}//noticeList END
	
	
	public int FaQTotal(String kef, String kew) {
		int Total = 0;
		
		try {
			String msg = "select count(*) as cnt from (select * from busNotice where n_type='FaQ') "+noticeSearch(kef, kew);
			pstmt = con.prepareStatement(msg);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			Total = rs.getInt("cnt");
			}
		}catch (Exception e) {System.out.println("토탈에러: "+e);}
		
		return Total;
	}//noticeTotal end
	
	
	public void FaQHit(int no) {
		try {
			String msg = "update busNotice set n_hit=n_hit+1 where n_noticeno="+no;
			pstmt = con.prepareStatement(msg);
			pstmt.executeUpdate();
		} catch (Exception e) {System.out.println("조회수에러: "+e);
		}
		
	}//noticeHit END
	
	
	public FaQDTO FaQDetail(int rn) {
		FaQDTO dto = new FaQDTO();
		try {
			String msg = "select * from (select rownum as rn, b.* from (select rownum as newrn, n.* from busNotice n where n_type='FaQ' order by n_noticeno desc) b) where rn="+rn;
			pstmt = con.prepareStatement(msg);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			dto.setNewrn(rs.getInt("newrn"));
			dto.setRn(rs.getInt("rn"));
			dto.setNo(rs.getInt("n_noticeNo"));
			dto.setId(rs.getString("n_id"));
			dto.setTitle(rs.getString("n_title"));
			dto.setContent(rs.getString("n_content"));
			dto.setDate(rs.getDate("n_date"));
			dto.setEditDate(rs.getDate("n_editDate"));
			dto.setHit(rs.getInt("n_hit"));
			dto.setType(rs.getString("n_type"));
			}
		}catch (Exception e) {System.out.println("디테일에러: "+e);}
		
		return dto;
	}//noticeDetail END
	
	
	public void FaQDelete(int no) {
		FaQDTO dto = new FaQDTO();
		try {
			String msg = "delete busNotice where n_noticeno="+no;
			pstmt = con.prepareStatement(msg);
			pstmt.executeUpdate();
		}catch (Exception e) {System.out.println("삭제에러: "+e);}
	}//noticeDelete END

	public void FaQInsert(String title, String content) {
		try {
			String msg = "insert into busNotice values(n_noticeNo.nextval, 'admin', ?, ?, sysdate, sysdate, 0, 'FaQ')";
			pstmt = con.prepareStatement(msg);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.executeUpdate();
		}catch (Exception e) {System.out.println("인서트에러: "+e);}
	}//noticeInsert END

	public void FaQUpdate(int no, String title, String content) {
		try {
			String msg = "update busNotice set n_title=?, n_content=?, n_editdate=sysdate where n_noticeno=?";
			pstmt = con.prepareStatement(msg);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			pstmt.executeUpdate();
		}catch (Exception e) {System.out.println("수정에러: "+e);}
	}//noticeUpdate
	
	
	
}//noticeDAO class END
