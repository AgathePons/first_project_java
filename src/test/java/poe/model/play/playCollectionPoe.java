package poe.model.play;

import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;

import java.time.temporal.ChronoUnit;

public class playCollectionPoe {
    @Test
    void playWithListPoe() {
        List<Poe> poeList = List.of(
                new Poe(
                        "Java Fullstack",
                        LocalDate.of(2022,10,24),
                        LocalDate.of(2023,1,27),
                        PoeType.POEI
                ),
                new Poe(
                        "Java Fullstack",
                        LocalDate.of(2022,11,2),
                        LocalDate.of(2023,2,3),
                        PoeType.POEC
                ),
                new Poe(
                        "Consultant Devops",
                        LocalDate.of(2022,6,13),
                        LocalDate.of(2022,9,16),
                        PoeType.POEC
                ),
                new Poe(
                        "Consultant Cyber Sécurité",
                        LocalDate.of(2021,9,13),
                        LocalDate.of(2021,11,16),
                        PoeType.POEI
                ),
                new Poe(
                        "Consultant SAP",
                        LocalDate.of(2022,4,13),
                        LocalDate.of(2022,8,16),
                        PoeType.POEI
                ),
                new Poe(
                        "Consultant BI",
                        LocalDate.of(2022,9,24),
                        LocalDate.of(2022,11,23),
                        PoeType.POEI
                )
        );
        // exo 1 number of POEI
        int poeiNumber = poeList.stream()
              .filter(poe -> PoeType.POEI.equals(poe.getPoeType()))
              .toList()
              .size();
        System.out.println("number of POEI: " + poeiNumber);

        // exo 2 average of POE duration in days
      OptionalDouble countPoeAverageDays = poeList.stream()
              .mapToLong(poe -> ChronoUnit.DAYS.between(poe.getBeginDate(), poe.getEndDate()))
              .peek(duration -> System.out.println("debug >> poe duration: " + duration))
              .average();
      // or if we are sure to have at least one value, we can add .getAsDouble(); at the end to have direct a double
      System.out.println("average of POE duration in days: " + countPoeAverageDays.getAsDouble());
    }
}
