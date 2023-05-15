package semicolon.africa.votersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.votersApp.model.Gender;
import semicolon.africa.votersApp.model.Voter;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasVoterRepositoryImplTest {

    private final VotersRepository votersRepository = new BvasVoterRepositoryImpl();

    private Voter savedVoter;

    @BeforeEach
    public void setUp(){
        Voter voter = builderTestVoter();
        savedVoter = votersRepository.save(voter);
    }

    @Test
    public void testSaveVoter() {
        assertNotNull(savedVoter);
        assertNotNull(savedVoter.getId());
    }
    private  Voter builderTestVoter(){
        Voter voter = new Voter();
        voter.setName("Remigious Enefola");
        voter.setAge(20);
        voter.setGender(Gender.FEMALE);
        return voter;
    }

    @Test
    public void testFindVoterById() {
        Voter foundVoter = votersRepository.findById(savedVoter.getId());
        assertNotNull(foundVoter);
    }

    @Test
    public void testFindAllVoter() {
        Voter secondVoter = new Voter();
        Voter thirdVoter = new Voter();
        votersRepository.save(secondVoter);
        votersRepository.save(thirdVoter);
        List<Voter>allVoters = votersRepository.findAll();
        assertEquals(3, allVoters.size());
        assertNotNull(allVoters.get(0));
        assertNotNull(allVoters.get(1));
        assertNotNull(allVoters.get(2));

    }

    @Test
    void testDeleteVoterById() {
        Voter secondVoter = new Voter();
        Voter secondSaveVoter = votersRepository.save(secondVoter);
        List<Voter> voters = votersRepository.findAll();
        assertEquals(2, voters.size());
        votersRepository.deleteById(secondSaveVoter.getId());
        voters = votersRepository.findAll();
        assertEquals(1, voters.size());
    }

}