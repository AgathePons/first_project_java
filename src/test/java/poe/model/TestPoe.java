package poe.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestPoe {
    @Test
    void testDefaultConstructor() {
        Poe poe = new Poe();
        poe.setTitle("Java full stack");
        poe.setBeginDate(LocalDate.of(2020, 05, 24));
        poe.setEndDate(LocalDate.of(2021, 05, 24));
        poe.setPoeType(PoeType.POEI);
        System.out.println(poe.toString());
        assertEquals(poe.getTitle(), "Java full stack");
        assertEquals((poe.getBeginDate()), LocalDate.of(2020, 05, 24));
        assertEquals(poe.getEndDate(), LocalDate.of(2021, 05, 24));
        assertEquals(poe.getPoeType(), PoeType.POEI);
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate beginDate = LocalDate.of(2020, 05, 24);
        LocalDate endDate = LocalDate.of(2021, 05, 24);
        Poe poe = new Poe("Java full stack", beginDate, endDate, PoeType.POEI);
        System.out.println(poe.toString());
        assertEquals(poe.getTitle(), "Java full stack");
        assertEquals((poe.getBeginDate()), LocalDate.of(2020, 05, 24));
        assertEquals(poe.getEndDate(), LocalDate.of(2021, 05, 24));
        assertEquals(poe.getPoeType(), PoeType.POEI);
    }

    @Test
    void testToString() {
        LocalDate beginDate = LocalDate.of(2020, 05, 24);
        LocalDate endDate = LocalDate.of(2021, 05, 24);
        Poe poe = new Poe("Java full stack", beginDate, endDate, PoeType.POEI);
        assertEquals(poe.toString(), "Poe{Java full stack\n" +
                "POEI (2020-05-24 to 2021-05-24)}");
    }
}