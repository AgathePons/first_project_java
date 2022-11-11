package manip.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestMonster {
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
    System.out.println(monster.toString());
  }
  @Test
  void testAddCapacity() {

  }
  @Test
  void testAddCapacitiesCollection() {

  }
  @Test
  void testAddCapacitiesVarArgs() {

  }
  @Test
  void testToString() {

  }
}