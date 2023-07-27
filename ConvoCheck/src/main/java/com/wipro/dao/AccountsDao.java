package com.wipro.dao;

import com.wipro.bean.Accounts;

public interface AccountsDao {
	public String signUpUser(Accounts acc);
	public String loginUser(Accounts acc);
}
