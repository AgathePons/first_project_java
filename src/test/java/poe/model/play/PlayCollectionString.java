package poe.model.play;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayCollectionString {
    @Test
    void playWithList1() {
        List<String> animals = new ArrayList<>(); // diamond notation, we do not have to re-specify the type
        animals.add("Cat");
        animals.add("Puppy");
        System.out.println(animals); // call toString() by default
        System.out.println("size: " + animals.size());
        for (String animal: animals) {
            System.out.println("\t- I pet the " + animal);
        }
        String myAnimal = animals.get(0);
        System.out.println("Awwww this " + myAnimal + " is soooo cuuuute!!");
    }
    @Test
    void playWithList2() {
        List<String> animals = new ArrayList<>();
        Collections.addAll(animals, "Cat", "Dog", "Koala", "Snake", "Ant", "Wolf");
        System.out.println(animals);
    }

    @Test
    void playWithList3() {
        // since Java 11
        List<String> animals = List.of("Cat", "Dog", "Bird", "Bunny");
        System.out.println(animals);
        System.out.println(animals.getClass());
    }
}
