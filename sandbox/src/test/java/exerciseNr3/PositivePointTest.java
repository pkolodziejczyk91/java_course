package exerciseNr3;

import org.testng.Assert;
import org.testng.annotations.Test;
import piotr.javaCourse.sandbox.excerciseNr2.Point;

public class PositivePointTest {
  @Test
  public void testArea() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(2, 2);
    Assert.assertEquals(p1.distance(p2), 0);
  }
}
