package bean;
import java.util.List;
/**
 * ��ҳģ��
 * @author 11361
 * @param <T>
 */
public class Page<T> {
	//��ǰ�ǵڼ�ҳ
	private int pageNo;
	
	//��ҳ��
	private int totalPage;
	
	//�ܼ�¼��
	private int totalCount;
	
	//ÿҳ��ʾ���������������ݿ⣬һ�β�4����¼
	private int pageSize = 4;
	
	//�������ݿ���ĸ�������ʼ��
	private int index;
	
	//�Ƿ�����һҳ
	private boolean hasNext;
	
	//�Ƿ�����һҳ
	private boolean hasPrev;
	
	//��װ�˲�ѯ���ķ�ҳ����
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
		//service��������pageNo֮ǰҪ������totalCount��PageSize
		pageNo = pageNo>getTotalPage()?getTotalPage():pageNo;
		this.pageNo = pageNo;
	}

	//��ȡ��ҳ��
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

	//����ó�����ֵ
	public int getIndex() {
		/**
		 * ҳ��    ��ʼ    ����
		 * 1      0    3
		 * 2      4    7
		 * 3      8    11
		 */
		int i = (getPageNo() - 1)*getPageSize();
		if(i<0) i=0;
		return i;
	}

	//�ж��Ƿ�����һ�������ݵ�ǰҳ���ж�
	public boolean isHasNext() {
		return getPageNo() < getTotalPage();
	}

	//�ж��Ƿ�����һ��
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
