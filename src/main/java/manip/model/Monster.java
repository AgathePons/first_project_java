package manip.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Monster {
  private String name;
  private LocalDate birthdate;
  private Alignment alignment;
  @Builder.Default
  private List<Capacity> capacities = new ArrayList<>();

  public void addCapacity(Capacity capacity) {
    capacities.add(capacity);
  }

  @Override
  public String toString() {
    String output = name.toUpperCase() +
            " : " +
            alignment +
            "\nCapacities:";
    capacities.forEach(capacity -> capacity.toString());
    return output;
  }
}
