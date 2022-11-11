package manip.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

  public void addCapacities(Collection<? extends Capacity> otherCapacities) {
    capacities.addAll(otherCapacities);
  }

  public void addCapacities(Capacity... otherCapacities) {
    Collections.addAll(capacities, otherCapacities);
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
