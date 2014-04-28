package email;

import java.io.IOException;

import java.io.Reader;

import email.My_memberDAOAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class My_memberDAOInterceptor implements Interceptor {

	private Reader reader;	//���� ��Ʈ���� ���� reader.
	private SqlMapClient sqlMapper;
	
	public void destroy() {//�� ������ null��ü�� ���->�ڿ��ݳ�
		sqlMapper = null;
	}

	
	public void init(){//��ó�� 1�� dao ���� 
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		} catch (IOException e) {			e.printStackTrace();		} 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		try {			reader.close();		} 
		catch (IOException e) {		e.printStackTrace();		}
	}

	
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		Object action = invocation.getAction();
		//�׼� ȣ��⸦ ���� ���޵� �׼��� ���� ������ �׼� ����
		//���� adction��ü�� daoaware������ ��ü���� �ƴ��� ���� 
		
		 if(action instanceof My_memberDAOAware){
			//dao����
			My_memberDAOAware my_memberDAOAware = (My_memberDAOAware)action;
			my_memberDAOAware.setMy_memberDAO(sqlMapper);//dao�Ҵ�
			
		}
		//���࿡ ���� ���ͼ��Ͱ� �ִٸ� ���� ���ͼ��� ȣ��
		//���� ���ͼ��Ͱ� ������ ���ͼ��Ͷ�� �׼��� ȣ�� 
		return invocation.invoke();
	}


	
	

}
