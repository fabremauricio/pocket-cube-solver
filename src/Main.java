import java.util.function.Consumer;

public class Main {

  public static void main(String[] args) {
    //Reader reader = new Reader();
    //Cube cube = new Cube(reader.parseInput());

    Cube cube = Controller.shuffle(new Cube(), 7);
    System.out.println("Starting...");
    List<Movement> solution = solve(cube);
    printSolution(solution);
  }

  public static List<Movement> solve(Cube cube) {
    List<Movement> movements = new List<Movement>();
    List<Movement> best = new List<Movement>();

    movements.add(new Movement(cube, "Initial "));
    backtracking(cube, movements, best);

    return best;
  }

  public static void printSolution(List<Movement> list) {
    list.forEach(
      (Movement mov) -> {
        System.out.println("-> " + mov.type + " " + mov.cube.toString());
      }
    );
  }

  public static void backtracking(
    Cube cube,
    List<Movement> movements,
    List<Movement> best
  ) {
    if (cube.isSolved()) {
      System.out.println(
        "Solution of " + movements.size() + " movements found."
      );
      if (best.size() == 0 || movements.size() < best.size()) {
        best.copy(movements);
      }
    } else if (
      (best.size() == 0 || movements.size() < best.size() - 1) &&
      movements.size() < 14
    ) {
      int[] commands = Utils.randomArray(6);
      for (int i = 0; i < 6; i++) {
        Movement mov = Controller.move(cube, commands[i]);

        if (!movements.contains(mov)) {
          movements.add(mov);
          backtracking(mov.cube, movements, best);
          movements.remove();
        }
      }
    }
  }
}
