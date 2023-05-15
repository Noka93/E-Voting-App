package semicolon.africa.votersApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.votersApp.dto.request.CreateElectionRequest;
import semicolon.africa.votersApp.dto.response.CreateElectionResponse;
import semicolon.africa.votersApp.model.Party;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasElectionServiceImplTest {

    private final ElectionService electionService = new BvasElectionServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @Test
    void createElectionTest(){
        CreateElectionRequest createElectionRequest = new CreateElectionRequest();
//        createElectionRequest.setElectionCategory("GUBERNATORIAL");
//        createElectionRequest.setElectionDate("2023-02-25");
//        List<String> parties = getParties();
//        createElectionRequest.setParties(parties);
//        List<String> states = getStates();
//        createElectionRequest.setStates(states);
//        CreateElectionResponse createElectionResponse = electionService.createElection(createElectionRequest);
//        assertNotNull(createElectionResponse);
    }

    private static List<String> getStates() {
        List<String>states = new ArrayList<>();
        states.add("Lagos");
        states.add("Kogi");
        states.add("Kano");
        return states;
    }

    private static List<String> getParties() {
        List<String> parties = new ArrayList<>();
        parties.add("PDP");
        parties.add("APC");
        parties.add("townHall");
        parties.add("LP");
        return parties;
    }
}