package LogicLayer;

import java.awt.Point;

public interface IEntityObject extends IGameObject {

  void updateCurrentDirection(Directions newDirection);

  boolean isPathBlocked();

  boolean isPathAtEndOfMap();

  void movePositionOnBoardValidation();

  void movePositionOnBoard();

  void movePositionOnBoardWithWrapping();

  Directions getCurrentDirection();

  String getName();

  Point getCurrentPosition();
}
