package kr.or.gobooke.review.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.review.service.ReviewService;
import kr.or.gobooke.review.service.ReviewServiceImpl;

public class BookReviewDeleteController implements Controller {
	ReviewService reviewService=new ReviewServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav=new ModelAndView();
		int review_no=Integer.parseInt(request.getParameter("no"));
		int book_no=Integer.parseInt(request.getParameter("book_no"));
		System.out.println("request값받아옴?"+review_no);
		int reviewDeleteCheck=reviewService.deleteReview(review_no);
		System.out.println("삭제됨?"+reviewDeleteCheck);
		
		/*mav.setView("/view/books/book_review.jsp");*/
		mav.setView("redirect:"+request.getContextPath()+"/review/bookreview.do?book_no="+book_no);
		return mav;
	}

}
