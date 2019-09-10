package ConsoleLayer;

import LogicLayer.Board;
import java.awt.Point;

public class ConsolePrinter {

  private int mapWidth;
  private int mapHeight;
  private Board gameBoard;

  public ConsolePrinter(int mapWidth, int mapHeight, Board gameBoard) {
    this.gameBoard = gameBoard;
    this.mapHeight = mapHeight;
    this.mapWidth = mapWidth;
  }

  public void printCurrentTick() {
    for (int i = mapWidth - 1; i > -1; i--){
      for (int j = 0; j < mapHeight; j++){
        if (gameBoard.isObjectAtPositionPacman(new Point(j, i))){
          System.out.print("V"); //Change for direction
        }
        else if (gameBoard.isObjectAtPositionFood(new Point(j, i))){
          System.out.print("."); //Change if eaten
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}