package poe.model.play;

import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;
import poe.model.Trainee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        LocalDate beginDate = LocalDate.of(2020, 05, 24);
        LocalDate endDate = LocalDate.of(2021, 05, 24);
        List<Trainee> trainees = new ArrayList<>();
        Poe poe = new Poe("Java full stack", beginDate, endDate, PoeType.POEI, trainees);
        assertEquals("\nPoe{Java full stack POEI (2020-05-24 to 2021-05-24)}\n", poe.toString());
    }
}
