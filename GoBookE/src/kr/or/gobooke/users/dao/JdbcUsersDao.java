package kr.or.gobooke.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import kr.or.gobooke.cart.dao.CartDao;
import kr.or.gobooke.cart.dao.JdbcCartDao;
import kr.or.gobooke.cart.domain.CartList;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.users.domain.OrderUser;
import kr.or.gobooke.users.domain.Users;

public class JdbcUsersDao implements UsersDao {

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
		
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append(" INSERT INTO users(user_id,    ");
		sb.append(" 				 user_name,    ");
		sb.append(" 				 user_telephone,    ");
		sb.append(" 				 user_email,    ");
		sb.append(" 				 user_address,    ");
		sb.append(" 				 user_address_detail,    ");
		sb.append(" 				 user_password,    ");
		sb.append(" 				 user_admin_flag,    ");
		sb.append(" 				 user_regdate)   ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?, 'N', sysdate)");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getTelephone());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getAddressDetail());
			pstmt.setString(7, user.getPassword());
			
			pstmt.executeUpdate();
			System.out.println("User Create Complated");
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUsersDao.create 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}

	}

	@Override
	public Users search(String userId) {

		Users user = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT user_id,  ");
		sb.append("		  user_name, ");
		sb.append("		  user_password, ");
		sb.append("		  user_email, ");
		sb.append("		  user_telephone, ");
		sb.append("		  user_address, ");
		sb.append("		  user_address_detail ");
		sb.append("FROM users  ");
		sb.append("WHERE user_id = ? ");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user = new Users(rs.getString("user_id"), rs.getString("user_name"),rs.getString("user_password"), 
						rs.getString("user_email"), rs.getString("user_telephone"), 
						rs.getString("user_address"), rs.getString("user_address_detail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUsersDao.search 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
				if(rs != null) rs.close();
			} catch (Exception e) {}
		}
		
		return user;
	}

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
	public Users createUser(ResultSet rs) throws SQLException {
		String uid = rs.getString("user_id");		
		String name = rs.getString("user_name");
		String telephone = rs.getString("user_telephone");
		String email = rs.getString("user_email");
		String address=rs.getString("user_address");
		String address_detail=rs.getString("user_address_detail");
		String passwd = rs.getString("user_password");
		String regdate=rs.getString("user_regdate");
		char adminFlag=rs.getString("user_admin_flag").charAt(0);
		
		Users user = new Users();
		user.setId(uid);
		user.setName(name);
		user.setTelephone(telephone);
		user.setEmail(email);
		user.setAddress(address);
		user.setAddressDetail(address_detail);
		user.setPassword(passwd);
		user.setRegdate(regdate);
		user.setAdminFlag(adminFlag);
		return user;
	}

	@Override
	public Users isMember(String id, String passwd) {
		Users user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select user_id,\r\n" + 
				"      user_name,\r\n" + 
				"      user_telephone,\r\n" + 
				"      user_email,\r\n" + 
				"      user_address,\r\n" + 
				"      user_address_detail,\r\n" + 
				"      user_password,\r\n" + 
				"      TO_CHAR(user_regdate, 'YYYY/MM/DD HH24:MI:SS') user_regdate,\r\n" + 
				"      user_admin_flag\r\n" + 
				"      from users where user_id=? and user_password=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id.trim());
			pstmt.setString(2, passwd.trim());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = createUser(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.isMember(id, passwd) 실행 중 예외발생", e);
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return user;
	}
	
	
	@Override
	/** 회원 정보 반환 */
	public OrderUser getOrderUser(String userId) {
		OrderUser orderUser = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT 	user_name, ");
		sb.append("			user_telephone, " );
		sb.append("			user_address, ");
		sb.append("			user_address_detail ");
		sb.append("FROM users ");
		sb.append("WHERE user_id = ? ");
		
		
		try {	
			connection = dataSource.getConnection();		
			pstmt = connection.prepareStatement(sb.toString());
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderUser = new OrderUser(rs.getString("user_name"), rs.getString("user_telephone"),
						rs.getString("user_address"),rs.getString("user_address_detail"));
			}
				
		}	catch(Exception e) {
			throw new RuntimeException("JdbcUsersDao.getUser Error!");
			
		}	finally {
			if(rs != null)
				try { rs.close(); } catch (SQLException e) {}
			if(pstmt != null) 	
				try { pstmt.close(); } catch (SQLException e) {}
			if(connection != null) 	
				try { connection.close(); } catch (SQLException e) {}
		}
		
		return orderUser;
	}

	@Override
	public void userUpdate(String passwd, String address, String addressDetail, String userId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String updateSql = " UPDATE users  "
				+ " SET user_password = ?, user_address = ?, user_address_detail = ?  "
				+ " WHERE user_id = ? ";
		
		try {
			con=dataSource.getConnection();	
			pstmt = con.prepareStatement(updateSql);
			
			pstmt.setString(1, passwd);
			pstmt.setString(2, address);
			pstmt.setString(3, addressDetail);
			pstmt.setString(4, userId);
			
			pstmt.executeUpdate();
			System.out.println("회원 정보 수정 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUsersDao.userUpdate 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}
	
	@Override
	/** 관리자 판별 */
	public Boolean isAdmin(String id) {
		Boolean flag = false;
		String str = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT 	user_admin_flag ");
		sb.append("FROM users ");
		sb.append("WHERE user_id = ? ");
		
		try {	
			connection = dataSource.getConnection();		
			pstmt = connection.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				str = rs.getString("user_admin_flag");
			}

			if((str.trim()).equals("Y")) {
				flag = true;
			}
				
		}	catch(Exception e) {
			throw new RuntimeException("JdbcUsersDao.isAdmin Error!");
			
		}	finally {
			if(rs != null)
				try { rs.close(); } catch (SQLException e) {}
			if(pstmt != null) 	
				try { pstmt.close(); } catch (SQLException e) {}
			if(connection != null) 	
				try { connection.close(); } catch (SQLException e) {}
		}
		
		return flag;
	}
	
}