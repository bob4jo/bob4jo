package basket;

import java.util.ArrayList;
import java.util.List;

import ms_AdminAction.StoreDAOAware;
import ms_AdminAction.ms_AdminDTO;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class Ms_MenuMainAction extends ActionSupport implements StoreDAOAware{
	private SqlMapClient sqlMapper;
	private List<ms_AdminDTO> list;
	public String execute() throws Exception{
		
		list = new ArrayList<ms_AdminDTO>(); 
		//모든글을 list에 넣고
		list = sqlMapper.queryForList("ms_SelectAll");
		return SUCCESS;
	}


	public void setStoreDAO(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}
	
	public SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
	public void setSqlMapper(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}
	public List<ms_AdminDTO> getList() {
		return list;
	}
	public void setList(List<ms_AdminDTO> list) {
		this.list = list;
	}

}

