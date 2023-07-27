package com.wipro.service;

import com.wipro.bean.Accounts;
import com.wipro.dao.AccountsDao;
import com.wipro.factory.AccountsDaoFactory;

public class AccountsServiceImpl implements AccountsService {

	@Override
	public String signUpUserService(Accounts acc) {
		AccountsDao accDao = AccountsDaoFactory.getAccountsDaoObject();
		String status = accDao.signUpUser(acc);
		return status;
	}

	@Override
	public String loginUserService(Accounts acc) {
		AccountsDao accDao = AccountsDaoFactory.getAccountsDaoObject();
		String status = accDao.loginUser(acc);
		return status;
	}

}
