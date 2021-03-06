package kr.or.gobooke.book.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

/**
 *
 * 베스트셀러 요청 컨트롤러
 * @author 박성준
 *
 */
public class BookBestSellerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav=new ModelAndView();
		mav.setView("/view/books/bestseller.jsp");
		return mav;
	}

}
