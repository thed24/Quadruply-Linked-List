package MultiLayerLinkedList;

public class MultiLayerLinkedList {

  private Node referenceNode;
  private Node rowIteratorNode;
  private Node columnIteratorNode;
  private int width, height;

  public MultiLayerLinkedList(int width, int height) {
    this.width = width;
    this.height = height;
    referenceNode = new Node();
    rowIteratorNode = columnIteratorNode = referenceNode;

    for (int I = 0; I < height; ++I) {
      for (int J = 0; J < width; ++J) {
        if (I == 0) {
          if (J < width - 1) {
            rowIteratorNode.Right = new Node();
            rowIteratorNode.Right.Left = rowIteratorNode;
            rowIteratorNode = rowIteratorNode.Right;
          }
        } else {
          if (J < width - 1) {
            rowIteratorNode.Right = new Node();
            rowIteratorNode.Up.Down = rowIteratorNode;
            rowIteratorNode.Right.Left = rowIteratorNode;
            rowIteratorNode.Right.Up = rowIteratorNode.Up.Right;
            rowIteratorNode = rowIteratorNode.Right;
          }
        }
      }
      if (I < height - 1) {
        columnIteratorNode.Down = new Node();
        columnIteratorNode.Down.Up = columnIteratorNode;
        rowIteratorNode = columnIteratorNode = columnIteratorNode.Down;
      }
    }

    for (int I = 0; I < height; ++I) {
      for (int J = 0; J < width; ++J) {
        wrapNode(I, J);
      }
      System.out.println();
    }
  }

  public void setValue(int xAxisPosition, int yAxisPosition, int newValue) {
    rowIteratorNode = referenceNode;

    for (int I = 0; I < yAxisPosition; ++I) {
      rowIteratorNode = rowIteratorNode.Down;
    }

    for (int J = 0; J < xAxisPosition; ++J) {
      rowIteratorNode = rowIteratorNode.Right;
    }

    rowIteratorNode.Value = newValue;
  }

  public int getValue(int xAxisPosition, int yAxisPosition) {
    rowIteratorNode = referenceNode;

    for (int I = 0; I < yAxisPosition; ++I) {
      rowIteratorNode = rowIteratorNode.Down;
    }

    for (int J = 0; J < xAxisPosition; ++J) {
      rowIteratorNode = rowIteratorNode.Right;
    }

    return rowIteratorNode.Value;
  }

  public Node getNodeAtPosition() {
    int X = coordinate.x;
    int Y = coordinate.y;

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
      Node newNode = getNode(height - 1, J);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Left = newNode;
    }

    if (J == 0) {
      Node newNode = getNode(I, width - 1);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Up = newNode;
    }

    if (I == width - 1) {
      Node newNode = getNode(0, J);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Right = newNode;
    }

    if (J == height - 1) {
      Node newNode = getNode(I, 0);
      rowIteratorNode = getNode(I, J);
      rowIteratorNode.Down = newNode;
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
