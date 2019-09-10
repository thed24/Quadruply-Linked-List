package LogicLayer;

public class Dot implements IGameObject {
  private boolean isEdible = true;

  @Override
  public boolean isSolid(){
    return false;
  }

  @Override
  public boolean isEdible() {
    return this.isEdible;
  }

  @Override
  public void effectWhenEaten() {
    this.isEdible = false;
  }

  @Override
  public String toString() {
    return ".";
  }
}
