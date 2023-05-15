package semicolon.africa.votersApp.repositories;

import semicolon.africa.votersApp.model.Election;

import java.util.List;

public interface ElectionRepository {
    Election findById(String id);

    List<Election> findAll();

    Election save(Election election);

    void deleteById(String id);
}
