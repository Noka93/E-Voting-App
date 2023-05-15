package semicolon.africa.votersApp.repositories;

import semicolon.africa.votersApp.model.UserInformation;

import java.util.List;

public interface UserInformationRepository {
    UserInformation findById(String id);
    List<UserInformation> findAll();
    UserInformation save(UserInformation userInformation);
    void deleteById(String id);
}
