package com.arc.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arc.util.DBConnector;

public class EmpDAO {
	
	public int empInsert(EmpDTO empDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con= DBConnector.getConnect();
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, nvl(comm, 0) comm, deptno) values (?, ?, ?, ?, sysdate, ?, ?, ?)";
		
			ps = con.prepareStatement(sql);
			ps.setInt(1, empDTO.getEmpno());
			ps.setString(2, empDTO.getEname());
			ps.setString(3, empDTO.getJob());
			ps.setInt(4, empDTO.getMgr());
			
			ps.setInt(5, empDTO.getSal());
			ps.setInt(6, empDTO.getComm());
			ps.setInt(7, empDTO.getDeptno());
			
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
		
	}
	
	//getSelectList
	//전체사원정보 - 최신입사일순
	public ArrayList<EmpDTO> getSelectList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmpDTO empDTO = null;
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from emp "
					+ "order by hiredate desc";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setMgr(rs.getInt(4));
				empDTO.setHiredate(rs.getDate(5));
				empDTO.setSal(rs.getInt(6));
				empDTO.setComm(rs.getInt(7));
				empDTO.setDeptno(rs.getInt(8));
				ar.add(empDTO);
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
	

	//getSelectOne
	//매개변수 사원번호
	//java.sql.date - hiredate
	//nvl(comm, 0)
	public EmpDTO getSelectOne(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmpDTO empDTO = null;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from emp "
					+ "where empno = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, empno);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setMgr(rs.getInt(4));
				empDTO.setHiredate(rs.getDate(5));
				empDTO.setSal(rs.getInt(6));
				empDTO.setComm(rs.getInt(7));
				empDTO.setDeptno(rs.getInt(8));
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
		return empDTO;
	}//getSelectOne
}
