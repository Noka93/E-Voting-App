package semicolon.africa.votersApp.service;

import semicolon.africa.votersApp.dto.request.CreateElectionRequest;
import semicolon.africa.votersApp.dto.response.CreateElectionResponse;
import semicolon.africa.votersApp.repositories.ElectionRepository;
import semicolon.africa.votersApp.repositories.ElectionRepositoryImpl;

public class BvasElectionServiceImpl implements ElectionService{

    private final ElectionRepository electionRepository = new ElectionRepositoryImpl();
    @Override
    public CreateElectionResponse createElection(CreateElectionRequest electionRequest) {
        return null;
    }
}
