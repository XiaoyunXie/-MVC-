package service.impl;

import java.util.List;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImp;
import service.BookService;

/**
 * ͼ��ҵ���߼�ʵ��
 * @author 11361
 *
 */
public class BookServiceImpl implements BookService{

	private BookDao bd = new BookDaoImp();
	//���ͼ��
	@Override
	public boolean add(Book book) {
		return bd.addBook(book);
	}

	//�޸�ͼ��
	@Override
	public boolean update(Book book) {
		return bd.updateBook(book);
	}

	//ɾ��ͼ��
	@Override
	public boolean delete(Book book) {
		return bd.delBook(book);
	}

	//����һ��ͼ��
	@Override
	public Book getOne(Book book) {
		return bd.getBook(book);
	}

	//��������ͼ��
	@Override
	public List<Book> getAll() {
		return bd.getAllBook();
	}

	/**
	 * ��ȡ��ҳ����
	 */
	@Override
	public Page<Book> getPage(String pageNo,String pageSize) {
		//���û�����������ȷ�װ����
		Page<Book> page = new Page<Book>();
		//���û����������ת�Ͳ���װ,����Ĭ��ֵ
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
		//��ΪҪʹ��totalCount����ǰ�ܼ�¼���������Ի���Ҫ�����ݿ�
		int totalCount = bd.getTotalCount();//��ȡ�ܼ�¼��
		page.setTotalCount(totalCount);
		page.setPageNo(pn);
		
		//��ѯ���ݲ���װ
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
		//��ҳ���ҳ���С���ý�page������
		page.setPageSize(ps);
		
		int count = bd.getTotalCountByPrice(min, max);
		page.setTotalCount(count);
		//����������õ�
		page.setPageNo(pn);
		//��ѯ��Ӧ����
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
		//��ҳ���ҳ���С���ý�page������
		page.setPageSize(ps);
		int count = bd.getTotalCountByTitle(title);
		page.setTotalCount(count);
		//����������õ�
		page.setPageNo(pn);
		//��ѯ��Ӧ����
		List<Book> list = bd.getPageByTitle(page.getIndex(), page.getPageSize(), title);
		page.setPageData(list);
		return page;
	}

	
}
