package manip.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Capacity {
  private String title;
  private  String description;
  private int value;

  @Override
  public String toString() {
    return "\n>>\t " +
            title +
            "\n\tvalue: " +
            value +
            "\n\t-> " +
            description;
  }
}
