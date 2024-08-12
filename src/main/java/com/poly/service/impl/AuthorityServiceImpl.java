package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.dao.AuthorityDAO;
import com.poly.entity.Account;
import com.poly.entity.Authority;
import com.poly.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	AuthorityDAO auDao;
	
	@Autowired
	AccountDAO acDao;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = acDao.getAdministrators();
		return auDao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return auDao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return auDao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		auDao.deleteById(id);
	}

}
