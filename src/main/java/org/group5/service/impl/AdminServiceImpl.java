package org.group5.service.impl;
import org.group5.dao.AdminDao;
        import org.group5.model.Admin;
        import org.group5.service.AdminService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import java.util.HashSet;
        import java.util.Set;

/**
 * Created by Ghanshyam on 7/10/2016.
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public void add(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public Admin addAdmin(Admin admin) {
        adminDao.save(admin);
        return adminDao.findOne(admin.getId());

    }

    @Override
    public void update(Admin admin) {
        adminDao.save(admin);
    }


    @Override
    public void delete(long id) {
        adminDao.delete(id);
    }

    @Override
    public Admin findById(long id) {
        return adminDao.findOne(id);
    }

    @Override
    public Set<Admin> getAll() {
        Set<Admin> result = new HashSet<>();
        adminDao.findAll().forEach(item -> result.add(item));
        return result;
    }
    @Override
    public Admin checkAdmin(String email, String password) {
        return adminDao.findAdmin(email,password);
    }


}