package org.group5.service.impl;

import org.group5.dao.AccountDao;
import org.group5.model.Account;
import org.group5.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Neha on 7/11/2016.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void add(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(long id) {
        accountDao.delete(id);
    }

    @Override
    public Account findById(long id) {
        return accountDao.findOne(id);
    }

    @Override
    public Set<Account> getAll() {
        Set<Account> result = new HashSet<>();
        accountDao.findAll().forEach(item -> result.add(item));
        return result;
    }
}
