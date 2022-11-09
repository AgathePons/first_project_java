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
        List<String> animals = List.of("Cat", "Dog", "Bird", "Bunny", "Unicorn", "snake");
        System.out.println(animals);
        System.out.println(animals.getClass()); // this List is immutable, we cannot use the add() method for example
        // loops: statements
        for (String animal: animals) {
            System.out.println("\t- I pet the " + animal.toUpperCase() + " <3");
        }
        System.out.println("And................");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println("\t-> I feed the " + animals.get(i));
        }
        System.out.println("And................");
        // loops: functional
        // .forEach()
        animals.forEach(animal -> System.out.println("\t>> Who let the " + animal + " out? Woo! Woowoo!"));
        System.out.println("And................");
        // .reduce() .map() .filter()
        List<Integer> countLetters = animals.stream()
                .map(animal -> animal.length())
                .toList(); // toList() java 17
        System.out.println(countLetters);
        System.out.println("And................");
        // other pipeline
        List<Integer> countLetters2 = animals.stream()
                .filter(animal -> animal.endsWith("e"))
                .map(String::length) // function reference
                .toList();
        System.out.println(countLetters2);
        // other pipeline with reduce()
        int totalCountLetters = animals.stream()
                .mapToInt(String::length)// prevent the autoboxing in Integer and allow to use int methods
                .sum();
        System.out.println("There are " + totalCountLetters + " letters");
    }
}
