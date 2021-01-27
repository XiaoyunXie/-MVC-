package bean;

import java.io.Serializable;

/**
 * ͼ����Ϣ�����԰���id�����⡢���ߡ������硢�۸�ͼƬ·��
 * @author 11361
 *
 */
public class Book implements Serializable{
	/**
	 * ͼ��id
	 */
	private Integer id = null;
	/**
	 * ͼ����⢘
	 */
	private String title = null;
	/**
	 * ͼ������
	 */
	private String author = null;
	/**
	 * ͼ�������
	 */
	private String publisher = null;
	/**
	 * ͼ��۸�
	 */
	private float price = 0.0F;
	
	/**
	 * ͼ���ͼƬ·��,����ָ��Ĭ��·��
	 */
	private String imgPath = "static/img/default.jpg";
	
	public Book() {	
	}

	public Book(Integer id, String title, String author, String publisher, float price,String imgPath) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		if (imgPath != null)
			this.imgPath = imgPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", imgPath=" + imgPath + "]";
	}

	
	
	
	
	
}
