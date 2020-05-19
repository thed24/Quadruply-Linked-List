package QuadruplyLinkedList;

public class QuadruplyLinkedList<T> {

  private final Node<T> referenceNode;
  private final int width, height;
  private Node<T> rowIteratorNode;

  public QuadruplyLinkedList(int width, int height) {
    this.width = width;
    this.height = height;
    referenceNode = new Node<T>();
    Node<T> columnIteratorNode;
    rowIteratorNode = columnIteratorNode = referenceNode;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        createRows(width, i, j);
      }
      columnIteratorNode = createColumns(height, columnIteratorNode, i);
    }

    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {
        wrapNode(j, i);
        getNode(j, i).position = new Point(j, i);
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void setValue(Point coordinate, T value) {
    setRowIteratorNode(coordinate);
    rowIteratorNode.value = value;
  }

  public T getValue(Point coordinate) {
    setRowIteratorNode(coordinate);
    return rowIteratorNode.value;
  }

  public Node<T> getNode(int x, int y) {
    setRowIteratorNode(new Point(x, y));
    return rowIteratorNode;
  }

  private Node<T> createColumns(int height, Node<T> columnIteratorNode, int i) {
    if (i < height - 1) {
      columnIteratorNode.down = new Node<T>();
      columnIteratorNode.down.up = columnIteratorNode;
      rowIteratorNode = columnIteratorNode = columnIteratorNode.down;
    }
    return columnIteratorNode;
  }

  private void createRows(int width, int i, int j) {
    if (i == 0) {
      if (j < width - 1) {
        rowIteratorNode.right = new Node<T>();
        rowIteratorNode.right.left = rowIteratorNode;
        rowIteratorNode = rowIteratorNode.right;
      }
    } else {
      if (j < width - 1) {
        rowIteratorNode.right = new Node<T>();
        rowIteratorNode.up.down = rowIteratorNode;
        rowIteratorNode.right.left = rowIteratorNode;
        rowIteratorNode.right.up = rowIteratorNode.up.right;
        rowIteratorNode = rowIteratorNode.right;
      }
      if (j == width - 1) {
        rowIteratorNode.up.down = rowIteratorNode;
      }
    }
  }

  private void setRowIteratorNode(Point coordinate) {
    int x = coordinate.getX();
    int y = coordinate.getY();
    rowIteratorNode = referenceNode;

    for (int i = 0; i < y; ++i) {
      rowIteratorNode = rowIteratorNode.down;
    }

    for (int i = 0; i < x; ++i) {
      rowIteratorNode = rowIteratorNode.right;
    }
  }

  private void wrapNode(int x, int y) {
    Node<T> currentNode = getNode(x, y);
    rowIteratorNode = currentNode;

    if (x == 0) {
      rowIteratorNode.left = getNodeAtEdge(y, width - 1, currentNode);
    }

    if (y == 0) {
      rowIteratorNode.up = getNodeAtEdge(height - 1, x, currentNode);
    }

    if (x == width - 1) {
      rowIteratorNode.right = getNodeAtEdge(y, 0, currentNode);
    }

    if (y == height - 1) {
      rowIteratorNode.down = getNodeAtEdge(0, x, currentNode);
    }
  }

  private Node<T> getNodeAtEdge(int y, int x, Node<T> node) {
    Node<T> nodeAtEdge = getNode(x, y);
    rowIteratorNode = node;
    return nodeAtEdge;
  }
}
