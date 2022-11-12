package manip.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCapacity {
  @Test
  void testDefaultConstructor() {
    Capacity capacity = new Capacity();
    assertNull(capacity.getTitle());
    assertNull(capacity.getDescription());
    assertEquals(0, capacity.getValue());
  }
  @Test
  void testAllArgsConstructor() {
    Capacity capacity = new Capacity(
            "Fire ball",
            "Throws a ball of fire",
            25
    );
    assertEquals("Fire ball", capacity.getTitle());
    assertEquals("Throws a ball of fire", capacity.getDescription());
    assertEquals(25, capacity.getValue());
  }
  @Test
  void testToString() {
    Capacity capacity = Capacity.builder()
            .title("Fire ball")
            .description("Throws a ball of fire")
            .value(25)
            .build();
    assertEquals(
            "\nCapacity: Fire ball\nvalue: 25\n-> Throws a ball of fire",
            capacity.toString()
    );
  }
}