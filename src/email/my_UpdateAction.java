package email;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.SessionAware;










import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class my_UpdateAction extends ActionSupport  implements Preparable, ModelDriven<my_memberDTO>,SessionAware,My_memberDAOAware {

	
	private SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	my_memberDTO my_memberdto; //파라미터를 저장할 객체
	Map session;
	HttpServletResponse response;
	HttpServletRequest request;
	
			
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
	  
	  
	  public String form() throws Exception{//생성
		  System.out.print("3");
		 
		
	       
		  
      	 return SUCCESS;
      }
	
			//회원가입 액션 
			public String execute() throws Exception{//인터셉터 한 뒤 실행
				ActionContext context = ActionContext.getContext();
				Map session = (Map) context.getSession();
			//String myid = (String)((HttpServletRequest)session).getAttribute("memId");
				
				//session.put("memId" , myid);
			sqlMapper.update("my_update", my_memberdto);
			
			System.out.print("3");
				   
			 return SUCCESS;
}

			public void setSession(Map map) {

		        this.session = map;

		    }


			
			public Map getSession() {
				return session;
			}


			public void setServletResponse(HttpServletResponse response) {
				this.response= response;
			}


			
			public void setServletRequest(HttpServletRequest request) {
				this.request = request;
			}
}
