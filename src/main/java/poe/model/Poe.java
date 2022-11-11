package poe.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void addTrainees(Collection<? extends Trainee> otherTrainees) {
        trainees.addAll(otherTrainees);
    }

    public void addTrainees(Trainee... otherTrainees) {
            Collections.addAll(trainees,  otherTrainees); // act like a for each loop to put trainee one by one
    }

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
