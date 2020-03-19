package QuadruplyLinkedList;

import java.util.Objects;

public class Point {

  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public boolean equals(Object otherPoint) {
    if (otherPoint == null) {
      return false;
    }
    if (getClass() != otherPoint.getClass()) {
      return false;
    }
    final Point other = (Point) otherPoint;
    return (this.x == other.x) && (this.y == other.y);
  }
}
