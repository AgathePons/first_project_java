package poe.model.play;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlaySortStrings {
  @Test
  void compareStrings() {
    String animal1 = "dog";
    String animal2 = "cat";
    String animal3 = "aaa";
    String animal4 = "aaa";
    // Comparable : interface to compare different type of data
    // if superior return positive int, if inferior return negative int, if equal return 0
    assertTrue(animal1.compareTo(animal2) > 0);
    System.out.println(animal1.compareTo(animal2));
    System.out.println(animal2.compareTo(animal2));
    System.out.println(animal2.compareTo(animal1));
    assertTrue(animal3.compareTo(animal4) == 0);
  }

  @Test
  void sortListStrings() {
    List<String> animals = new ArrayList<>();
    Collections.addAll(animals, "cat", "dog", "bird", "bunny", "unicorn", "snake");
    Collections.sort(animals);
    System.out.println(animals);
    animals.sort(Comparator.reverseOrder());
    System.out.println(animals);
  }

  @Test
  void sortListFrenchWords() {
    List<String> words = new ArrayList<>();
    Collections.addAll(words, "étage", "étuve", "été");
    Collator collator = Collator.getInstance(new Locale("fr", "FR"));
    // sort in French order
    Collections.sort(words, collator);
    System.out.println(words);
  }

  @Test
  void sortListSpanishWords() {
    List<String> words = new ArrayList<>();
    Collections.addAll(words, "mano", "mañana", "matador");
    // sort in Spanish order
    Collator collator = Collator.getInstance(new Locale("es", "ES"));
    Collections.sort(words, collator);
    System.out.println(words);
  }
}
