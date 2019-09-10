package ConsoleLayerTests;

import ConsoleLayer.ConsolePrinter;
import LogicLayer.Board;
import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;

public class ConsolePrinterTests {

  @Test
  public void testPrinter() {
    Board testBoard = new Board(5, 5);
    ConsolePrinter testPrinter = new ConsolePrinter(5, 5, testBoard);
    testPrinter.printCurrentTick();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testPrinter.printCurrentTick();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testPrinter.printCurrentTick();
    testBoard.getGameObjectFromName("Pacman").movePositionOnBoardValidation();
    testPrinter.printCurrentTick();
    Assert.assertEquals(new Point(2, 0),
        testBoard.getGameObjectFromName("Pacman").getCurrentPosition());
  }
}
