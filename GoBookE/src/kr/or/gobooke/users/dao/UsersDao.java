package kr.or.gobooke.users.dao;

import kr.or.gobooke.users.domain.Users;

/**
 * Users관련 Dao 주요 기능
 * 
 * @author 김수진
 */

public interface UsersDao {
	/** 등록은 create 수정은 update 삭제는 delete 조회는 read */
	/** 기능은 따로 구현하시구 이변수명들은 변경하지 말아주세요.*/
	
	/** 신규 사용자 등록 */
	public void create(Users user);
	
	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	public Users search(String id);
	
	/** 회원정보 수정 */
	public void update(Users user);
	
	/** 회원 여부 반환 */
	public Users isMember(String id, String passwd);
	
}
