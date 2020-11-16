public class Cube {

  private int[] colors;

  public Cube() {
    this.colors = new int[24];

    for (int i = 0; i < 6; i++) {
      int color = this.colors[i * 4];
      for (int j = 0; j < 4; j++) {
        this.colors[i * 4 + j] = i;
      }
    }
  }

  public Cube(Cube other) {
    this.colors = new int[24];

    for (int i = 0; i < 24; i++) {
      this.colors[i] = other.colors[i];
    }
  }

  public Cube(int[] colors) {
    this.colors = new int[24];

    int sum = 0;
    for (int i = 0; i < 24; i++) {
      this.colors[i] = colors[i];
      sum += colors[i];
    }

    if (sum != 60) {
      throw new Error("Wrong format");
    }
  }

  public void moveRight() {
    Utils.permutateCircular(this.colors, new int[] { FTR, TBR, BDR, DFR });
    Utils.permutateCircular(this.colors, new int[] { FDR, TFR, BTR, DBR });
    Utils.permutateCircular(this.colors, new int[] { RFT, RBT, RBD, RFD });
  }

  public void moveTop() {
    Utils.permutateCircular(this.colors, new int[] { FTR, LFT, BTL, RBT });
    Utils.permutateCircular(this.colors, new int[] { FTL, LBT, BTR, RFT });
    Utils.permutateCircular(this.colors, new int[] { TFR, TFL, TBL, TBR });
  }

  public void moveFront() {
    Utils.permutateCircular(this.colors, new int[] { TFR, RFD, DFL, LFT });
    Utils.permutateCircular(this.colors, new int[] { TFL, RFT, DFR, LFD });
    Utils.permutateCircular(this.colors, new int[] { FTR, FDR, FDL, FTL });
  }

  public boolean isSolved() {
    for (int i = 0; i < 6; i++) {
      int color = this.colors[i * 4];

      for (int j = 0; j < 4; j++) {
        if (this.colors[i * 4 + j] != color) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;

    Cube other = (Cube) o;

    for (int i = 0; i < 24; i++) {
      if (other.colors[i] != colors[i]) return false;
    }

    return true;
  }

  public String toString() {
    String line = "";
    for (int i = 0; i < this.colors.length; i++) {
      line += "[" + this.colors[i] + "]";
    }
    return line;
  }

  static final int FTR = 0;
  static final int FTL = 1;
  static final int FDR = 2;
  static final int FDL = 3;

  static final int BTR = 4;
  static final int BTL = 5;
  static final int BDR = 6;
  static final int BDL = 7;

  static final int TFR = 8;
  static final int TFL = 9;
  static final int TBR = 10;
  static final int TBL = 11;

  static final int DFR = 12;
  static final int DFL = 13;
  static final int DBR = 14;
  static final int DBL = 15;

  static final int RFT = 16;
  static final int RFD = 17;
  static final int RBT = 18;
  static final int RBD = 19;

  static final int LFT = 20;
  static final int LFD = 21;
  static final int LBT = 22;
  static final int LBD = 23;
}
