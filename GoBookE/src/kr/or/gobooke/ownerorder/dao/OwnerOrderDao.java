package kr.or.gobooke.ownerorder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.or.gobooke.common.web.OwnerOrderParams;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * OwnerOrder 관련 Dao 주요 기능
 * 
 * @author 김수진
 */

public interface OwnerOrderDao {
	/** 기능은 따로 구현하시구 이 변수명들은 변경하지 말아주세요.*/
	
	/** 신규 등록 */
	public void create(OwnerOrder ownerOrder);
	
	/** 발주 리스트 조회 */
	public List<OwnerOrder> listByParams(OwnerOrderParams params);
	
	public OwnerOrder createOwnerOrder(ResultSet rs) throws SQLException;
	
	/**  전체 발주 수 */
	public int pageCount(OwnerOrderParams params);

}
