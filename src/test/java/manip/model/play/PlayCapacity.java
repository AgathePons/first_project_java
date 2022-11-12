package manip.model.play;

import manip.model.Capacity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayCapacity {
  static Capacity capacity1;
  static Capacity capacity2;
  static Capacity capacity3;
  static Capacity capacity4;

  @BeforeAll
  static void initCapacities() {
    capacity1 = Capacity.builder()
            .title("Fire Ball")
            .description("Throws a ball of fire")
            .value(25)
            .build();
    capacity2 = Capacity.builder()
            .title("Venomous scratch")
            .description("Scratch with its paw and poisons its victim")
            .value(15)
            .build();
    capacity3 = Capacity.builder()
            .title("Wild cry")
            .description("Frighten its victim with a wild cry")
            .value(5)
            .build();
    capacity4 = Capacity.builder()
            .title("YOLO attack")
            .description("Do whatever anyhow and see what happen")
            .value(20)
            .build();
  }

  @Test
  void playWithCapacity() {
    List<Capacity> capacities = new ArrayList<>();
    Collections.addAll(
            capacities,
            capacity1,
            capacity2,
            capacity3,
            capacity4
    );
    // for of
    for (Capacity capacity: capacities) {
      System.out.println(
              ">> The capacity \"" +
                      capacity.getTitle() +
                      "\" inflicts " +
                      capacity.getValue() +
                      " points"
      );
    }
    // for each
    capacities.forEach(capacity -> System.out.println(
            capacity.getTitle().toUpperCase() +
                    ": " +
                    capacity.getDescription() +
                    " (" +
                    capacity.getValue() +
                    "pts)"
    ));
    // map
    List<Integer> valueList = capacities.stream()
            .map(capacity -> capacity.getValue())
            .toList();
    System.out.println(valueList);
  }
}
