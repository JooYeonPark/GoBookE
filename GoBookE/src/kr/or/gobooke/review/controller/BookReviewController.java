package kr.or.gobooke.review.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.common.web.PageBuilder;
import kr.or.gobooke.common.web.Params;
import kr.or.gobooke.review.domain.Review;
import kr.or.gobooke.review.service.ReviewService;
import kr.or.gobooke.review.service.ReviewServiceImpl;

public class BookReviewController implements Controller {

		ReviewService reviewService=new ReviewServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav=new ModelAndView();
		
		//int book_no=Integer.parseInt(request.getParameter("book_no"));
		
		int pageSize = 10;
		int pageNum = 10;
		
		String type = "book_no";
		String value = request.getParameter("book_no");
		
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		int pageCount = Integer.parseInt(page);
		
		Params params=new Params();
		params.setPage(pageCount);
		params.setPageSize(pageSize);
		params.setPageNum(pageNum);
		params.setType(type);
		params.setValue(value);
		
		
		List<Review> reviewList=reviewService.getReviewList(params);
		int rowCount = reviewService.pageCount(params);
		
		PageBuilder pageBuilder=new PageBuilder(params,rowCount);
		pageBuilder.build();
		
		mav.addObject("bookNo", value);
		mav.addObject("list", reviewList);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);
		
		mav.setView("/view/books/book_review.jsp");
		
		return mav;
	}

}
