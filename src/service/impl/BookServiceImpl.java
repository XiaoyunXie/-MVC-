package service.impl;

import java.util.List;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImp;
import service.BookService;

/**
 * 图书业务逻辑实现
 * @author 11361
 *
 */
public class BookServiceImpl implements BookService{

	private BookDao bd = new BookDaoImp();
	//添加图书
	@Override
	public boolean add(Book book) {
		return bd.addBook(book);
	}

	//修改图书
	@Override
	public boolean update(Book book) {
		return bd.updateBook(book);
	}

	//删除图书
	@Override
	public boolean delete(Book book) {
		return bd.delBook(book);
	}

	//查找一本图书
	@Override
	public Book getOne(Book book) {
		return bd.getBook(book);
	}

	//查找所有图书
	@Override
	public List<Book> getAll() {
		return bd.getAllBook();
	}

	/**
	 * 获取分页数据
	 */
	@Override
	public Page<Book> getPage(String pageNo,String pageSize) {
		//将用户传入的数据先封装部分
		Page<Book> page = new Page<Book>();
		//将用户传入的数据转型并封装,设置默认值
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
		}
		try {
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
		}
		page.setPageSize(ps);
		//因为要使用totalCount（当前总记录数），所以还需要查数据库
		int totalCount = bd.getTotalCount();//获取总记录数
		page.setTotalCount(totalCount);
		page.setPageNo(pn);
		
		//查询数据并封装
		List<Book> list = bd.getPageList(page.getIndex(), page.getPageSize());
		page.setPageData(list);
		return page;
	}

	@Override
	public Page<Book> getPageByPrice(String pageNo, String pageSize, String maxPrice, String minPrice) {
		double min = 0.0;
		double max = Double.MAX_VALUE;
		Page<Book> page = new Page<Book>();
		try {
			min = Double.parseDouble(minPrice);
			max = Double.parseDouble(maxPrice);
		} catch (Exception e) {
		}
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
		}
		try {
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
		}
		//将页码和页面大小设置进page对象中
		page.setPageSize(ps);
		
		int count = bd.getTotalCountByPrice(min, max);
		page.setTotalCount(count);
		//这是最后设置的
		page.setPageNo(pn);
		//查询相应数据
		List<Book> list = bd.getPageByPrice(page.getIndex(), page.getPageSize(), min, max);
		
		page.setPageData(list);
		return page;
	}

	@Override
	public Page<Book> getPageByTitle(String pageNo, String pageSize, String title) {
		Page<Book> page = new Page<Book>();
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
		}
		try {
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
		}
		//将页码和页面大小设置进page对象中
		page.setPageSize(ps);
		int count = bd.getTotalCountByTitle(title);
		page.setTotalCount(count);
		//这是最后设置的
		page.setPageNo(pn);
		//查询相应数据
		List<Book> list = bd.getPageByTitle(page.getIndex(), page.getPageSize(), title);
		page.setPageData(list);
		return page;
	}

	
}
