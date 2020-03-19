package QuadruplyLinkedList;

public class Node<T> {

  public Point position;
  public T value;
  Node<T> up, down, left, right;

  Node() {
    up = down = left = right = null;
  }
}
