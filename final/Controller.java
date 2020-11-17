public class Controller {

  public static Movement move(Cube cube, int command) {
    Movement movement = new Movement();
    if (command == 0) {
      movement.cube = moveFrontPos(cube);
      movement.type = MovementType.FRONT_POS;
    } else if (command == 1) {
      movement.cube = moveFrontNeg(cube);
      movement.type = MovementType.FRONT_NEG;
    } else if (command == 2) {
      movement.cube = moveTopPos(cube);
      movement.type = MovementType.TOP_POS;
    } else if (command == 3) {
      movement.cube = moveTopNeg(cube);
      movement.type = MovementType.TOP_NEG;
    } else if (command == 4) {
      movement.cube = moveRightPos(cube);
      movement.type = MovementType.RIGHT_POS;
    } else if (command == 5) {
      movement.cube = moveRightNeg(cube);
      movement.type = MovementType.RIGHT_NEG;
    }

    return movement;
  }

  public static Cube shuffle(Cube cube, int steps) {
    Cube output = cube;

    for (int i = 0; i < steps; i++) {
      int command = (int) (Math.random() * 6);
      output = move(output, command).cube;
    }

    return output;
  }

  public static Cube moveRightPos(Cube cube) {
    Cube result = new Cube(cube);
    result.moveRight();
    return result;
  }

  public static Cube moveRightNeg(Cube cube) {
    Cube result = new Cube(cube);
    result.moveRight();
    result.moveRight();
    result.moveRight();
    return result;
  }

  public static Cube moveFrontPos(Cube cube) {
    Cube result = new Cube(cube);
    result.moveFront();
    return result;
  }

  public static Cube moveFrontNeg(Cube cube) {
    Cube result = new Cube(cube);
    result.moveFront();
    result.moveFront();
    result.moveFront();
    return result;
  }

  public static Cube moveTopPos(Cube cube) {
    Cube result = new Cube(cube);
    result.moveTop();
    return result;
  }

  public static Cube moveTopNeg(Cube cube) {
    Cube result = new Cube(cube);
    result.moveTop();
    result.moveTop();
    result.moveTop();
    return result;
  }
}
