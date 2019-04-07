package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import com.javaex.vo.UserVo;

public class UserDao {

	private static UserDao instance = new UserDao();
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstm;

	private final String url = "jdbc:oracle:thin:@10.37.129.3:1521:xe";
	private final String username = "webdb";
	private final String password = "webdb";

	public UserDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static UserDao getInstance() {
		return instance;
	}

	private void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	

	public int insert(UserVo vo) {
		getConnection();
		
		int count = 0;
		try {
			String sql = "insert into users values (seq_users_no.nextval , ? ,? , ? , ?) ";

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getEmail());
			pstm.setString(3, vo.getPassword());
			pstm.setString(4, vo.getGender());

			count = pstm.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return count;
	}

	public UserVo getUser(String email, String password) {
		UserVo uservo = null;
		getConnection();
	
		try {
			pstm = conn.prepareStatement("select no, name from users where email=? and password = ? ");
			pstm.setString(1, email);
			pstm.setString(2, password);
			rs = pstm.executeQuery();

			while (rs.next()) {
				uservo = new UserVo();

				uservo.setNo(rs.getInt("no"));
				uservo.setName(rs.getString("name"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return uservo;
	}
	
	public int update(String name, String password, String gender, int no) {
		UserVo uservo = null;
		getConnection();
		int count = 0;
		
		try {
			pstm = conn.prepareStatement("update users set name = ?, password=?, gender=? where no=? ");
			pstm.setString(1, name);
			pstm.setString(2, password);
			pstm.setString(3, gender);
			pstm.setInt(4, no);
			count = pstm.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return count;
	}
}
