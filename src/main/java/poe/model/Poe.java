package poe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Poe {
    private String title;
    private LocalDate beginDate;
    private LocalDate endDate;
    private PoeType poeType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    @Override
    public String toString() {
        return "Poe{" +
                title +
                "\n" +
                poeType +
                " (" +
                beginDate +
                " to " +
                endDate +
                ")}";
    }
}
