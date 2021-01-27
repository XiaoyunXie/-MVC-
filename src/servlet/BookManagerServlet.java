package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();
    
    /**
     * 显示分页数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//用户点击图书管理，显示部分数据，页码应该是用户传进来的
    	String pn = request.getParameter("pn");
    	Page<Book> page = bookService.getPage(pn, "4");
    	page.setUrl("manager/BookManagerServlet?method=page");
    	//将第一页的数据放到页面显示
    	request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/bookManage.jsp").forward(request, response);
    }
	
	/**
	 * 图书删除
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String pn = request.getParameter("pn");
		//代表我从哪里来
		String string = request.getHeader("Referer");
		Book book = WebUtils.param2bean2(request, new Book());
		//调用删除方法
		bookService.delete(book);
		//回到列表显示
		response.sendRedirect(string);
	}
	

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//按照id查出某本图书
		Book book = WebUtils.param2bean2(request, new Book());
		//获取详细信息
		Book one = bookService.getOne(book);
		//回到编辑页面进行显示
		request.setAttribute("book", one);
		request.getRequestDispatcher("/pages/bookInsert.jsp").forward(request, response);
	}
	
	/**
	 * 图书修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pn = request.getParameter("pn");
		Book newBook = WebUtils.param2bean2(request, new Book());
//		
//		bookService.update(newBook);
//		
//		//返回列表页面
//		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=list");
		//由于添加和修改操作，封装出的book的id有差别，所以可以通过id来断定是修改还是添加
		if(newBook.getId() == 0) {
			//添加
			bookService.add(newBook);
		}else {
			//修改
			bookService.update(newBook);
		}
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+pn);
	}
}
