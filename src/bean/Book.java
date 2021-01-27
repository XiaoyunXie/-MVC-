package bean;

import java.io.Serializable;

/**
 * 图书信息，属性包括id、标题、作者、出版社、价格、图片路径
 * @author 11361
 *
 */
public class Book implements Serializable{
	/**
	 * 图书id
	 */
	private Integer id = null;
	/**
	 * 图书标题
	 */
	private String title = null;
	/**
	 * 图书作者
	 */
	private String author = null;
	/**
	 * 图书出版社
	 */
	private String publisher = null;
	/**
	 * 图书价格
	 */
	private float price = 0.0F;
	
	/**
	 * 图书的图片路径,可以指定默认路径
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
