package semicolon.africa.votersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.votersApp.model.Admin;
import semicolon.africa.votersApp.model.Party;
import semicolon.africa.votersApp.model.UserInformation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAdminRepositoryImplTest {

    private final AdminRepository adminRepository = new BvasAdminRepositoryImpl();
    private Admin savedAdmin;


    @BeforeEach
    void setUp() {
        Admin admin = new Admin();
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName("favour_white55@gmail.com");
        userInformation.setPassword("remigious002#");
        admin.setUserInformation(userInformation);
        savedAdmin = adminRepository.save(admin);
    }

    @Test
    void testSavedAdmin() {
        assertNotNull(savedAdmin);
    }

    @Test
    void testFindAdminById() {
        Admin foundAdmin = adminRepository.findById(savedAdmin.getId());
        assertNotNull(foundAdmin);
        assertNotNull(foundAdmin.getUserInformation());
    }

    @Test
    void testFindAllAdmin() {
        Admin adminOne = new Admin();
        Admin adminTwo = new Admin();
        adminRepository.save(adminOne);
        adminRepository.save(adminTwo);
        List<Admin>allAdmin = adminRepository.findAll();
        assertEquals(3, allAdmin.size());
    }

    @Test
    void testDeleteAdminById() {
        Admin adminOne = new Admin();
        Admin newAdmin = adminRepository.save(adminOne);
        List<Admin>admins = adminRepository.findAll();
        assertEquals(2, admins.size());
        adminRepository.deleteById(newAdmin.getId());
        admins = adminRepository.findAll();
        assertEquals(1, admins.size());


    }
}