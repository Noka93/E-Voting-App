package semicolon.africa.votersApp.Mappers;

import semicolon.africa.votersApp.dto.request.CreateElectionRequest;
import semicolon.africa.votersApp.dto.request.VoterRegistrationRequest;
import semicolon.africa.votersApp.model.*;

import java.time.LocalDate;
import java.util.List;

public class ModelMapper {
    public static Voter map(VoterRegistrationRequest voterRegistrationRequest) {
        Voter voter = new Voter();
        voter.setAge(voterRegistrationRequest.getAge());
        voter.setName(voterRegistrationRequest.getName());
        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
        voter.setGender(voterGender);
        Address address = new Address();
        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
        address.setStreet(voterRegistrationRequest.getStreet());
        address.setTown(voterRegistrationRequest.getTown());
        address.setLocalGovernmentArea(voterRegistrationRequest.getLga());
        address.setState(voterRegistrationRequest.getState());
        voter.setAddress(address);
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName(voterRegistrationRequest.getUserName());
        userInformation.setPassword(voterRegistrationRequest.getPassword());
        voter.setUserInformation(userInformation);
        return voter;
    }

    public static Election map(CreateElectionRequest createElectionRequest){
//        Election election = new Election();
//        Category electionCategory = Category.valueOf(createElectionRequest.getElectionCategory().toUpperCase());
//        election.setCategory(electionCategory);
//        LocalDate electionDate =  (LocalDate.parse(createElectionRequest.getElectionDate()));
//        election.setDate(electionDate);
//        List<String> parties = getPoliticalPaties(createElectionRequest.getParties());
//        election.setParties(parties);
        return null;
    }
}