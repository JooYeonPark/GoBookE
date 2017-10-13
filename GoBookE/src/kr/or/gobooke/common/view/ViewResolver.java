package kr.or.gobooke.common.view;

import javax.servlet.ServletException;

/**
 * View 선택 및 실행
 * @author 김수진
 *
 */
public class ViewResolver{
	
	public View resolve(String path) throws ServletException{
		View view = new JSPView(path);
		return view;
	}
}
