package semicolon.africa.votersApp.repositories;

import org.springframework.stereotype.Repository;
import semicolon.africa.votersApp.model.Admin;
import semicolon.africa.votersApp.model.UserInformation;
import semicolon.africa.votersApp.model.Voter;
import semicolon.africa.votersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BvasAdminRepositoryImpl implements AdminRepository {

    List<Admin>admins = new ArrayList<>();
    @Override
    public Admin findById(String id) {
        for (Admin admin:admins) {
            if (admin.getId().equals(id)) return admin;
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return admins;
    }

    @Override
    public Admin save(Admin admin) {
        admin.setId(AppUtils.generateId());
        admins.add(admin);
        return admin;
    }

    @Override
    public void deleteById(String id) {
    Admin savedAdmin = findById(id);
    if(savedAdmin != null)admins.remove(savedAdmin);
    }
}