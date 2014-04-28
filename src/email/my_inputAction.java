package email;

import email.my_memberDTO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sun.jmx.snmp.Timestamp;

import java.util.*;

public class my_inputAction extends ActionSupport implements My_memberDAOAware,Preparable,ModelDriven{

	Calendar today = Calendar.getInstance();
	SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	my_memberDTO my_memberdto; //파라미터를 저장할 객체

			/*
			 * private String myid;
			private String passwd;
			private String myname;
			private String gender;
			private String year1;
			private String month1;
			private String date1;
			private String email;
			private String hp1;
			private String hp2;
			private String hp3;
			private Timestamp reg_date;*/
	
	public my_memberDTO getMy_memberdto() {
		return my_memberdto;
	}

	public void setMy_memberdto(my_memberDTO my_memberdto) {
		this.my_memberdto = my_memberdto;
	}


	public void setMy_memberDAO(SqlMapClient sqlMapper) {
    	this.sqlMapper=sqlMapper;
	}
	
	  public Object getModel() {//dto호출
		  System.out.print("2");
		  return my_memberdto;
      	
      }
	  public void prepare() throws Exception{//생성
		  System.out.print("1");
      	my_memberdto = new my_memberDTO();
      }
	
			//회원가입 액션 
			
	  
	  public String form() throws Exception{//인터셉터 한 뒤 실행
			
	
			 return SUCCESS;
			}
	  
	  
	  
	  
	  
	  
	  public String execute() throws Exception{//인터셉터 한 뒤 실행
				my_memberdto.setReg_date(today.getTime());
				System.out.print("3");
			
				
			
				//등록 쿼리 수행
				sqlMapper.insert("my_input", my_memberdto);
				
	
			 return SUCCESS;
			}
			
			
			
			//setter 외부의 값을 변경할 수 있도록 하고 이 값을 직접 가져다 사용하지 못하도록 하기 위해 setter정의
			//getter 사용하기만 하고 변경은 못함 readonly
	
   
      
 }
			
