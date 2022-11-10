package poe.model.play;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;

import java.time.temporal.ChronoUnit;

public class playCollectionPoe {

  static List<Poe> poeList;

  @BeforeAll
  static void initData() {
    poeList = List.of(
            Poe.builder()
                    .title("Java Fullstack")
                    .beginDate(LocalDate.of(2022, 10, 24))
                    .endDate(LocalDate.of(2023, 1, 27))
                    .poeType(PoeType.POEI)
                    .build(),

            Poe.builder()
                    .title("Java Fullstack")
                    .beginDate(LocalDate.of(2022, 11, 2))
                    .endDate(LocalDate.of(2023, 2, 3))
                    .poeType(PoeType.POEC)
                    .build(),

            Poe.builder()
                    .title("Consultant Devops")
                    .beginDate(LocalDate.of(2022, 6, 13))
                    .endDate(LocalDate.of(2022, 9, 16))
                    .poeType(PoeType.POEC)
                    .build(),

            Poe.builder()
                    .title("Consultant Cyber Sécurité")
                    .beginDate(LocalDate.of(2021, 9, 13))
                    .endDate(LocalDate.of(2021, 11, 16))
                    .poeType(PoeType.POEI)
                    .build(),

            Poe.builder()
                    .title("Consultant SAP")
                    .beginDate(LocalDate.of(2022, 4, 13))
                    .endDate(LocalDate.of(2022, 8, 16))
                    .poeType(PoeType.POEI)
                    .build(),

            Poe.builder()
                    .title("Consultant BI")
                    .beginDate(LocalDate.of(2022, 9, 24))
                    .endDate(LocalDate.of(2022, 11, 23))
                    .poeType(PoeType.POEI)
                    .build()
    );
  }

  @Test
  void numberOfPoei() {
    // exo 1 number of POEI
    int poeiNumber = poeList.stream()
            .filter(poe -> PoeType.POEI.equals(poe.getPoeType()))
            .toList()
            .size();
    System.out.println("number of POEI: " + poeiNumber);
  }

  @Test
  void averageOfPoeDaysDuration() {
    // exo 2 average of POE duration in days
    OptionalDouble countPoeAverageDays = poeList.stream()
            .mapToLong(poe -> ChronoUnit.DAYS.between(poe.getBeginDate(), poe.getEndDate()))
            .peek(duration -> System.out.println("debug >> poe duration: " + duration))
            .average();
    // or if we are sure to have at least one value, we can add .getAsDouble(); at the end to have direct a double
    // at the beginning of the list, we can add .skip() or .limit() to do the action on a sample of the list
    System.out.println("average of POE duration in days: " + countPoeAverageDays.getAsDouble());
  }
}
