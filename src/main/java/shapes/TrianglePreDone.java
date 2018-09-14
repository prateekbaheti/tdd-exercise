package shapes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.pow;

public class TrianglePreDone {

  private List<Integer> sides;

  public TrianglePreDone(int side1, int side2, int side3) {
    sides = Arrays.asList(side1, side2, side3);
    Collections.sort(sides);
  }


  public int perimeter() {
    return sides.stream().mapToInt(i -> i).sum();
  }

  public boolean isRightAngle() {
    return pow(sides.get(0), 2) + pow(sides.get(1), 2) == pow(sides.get(2), 2);
  }
}
