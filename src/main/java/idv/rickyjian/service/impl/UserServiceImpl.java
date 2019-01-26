package idv.rickyjian.service.impl;

import org.springframework.stereotype.Service;

import idv.rickyjian.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	登入驗證 商業邏輯
	@Override
	public boolean isAccountValid(String userName, String password) {
		if (userName.equals("ricky")&&password.equals("0123")) {
			return true;
		}
		return false;
	}

}
