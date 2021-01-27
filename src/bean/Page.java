package bean;
import java.util.List;
/**
 * 分页模型
 * @author 11361
 * @param <T>
 */
public class Page<T> {
	//当前是第几页
	private int pageNo;
	
	//总页数
	private int totalPage;
	
	//总记录数
	private int totalCount;
	
	//每页显示的条数，告诉数据库，一次查4条记录
	private int pageSize = 4;
	
	//告诉数据库从哪个索引开始查
	private int index;
	
	//是否有下一页
	private boolean hasNext;
	
	//是否有上一页
	private boolean hasPrev;
	
	//封装了查询出的分页数据
	private List<T> pageData;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		pageNo = pageNo>0?pageNo:1;
		//service中在设置pageNo之前要先设置totalCount和PageSize
		pageNo = pageNo>getTotalPage()?getTotalPage():pageNo;
		this.pageNo = pageNo;
	}

	//获取总页数
	public int getTotalPage() {
		int t = getTotalCount()/getPageSize();
		if(!(getTotalCount()%getPageSize()==0)) {
			t = t + 1;
		}
		
		return t;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	//计算得出索引值
	public int getIndex() {
		/**
		 * 页码    开始    结束
		 * 1      0    3
		 * 2      4    7
		 * 3      8    11
		 */
		int i = (getPageNo() - 1)*getPageSize();
		if(i<0) i=0;
		return i;
	}

	//判断是否有下一个，根据当前页码判断
	public boolean isHasNext() {
		return getPageNo() < getTotalPage();
	}

	//判断是否有上一个
	public boolean isHasPrev() {
		return getPageNo() > 1;
	}


	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int pageNo, int totalPage, int totalCount, int pageSize, int index, boolean hasNext, boolean hasPrev,
			List<T> pageData) {
		super();
		this.pageNo = pageNo;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.index = index;
		this.hasNext = hasNext;
		this.hasPrev = hasPrev;
		this.pageData = pageData;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", pageSize="
				+ pageSize + ", index=" + index + ", hasNext=" + hasNext + ", hasPrev=" + hasPrev + ", pageData="
				+ pageData + "]";
	}
	
	
}
