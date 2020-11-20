import java.util.Random;

public class Utils {

  public static int[] generateRandomArray(int size) {
    Random random = new Random();
    int[] array = new int[size];

    for (int i = 0; i < size; i++) {
      array[i] = i;
    }

    for (int i = 0; i < size; i++) {
      int randomIndex = random.nextInt(size);
      int aux = array[randomIndex];

      array[randomIndex] = array[i];
      array[i] = aux;
    }

    return array;
  }

  public static void permutateCyclic(int[] array, int[] cycle) {
    int last = array[cycle[cycle.length - 1]];

    for (int i = cycle.length - 1; i > 0; i--) {
      int from = cycle[i - 1];
      int to = cycle[i];

      array[to] = array[from];
    }

    array[cycle[0]] = last;
  }
}
