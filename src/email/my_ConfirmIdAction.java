package email;

import org.apache.struts2.interceptor.SessionAware;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class my_ConfirmIdAction extends ActionSupport  implements Preparable, ModelDriven<my_memberDTO>,My_memberDAOAware {

private SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private my_memberDTO my_memberdto; //파라미터를 저장할 객체
	
	
	
	public void setMy_memberDAO(SqlMapClient sqlMapper) {
    	this.sqlMapper=sqlMapper;
	}
	
	public my_memberDTO getModel() {//dto 호출 
		System.out.print("2");
	 return my_memberdto;
			         
	}
	  public void prepare() throws Exception{//생성
		  System.out.print("1");
      	my_memberdto = new my_memberDTO();
      }

	  public String execute() throws Exception{
		  System.out.print("3");
		 
		  my_memberdto = (my_memberDTO)sqlMapper.queryForObject("my_confirmId",my_memberdto );
		
	     return SUCCESS; 
}

	public my_memberDTO getMy_memberdto() {
		return my_memberdto;
	}

	public void setMy_memberdto(my_memberDTO my_memberdto) {
		this.my_memberdto = my_memberdto;
	}

}
