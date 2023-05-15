package semicolon.africa.votersApp.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Election {
    private String id;
    private LocalDate date;
    List<String> parties;
    private Category category;
}
