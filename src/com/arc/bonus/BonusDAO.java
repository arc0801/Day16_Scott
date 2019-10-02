package com.arc.bonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arc.util.DBConnector;

public class BonusDAO {

	public void delete() {
		
		
		
		
		
		
	}//delete
	
	
	public void bonusInsert() {
		
		
		
		
		
		
		
		
		
	}//bonusInsert
	
	
	public void getSelectList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BonusDTO bonusDTO = null;
		
		
		
		
		
	}//getSelectList
	
	
	public BonusDTO getSelectOne(String ename) {
		//이름으로~
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BonusDTO bonusDTO = null;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from bonus "
					+ "where ename = ?";
			
			st = con.prepareStatement(sql);
			st.setString(1, ename);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bonusDTO;
		
	}//getSelectOne
}
