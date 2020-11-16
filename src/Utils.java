import java.util.Random;

public class Utils {

  public static int[] randomArray(int size) {
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

  public static void permutateCircular(int[] array, int[] permutations) {
    int last = array[permutations[permutations.length - 1]];

    for (int i = permutations.length - 1; i > 0; i--) {
      int from = permutations[i - 1];
      int to = permutations[i];

      array[to] = array[from];
    }

    array[permutations[0]] = last;
  }
}
