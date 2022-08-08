package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.db.DBConnect;
import test.pack.MemberDto;

public class MemberDao {
	Connection conn = null;
	String query = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int numSuccess = 0;
	
	public List<MemberDto> getAllData() {
		List<MemberDto> memList = new ArrayList<MemberDto>();
		
		try {
			conn = new DBConnect().getConn();
			query = "SELECT * FROM member"
					+ " ORDER BY num ASC";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDto mem = new MemberDto();
				
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("address");
				
				mem.setNum(num);
				mem.setName(name);
				mem.setAddr(addr);
				
				memList.add(mem);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return memList;
	}
	
	
	public MemberDto getData() {
		MemberDto mem = null;
		
		try {
			conn = new DBConnect().getConn();
			query = "SELECT * FROM member"
					+ " WHERE ROWNUM=1"
					+ " ORDER BY num DESC";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("address");
				
				mem = new MemberDto(num, name, addr);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return mem;
	}
	
	
	public MemberDto getData(int num) {
		MemberDto mem = null;
		
		try {
			conn = new DBConnect().getConn();
			query = "SELECT * FROM member"
					+ " WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("address");
				
				mem = new MemberDto(num, name, addr);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return mem;
	}
	
	
	public boolean insert(MemberDto mem) {
		try {
			conn = new DBConnect().getConn();
			query = "INSERT INTO member"
					+ " (num, name, address)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, mem.getName());
			ps.setString(2, mem.getAddr());
			
			numSuccess = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(numSuccess > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean update(MemberDto mem) {
		try {
			conn = new DBConnect().getConn();
			query = "UPDATE member"
					+ " SET name=?, address=?"
					+ " WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, mem.getName());
			ps.setString(2, mem.getAddr());
			ps.setInt(3, mem.getNum());
			
			numSuccess = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(numSuccess > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean delete(int num) {
		try {
			conn = new DBConnect().getConn();
			query = "DELETE FROM member"
					+ " WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, num);
			
			numSuccess = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(numSuccess > 0) {
			return true;
		} else {
			return false;
		}
	}
}
