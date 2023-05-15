package semicolon.africa.votersApp.service;

import semicolon.africa.votersApp.dto.request.CreateElectionRequest;
import semicolon.africa.votersApp.dto.response.CreateElectionResponse;

public interface ElectionService {

    CreateElectionResponse createElection(CreateElectionRequest electionRequest);
}
