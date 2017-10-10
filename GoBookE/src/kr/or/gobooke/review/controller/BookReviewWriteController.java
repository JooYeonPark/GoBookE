package kr.or.gobooke.review.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.review.domain.Review;
import kr.or.gobooke.review.service.ReviewService;
import kr.or.gobooke.review.service.ReviewServiceImpl;

public class BookReviewWriteController implements Controller {
		
	ReviewService reviewService=new ReviewServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav=new ModelAndView();
		String user_id=request.getParameter("userId");
		String message=request.getParameter("message");
		double grade=Double.parseDouble(request.getParameter("grade"));
		int book_no=Integer.parseInt(request.getParameter("book_no"));
		
//		System.out.println("받아옵니까?"+user_id+message+grade+book_no);
		
		Review review=new Review();
		review.setUserId(user_id);
		review.setMessage(message);
		review.setGrade(grade);
		review.setBookNo(book_no);
		
		int reviewCheck=reviewService.reviewWrite(review);
		
		if(reviewCheck>0) {
		System.out.println("밥먹으러 갑니다.");
		}
		/*mav.setView("/view/books/book_review.jsp");*/
		mav.setView("redirect:"+request.getContextPath()+"/review/bookreview.do?book_no="+book_no);
		return mav;
	}

}
