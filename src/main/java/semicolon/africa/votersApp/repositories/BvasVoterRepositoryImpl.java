package semicolon.africa.votersApp.repositories;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import semicolon.africa.votersApp.model.Voter;
import semicolon.africa.votersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class BvasVoterRepositoryImpl implements VotersRepository{

    List<Voter>voters = new ArrayList<>();

    @Override
    public Voter findById(String id) {
        for (Voter voter:voters) {
            if (voter.getId().equals(id)) return voter;
        }
        return null;
    }

    @Override
    public List<Voter> findAll() {
        return voters;
    }

    @Override
    public Voter save(Voter voter) {
        String id = AppUtils.generateId();
        voter.setId(id);
        voters.add(voter);
        return voter;
    }

    @Override
    public void deleteById(String id) {
        Voter foundVoter = findById(id);
        if (foundVoter != null)voters.remove(foundVoter);
    }



//    @Autowired
//    VotersRepository votersRepository;
//
//    List<Voter> voterList = new ArrayList<>();
//
//    int lastIdCreated;
//    int idCounter = 1;
//
//
//    @Override
//    public Voter findById(String id) {
//        if (id != null)
//        return votersRepository.findById(id);
//        return null;
//    }
//    @Override
//    public List<Voter> findAll() {
//        return votersRepository.findAll();
//    }
//
//    @Override
//    public Voter save(Voter voter) {
//        voter.setId( idCounter + "");
//        idCounter++;
//        voterList.add(voter);
//        return voter;
//    }
//
//    @Override
//    public void deleteById(String id) {
//        votersRepository.deleteById(id);
//    }
//    @Override
//    public int count() {
//        return voterList.size();
//    }
}
