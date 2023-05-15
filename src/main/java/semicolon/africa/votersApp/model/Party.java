package semicolon.africa.votersApp.model;

import lombok.Data;

@Data
public class Party {
    private  String id;
    private UserInformation userInformation;
    private String name;
}
