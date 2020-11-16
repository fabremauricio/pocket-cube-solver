import java.util.function.Consumer;

public class Main {

  public static void main(String[] args) {
    Reader reader = new Reader();
    Solver solver = new Solver();
    //Cube cube = new Cube(reader.parseInput());

    Cube cube = Controller.shuffle(new Cube(), 7);
    System.out.println("Starting...");
    List<Movement> solution = solver.solve(cube);
    printSolution(solution);
  }

  public static void printSolution(List<Movement> list) {
    list.forEach(
      (Movement mov) -> {
        System.out.println("-> " + mov.type + " " + mov.cube.toString());
      }
    );
  }
}
