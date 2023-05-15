package semicolon.africa.votersApp.repositories;

import semicolon.africa.votersApp.model.Party;

import java.util.List;

public interface PartyRepository {
    Party findById(String id);
    List<Party> findAll();
    Party save(Party party);
    void deleteById(String id);


}
