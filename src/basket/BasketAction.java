package basket;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import ms_AdminAction.StoreDAOAware;
import ms_AdminAction.ms_AdminDTO;
import basket.basketPaging;
import basket.ms_BasketDTO;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BasketAction extends ActionSupport implements Preparable, ModelDriven, StoreDAOAware{
	SqlMapClient sqlMapper;
	ms_BasketDTO paramClass;
	Map sessionMap;
	Calendar today = Calendar.getInstance();

	private List<ms_BasketDTO> list;
	private int currentPage = 1;  //현재 페이지
	private int totalCount;  //총게시물의 수
	private int blockCount = 10;  //한 페이지의 게시물수
	private int blockPage = 5; //한 화면에 보여줄 페이지의 수
	private String pagingHtml; //페이징을 구현한 HTML
	private basketPaging page;  //페이징 클래스
	private int sum = 0;
	
	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper= sqlMapper;
	}

	public String execute() throws Exception{

		return SUCCESS;
	}
	
	public void prepare() throws Exception {
		paramClass = new ms_BasketDTO();		
	}
	public Object getModel() {
		return paramClass;
	}
	
	//장바구니 LIST 액션
	public String basketlist() throws Exception{
		 
		    list = new ArrayList<ms_BasketDTO>(); 
			//모든글을 list에 넣고
			list = sqlMapper.queryForList("basketSelectAll"); //결과가 여러개일때 queryForList,결과가하나면 queryForObject
			totalCount = list.size(); //전체 글 갯수
			page = new basketPaging(currentPage, totalCount, blockCount, blockPage);//ms_PagingAction객체 생성
			pagingHtml = page.getPagingHtml().toString(); //페이지 HTML생성
			
			//현재 페이지에서 보여줄 마지막 글의 번호
			int lastCount = totalCount;
			//현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1번호로 설정
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() +1;
			//전체 리스트에서 현재 페이지만큼의 리스트만 가져옴
			list = list.subList(page.getStartCount(), lastCount);
			
			// 연동후 myid를 session으로 받아와서 아래에 매개변수로 넣어줘야함.
			
			//sum = (Integer)sqlMapper.queryForObject("basketSelectSum", );
			//paramClass 나 set,get메소드를 basketlist()내에 생성해서 사용해야함.
			//System.out.println(sum);
			
			//result.setM(Integer.parsent(getM()));
			/*for(int i=0; i<list.size(); i++){
				paramClass = list.get(i);
				int m_Aap = Integer.parseInt(paramClass.getM_Ap());

			}*/
			
			
			return SUCCESS;
	}
	
	public String insert() throws Exception{
		System.out.println("insert");
		
		paramClass.setBreg_Date(today.getTime());
		sqlMapper.insert("insertBasket",paramClass);
		return SUCCESS;
	}
	
	public String update() throws Exception{
		System.out.println("update");
		//paramClass.setM_Ea(m_Eq+"");
		System.out.println(paramClass.getM_Ea());
		try{
			sqlMapper.update("updateBasket",paramClass);
		}catch(Exception e){e.printStackTrace();}
		return SUCCESS;
	}
	
	public String deleteOne() throws Exception{

		paramClass = (ms_BasketDTO)sqlMapper.queryForObject("bk_selectOne", paramClass.getNo());
		sqlMapper.delete("deleteBasketOne",paramClass);
		System.out.println("deleteOne");
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		
		sqlMapper.delete("deleteBasket",paramClass.getMyid());
		System.out.println("delete");
		return SUCCESS;
	}



	public ms_BasketDTO getParamClass() {
		return paramClass;
	}
	public void setParamClass(ms_BasketDTO paramClass) {
		this.paramClass = paramClass;
	}
	
	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}
	public List<ms_BasketDTO> getList() {
		return list;
	}

	public void setList(List<ms_BasketDTO> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public basketPaging getPage() {
		return page;
	}

	public void setPage(basketPaging page) {
		this.page = page;
	}
}
