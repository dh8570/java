package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.db.DBConnect;
import test.dto.WorkDto;

public class WorkDao {
	Connection conn = null;
	PreparedStatement ps = null;
	String query = null;
	ResultSet rs = null;
	
	WorkDto dto = null;
	List<WorkDto> workList = null;
	int successNum = 0;
	
	// 전체 데이터 인덱스 기준으로 정렬
	// 전체 데이터 할 일 기준으로 정렬
	// 전체 데이터 날짜 기준으로 정렬
	public List<WorkDto> getAllData(String selectType) {
		workList = new ArrayList<WorkDto>();
		
		try {
			conn = new DBConnect().getConnect();
			if(selectType.equals("Num")) {
				query = "SELECT * FROM worklist"
						+ " ORDER BY num ASC";
			} else if(selectType.equals("Content")) {
				query = "SELECT * FROM worklist"
						+ " ORDER BY content ASC";
			} else if(selectType.equals("Datetime")) {
				query = "SELECT * FROM worklist"
						+ " ORDER BY datetime ASC";
			}
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String content = rs.getString("content");
				String datetime = rs.getString("datetime");
				datetime = datetime.replace(" 00:00:00", "");
				
				dto = new WorkDto(num, content, datetime);
				workList.add(dto);
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
		
		return workList;
	}
	
	// 특정 데이터 수집
	public WorkDto getData(int selectedNum) {
		try {
			conn = new DBConnect().getConnect();
			query = "SELECT * FROM worklist"
					+ " WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, selectedNum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int num = rs.getInt("num");
				String content = rs.getString("content");
				String datetime = rs.getString("datetime");
				datetime = datetime.replace(" 00:00:00", "");
				
				dto = new WorkDto(num, content, datetime);
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
		
		return dto;
	}
	
	// 데이터 입력
	public boolean insert(WorkDto inputDto) {
		try {
			conn = new DBConnect().getConnect();
			query = "INSERT INTO worklist"
					+ " (num, content, datetime)"
					+ " VALUES (worklist_seq.NEXTVAL, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, inputDto.getContent());
			ps.setString(2, inputDto.getDatetime());
			
			successNum = ps.executeUpdate();
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
		
		if(successNum>0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 데이터 수정
	public boolean update(WorkDto inputDto) {
		try {
			conn = new DBConnect().getConnect();
			query = "UPDATE worklist"
					+ " SET content=?, datetime=?"
					+ " WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, inputDto.getContent());
			ps.setString(2, inputDto.getDatetime());
			ps.setInt(3, inputDto.getNum());
			
			successNum = ps.executeUpdate();
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
		
		if(successNum>0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 데이터 삭제
	public boolean delete(int inputNum) {
		try {
			conn = new DBConnect().getConnect();
			query = "DELETE FROM worklist"
					+ " WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, inputNum);
			
			successNum = ps.executeUpdate();
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
		
		if(successNum>0) {
			return true;
		} else {
			return false;
		}
	}
}
