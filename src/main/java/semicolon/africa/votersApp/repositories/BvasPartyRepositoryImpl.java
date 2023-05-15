package semicolon.africa.votersApp.repositories;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import semicolon.africa.votersApp.model.Party;
import semicolon.africa.votersApp.model.UserInformation;
import semicolon.africa.votersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BvasPartyRepositoryImpl implements PartyRepository {

    private final List<Party> politicalParties = new ArrayList<>();

    private final  UserInformationRepository userInformationRepository = new UserInformationRepositoryImpl();

    @Override
    public Party findById(String id) {
        Party foundParty = null;
        for (Party party:politicalParties) {
            if (party.getId().equals(id)) foundParty = party;
        }
        if (foundParty != null){
            String userInformationId = AppUtils.getUserInformationId(foundParty.getId());
            UserInformation userInformation = userInformationRepository.findById(userInformationId);
            foundParty.setUserInformation(userInformation);
        }
        return foundParty;
    }

    @Override
    public List<Party> findAll() {
        List<Party>foundPoliticalParties = new ArrayList<>();
        for (Party party:politicalParties) {
           String userInformationId = AppUtils.getUserInformationId(party.getId());
            if (userInformationId != null){
                UserInformation foundUserInformation = userInformationRepository.findById(userInformationId);
                party.setUserInformation(foundUserInformation);
            }
            foundPoliticalParties.add(party);

        }
        return foundPoliticalParties;
    }

    @Override
    public Party save(Party party) {
        party.setId(AppUtils.generateId());
        boolean isPartyWithUserInformation = party.getUserInformation()!=null;
        if (isPartyWithUserInformation)savedUserInformation(party);
        politicalParties.add(party);
        System.out.println(politicalParties);
        return party;
    }

    private void savedUserInformation(Party party) {
        UserInformation savedUserInformation = userInformationRepository.save(party.getUserInformation());
        String partyId = party.getId();
        String userInformationId = savedUserInformation.getUserId();
        AppUtils.linkedUserToUserInformation(partyId, userInformationId);
    }

    @Override
    public void deleteById(String id) {
        var foundParty = findById(id);
        if (foundParty != null) politicalParties.remove(foundParty);

    }

//
//    @Autowired
//    PartyRepository partyRepository;
//    @Override
//    public Party findById(String id) {
//        return partyRepository.findById(id);
//    }
//
//    @Override
//    public List<Party> findAll() {
//        return partyRepository.findAll();
//    }
//    @Override
//    public Party save(Party party) {
//        Party newParty = new Party();
//        party.setUserInformation(newParty.getUserInformation());
//        Party savedParty = partyRepository.save(newParty);
//        return savedParty;
//    }
//
//    @Override
//    public void deleteById(String id) {
//        partyRepository.deleteById(id);
//    }
//}
}