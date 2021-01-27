package dao.impl;

import java.util.List;

import bean.Book;
import dao.BaseDao;
import dao.BookDao;

public class BookDaoImp extends BaseDao<Book> implements BookDao{

	@Override
	public List<Book> getAllBook() {
		String sql = "select id,title,author,publisher,price,img_path as imgPath from bs_book";
		//��������ͼ��
		return getBeans(sql);
	}

	//���ͼ��
	@Override
	public boolean addBook(Book book) {
		String sql = "insert into bs_book(title,author,publisher,price,img_path) values (?,?,?,?,?)";
		int update = update(sql, book.getTitle(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getImgPath());
		return update > 0;
	}

	//ɾ��ͼ��
	@Override
	public boolean delBook(Book book) {
		String sql = "delete from bs_book where id = ?";
		int update = update(sql, book.getId());
		return update > 0;
	}

	//�޸�ͼ��
	@Override
	public boolean updateBook(Book book) {
		//��Ҫ�޸�
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
	 * ����ͼ��۸��ѯͼ��
	 * @param index
	 * @param size
	 * @param maxPrice    ���۸�
	 * @param minPrice    ��С�۸�
	 * @return
	 */
	@Override
	public List<Book> getPageByPrice(int index, int size,double minPrice,double maxPrice) {
		String sql = "select id,title,author,publisher,price,img_path as imgPath from bs_book where price between ? and ? limit ?,?";
		return getBeans(sql,minPrice,maxPrice,index,size);
	}

	/**
	 * ����ͼ������ѯͼ��
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
	 * ����ͼ��۸���ҳ���Ӧ�ļ�¼��
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
