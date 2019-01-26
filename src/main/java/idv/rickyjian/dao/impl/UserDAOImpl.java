package idv.rickyjian.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import idv.rickyjian.bean.UserBean;
import idv.rickyjian.dao.UserDAO;
import idv.rickyjian.vo.UserAccount;

@Repository
public class UserDAOImpl extends BaseDAOImpl<UserAccount> implements UserDAO {


	@Override
	public List<UserAccount> seach(UserBean userBean) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserAccount.class);
		if(userBean!=null) {
			String userName = userBean.getUserName();
			String password = userBean.getPassword()
			if(userName!=null&&!userBean.equals("")) {
				detachedCriteria.add(Restrictions.eq("userName", userName));
			}
			if(password!=null&&!password.equals("")) {
				detachedCriteria.add(Restrictions.eq("password", password));
			}
		}
		return (List<UserAccount>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

}
