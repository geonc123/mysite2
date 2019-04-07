package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.GeustBookVo;
import com.javaex.vo.UserVo;

public class GeustDao {
	private static GeustDao instance = new GeustDao();
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstm;

	private final String url = "jdbc:oracle:thin:@10.37.129.3:1521:xe";
	private final String username = "webdb";
	private final String password = "webdb";

	public GeustDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static GeustDao getInstance() {
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

	// 이런식으로 쓰자
	public List<GeustBookVo> getList() {
		getConnection();
		List<GeustBookVo> list = new ArrayList<GeustBookVo>();
		try {
			System.out.println("쿼리문 실행 ");
			pstm = conn.prepareStatement("select g.no as no, g.title as title, g.content as content"
					+ ", g.hit as hit, g.reg_date as reg_date, g.user_no as user_no , u.name as name "
					+ "	 from users u join geustbook g on u.no=g.user_no order by g.no desc ");
			rs = pstm.executeQuery();
			while (rs.next()) {

				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String reg_date = rs.getString("reg_date");
				int user_no = rs.getInt("user_no");
				String name = rs.getString("name");

				GeustBookVo vo = new GeustBookVo(no, title, content, hit, reg_date, user_no, name);
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return list;
	}

	public int delete(int no) {
		getConnection();
		try {
			System.out.println("쿼리문 실행 ");
			pstm = conn.prepareStatement(" delete from geustbook where no=? ");
			pstm.setInt(1, no);
			rs = pstm.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return 0;
	}

	public GeustBookVo getVo(int no) {
		getConnection();
		GeustBookVo vo = null;
		try {
			pstm = conn.prepareStatement(" select title, content, user_no from geustbook where no = ? ");
			pstm.setInt(1, no);

			rs = pstm.executeQuery();
			
			
			while (rs.next()) {
			vo = new GeustBookVo();

			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setUser_no(rs.getInt("user_no"));
			vo.setNo(no);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return vo;
	}

	public int modify(String title, String content, int no, int user_no) {
		getConnection();
		try {
			System.out.println("쿼리문 실행 ");
			pstm = conn.prepareStatement(
					"update geustbook set content = ? , title = ?  where no=? and user_no=?");

			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setInt(3, user_no);
			rs = pstm.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return 0;
	}

	public int insert(String title, String context, int user_no) {
		getConnection();
		try {
			System.out.println("쿼리문 실행 ");
			pstm = conn.prepareStatement("	insert into geustbook values ( SEQ_GEUST_NO.nextval,?,?,1, "
					+ " to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') , ? )");

			pstm.setString(1, title);
			pstm.setString(2, context);
			pstm.setInt(3, user_no);
			rs = pstm.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return 0;
	}

	public int addList() {
		return 0;
	}

	public int upHit(int no) {
		
		getConnection();
		try {
			System.out.println("쿼리문 실행 ");
			pstm = conn.prepareStatement("update geustbook set hit= hit+1 where no=?");
			pstm.setInt(1, no);
			rs = pstm.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		System.out.println("up hit !!!!");
		return 0;
	}

}
