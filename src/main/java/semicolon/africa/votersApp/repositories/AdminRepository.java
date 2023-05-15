package semicolon.africa.votersApp.repositories;

import semicolon.africa.votersApp.model.Admin;

import java.util.List;

public interface AdminRepository {
    Admin findById(String id);
    List<Admin> findAll();
    Admin save(Admin admin);
    void deleteById(String id);
}
