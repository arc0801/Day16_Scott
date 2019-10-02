package com.arc.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arc.emp.EmpDTO;
import com.arc.util.DBConnector;

public class DeptDAO {
	
	//새로운 부서 데이터 추가
	public int deptInsert(DeptDTO deptDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "insert into dept(deptno, dname, loc) values (?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, deptDTO.getDeptno());
			ps.setString(2, deptDTO.getDname());
			ps.setString(3, deptDTO.getLoc());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}//insert
	

	public ArrayList<DeptDTO> deptSelectList(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DeptDTO deptDTO = null;
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from dept order by deptno asc";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt(1));
				deptDTO.setDname(rs.getString(2));
				deptDTO.setLoc(rs.getString(3));
				
				ar.add(deptDTO);
			}
			//if(ar.size()==0){
			// 데이터 없음~}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
	}
	
	
	public DeptDTO getSelectOne(int deptno) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DeptDTO deptDTO = null;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from dept "
					+ "where deptno = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, deptno);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt(1));
				deptDTO.setDname(rs.getString(2));
				deptDTO.setLoc(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deptDTO;
	}
}
