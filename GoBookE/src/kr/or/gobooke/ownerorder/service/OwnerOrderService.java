package kr.or.gobooke.ownerorder.service;

import java.util.List;

import kr.or.gobooke.common.web.OwnerOrderParams;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author 김수진
 *
 */
public interface OwnerOrderService {
/** 기능은 따로 구현하시구 이변수명들은 변경하지 말아주세요.*/
	
	/** 신규 등록 */
	public void create(OwnerOrder ownerOrder);
	
	/** 상세 정보 조회 */
	public OwnerOrder search(int no);
	
	/** 발주 전체 리스트 */
	public List<OwnerOrder> listByParams(OwnerOrderParams params);
	
	/** 전체 발주 수 */
	public int pageCount(OwnerOrderParams params);

}
