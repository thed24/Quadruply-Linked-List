package MultiLayerLinkedListTests;

import LogicLayer.Board;
import LogicLayer.Pacman;
import MultiLayerLinkedList.MultiLayerLinkedList;
import java.awt.Point;
import org.junit.Test;

public class MultiLayerLinkedListTests {

  @Test
  public void testLinkedListInitializesCorrectly() {
    MultiLayerLinkedList testBoard = new MultiLayerLinkedList(5, 5);
    for (int I = 0; I < 5; I++) {
      for (int J = 0; J < 5; J++) {
        System.out.print(testBoard.getValue(new Point(I, J)));
      }
      System.out.println();
    }
  }

  @Test
  public void testLinkedListInitializesCorrectlyWithPacman() {
    MultiLayerLinkedList testBoard = new MultiLayerLinkedList(5, 5);
    testBoard.setValue(new Point(2, 2), new Pacman(new Point(2, 2), "Pacman", new Board(5, 5)));
    for (int I = 0; I < 5; I++) {
      for (int J = 0; J < 5; J++) {
        System.out.print(testBoard.getValue(new Point(I, J)));
      }
      System.out.println();
    }
  }
}
