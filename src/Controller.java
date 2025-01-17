public class Controller {

  public static Cube moveRightPos(Cube cube) {
    /** TODO */
  }

  public static Cube moveRightNeg(Cube cube) {
    /** TODO */
  }

  public static Cube moveFrontPos(Cube cube) {
    /** TODO */
  }

  public static Cube moveFrontNeg(Cube cube) {
    /** TODO */
  }

  public static Cube moveTopPos(Cube cube) {
    /** TODO */
  }

  public static Cube moveTopNeg(Cube cube) {
    /** TODO */
  }

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
}
