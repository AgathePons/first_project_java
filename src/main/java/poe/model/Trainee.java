package poe.model;

import lombok.*;

import java.time.LocalDate;
@Builder
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
