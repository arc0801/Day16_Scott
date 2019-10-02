package com.arc.bonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arc.util.DBConnector;

public class BonusDAO {

	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;

	public BonusDAO() {
		con = null;
		st = null;
		rs = null;
	}

	public int delete(String ename) {
		int result = 0;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "delete bonus "
					+ "where ename = ?";
			
			st = con.prepareStatement(sql);
			st.setString(1, ename);
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;

	}//delete


	public int bonusInsert(BonusDTO bonusDTO) {
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into bonus (ename, job, sal, comm) "
					+ "values (?, ?, ?, ?)";
			
			st = con.prepareStatement(sql);
			st.setString(1, bonusDTO.getEname());
			st.setString(2, bonusDTO.getJob());
			st.setInt(3, bonusDTO.getSal());
			st.setInt(4, bonusDTO.getComm());
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;

	}//bonusInsert


	public ArrayList<BonusDTO> getSelectList() {
		BonusDTO bonusDTO = null;
		ArrayList<BonusDTO> ar = new ArrayList<BonusDTO>();

		try {
			con = DBConnector.getConnect();

			String sql = "select * from bonus "
					+ "order by sal desc";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));
				ar.add(bonusDTO);
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

		return ar;

	}//getSelectList


	public BonusDTO getSelectOne(String ename) {
		//이름으로~
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
