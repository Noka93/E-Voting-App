package semicolon.africa.votersApp.service;

import semicolon.africa.votersApp.dto.request.VoterRegistrationRequest;
import semicolon.africa.votersApp.dto.response.DeleteVoterResponse;
import semicolon.africa.votersApp.dto.response.VoterRegistrationResponse;
import semicolon.africa.votersApp.exceptions.VoterRegistrationException;
import semicolon.africa.votersApp.model.Voter;

import java.util.List;

public interface VotersService {

    VoterRegistrationResponse registerNewVoter(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException;

    Voter getVoterById(String id);

    List<Voter> getAllVoters();

    DeleteVoterResponse deleteVoterById(String id);

}
