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
        return gameBoard.boardMap.get(new Point(currentPosition.x, currentPosition.y + 1))
            .isSolid();
      case Down:
        return gameBoard.boardMap.get(new Point(currentPosition.x, currentPosition.y - 1))
            .isSolid();
      case Right:
        return gameBoard.boardMap.get(new Point(currentPosition.x + 1, currentPosition.y))
            .isSolid();
      case Left:
        return gameBoard.boardMap.get(new Point(currentPosition.x - 1, currentPosition.y))
            .isSolid();
    }
    return true;
  }

  @Override
  public boolean isPathAtEndOfMap() {
    switch (getCurrentDirection()) {
      case Up:
        return currentPosition.y == gameBoard.boardMap.keySet().stream().map(
            iGameObject -> iGameObject.y).reduce(Integer::max).orElse(0);
      case Down:
        return currentPosition.y == 0;
      case Right:
        return currentPosition.x == gameBoard.boardMap.keySet().stream().map(
            iGameObject -> iGameObject.x).reduce(Integer::max).orElse(0);
      case Left:
        return currentPosition.x == 0;
    }
    return true;
  }

  @Override
  public void movePositionOnBoardValidation() {
    if (isPathAtEndOfMap()) { //fix breaking path blocked null pointer
      movePositionOnBoardWithWrapping();
      return;
    }
    if (isPathBlocked()) {
      return;
    }
      movePositionOnBoard();
  }

  @Override
  public void movePositionOnBoard() {
    switch (currentDirection) {
      case Up:
        currentPosition.y += 1;
        break;
      case Down:
        currentPosition.y -= 1;
        break;
      case Left:
        currentPosition.x -= 1;
        break;
      case Right:
        currentPosition.x += 1;
        break;
    }
  }

  @Override
  public void movePositionOnBoardWithWrapping() {
    switch (currentDirection) {
      case Up:
        currentPosition.y = 0;
        break;
      case Down:
        currentPosition.y = gameBoard.boardMap.keySet().stream().map(
            iGameObject -> iGameObject.y).reduce(Integer::max).orElse(0);
        break;
      case Right:
        currentPosition.x = 0;
        break;
      case Left:
        currentPosition.x = gameBoard.boardMap.keySet().stream().map(
            iGameObject -> iGameObject.x).reduce(Integer::max).orElse(0);
        break;
    }
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
}
