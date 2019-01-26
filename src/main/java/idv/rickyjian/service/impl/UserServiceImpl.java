package idv.rickyjian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.rickyjian.bean.UserBean;
import idv.rickyjian.dao.UserDAO;
import idv.rickyjian.service.UserService;
import idv.rickyjian.vo.UserAccount;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

//	登入驗證 商業邏輯
	@Override
	public boolean isAccountValid(String userName, String password) {
		UserBean userBean = new UserBean();
		userBean.setPassword(password);
		userBean.setUserName(userName);
		List<UserAccount> userList = userDAO.seach(userBean);
		if (userList.size()==1) {
			return true;
		}
		return false;
	}

	@Override
	public UserBean getById(String userName) {
		UserAccount user = userDAO.getById(userName);
		if (user!=null) {
			UserBean resultBean = new UserBean();
			resultBean.setPassword(user.getPassword());
			resultBean.setUserName(user.getUserName());
			resultBean.setGender(user.getGender());
			return resultBean;
		}
		return null;
	}


}
