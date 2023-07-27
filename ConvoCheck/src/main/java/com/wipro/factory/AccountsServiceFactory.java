package com.wipro.factory;

import com.wipro.service.AccountsService;
import com.wipro.service.AccountsServiceImpl;

public class AccountsServiceFactory {
	private static AccountsService accService = null;
	
	static {
		accService = new AccountsServiceImpl();
	}
	
	public static AccountsService getAccountsServiceObject() {
		return accService;
	}
}
