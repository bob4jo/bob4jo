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
	SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	my_memberDTO my_memberdto; //�Ķ���͸� ������ ��ü

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
	
	  public Object getModel() {//dtoȣ��
		  System.out.print("2");
		  return my_memberdto;
      	
      }
	  public void prepare() throws Exception{//����
		  System.out.print("1");
      	my_memberdto = new my_memberDTO();
      }
	
			//ȸ������ �׼� 
			
	  
	  public String form() throws Exception{//���ͼ��� �� �� ����
			
	
			 return SUCCESS;
			}
	  
	  
	  
	  
	  
	  
	  public String execute() throws Exception{//���ͼ��� �� �� ����
				my_memberdto.setReg_date(today.getTime());
				System.out.print("3");
			
				
			
				//��� ���� ����
				sqlMapper.insert("my_input", my_memberdto);
				
	
			 return SUCCESS;
			}
			
			
			
			//setter �ܺ��� ���� ������ �� �ֵ��� �ϰ� �� ���� ���� ������ ������� ���ϵ��� �ϱ� ���� setter����
			//getter ����ϱ⸸ �ϰ� ������ ���� readonly
	
   
      
 }
			
