package poe.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Poe {
    private String title;
    private LocalDate beginDate;
    private LocalDate endDate;
    private PoeType poeType;

    @Builder.Default
    private List<Trainee> trainees = new ArrayList<>();



    @Override
    public String toString() {
        return "\nPoe{" +
                title +
                " " +
                poeType +
                " (" +
                beginDate +
                " to " +
                endDate +
                ")}\n";
    }
}
