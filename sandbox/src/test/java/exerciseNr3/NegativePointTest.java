package exerciseNr3;

import org.testng.Assert;
import org.testng.annotations.Test;
import piotr.javaCourse.sandbox.excerciseNr2.Point;

public class NegativePointTest {

  @Test
  public void testArea() {
    Point p1 = new Point(1,10);
    Point p2 = new Point(4, 8);
    Assert.assertNotEquals(p1.distance(p2), 0);
  }
}
