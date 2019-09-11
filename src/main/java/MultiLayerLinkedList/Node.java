package MultiLayerLinkedList;

import LogicLayer.Dot;
import LogicLayer.IGameObject;
import java.awt.Point;

public class Node {
  public Node up, down, left, right;
  public int value;

  public Node() {
    value = 0;
    up = down = left = right = null;
  }
}
