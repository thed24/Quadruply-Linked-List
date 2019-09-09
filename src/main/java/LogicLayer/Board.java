package LogicLayer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

  private List<IEntityObject> entityObjects = new ArrayList<>();
  protected Map<Point, IGameObject> boardMap = new HashMap<>();

  public Board(int mapWidth, int mapHeight) {
    for (int i = 0; i < mapWidth; i++) {
      for (int j = 0; j < mapHeight; j++) {
        boardMap.put(new Point(i, j), new Dot());
      }
    }
    entityObjects.add(new Pacman(new Point(mapWidth / 2, mapHeight / 2), "Pacman", this));
    boardMap.put(entityObjects.get(0).getCurrentPosition(), entityObjects.get(0));
  }

  public int getDotsRemaining() {
    return (int) boardMap.entrySet().stream()
        .filter(x -> x.getValue() instanceof Dot)
        .count();
  }

  public IEntityObject getGameObjectFromName(String gameObjectName) {
    return entityObjects.stream()
        .filter(x -> x.getName().equals(gameObjectName))
        .findFirst().orElse(null);
  }
}
