package MultiLayerLinkedList;

import LogicLayer.Dot;
import LogicLayer.IGameObject;
import java.awt.Point;

public class Node {
  public Node Up, Down, Left, Right;
  public Point Position;
  public IGameObject Value;

  public Node() {
    Value = new Dot();
    Position = new Point(0,0);
    Up = Down = Left = Right = null;
  }
}
