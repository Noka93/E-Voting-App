package semicolon.africa.votersApp.dto.request;

import lombok.Data;
import semicolon.africa.votersApp.model.Party;

import java.util.List;
@Data
public class CreateElectionRequest {
    private String electionDate;
    private String electionCategory;
    List<String>states;
    List<Party>parties;
    List<String> localGovernment;

}
