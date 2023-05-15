package semicolon.africa.votersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.votersApp.model.Party;
import semicolon.africa.votersApp.model.Voter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasPartyRepositoryImplTest {

    private final PartyRepository partyRepository = new BvasPartyRepositoryImpl();

    private Party savedParty;

    @BeforeEach
    void setUp() {
        savedParty = partyRepository.save(new Party());
    }

    @Test
    void testSaveParty() {
        assertNotNull(savedParty);

    }

    @Test
    void findById() {
        var foundParty = partyRepository.findById(savedParty.getId());
        assertNotNull(foundParty);
    }

    @Test
    void findAll() {
        Party partyOne = new Party();
        Party partyTwo = new Party();
        partyRepository.save(partyOne);
        partyRepository.save(partyTwo);
        List<Party> allParties = partyRepository.findAll();
        assertEquals(3, allParties.size());
    }

    @Test
    void deleteById() {
        Party partyOne = new Party();
        Party savePartOne = partyRepository.save(partyOne);
        List<Party> parties = partyRepository.findAll();
        assertEquals(2, parties.size());
        partyRepository.deleteById(savePartOne.getId());
        parties = partyRepository.findAll();
        assertEquals(1, parties.size());
    }
}