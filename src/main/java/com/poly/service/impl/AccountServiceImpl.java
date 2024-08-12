package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAO accountDao;
	
	@Override
	public Account findById(String username) {
		return accountDao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		return accountDao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

}
