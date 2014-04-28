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
	private int currentPage = 1;  //���� ������
	private int totalCount;  //�ѰԽù��� ��
	private int blockCount = 10;  //�� �������� �Խù���
	private int blockPage = 5; //�� ȭ�鿡 ������ �������� ��
	private String pagingHtml; //����¡�� ������ HTML
	private basketPaging page;  //����¡ Ŭ����
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
	
	//��ٱ��� LIST �׼�
	public String basketlist() throws Exception{
		 
		    list = new ArrayList<ms_BasketDTO>(); 
			//������ list�� �ְ�
			list = sqlMapper.queryForList("basketSelectAll"); //����� �������϶� queryForList,������ϳ��� queryForObject
			totalCount = list.size(); //��ü �� ����
			page = new basketPaging(currentPage, totalCount, blockCount, blockPage);//ms_PagingAction��ü ����
			pagingHtml = page.getPagingHtml().toString(); //������ HTML����
			
			//���� ���������� ������ ������ ���� ��ȣ
			int lastCount = totalCount;
			//���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1��ȣ�� ����
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() +1;
			//��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� ������
			list = list.subList(page.getStartCount(), lastCount);
			
			// ������ myid�� session���� �޾ƿͼ� �Ʒ��� �Ű������� �־������.
			
			//sum = (Integer)sqlMapper.queryForObject("basketSelectSum", );
			//paramClass �� set,get�޼ҵ带 basketlist()���� �����ؼ� ����ؾ���.
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
