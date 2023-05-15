package semicolon.africa.votersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.votersApp.model.UserInformation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInformationRepositoryImplTest {
    private final UserInformationRepository userInformationRepository = new UserInformationRepositoryImpl();
    private UserInformation savedUserInformation;
    @BeforeEach
    void setUp() {
        UserInformation userInformation = builderTestUserInformation();
        savedUserInformation = userInformationRepository.save(userInformation);

    }

    @Test
    public void testSaveUserInformation() {
        assertNotNull(savedUserInformation);

    }

    private UserInformation builderTestUserInformation() {
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName("Remigious");
        userInformation.setPassword("1234");
        return userInformation;
    }

    @Test
    void testFindUserInformationById() {
        UserInformation newUserInformation = userInformationRepository.findById(savedUserInformation.getUserId());
        assertNotNull(newUserInformation);
    }

    @Test
    void findAllUserInformation() {
        UserInformation userInformation1 = new UserInformation();
        UserInformation userInformation2 = new UserInformation();
        UserInformation userInformation3 = new UserInformation();
        userInformationRepository.save(userInformation1);
        userInformationRepository.save(userInformation2);
        userInformationRepository.save(userInformation3);

        List<UserInformation>informations = userInformationRepository.findAll();
        assertEquals(4, informations.size());
    }

    @Test
    void deleteUserInformationById() {
        UserInformation userInformation1 = new UserInformation();
        UserInformation newUserInformation = userInformationRepository.save(userInformation1);
        List<UserInformation> informations = userInformationRepository.findAll();
        assertEquals(2, informations.size());
        System.out.println(informations);
        userInformationRepository.deleteById(newUserInformation.getUserId());
        informations = userInformationRepository.findAll();
        assertEquals(1, informations.size());
    }
}