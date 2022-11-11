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
    return "\n>> " +
            title +
            "\nvalue: " +
            value +
            "\n-> " +
            description;
  }
}
