
//생성자나 setter메소드를 사용해서 연관되는 객체를 인자로 보내서 생성 활용하는 것을 의미
//aware인터페이스는 현재 액션단에서 필욘 경우에만 사용 가능하도록 제약 
//dao를 생성하는 방법은 아무 액션에다가 dao를 주입하지 못하도록, 즉 필요한 액션에서만
//daoaware란 인터페이스를 사용하도록 하는 것이 핵심 

package email;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface My_memberDAOAware {
	public void setMy_memberDAO(SqlMapClient sqlMapper);
}
