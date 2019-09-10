package LogicLayer;

import MultiLayerLinkedList.MultiLayerLinkedList;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Board {

  private List<IEntityObject> entityObjects = new ArrayList<>();
  protected MultiLayerLinkedList boardMap;

  public Board(int mapWidth, int mapHeight) {
    boardMap = new MultiLayerLinkedList(mapHeight, mapWidth);
    for (int i = 0; i < mapWidth; i++) {
      for (int j = 0; j < mapHeight; j++) {
        boardMap.setValue(new Point(i, j), new Dot());
      }
    }
    entityObjects.add(new Pacman(new Point(mapWidth / 2, mapHeight / 2), "Pacman", this));
    boardMap.setValue(entityObjects.get(0).getCurrentPosition(), entityObjects.get(0));
  }

  public IEntityObject getGameObjectFromName(String gameObjectName) {
    return entityObjects.stream()
        .filter(x -> x.getName().equals(gameObjectName))
        .findFirst().orElse(null);
  }

  public boolean isObjectAtPositionFood(Point positionOnMap) {
    return boardMap.getValue(positionOnMap) instanceof Dot;
  }

  public boolean isObjectAtPositionPacman(Point positionOnMap) {
    return boardMap.getValue(positionOnMap) instanceof Pacman;
  }
}
