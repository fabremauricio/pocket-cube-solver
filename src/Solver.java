import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solver {

  public void solve(Cube cube) {
    List<Movement> movements = new LinkedList<Movement>();
    List<Movement> best = new LinkedList<Movement>();

    movements.add(new Movement(cube, MovementType.INITIAL));

    System.out.println("Started...");
    backtracking(cube, movements, best);
    System.out.println("Finished...");
    printSolution(best);
  }

  private void backtracking(
    Cube cube,
    List<Movement> movements,
    List<Movement> best
  ) {
    if (cube.isSolved()) {
      System.out.println(
        "Solution of " + movements.size() + " movements found."
      );
      if (best.size() == 0 || movements.size() < best.size()) {
        best.clear();
        best.addAll(movements);
      }
    } else if (
      (best.size() == 0 || movements.size() < best.size() - 1) &&
      movements.size() < 14
    ) {
      int[] commands = Utils.generateRandomArray(6);
      for (int i = 0; i < 6; i++) {
        Movement mov = Controller.move(cube, commands[i]);

        if (!movements.contains(mov)) {
          movements.add(mov);
          backtracking(mov.cube, movements, best);
          movements.remove(movements.size() - 1);
        }
      }
    }
  }

  public void printSolution(List<Movement> list) {
    Iterator<Movement> movements = list.iterator();

    while (movements.hasNext()) {
      Movement mov = movements.next();
      System.out.println(mov.type);
    }
  }
}
