package com.arc.salgrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.arc.util.DBConnector;

public class SalgradeDAO {

	//삭제
		public int delete(int grade) {
			
			DBConnector dbc= new DBConnector();
			Connection con = null;
			PreparedStatement st = null;
			int result = 0;
			
			try {
				con = dbc.dbconnecter();
				String sql = "delete salgrade where grade=? ";
				st = con.prepareStatement(sql);
				
				st.setInt(1, grade);
				
				result = st.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					con.close();
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return result;
		}
		
		//삽입
		public int salInsert(SalgradeDTO salgradeDTO) {
			DBConnector dbc= new DBConnector();
			Connection con = null;
			PreparedStatement st = null;
			int result = 0;
			try {
				con = dbc.dbconnecter();
				String sql = "insert into salgrade(grade, losal, hisal) values (? ,? ,?)";
				st = con.prepareStatement(sql);
				
				st.setInt(1,salgradeDTO.getGrade());
				st.setInt(2,salgradeDTO.getLosal());
				st.setInt(3,salgradeDTO.getHisal());

				result = st.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					con.close();
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return result;
		}
		
		//전체출력
		public ArrayList<SalgradeDTO> getSelectList() {
			ArrayList<SalgradeDTO> ar = new ArrayList<SalgradeDTO>();
			DBConnecter dbc= new DBConnecter();
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			SalgradeDTO salDto = null;
			
			try {
				con = dbc.dbconnecter();
				String sql = "select * from salgrade";
				st = con.prepareStatement(sql);
				rs = st.executeQuery();
				
				while(rs.next()) {
					salDto = new SalgradeDTO();
					salDto.setGrade(rs.getInt("grade"));
					salDto.setLosal(rs.getInt("losal"));
					salDto.setHisal(rs.getInt("hisal"));
					ar.add(salDto);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					con.close();
					st.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			return ar;
		}
		//하나검색
		public SalgradeDTO getSelectOne(int grade) {
			
			DBConnecter dbc= new DBConnecter();
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			SalgradeDTO salDto = null;
			
			try {
				con  = dbc.dbconnecter();
				String sql = "select * from salgrade where grade = ?";
				st = con.prepareStatement(sql);
				st.setInt(1, grade);
				rs = st.executeQuery();
				
				if(rs.next()) {
					salDto = new SalgradeDTO();
					salDto.setGrade(rs.getInt("grade"));
					salDto.setLosal(rs.getInt("losal"));
					salDto.setHisal(rs.getInt("hisal"));
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					con.close();
					st.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			return salDto;
			
		}
}
