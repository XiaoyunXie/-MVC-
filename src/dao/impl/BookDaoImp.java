package dao.impl;

import java.util.List;

import bean.Book;
import dao.BaseDao;
import dao.BookDao;

public class BookDaoImp extends BaseDao<Book> implements BookDao{

	@Override
	public List<Book> getAllBook() {
		String sql = "select id,title,author,publisher,price,img_path as imgPath from bs_book";
		//返回所有图书
		return getBeans(sql);
	}

	//添加图书
	@Override
	public boolean addBook(Book book) {
		String sql = "insert into bs_book(title,author,publisher,price,img_path) values (?,?,?,?,?)";
		int update = update(sql, book.getTitle(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getImgPath());
		return update > 0;
	}

	//删除图书
	@Override
	public boolean delBook(Book book) {
		String sql = "delete from bs_book where id = ?";
		int update = update(sql, book.getId());
		return update > 0;
	}

	//修改图书
	@Override
	public boolean updateBook(Book book) {
		//需要修改
		String sql = "update bs_book set title=?,author=?,publisher=?,price=?,img_path=? where id=?";
		int update = update(sql, book.getTitle(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getImgPath(),book.getId());
		return update > 0;
	}

	@Override
	public Book getBook(Book book) {
		String sql = "select id,title,author,publisher,price,img_path as imgPath from bs_book where id = ?";
		return getBean(sql, book.getId());
	}

	@Override
	public List<Book> getPageList(int index, int size) {
		String sql = "select id,title,author,publisher,price,img_path as imgPath from bs_book limit ?,?";
		return getBeans(sql, index,size);
	}
	
	/**
	 * 根据图书价格查询图书
	 * @param index
	 * @param size
	 * @param maxPrice    最大价格
	 * @param minPrice    最小价格
	 * @return
	 */
	@Override
	public List<Book> getPageByPrice(int index, int size,double minPrice,double maxPrice) {
		String sql = "select id,title,author,publisher,price,img_path as imgPath from bs_book where price between ? and ? limit ?,?";
		return getBeans(sql,minPrice,maxPrice,index,size);
	}

	/**
	 * 根据图书标题查询图书
	 */
	@Override
	public List<Book> getPageByTitle(int index, int size, String title) {
		String sql = "select id,title,author,publisher,price,img_path as imgPath from bs_book where title = ?";
		return getBeans(sql, title);
	}
	
	
	@Override
	public int getTotalCount() {
		String sql = "select count(*) from bs_book";
		Object object = getSingleValue(sql);
		int parseInt = 0;
		try {
			parseInt = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return parseInt;
	}

	/**
	 * 根据图书价格查找出相应的记录数
	 */
	@Override
	public int getTotalCountByPrice(double minPrice, double maxPrice) {
		String sql = "select count(*) from bs_book where price between ? and ?";
		Object object = getSingleValue(sql, minPrice,maxPrice);
		int i = 0;
		try {
			i = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public int getTotalCountByTitle(String title) {
		String sql = "select count(*) from bs_book where title = ?";
		Object object = getSingleValue(sql, title);
		int i = 0;
		try {
			i = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}



}
