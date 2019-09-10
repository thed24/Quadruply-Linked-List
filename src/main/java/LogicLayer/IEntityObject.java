package LogicLayer;

import java.awt.Point;

public interface IEntityObject extends IGameObject {

  void updateCurrentDirection(Directions newDirection);

  boolean isPathBlocked();

  void movePositionOnBoardValidation();

  void movePositionOnBoard();

  Directions getCurrentDirection();

  String getName();

  Point getCurrentPosition();
}
