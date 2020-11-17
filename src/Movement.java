enum MovementType {
  INITIAL,
  FRONT_POS,
  FRONT_NEG,
  RIGHT_POS,
  RIGHT_NEG,
  TOP_POS,
  TOP_NEG,
}

public class Movement {

  public Cube cube;
  public MovementType type;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;

    Movement other = (Movement) o;
    return other.cube.equals(cube);
  }

  public Movement() {}

  public Movement(Cube cube, MovementType type) {
    this.cube = cube;
    this.type = type;
  }
}
