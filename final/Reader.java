import java.util.Scanner;

public class Reader {

  public static String COLOR_RED = "R";
  public static String COLOR_GREEN = "G";
  public static String COLOR_BLUE = "B";
  public static String COLOR_WHITE = "W";
  public static String COLOR_YELLOW = "Y";
  public static String COLOR_ORANGE = "O";

  public static int VALUE_COLOR_RED = 0;
  public static int VALUE_COLOR_GREEN = 1;
  public static int VALUE_COLOR_BLUE = 2;
  public static int VALUE_COLOR_WHITE = 3;
  public static int VALUE_COLOR_YELLOW = 4;
  public static int VALUE_COLOR_ORANGE = 5;

  public int[] parseInput() {
    System.out.println("Use one of: ( r | g | b | o | w | y )");
    Scanner in = new Scanner(System.in);
    int[] colors = new int[24];

    colors[Cube.FTR] = parseColor("Front Top Right: ", in);
    colors[Cube.FTL] = parseColor("Front Top Left: ", in);
    colors[Cube.FDR] = parseColor("Front Down Right: ", in);
    colors[Cube.FDL] = parseColor("Front Down Left: ", in);

    colors[Cube.BTR] = parseColor("Back Top Right: ", in);
    colors[Cube.BTL] = parseColor("Back Top Left: ", in);
    colors[Cube.BDR] = parseColor("Back Down Right: ", in);
    colors[Cube.BDL] = parseColor("Back Down Left: ", in);

    colors[Cube.TFR] = parseColor("Top Front Right: ", in);
    colors[Cube.TFL] = parseColor("Top Front Left: ", in);
    colors[Cube.TBR] = parseColor("Top Back Right: ", in);
    colors[Cube.TBL] = parseColor("Top Back Left: ", in);

    colors[Cube.DFR] = parseColor("Down Front Right: ", in);
    colors[Cube.DFL] = parseColor("Down Front Left: ", in);
    colors[Cube.DBR] = parseColor("Down Back Right: ", in);
    colors[Cube.DBL] = parseColor("Down Back Left: ", in);

    colors[Cube.RFT] = parseColor("Right Front Top: ", in);
    colors[Cube.RFD] = parseColor("Right Front Down: ", in);
    colors[Cube.RBT] = parseColor("Right Back Top: ", in);
    colors[Cube.RBD] = parseColor("Right Back Down: ", in);

    colors[Cube.LFT] = parseColor("Left Front Top: ", in);
    colors[Cube.LFD] = parseColor("Left Front Down: ", in);
    colors[Cube.LBT] = parseColor("Left Back Top: ", in);
    colors[Cube.LBD] = parseColor("Left Back Down: ", in);

    return colors;
  }

  private int parseColor(String message, Scanner in) {
    int color = -1;
    boolean parsed = false;

    while (!parsed) {
      System.out.print(message);
      String s = in.nextLine().toUpperCase();

      if (s.equals(COLOR_RED)) {
        color = VALUE_COLOR_RED;
        parsed = true;
      } else if (s.equals(COLOR_GREEN)) {
        color = VALUE_COLOR_GREEN;
        parsed = true;
      } else if (s.equals(COLOR_BLUE)) {
        color = VALUE_COLOR_BLUE;
        parsed = true;
      } else if (s.equals(COLOR_WHITE)) {
        color = VALUE_COLOR_WHITE;
        parsed = true;
      } else if (s.equals(COLOR_YELLOW)) {
        color = VALUE_COLOR_YELLOW;
        parsed = true;
      } else if (s.equals(COLOR_ORANGE)) {
        color = VALUE_COLOR_ORANGE;
        parsed = true;
      } else {
        System.out.println("Use one of: ( r | g | b | o | w | y )");
      }
    }

    return color;
  }
}
