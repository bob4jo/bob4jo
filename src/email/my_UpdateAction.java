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

	
	private SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	my_memberDTO my_memberdto; //�Ķ���͸� ������ ��ü
	Map session;
	HttpServletResponse response;
	HttpServletRequest request;
	
			
	public void setMy_memberDAO(SqlMapClient sqlMapper) {
    	this.sqlMapper=sqlMapper;
	}
	
	public my_memberDTO getModel() {//dto ȣ�� 
		System.out.print("2");
	 return my_memberdto;
			         
	}
	  public void prepare() throws Exception{//����
		  System.out.print("1");
      	my_memberdto = new my_memberDTO();
      }
	  
	  
	  public String form() throws Exception{//����
		  System.out.print("3");
		 
		
	       
		  
      	 return SUCCESS;
      }
	
			//ȸ������ �׼� 
			public String execute() throws Exception{//���ͼ��� �� �� ����
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
