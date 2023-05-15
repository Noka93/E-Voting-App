//package semicolon.africa.votersApp.repositories;
//
//import org.junit.jupiter.api.Test;
//import semicolon.africa.votersApp.model.Gender;
//import semicolon.africa.votersApp.model.Voter;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//class VoterRepositoryImplTest {
//    @Test
//    public void shouldReturnCorrectVoterWhenFound() {
//        Voter v1 = new Voter("123");
//        Voter v2 = new Voter("456");
//        Voter v3 = new Voter("789");
//
//        List<Voter> voterList = Arrays.asList(v1, v2, v3);
//        Voter voter = new Voter();
//        VotersRepository voterRepository = new BvasVoterRepositoryImpl();
//        Voter foundVoter = voterRepository.findById("456");
//        assertEquals(voter.getId(), foundVoter);
//    }
//
//    @Test
//    public void shouldReturnNullWhenNotFound() {
//        Voter v1 = new Voter("123");
//        Voter v2 = new Voter("456");
//        Voter v3 = new Voter("789");
//        List<Voter> voterList = Arrays.asList(v1, v2, v3);
//        VotersRepository voterRepository = new BvasVoterRepositoryImpl(Collections.singletonList(voterList));
//        Voter foundVoter = voterRepository.findById("999");
//        assertNull(foundVoter);
//    }
//
//    @Test
//    public void shouldSaveVoter() {
//        Voter voter = new Voter();
//        voter.setName("John Doe");
//        voter.setGender(Gender.MALE);
//        voter.setAddress("123 Main St");
//        voter.setAge(30);
//        voter.setVoterIdentificationNumber("ABC123");
//
//        VotersRepository voterRepository = new BvasVoterRepositoryImpl();
//
//        Voter savedVoter = voterRepository.save(voter);
//
//        assertNotNull(savedVoter.getId());
//        assertEquals(voter.getName(), savedVoter.getName());
//        assertEquals(voter.getGender(), savedVoter.getGender());
//        assertEquals(voter.getAddress(), savedVoter.getAddress());
//        assertEquals(voter.getAge(), savedVoter.getAge());
//        assertEquals(voter.getVoterIdentificationNumber(), savedVoter.getVoterIdentificationNumber());
//
//        Voter retrievedVoter = voterRepository.findById(savedVoter.getId());
//        assertNotNull(retrievedVoter);
//        assertEquals(savedVoter, retrievedVoter);
//    }
//
//    }
//
