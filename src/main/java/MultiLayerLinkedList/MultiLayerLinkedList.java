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
            rowIteratorNode.right = new Node();
            rowIteratorNode.right.left = rowIteratorNode;
            rowIteratorNode = rowIteratorNode.right;
          }
        } else {
          if (J < width - 1) {
            rowIteratorNode.right = new Node();
            rowIteratorNode.up.down = rowIteratorNode;
            rowIteratorNode.right.left = rowIteratorNode;
            rowIteratorNode.right.up = rowIteratorNode.up.right;
            rowIteratorNode = rowIteratorNode.right;
          }
          if (J == Width - 1) {
            rowIteratorNode.up.down = rowIteratorNode;
          }
        }
      }
      if (I < height - 1) {
        columnIteratorNode.down = new Node();
        columnIteratorNode.down.up = columnIteratorNode;
        rowIteratorNode = columnIteratorNode = columnIteratorNode.down;
      }
    }

    for (int I = 0; I < height; ++I) {
      for (int J = 0; J < width; ++J) {
        wrapNode(J, I);
      }
      System.out.println();
    }
  }

  public void setValue(int xAxisPosition, int yAxisPosition, int newValue) {
    rowIteratorNode = referenceNode;

    for (int I = 0; I < yAxisPosition; ++I) {
      rowIteratorNode = rowIteratorNode.down;
    }

    for (int J = 0; J < xAxisPosition; ++J) {
      rowIteratorNode = rowIteratorNode.right;
    }

    rowIteratorNode.value = newValue;
  }

  public int getValue(int xAxisPosition, int yAxisPosition) {
    rowIteratorNode = referenceNode;

    for (int I = 0; I < yAxisPosition; ++I) {
      rowIteratorNode = rowIteratorNode.down;
    }

    for (int J = 0; J < xAxisPosition; ++J) {
      rowIteratorNode = rowIteratorNode.right;
    }

    return rowIteratorNode.value;
  }

  public Node getNodeAtPosition(int xAxisPosition, int yAxisPosition) {
    rowIteratorNode = referenceNode;

    for (int I = 0; I < yAxisPosition; ++I) {
      rowIteratorNode = rowIteratorNode.down;
    }

    for (int J = 0; J < xAxisPosition; ++J) {
      rowIteratorNode = rowIteratorNode.right;
    }

    return rowIteratorNode;
  }

  private void wrapNode(int I, int J) {
    rowIteratorNode = getNodeAtPosition(I, J);

    if (I == 0) {
      Node newNode = getNodeAtPosition(height - 1, J);
      rowIteratorNode = getNodeAtPosition(I, J);
      rowIteratorNode.left = newNode;
    }

    if (J == 0) {
      Node newNode = getNodeAtPosition(I, width - 1);
      rowIteratorNode = getNodeAtPosition(I, J);
      rowIteratorNode.up = newNode;
    }

    if (I == width - 1) {
      Node newNode = getNodeAtPosition(0, J);
      rowIteratorNode = getNodeAtPosition(I, J);
      rowIteratorNode.right = newNode;
    }

    if (J == height - 1) {
      Node newNode = getNodeAtPosition(I, 0);
      rowIteratorNode = getNodeAtPosition(I, J);
      rowIteratorNode.down = newNode;
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
