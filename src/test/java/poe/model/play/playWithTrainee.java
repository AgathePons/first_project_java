package poe.model.play;

import org.junit.jupiter.api.Test;
import poe.model.Trainee;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class playWithTrainee {
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
        assertEquals(birthdate, trainee.getBirthdate(), "birthdate");
    }

    @Test
    void severalInstances() {
        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        System.out.println(trainee1);
        System.out.println(trainee2);
    }

    @Test
    void testToString() {
        Trainee trainee = new Trainee("Micheline", "Durand", LocalDate.of(1950, 5, 18));
        System.out.println(trainee.toString());
    }
}
