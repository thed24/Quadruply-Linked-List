package MultiLayerLinkedList;

import LogicLayer.Directions;
import LogicLayer.IGameObject;
import java.awt.Point;

public class MultiLayerLinkedList {

  private Node referenceNode;
  private Node rowIteratorNode;
  private Node columnIterator;
  private int width, height;

  public MultiLayerLinkedList(int Width, int Height) {
    width = Width;
    height = Height;
    referenceNode = new Node();
    rowIteratorNode = columnIterator = referenceNode;

    for (int I = 0; I < Height; ++I) {
      for (int J = 0; J < Width; ++J) {
        if (I == 0) { //if first row
          if (J < Width - 1) { //if not end of column
            rowIteratorNode.Right = new Node();
            rowIteratorNode.Right.Left = rowIteratorNode;
            rowIteratorNode = rowIteratorNode.Right;
          }
        } else {
          if (J < Width - 1) {//if not end of column
            if (J == 0) {//if first column
              rowIteratorNode.Up = columnIterator; //Up is self reference
            }
            rowIteratorNode.Right = new Node();
            rowIteratorNode.Up.Down = rowIteratorNode; //Up alters own down
            rowIteratorNode.Right.Left = rowIteratorNode;
            rowIteratorNode.Right.Up = rowIteratorNode.Up.Right;
            rowIteratorNode = rowIteratorNode.Right;
          }
        }
      }
      if (I < Height - 1) {
        columnIterator.Down = new Node();
        columnIterator.Down.Up = columnIterator;
        columnIterator = columnIterator.Down;
        rowIteratorNode = columnIterator;
      }
    }

    for (int I = 0; I < Height; ++I) {
      for (int J = 0; J < Width; ++J) {
        wrapNode(I, J);
        getNode(I, J).Position = new Point(I, J);
      }
      System.out.println();
    }
  }

  public void setValue(Point coordinate, IGameObject Value) {
    int X = coordinate.x;
    int Y = coordinate.y;
    rowIteratorNode = referenceNode;

    for (int I = 0; I < Y; ++I) {
      rowIteratorNode = rowIteratorNode.Down;
    }

    for (int J = 0; J < X; ++J) {
      rowIteratorNode = rowIteratorNode.Right;
    }

    rowIteratorNode.Value = Value;
  }

  public IGameObject getValue(Point coordinate) {
    int X = coordinate.x;
    int Y = coordinate.y;

    rowIteratorNode = referenceNode;

    for (int I = 0; I < Y; ++I) {
      rowIteratorNode = rowIteratorNode.Down;
    }

    for (int J = 0; J < X; ++J) {
      rowIteratorNode = rowIteratorNode.Right;
    }

    return rowIteratorNode.Value;
  }

  public Node getNeighbouringNode(Point coordinate, Directions currentDirection) {
    int X = coordinate.x;
    int Y = coordinate.y;

    rowIteratorNode = referenceNode;

    for (int I = 0; I < Y; ++I) {
      rowIteratorNode = rowIteratorNode.Down;
    }

    for (int J = 0; J < X; ++J) {
      rowIteratorNode = rowIteratorNode.Right;
    }

    switch (currentDirection) {
      case Up:
        return rowIteratorNode.Up;
      case Down:
        return rowIteratorNode.Down;
      case Left:
        return rowIteratorNode.Left;
      case Right:
        return rowIteratorNode.Right;
    }
    return null;
  }

  private Node getNode(int X, int Y) {
    rowIteratorNode = referenceNode;

    for (int I = 0; I < Y; ++I) {
      rowIteratorNode = rowIteratorNode.Down;
    }

    for (int J = 0; J < X; ++J) {
      rowIteratorNode = rowIteratorNode.Right;
    }

    return rowIteratorNode;
  }

  private void wrapNode(int I, int J) {
    rowIteratorNode = getNode(I, J);

    if (I == 0) {
      Node newNode = getNode(I, height - 1);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Left = newNode;
    }

    if (J == 0) {
      Node newNode = getNode(width - 1, I);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Up = newNode;
    }

    if (I == width - 1) {
      Node newNode = getNode(I, 0);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Right = newNode;
    }

    if (J == height - 1) {
      Node newNode = getNode(0, J);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Down = newNode;
    }
  }

  public int GetWidth() {
    return width;
  }

  public int GetHeight() {
    return height;
  }
}
