
//�����ڳ� setter�޼ҵ带 ����ؼ� �����Ǵ� ��ü�� ���ڷ� ������ ���� Ȱ���ϴ� ���� �ǹ�
//aware�������̽��� ���� �׼Ǵܿ��� �ʿ� ��쿡�� ��� �����ϵ��� ���� 
//dao�� �����ϴ� ����� �ƹ� �׼ǿ��ٰ� dao�� �������� ���ϵ���, �� �ʿ��� �׼ǿ�����
//daoaware�� �������̽��� ����ϵ��� �ϴ� ���� �ٽ� 

package email;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface My_memberDAOAware {
	public void setMy_memberDAO(SqlMapClient sqlMapper);
}
