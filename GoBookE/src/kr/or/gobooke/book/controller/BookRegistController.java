package kr.or.gobooke.book.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService2;
import kr.or.gobooke.book.service.BookServiceImpl2;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

/**
 * 책 등록
 * 
 * /book/bookregist 요청에 대한 세부 컨트롤러
 * @author 김수진
 *
 */
public class BookRegistController implements Controller {
	
	private BookServiceImpl2 bookService = new BookService2();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		//보관 클래스
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//업로드 클래스 선언
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = null;
		
		try {
			list = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> iter = list.iterator();
		
		Book book = new Book();
		HashMap<String, String> dataMap = new HashMap<String, String>();
		
		while (iter.hasNext()) {
			FileItem item = iter.next();

			if (item.isFormField()) { //text
	      
				String name = item.getFieldName();
				String value = null;
				try {
					value = item.getString("utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dataMap.put(name, value); //HashMap을 사용하여 밑의 내용이 간단해지면서 가독성이 좋아진다.
			} else { 

				if (item.getFieldName().equals("image")) {
					if (item.getName() == "" || item.getName() == null)
						continue;
					String fileName = item.getName();//파일명 중복시 덮어쓰기 방지(각각 다른 사람이 같은 이름의 파일을 올릴 수 있다.)

					upload.setFileSizeMax(1024 * 1024 * 10);
					long size = item.getSize();

					/*ServletContext context=request.getServletContext();
					String path=request.getContextPath();
					System.out.println("path : " + path);*/
					
					String path = "C:\\Users\\kosta\\Documents\\GoBookE\\GoBookE\\WebContent\\img\\books";
	                
					File file = new File(path, fileName);
					try {
						item.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					book.setImage(fileName);
				}
			}

		}
	    book.setDataMap(dataMap);
	    
	    String detail = book.getDetail();
	    String[] sp = detail.split("\r\n");
	    detail = sp[0];
	    for(int i = 1; i<sp.length; i++){
	    	detail += "<br>" +  sp[i] ;
	    }
	    book.setDetail(detail);
	    
		bookService.create(book);
		
		mav.setView("/view/admin/bookregist.jsp");
		
		return mav;
	}

}




