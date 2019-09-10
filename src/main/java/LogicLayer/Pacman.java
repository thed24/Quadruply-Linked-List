package LogicLayer;

import java.awt.Point;

public class Pacman implements IEntityObject {

  private Board gameBoard;
  private Point currentPosition;
  private Directions currentDirection;
  private String name;

  public Pacman(Point currentPosition, String name, Board gameBoard) {
    currentDirection = Directions.Up;
    this.currentPosition = currentPosition;
    this.name = name;
    this.gameBoard = gameBoard;
  }

  @Override
  public boolean isSolid() {
    return true;
  }

  @Override
  public boolean isEdible() {
    return true;
  }

  @Override
  public void effectWhenEaten() {
  }

  @Override
  public void updateCurrentDirection(Directions newDirection) {
    this.currentDirection = newDirection;
  }

  @Override
  public boolean isPathBlocked() {
    switch (getCurrentDirection()) {
      case Up:
        return gameBoard.boardMap.getValue(new Point(currentPosition.x, currentPosition.y + 1))
            .isSolid();
      case Down:
        return gameBoard.boardMap.getValue(new Point(currentPosition.x, currentPosition.y - 1))
            .isSolid();
      case Right:
        return gameBoard.boardMap.getValue(new Point(currentPosition.x + 1, currentPosition.y))
            .isSolid();
      case Left:
        return gameBoard.boardMap.getValue(new Point(currentPosition.x - 1, currentPosition.y))
            .isSolid();
    }
    return true;
  }

  @Override
  public void movePositionOnBoardValidation() {
    if (isPathBlocked()) {
      return;
    }
    movePositionOnBoard();
  }

  @Override
  public void movePositionOnBoard() {
    //gameBoard.boardMap.setValue(currentPosition, new Dot());
    gameBoard.boardMap.getNeighbouringNode(currentPosition, currentDirection).Value = this;
    currentPosition = gameBoard.boardMap.getNeighbouringNode(currentPosition, currentDirection).Position;
  }

  @Override
  public Directions getCurrentDirection() {
    return currentDirection;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Point getCurrentPosition() {
    return currentPosition;
  }

  @Override
  public String toString() {
    return "V";
  }
}
