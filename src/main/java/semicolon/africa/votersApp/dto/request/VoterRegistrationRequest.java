package semicolon.africa.votersApp.dto.request;

import lombok.Data;

@Data
public class VoterRegistrationRequest {
    private String name;
    private String userName;
    private String password;
    private String houseNumber;
    private String street;
    private String town;
    private String lga;
    private String state;
    private int age;
    private String gender;
}
