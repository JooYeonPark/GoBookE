package kr.or.gobooke.ownerorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * JDBC API를 이용한 OwnerOrder 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * @author 김수진
 */
public class JdbcOwnerOrderDao implements OwnerOrderDao{
	
private DataSource dataSource;
	
	public JdbcOwnerOrderDao() {}
	
	public JdbcOwnerOrderDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(OwnerOrder ownerOrder) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = " INSERT INTO owner_order " + 
					 "            (owner_order_no, " + 
					 "             owner_order_publisher, " + 
					 "             owner_order_bookname,  " + 
					 "             owner_order_qty,  " + 
					 "             owner_order_totalprice,  " + 
					 "             user_id)  " + 
					 " VALUES     (owner_order_no_seq.nextval,  " + 
					 "            ?,  " + //출판사  
					 "            ?, " +  // 책제목
					 "            ?,  " +  // 수량
					 "            ?,  " +  // 총가격
					 "            'bangry11' ) "; // 관리자 아이디 - 나중에 로그인 아이디 받아오기.
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ownerOrder.getPublisher());
			pstmt.setString(2, ownerOrder.getBookName());
			pstmt.setInt(3, ownerOrder.getQty());
			pstmt.setInt(4, ownerOrder.getTotalPrice());
			pstmt.executeUpdate();

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			}

			throw new MallException("JdbcUserDao.create(User) 실행중 예외 발생", e);

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public OwnerOrder search(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
}












