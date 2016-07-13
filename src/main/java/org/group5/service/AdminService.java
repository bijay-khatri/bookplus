package org.group5.service;
import org.group5.model.Admin;
import java.util.Set;

/**
 * Created by Ghanshyam on 7/10/2016.
 */

public interface AdminService {

    void add(Admin admin);
    Admin addAdmin(Admin admin);
    void update(Admin admin);
    void delete(long id);
    Admin findById(long id);
    Set<Admin> getAll();
    Admin checkAdmin(String email, String password);

}