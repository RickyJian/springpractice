package idv.rickyjian.service;

import idv.rickyjian.bean.UserBean;

public interface UserService {

	public boolean isAccountValid(String userName ,String password);
	
	public UserBean getById(String userName);
	
}
