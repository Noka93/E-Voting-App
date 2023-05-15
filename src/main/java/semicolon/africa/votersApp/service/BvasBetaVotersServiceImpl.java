package semicolon.africa.votersApp.service;

import semicolon.africa.votersApp.Mappers.ModelMapper;
import semicolon.africa.votersApp.dto.request.VoterRegistrationRequest;
import semicolon.africa.votersApp.dto.response.DeleteVoterResponse;
import semicolon.africa.votersApp.dto.response.VoterRegistrationResponse;
import semicolon.africa.votersApp.exceptions.VoterRegistrationException;
import semicolon.africa.votersApp.model.Voter;
import semicolon.africa.votersApp.repositories.BvasVoterRepositoryImpl;
import semicolon.africa.votersApp.repositories.VotersRepository;
import semicolon.africa.votersApp.utils.GenerateIdUsingUUID;

import java.util.List;

public class BvasBetaVotersServiceImpl implements VotersService{

    private final VotersRepository votersRepository= new BvasVoterRepositoryImpl();

    @Override
    public VoterRegistrationResponse registerNewVoter(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException {
        Voter voter = ModelMapper.map(voterRegistrationRequest);
        String vin = GenerateIdUsingUUID.generateVoterIdentificationNumber();
        voter.setVoterIdentificationNumber(vin);
        Voter savedVoter = votersRepository.save(voter);
        if (savedVoter == null) throw new VoterRegistrationException("Voter registration failed");
        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        voterRegistrationResponse.setMessage("Registration Successful");
        voterRegistrationResponse.setVotersIdentificationNumber(savedVoter.getVoterIdentificationNumber());
        return voterRegistrationResponse;
    }

    @Override
    public Voter getVoterById(String id) {
        return votersRepository.findById(id);
    }

    @Override
    public List<Voter> getAllVoters() {
        return votersRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteVoterById(String id) {
        votersRepository.deleteById(id);
        return DeleteVoterResponse.builder().message("Voter deleted").build();
    }

}
