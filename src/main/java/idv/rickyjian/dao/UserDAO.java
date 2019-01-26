package idv.rickyjian.dao;

import java.util.List;

import idv.rickyjian.bean.UserBean;
import idv.rickyjian.vo.UserAccount;

public interface UserDAO extends BaseDAO<UserAccount> {
	
	public List<UserAccount> seach(UserBean userBean);

}
