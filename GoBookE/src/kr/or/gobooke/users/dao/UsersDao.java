package kr.or.gobooke.users.dao;

import kr.or.gobooke.users.domain.OrderUser;
import kr.or.gobooke.users.domain.Users;

/**
 * Users관련 Dao 주요 기능
 * 
 * @author 박주연
 */

public interface UsersDao {
	
	/** 신규 사용자 등록 */
	public void create(Users user);
	
	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	public Users search(String userId);
	
	/** 회원정보 수정 */
	public void update(Users user);
	
	/** 회원 여부 반환 */
	public Users isMember(String id, String passwd);
	
	/** 회원 정보 반환 */
	public OrderUser getOrderUser(String userId);
	
}
