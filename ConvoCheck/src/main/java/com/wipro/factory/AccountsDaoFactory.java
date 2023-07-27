package com.wipro.factory;

import com.wipro.dao.AccountsDao;
import com.wipro.dao.AccountsDaoImpl;

public class AccountsDaoFactory {
	private static AccountsDao accDao = null;
	
	static {
		accDao = new AccountsDaoImpl();
	}
	
	public static AccountsDao getAccountsDaoObject() {
		return accDao;
	}
}
