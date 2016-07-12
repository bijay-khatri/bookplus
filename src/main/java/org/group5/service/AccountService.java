package org.group5.service;

import org.group5.model.Account;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Neha on 7/11/2016.
 */

public interface AccountService {

    void add(Account account);
    void update(Account account);
    void delete(long id);
    Account findById(long id);
    Set<Account> getAll();



}
