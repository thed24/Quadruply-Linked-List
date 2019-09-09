package LogicLayerTests;

import LogicLayer.Board;
import LogicLayer.Directions;
import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;

public class PacmanTests {

  @Test
  public void testPacmanCanRotateUp() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Up);
    Assert.assertEquals(Directions.Up,
        testBoard.getGameObjectFromName("Pacman").getCurrentDirection());
  }

  @Test
  public void testPacmanCanRotateLeft() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Left);
    Assert.assertEquals(Directions.Left,
        testBoard.getGameObjectFromName("Pacman").getCurrentDirection());
  }

  @Test
  public void testPacmanCanRotateDown() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Down);
    Assert.assertEquals(Directions.Down,
        testBoard.getGameObjectFromName("Pacman").getCurrentDirection());
  }

  @Test
  public void testPacmanCanRotateRight() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Right);
    Assert.assertEquals(Directions.Right,
        testBoard.getGameObjectFromName("Pacman").getCurrentDirection());
  }

  @Test
  public void testPacmanCanMoveUpOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(2, 3),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }

  @Test
  public void testPacmanCanMoveDownOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Down);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(2, 1),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }

  @Test
  public void testPacmanCanMoveLeftOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Left);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(1, 2),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }

  @Test
  public void testPacmanCanMoveRightOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Right);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(3, 2),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }

  @Test
  public void testPacmanCanWrapUpOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(2, 0),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }

  @Test
  public void testPacmanCanWrapDownOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Down);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(2, 4),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }

  @Test
  public void testPacmanCanWrapLeftOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Left);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(4, 2),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }

  @Test
  public void testPacmanCanWrapRightOnBoard() {
    Board testBoard = new Board(5, 5);
    testBoard.getGameObjectFromName("Pacman").updateCurrentDirection(Directions.Right);
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    Assert.assertEquals(new Point(0, 2),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }
}
