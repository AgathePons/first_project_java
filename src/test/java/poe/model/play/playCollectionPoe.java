package poe.model.play;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.time.LocalDate;
import java.util.*;

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

  @Test
  void sortPoe() {
    // NavigableSet<Poe> poeSet = new TreeSet<>(poeList);
    // we cannot do this because Poe is not comparable by default
    // List<Poe> poeList2 = new ArrayList<>(poeList);
    // Collections.sort(poeList2); -> does not work because we must give a comparator
    // Comparator<Poe> comparatorPoe = (p1, p2) -> -1; return always -1
    // Comparator<Poe> comparatorPoe = Comparator.comparing(Poe::getBeginDate); // -> one arg keyExtractor
    Comparator<Poe> comparatorPoe = Comparator.comparing(
            Poe::getBeginDate,
            Comparator.reverseOrder()
    ); // -> we can add a second argument keyComparator
    NavigableSet<Poe> poeSet = new TreeSet<>(comparatorPoe);
    poeSet.addAll(poeList);
    System.out.println(poeSet);
    // multi criteria: poeType then date
    Comparator<Poe> comparatorPoe2 = Comparator.comparing(Poe::getPoeType)
            .thenComparing(Poe::getBeginDate); // -> then second criteria
    NavigableSet<Poe> poeSet2 = new TreeSet<>(comparatorPoe2);
    poeSet2.addAll(poeList);
    System.out.println(poeSet2);
  }
}
