package poe.model.play;

import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;
import poe.model.Trainee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class playWithPoe {
    @Test
    void testDefaultConstructor() {
        Poe poe = new Poe();
        assertNull(poe.getTitle());
        assertNull(poe.getBeginDate());
        assertNull(poe.getEndDate());
        assertNull(poe.getPoeType());
        assertTrue(poe.getTrainees().isEmpty(), "trainees is an empty collection");
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate beginDate = LocalDate.of(2020, 05, 24);
        LocalDate endDate = LocalDate.of(2021, 05, 24);
        List<Trainee> trainees = new ArrayList<>();
        Poe poe = new Poe("Java full stack", beginDate, endDate, PoeType.POEI, trainees);

        System.out.println(poe.toString());
        assertEquals("Java full stack", poe.getTitle());
        assertEquals(LocalDate.of(2020, 05, 24), poe.getBeginDate());
        assertEquals(LocalDate.of(2021, 05, 24), poe.getEndDate());
        assertEquals(PoeType.POEI, poe.getPoeType());
        assertSame(trainees, poe.getTrainees(), "trainees");
    }

    @Test
    void testToString() {
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();
        assertEquals("\nPoe{Java Fullstack POEI (2022-10-24 to 2023-01-27)}\n", poe.toString());
    }

    @Test
    void testAddTrainee() {
        // given
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();
        Trainee trainee = Trainee.builder()
                .firstname("Wesh")
                .build();
        // when
        poe.addTrainee(trainee);
        // then
        assertTrue(poe.getTrainees().contains(trainee), "trainee is contained in poe");
    }

    @Test
    void testAddTraineesCollection() {
        // given
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();
        Trainee trainee1 = Trainee.builder()
                .firstname("Wesh")
                .build();
        Trainee trainee2 = Trainee.builder()
                .firstname("Alors")
                .build();
        Set<Trainee> trainees = Set.of(trainee1, trainee2);
        // when
        poe.addTrainees(trainees);
        // then
        assertAll(trainees.stream()
                .map(trainee -> () -> assertTrue(
                        poe.getTrainees().contains(trainee),
                        "trainees " + trainee.getFirstname() +" is in poe")
                )
        );
    }

    @Test
    void testAddTraineesVarArgs() {
        // given
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();
        Trainee trainee1 = Trainee.builder()
                .firstname("Wesh")
                .build();
        Trainee trainee2 = Trainee.builder()
                .firstname("Alors")
                .build();
        // when
        poe.addTrainees(trainee1, trainee2);
        // then
        assertAll(Stream.of(trainee1, trainee2)
                .map(trainee -> () -> assertTrue(
                        poe.getTrainees().contains(trainee),
                        "trainees " + trainee.getFirstname() + " is in poe")
                )
        );
    }
}
