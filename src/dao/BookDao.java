package dao;

import java.util.List;

import bean.Book;

public interface BookDao {
	/**
	 * ��ȡ����ͼ��
	 * @return
	 */
	public List<Book> getAllBook();
	
	/**
	 * ���һ��ͼ��
	 * @param book ����Ҫ��ӵ�ͼ��
	 * @return true����ɹ�
	 */
	public boolean addBook(Book book);
	
	/**
	 * ɾ��һ��ͼ��
	 * @param book  Ҫɾ����ͼ�飬id
	 * @return
	 */
	public boolean delBook(Book book);
	
	/**
	 * �޸�һ��ͼ��   
	 * @param book  Ҫ�޸ĵ�ͼ�飬book���޸ĺ������
	 * @return
	 */
	public boolean updateBook(Book book);
	
	/**
	 * ����ͼ���id����ͼ��
	 * @param book  ����ͼ��id
	 * @return
	 */
	public Book getBook(Book book);
	
	/**
	 * ��ҳ����ͼ��ķ���
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Book> getPageList(int index,int size);
	
	
	public List<Book> getPageByTitle(int index,int size,String title);
	
	public List<Book> getPageByPrice(int index, int size,double minPrice,double maxPrice);
	
	/**
	 * ��ȡ����ͼ��ļ�¼��
	 * @return
	 */
	public int getTotalCount();
	
	public int getTotalCountByTitle(String title);
	
	public int getTotalCountByPrice(double minPrice,double maxPrice);
	
}
