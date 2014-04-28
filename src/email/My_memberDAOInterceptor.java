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

	private Reader reader;	//파일 스트림을 위한 reader.
	private SqlMapClient sqlMapper;
	
	public void destroy() {//힙 영역의 null객체로 명시->자원반납
		sqlMapper = null;
	}

	
	public void init(){//전처리 1번 dao 생성 
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		} catch (IOException e) {			e.printStackTrace();		} 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		try {			reader.close();		} 
		catch (IOException e) {		e.printStackTrace();		}
	}

	
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		Object action = invocation.getAction();
		//액션 호출기를 통해 전달된 액션이 오기 때문에 액션 받음
		//현재 adction객체가 daoaware구현한 객체인지 아닌지 구별 
		
		 if(action instanceof My_memberDAOAware){
			//dao주입
			My_memberDAOAware my_memberDAOAware = (My_memberDAOAware)action;
			my_memberDAOAware.setMy_memberDAO(sqlMapper);//dao할당
			
		}
		//만약에 다음 인터셉터가 있다면 다음 인터셉터 호출
		//현재 인터셉터가 마지막 인터셉터라며 액션을 호출 
		return invocation.invoke();
	}


	
	

}
