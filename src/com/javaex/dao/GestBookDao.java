package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.GestBookVo;



public class GestBookDao {

	private final String url = "jdbc:oracle:thin:@10.37.129.3:1521:xe";


	public List<GestBookVo> getList() {
		// 0. import java.sql.*;

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		List<GestBookVo> list = new ArrayList<GestBookVo>();
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query ="select * from gestbook order by no desc ";

			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();	
			// 4.결과처리
			while(rs.next()) {
				
				int no=rs.getInt("no");
				String id=rs.getString("id");
				String password=rs.getString("password");
				String noticeBoard = rs.getString("notice_board");
				String nowdate = rs.getString("nowdate");
				
				GestBookVo vo = new GestBookVo(no,id,password,noticeBoard, nowdate); 
				list.add(vo);
			}
		
		} catch (ClassNotFoundException e)// TODO Auto-generated method stub
		{
			System.out.println("error:드라이버로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
// 5. 자원정리
			try {

				if (rs != null) {

					rs.close();

				}

				if (pstmt != null) {

					pstmt.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (SQLException e) {

				System.out.println("error:" + e);

			}
		}

		return list;
	}
	
	public int insert(GestBookVo vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int count=0;
			
			try {
				// 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. Connection 얻어오기
				conn = DriverManager.getConnection(url, "webdb", "webdb");
				// 3. SQL문 준비 / 바인딩 / 실행
				String query ="insert into gestbook " + 
						"    (no, " + 
						"    id, " + 
						"    password, " + 
						"    notice_board, " + 
						"    nowdate ) " + 
						"    values (seq_gestbook_no.nextval, " + 
						"     		 ?, " + 
						"            ?, " + 
						"            ?, " + 
						"              to_char(sysdate, 'yyyy-mm-dd hh24:mi;ss') ) ";
				
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getNoticBoard());
			

				count = pstmt.executeUpdate();
						// 4.결과처리
			

			} catch (ClassNotFoundException e)// TODO Auto-generated method stub
			{
				System.out.println("error:드라이버로딩 실패 - " + e);
			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {

	// 5. 자원정리

				try {
					

					if (pstmt != null) {

						pstmt.close();

					}

					if (conn != null) {

						conn.close();

					}

				} catch (SQLException e) {

					System.out.println("error:" + e);
								
				}
			}
		
			return count;
		}

	public int delete(GestBookVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count=0;
		
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query ="delete from gestbook where no = ? " ;

			
			
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, vo.getNo());

			count = pstmt.executeUpdate();
					// 4.결과처리
		

		} catch (ClassNotFoundException e)// TODO Auto-generated method stub
		{
			System.out.println("error:드라이버로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

// 5. 자원정리

			try {
				

				if (pstmt != null) {

					pstmt.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (SQLException e) {

				System.out.println("error:" + e);
							
			}
		}
	
		return count;
		
	}
}

