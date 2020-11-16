public class Movement {

  public Cube cube;
  public String type;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;

    Movement other = (Movement) o;
    return other.cube.equals(cube);
  }

  public Movement() {}

  public Movement(Cube cube, String type) {
    this.cube = cube;
    this.type = type;
  }
}
