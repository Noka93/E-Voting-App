package semicolon.africa.votersApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.votersApp.dto.request.VoterRegistrationRequest;
import semicolon.africa.votersApp.dto.response.VoterRegistrationResponse;
import semicolon.africa.votersApp.exceptions.VoterRegistrationException;
import semicolon.africa.votersApp.model.Voter;

import java.util.List;

import static java.math.BigInteger.ZERO;
import static org.junit.jupiter.api.Assertions.*;
import static semicolon.africa.votersApp.utils.GenerateIdUsingUUID.ONE;

class BvasBetaVotersServiceImplTest {
    private VotersService votersService = new BvasBetaVotersServiceImpl();

    private VoterRegistrationRequest voterRegistrationRequest;

    @BeforeEach
    void setUp() {
        voterRegistrationRequest = buildVoterRegistrationRequest();
    }

    @Test
    void registerVoterTest() {
        try {
            VoterRegistrationResponse votersResponse =
                    votersService.registerNewVoter(voterRegistrationRequest);
            assertNotNull(votersResponse);
            assertNotNull(votersResponse.getVotersIdentificationNumber());
        } catch (VoterRegistrationException exception) {
            System.out.println(exception);
        }
    }

    @Test
    void getAllVotersTest() throws VoterRegistrationException {
       var response = votersService.registerNewVoter(voterRegistrationRequest);
       assertNotNull(response);
       List<Voter> voters = votersService.getAllVoters();
       assertNotNull(voters);
       assertEquals(1, voters.size());
    }

    @Test
    void getVoterByIdTest() throws VoterRegistrationException {
        var registrationResponse = votersService.registerNewVoter(voterRegistrationRequest);
        List<Voter> voters = votersService.getAllVoters();
        Voter lastRegisteredVoter = voters.get(voters.size() - 1);
        Voter foundVoter = votersService.getVoterById(lastRegisteredVoter.getId());
        assertNotNull(foundVoter);
        assertEquals(voterRegistrationRequest .getName(), foundVoter.getName());
    }

    @Test
    void deleteVoterById() throws VoterRegistrationException {
        votersService.registerNewVoter(voterRegistrationRequest);
        List<Voter> voters = votersService.getAllVoters();
        assertEquals(1, voters.size());
        Voter lastRegisteredVoter = voters.get(voters.size()-ONE);
        Voter foundVoter = votersService.getVoterById(lastRegisteredVoter.getId());
        votersService.deleteVoterById(foundVoter.getId());
        voters = votersService.getAllVoters();
        assertEquals(ZERO.intValue(), voters.size());
    }

    private static VoterRegistrationRequest buildVoterRegistrationRequest() {
        VoterRegistrationRequest registrationRequest = new VoterRegistrationRequest();
        registrationRequest.setAge(20);
        registrationRequest.setName("Remigious");
        registrationRequest.setLga("TownHall");
        registrationRequest.setGender("FEMALE");
        registrationRequest.setUserName("Mine123");
        registrationRequest.setPassword("Download123");
        registrationRequest.setState("Kogi");
        registrationRequest.setTown("Lokoja");
        registrationRequest.setStreet("Phase two");
        registrationRequest.setHouseNumber("No. 23");
        return registrationRequest;
    }
}
