package poe.model.play;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlaySortInteger {
  @Test
  void compareInteger() {
    int distance1 = 15;
    int distance2 = 4;
    assertFalse(distance1 < distance2);
  }

  @Test
  void sortIntegers() {
    List<Integer> distances = new ArrayList<>();
    Collections.addAll(distances, 15, 4, 101, 55, 2, 98);
    Collections.sort(distances); // in place, modify the distances ArrayList
    System.out.println(distances);
    distances.sort(Comparator.reverseOrder());// not reverse, but reverse the NATURAL order
    System.out.println(distances);
  }

  @Test
  void navigableSetInteger() {
    NavigableSet<Integer> distances = new TreeSet<>();
    Collections.addAll(distances, 15, 4, 101, 55, 2, 98);
    System.out.println(distances);
    distances.add(42);
    System.out.println(distances);
    // reverse
    NavigableSet<Integer> distances2 = new TreeSet<>(
            Comparator.reverseOrder()
    );
    distances2.addAll(distances);
    System.out.println(distances2);
    // Because it is a set, no double values
    System.out.println(distances2.add(42)); // don't throw error but return false
  }


}
