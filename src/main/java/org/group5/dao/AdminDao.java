package org.group5.dao;

import org.group5.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Ghanshyam on 7/11/2016.
 */
public interface AdminDao extends CrudRepository<Admin,Long> {
    //we don't need an implementation and or method unless we want to do something extra

    @Query("SELECT a FROM Admin a WHERE a.email=:email AND a.password=:password")
    public Admin findAdmin(@Param("email") String email, @Param("password") String password);
}