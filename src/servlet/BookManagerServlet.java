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
     * ��ʾ��ҳ����
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//�û����ͼ�������ʾ�������ݣ�ҳ��Ӧ�����û���������
    	String pn = request.getParameter("pn");
    	Page<Book> page = bookService.getPage(pn, "4");
    	page.setUrl("manager/BookManagerServlet?method=page");
    	//����һҳ�����ݷŵ�ҳ����ʾ
    	request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/bookManage.jsp").forward(request, response);
    }
	
	/**
	 * ͼ��ɾ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String pn = request.getParameter("pn");
		//�����Ҵ�������
		String string = request.getHeader("Referer");
		Book book = WebUtils.param2bean2(request, new Book());
		//����ɾ������
		bookService.delete(book);
		//�ص��б���ʾ
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
		//����id���ĳ��ͼ��
		Book book = WebUtils.param2bean2(request, new Book());
		//��ȡ��ϸ��Ϣ
		Book one = bookService.getOne(book);
		//�ص��༭ҳ�������ʾ
		request.setAttribute("book", one);
		request.getRequestDispatcher("/pages/bookInsert.jsp").forward(request, response);
	}
	
	/**
	 * ͼ���޸�
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
//		//�����б�ҳ��
//		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=list");
		//������Ӻ��޸Ĳ�������װ����book��id�в�����Կ���ͨ��id���϶����޸Ļ������
		if(newBook.getId() == 0) {
			//���
			bookService.add(newBook);
		}else {
			//�޸�
			bookService.update(newBook);
		}
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+pn);
	}
}
