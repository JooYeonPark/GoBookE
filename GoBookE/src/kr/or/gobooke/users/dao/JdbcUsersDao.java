package kr.or.gobooke.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.users.domain.Users;

public class JdbcUsersDao implements UsersDao {

	// private ConnerctionFactory factory;
	private DataSource dataSource;
	private String[] keys = null;

	public JdbcUsersDao() {}
	
	public JdbcUsersDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getFactory() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String[] getKeys() {
		return keys;
	}

	@Override
	public void create(Users user) {
//		System.out.println("create진입");
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		String sql = "insert into users(id, name, passwd, email, telephone, job, message, regdate) " 
//		+ "values(?, ?, ?, ?, ?, ?, ?, sysdate)";
//
//		try {
//			con = dataSource.getConnection();
//			con.setAutoCommit(false);
//
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, user.getId());
//			pstmt.setString(2, user.getName());
//			pstmt.setString(3, user.getPassword());
//			pstmt.setString(4, user.getEmail());
//			pstmt.setString(5, user.getTelephone());
//			pstmt.setString(6, user.getAdress());
//			pstmt.setString(7, user.getAdressDetail());
//			pstmt.setDate(8, user.getRegdate());
//			pstmt.executeUpdate();
//
//			con.commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//			}
//
//			throw new BlogException("JdbcUserDao.create(Users) 실행중 예외 발생", e);
//
//		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
//		}

	}

//	@Override
//	public Users read(String id) {
//
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		ResultSet rs = null;
//
//		Users user = null;
//		String sql = "Select id, " + "       name, " + "       passwd, " + "       email, "
//				+ "       To_char(, 'YYYY/MM/DD')  " + "From   users " + "WHERE id = ?";
//		
//		try {
//			con = dataSource.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id);
//
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				user = createUser(rs);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//			}
//
//			throw new BlogException("JdbcUserDao.read(Id) 실행중 예외 발생", e);
//		}
//
//		return false;
//	}

//	@Override
//	public List<Users> listAll() {
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		List<Users> users = new ArrayList<Users>();
//		Users user = null;
//
//		String sql = "Select id, " + "       name, " + "       passwd, " + "       email, "
//				+ "       To_char(, 'YYYY/MM/DD')  " + "From   users";
//
//		
//		try {
//			con = dataSource.getConnection();
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//				users.add(createUser(rs));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//			}
//
//			throw new BlogException("JdbcUserDao.listAll() 실행중 예외 발생", e);
//		}
//
//		return users;
//	}

//	@Override
//	public List<Map<String, String>> employeeList() {
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//
//		String sql = "SELECT e.employee_id, " + "       e.last_name, " + "       TO_CHAR(e.salary, '$999,999') salary, "
//				+ "       m.last_name manager_name, " + "       d.department_name, " + "       l.city department_city "
//				+ "FROM   employees e " + "       LEFT OUTER join employees m "
//				+ "         ON ( e.manager_id = m.employee_id ) " + "       LEFT OUTER join departments d "
//				+ "         ON ( e.department_id = d.department_id ) " + "       LEFT OUTER join locations l "
//				+ "         ON( d.location_id = l.location_id ) " + "ORDER BY e.EMPLOYEE_ID";
//
//		
//		try {
//			con = dataSource.getConnection();
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int columnCount = rsmd.getColumnCount();
//
//			setKeys(rsmd);
//
//			while (rs.next()) {
//				Map<String, String> result = new HashMap<String, String>();
//
//				for (int i = 1; i <= columnCount; i++) {
//					result.put(rsmd.getColumnLabel(i), rs.getString(keys[i - 1]));
//				}
//				list.add(result);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//			}
//
//			throw new BlogException("JdbcUserDao.employeeList() 실행중 예외 발생", e);
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (stmt != null)
//					stmt.close();
//				if (con != null)
//					con.close(); // 커넥션풀에 반납
//			} catch (Exception e2) {
//			}
//		}
//
//		return list;
//	}

//	public void setKeys(ResultSetMetaData rsmd) {
//		int columnCount;
//
//		try {
//			columnCount = rsmd.getColumnCount();
//			keys = new String[columnCount];
//
//			for (int i = 0; i < columnCount; i++) {
//				keys[i] = rsmd.getColumnLabel(i + 1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
	public Users createUser(ResultSet rs) {
		Users user = null;
		try {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			String email = rs.getString("email");
			String telephone = rs.getString("telephone");
			String job = rs.getString("job");
			String message = rs.getString("message");
			String regdate = rs.getString("regdate");

			user = new Users(id, name, password, email, telephone, job, message, regdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public Users isMember(String id, String passwd) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;

		Users user = null;
		String sql = "Select user_id, " + "user_name, " + "user_telephone, " + "user_email, "
					+ "To_char(regdate, 'YYYY/MM/DD') user_regdate " + "From users " + "WHERE user_id = ? AND user_password = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = createUser(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			}

			throw new MallException("JdbcUserDao.isMember(Id) 실행중 예외 발생", e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)	pstmt.close();
				if(con != null)	con.close();
			}catch (Exception e2) {}
		}

		return user;
	}

	@Override
	public Users search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Users user) {
		// TODO Auto-generated method stub
		
	}

}