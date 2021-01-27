package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Page;
import service.BookService;
import service.impl.BookServiceImpl;

public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();

	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pn = request.getParameter("pn");
    	Page<Book> page = bookService.getPage(pn, "4");
    	page.setUrl("client/BookClientServlet?method=page");
    	//将第一页的数据放到页面显示
    	request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/booklist.jsp").forward(request, response);
	}
	

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String max = request.getParameter("max");
		String min = request.getParameter("min");
		String pn = request.getParameter("pn");
		Page<Book> page = bookService.getPageByPrice(pn, "4", max, min);
		page.setUrl("client/BookClientServlet?method=pageByPrice&max="+max+"&min="+min);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/pages/booklist.jsp").forward(request, response);
	}
	
	protected void pageByTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String pn = request.getParameter("pn");
		Page<Book> page = bookService.getPageByTitle(pn, "4", title);
		if(page.getTotalCount() == 0) {
			page = bookService.getPage(pn, "4");
		}
		page.setUrl("client/BookClientServlet?method=pageByTitle&title="+title);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/pages/booklist.jsp").forward(request, response);
	}

}
