package piotr.javaCourse.sandbox.excerciseNr2;

public class ExerciseNr2 {
  public static void main(String[] args) {

    Point p1 = new Point(1,10);
    Point p2 = new Point(4, 8);

    System.out.println("The distance between points with coordinates " + p1.x + ", " + p1.y + " and " + p2.x + ", " + p2.y + " equals " + Point.distance(p1, p2));
  }
}
