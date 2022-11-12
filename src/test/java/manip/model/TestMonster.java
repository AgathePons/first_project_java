package manip.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestMonster {

  static Monster monster;
  static List<Capacity> capacityList;
  static Capacity capacity1;
  static Capacity capacity2;
  static Capacity capacity3;

  @BeforeAll
  static void initData() {
    monster = Monster.builder()
            .name("Green dragon")
            .birthdate(LocalDate.of(2020, 11, 28))
            .alignment(Alignment.EVIL)
            .build();

    capacityList = List.of(
            Capacity.builder()
              .title("Fire Ball")
              .description("Throws a ball of fire")
              .value(25)
              .build(),
            Capacity.builder()
                    .title("Venomous scratch")
                    .description("Scratch with its paw and poisons its victim")
                    .value(15)
                    .build(),
            Capacity.builder()
                    .title("Wild cry")
                    .description("Frighten its victim with a wild cry")
                    .value(5)
                    .build()
    );

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
  }

  @Test
  void testDefaultConstructor() {
    Monster monster = new Monster();
    assertNull(monster.getName());
    assertNull(monster.getBirthdate());
    assertNull(monster.getAlignment());
    assertEquals(0, monster.getCapacities().size());
  }
  @Test
  void testAllArgsConstructor() {
    LocalDate birthdate = LocalDate.of(2020, 11, 28);
    List<Capacity> capacities = new ArrayList<>();
    Monster monster = new Monster(
            "Green dragon",
            birthdate,
            Alignment.EVIL,
            capacities
    );
    assertEquals("Green dragon", monster.getName());
    assertEquals(LocalDate.of(2020, 11, 28), monster.getBirthdate());
    assertEquals(Alignment.EVIL, monster.getAlignment());
    assertSame(capacities, monster.getCapacities());
  }
  @Test
  void testAddCapacity() {
    monster.addCapacity(capacity1);
    assertTrue(monster.getCapacities().contains(capacity1), "capacity1 is contained in monster");
  }
  @Test
  void testAddCapacitiesCollection() {
    monster.addCapacities(capacityList);
    assertAll(capacityList.stream()
            .map(capacity -> () -> assertTrue(
                    monster.getCapacities().contains(capacity),
                    "capacity " + capacity.getTitle() + " is contained in monster"
            ))
    );
  }
  @Test
  void testAddCapacitiesVarArgs() {
    monster.addCapacities(capacity1, capacity2, capacity3);
    assertAll(Stream.of(capacity1, capacity2, capacity3)
            .map(capacity -> () -> assertTrue(
                    monster.getCapacities().contains(capacity),
                    "capacity " + capacity.getTitle() + " is contained in monster"
            ))
    );
  }
  @Test
  void testToStringWithCapacity() {
    monster.addCapacity(capacity1);
    assertEquals(
            "GREEN DRAGON : EVIL\n-- Capacities --\n>>\t Fire Ball\n\tvalue: 25\n\t-> Throws a ball of fire",
            monster.toString()
    );
  }
  @Test
  void testToStringWithoutCapacity() {
    assertEquals(
            "GREEN DRAGON : EVIL\n-- Capacities --\n\tno capacity",
            monster.toString()
    );
  }
}