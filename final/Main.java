public class Main {

  public static void main(String[] args) {
    greeting();
    //testRandomArray();
    //testPermutateCircular();
    //testRandomCube();
    //testUserDefinedCube();
  }

  public static void greeting() {
    System.out.println("Welcome!");
  }

  public static void testRandomCube() {
    Solver solver = new Solver();
    Cube cube = Controller.shuffle(new Cube(), 7);
    solver.solve(cube);
  }

  public static void testUserDefinedCube() {
    Solver solver = new Solver();
    Reader reader = new Reader();
    Cube cube = new Cube(reader.parseInput());
    solver.solve(cube);
  }

  public static void testRandomArray() {
    int[] array = Utils.generateRandomArray(6);
    printArray(array);
  }

  public static void testPermutateCircular() {
    int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
    printArray(array);
    Utils.permutateCircular(array, new int[] { 0, 1, 2 });
    printArray(array);
  }

  public static void printArray(int[] array) {
    String line = "";

    for (int i = 0; i < array.length; i++) {
      line += "[" + array[i] + "]";
    }

    System.out.println(line);
  }
}
