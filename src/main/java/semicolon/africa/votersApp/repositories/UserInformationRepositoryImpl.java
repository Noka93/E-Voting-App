package semicolon.africa.votersApp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import semicolon.africa.votersApp.model.UserInformation;
import semicolon.africa.votersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserInformationRepositoryImpl implements UserInformationRepository{

    List<UserInformation> userInformations = new ArrayList<>();

    @Override
    public UserInformation findById(String id) {
        for (UserInformation userInformation:userInformations) {
            if (userInformation.getUserId().equals(id))return userInformation;

        }
        return null;
    }

    @Override
    public List<UserInformation> findAll() {
        return userInformations;
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        String id = AppUtils.generateId();
        userInformation.setUserId(id);
        userInformations.add(userInformation);
        return userInformation;
    }

    @Override
    public void deleteById(String id) {
        UserInformation userInformation = findById(id);
        if (userInformation != null) userInformations.remove(userInformation);
    }

//    @Override
//    public UserInformation findById(String id) {
//        return userInformationRepository.findById(id);
//    }
//
//    @Override
//    public List<UserInformation> findAll() {
//        return userInformationRepository.findAll();
//    }
//
//    @Override
//    public UserInformation save(UserInformation userInformation) {
//        UserInformation newUser = new UserInformation();
//        newUser.setUserName(userInformation.getUserName());
//        newUser.setUserId(userInformation.getUserId());
//        newUser.setPassword(userInformation.getPassword());
//        return userInformationRepository.save(userInformation);
//    }
//
//    @Override
//    public void deleteById(String id) {
//        userInformationRepository.deleteById(id);
//
//    }
}
