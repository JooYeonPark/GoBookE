package kr.or.gobooke.users.service;

import java.util.List;

import kr.or.gobooke.users.domain.Users;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author 김수진
 *
 */
public interface UsersService {
	/** 등록은 create 수정은 update 삭제는 delete 조회는 read */
	
	/** 기능은 따로 구현하시구 이변수명들은 변경하지 말아주세요.
	 *  필요 기능은 추가해주시면 됩니다.
	 */
	
	/** 신규 사용자 등록 */
	public void create(Users user);
	
	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	public Users search(String id);
	
	/** 회원정보 수정 */
	public void update(Users user);
	
	/** 회원 여부 반환 */
	public Users isMember(String id, String passwd);
	
}
