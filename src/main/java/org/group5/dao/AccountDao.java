package org.group5.dao;

import org.group5.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Example on 7/11/2016.
 */
public interface AccountDao extends JpaRepository<Account,Long> {
}
