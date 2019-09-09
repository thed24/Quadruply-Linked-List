package LogicLayerTests;

import LogicLayer.Board;
import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;

public class BoardTests {

  @Test
  public void testBoardGeneratesCorrectAmountOfDots() {
    Board testBoard = new Board(5, 5);
    Assert.assertEquals(24, testBoard.getDotsRemaining());
  }

  @Test
  public void testBoardGeneratesPacmanInMiddle() {
    Board testBoard = new Board(5, 5);
    Assert.assertEquals(new Point(2, 2),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }
}
