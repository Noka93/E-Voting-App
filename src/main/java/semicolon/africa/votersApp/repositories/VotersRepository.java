package semicolon.africa.votersApp.repositories;

import semicolon.africa.votersApp.model.Voter;

import java.util.List;

public interface VotersRepository {
    Voter findById(String id);
    List<Voter> findAll();
    Voter save(Voter voter);
    void deleteById(String id);
}
