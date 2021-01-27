package service;

import java.util.List;

import bean.Book;
import bean.Page;

/**
 * ͼ��ҵ���߼�
 * @author 11361
 *
 */
public interface BookService {
	
	/**
	 * ���ͼ��
	 * @param book  Ҫ��ӵ�ͼ��
	 * @return   true��ӳɹ�
	 */
	public boolean add(Book book);
	
	/**
	 * �޸�ͼ��
	 * @param book   Ҫ�޸ĵ�ͼ��  ����id�޸���������
 	 * @return    true�޸ĳɹ�
	 */
	public boolean update(Book book);
	
	/**
	 * ɾ��ͼ��
	 * @param book  Ҫɾ����ͼ�� ����idɾ��
	 * @return   
	 */
	public boolean delete(Book book);
	
	/**
	 * ��ȡһ��ͼ��
	 * @param book Ҫ���ҵ�ͼ�� ��id��
	 * @return  ����Book����
	 */
	public Book getOne(Book book);
	
	/**
	 * ��ѯ������ͼ��
	 * @return ���ص���һ��List<Book>
	 */
	public List<Book> getAll();
	
	/**
	 * ���ط�ҳ����
	 * @return
	 */
	public Page<Book> getPage(String pageNo,String pageSize);
	
	/**
	 * ���ռ۸����ͼ��
	 * @param pageNo
	 * @param pageSize
	 * @param maxPrice
	 * @param minPrice
	 * @return
	 */
	public Page<Book> getPageByPrice(String pageNo,String pageSize,String maxPrice,String minPrice);
	
	/**
	 * ���ձ������ͼ��
	 * @param pageNo
	 * @param pageSize
	 * @param title
	 * @return
	 */
	public Page<Book> getPageByTitle(String pageNo,String pageSize,String title);
}
