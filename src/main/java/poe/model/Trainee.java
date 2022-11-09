package poe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Trainee {
    private String firstname;
    private String lastname;
    private LocalDate birthdate;

    @Override
    public String toString() {
        return "Trainee{" +
                firstname + ' ' +
                lastname + " (" +
                birthdate +
                ")}";
    }
}
