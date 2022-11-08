package poe.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestTrainee {
    @Test
    void testDefaultConstructor() {
        Trainee trainee = new Trainee();
        System.out.println(trainee);
        System.out.println(trainee.getFirstname());
        // call a method on null: NullPointerException
        trainee.setFirstname("Matt");
        System.out.println(trainee.getFirstname());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate birthdate = LocalDate.of(1998, 05, 24);
        Trainee trainee = new Trainee("Matt", "Damon", birthdate);
        assertEquals("Matt", trainee.getFirstname(), "firstname");
        assertEquals("Damon", trainee.getLastname(), "lastname");
        assertEquals(birthdate, trainee.getBirthdate());
    }

    @Test
    void severalInstances() {
        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        System.out.println(trainee1);
        System.out.println(trainee2);
    }
}