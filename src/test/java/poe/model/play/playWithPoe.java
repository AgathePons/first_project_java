package poe.model.play;

import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class playWithPoe {
    @Test
    void testDefaultConstructor() {
        Poe poe = new Poe();
        assertNull(poe.getTitle());
        assertNull(poe.getBeginDate());
        assertNull(poe.getEndDate());
        assertNull(poe.getPoeType());
        poe.setTitle("Java full stack");
        poe.setBeginDate(LocalDate.of(2020, 05, 24));
        poe.setEndDate(LocalDate.of(2021, 05, 24));
        poe.setPoeType(PoeType.POEI);
        assertEquals("Java full stack", poe.getTitle(), "title");
        assertEquals(LocalDate.of(2020, 05, 24), poe.getBeginDate(), "beginDate");
        assertEquals(LocalDate.of(2021, 05, 24), poe.getEndDate(), "endDate");
        assertEquals(PoeType.POEI, poe.getPoeType(), "poeType");
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate beginDate = LocalDate.of(2020, 05, 24);
        LocalDate endDate = LocalDate.of(2021, 05, 24);
        Poe poe = new Poe("Java full stack", beginDate, endDate, PoeType.POEI);
        System.out.println(poe.toString());
        assertEquals("Java full stack", poe.getTitle());
        assertEquals(LocalDate.of(2020, 05, 24), poe.getBeginDate());
        assertEquals(LocalDate.of(2021, 05, 24), poe.getEndDate());
        assertEquals(PoeType.POEI, poe.getPoeType());
    }

    @Test
    void testToString() {
        LocalDate beginDate = LocalDate.of(2020, 05, 24);
        LocalDate endDate = LocalDate.of(2021, 05, 24);
        Poe poe = new Poe("Java full stack", beginDate, endDate, PoeType.POEI);
        assertEquals("Poe{Java full stack\n" + "POEI (2020-05-24 to 2021-05-24)}", poe.toString());
    }
}
