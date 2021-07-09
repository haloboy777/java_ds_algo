import java.util.ArrayList;
import java.util.HashSet;

public class ValidSudoku {

  public static void main(String[] args) {
    ArrayList<String> sudoku = new ArrayList<>();
    sudoku.add("53..7....");
    sudoku.add("6..195...");
    sudoku.add(".98....6.");
    sudoku.add("8...6...3");
    sudoku.add("4..8.3..1");
    sudoku.add("7...2...6");
    sudoku.add(".6....28.");
    sudoku.add("...419..5");
    sudoku.add("....8..79");

    for (int i = 0; i < 9; i++) {
      if (!(validColumn(sudoku, i) && validRow(sudoku, i))) {
        System.out.println("not valid");
        System.exit(0);
      }
    }
    System.out.println(validBlockGrid(sudoku));
  }

  static boolean validRow(ArrayList<String> sudoku, int i) {
    if (sudoku.size() != 9) return false;
    HashSet<Integer> set = new HashSet<>();
    String row = sudoku.get(i);
    int a;
    for (Character x : row.toCharArray()) {
      if (!x.equals('.')) {
        a = Character.getNumericValue(x);
        if (a > 9 || a < 0) {
          // value out of range
          return false;
        }
        if (!set.add(a)) {
          return false;
        }
      }
    }
    return true;
  }

  static boolean validColumn(ArrayList<String> sudoku, int i) {
    HashSet<Integer> set = new HashSet<>();
    int a;
    Character x;
    for (String s : sudoku) {
      if (s.length() != 9) return false;
      x = s.charAt(i);
      if (!x.equals('.')) {
        a = Character.getNumericValue(x);
        if (a > 9 || a < 0) {
          return false;
        }
        if (!set.add(a)) {
          return false;
        }
      }
    }
    return true;
  }

  static boolean validBlockGrid(ArrayList<String> sudoku) {
    String s;
    Character x;
    int a;
    HashSet<Integer> set;
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        set = new HashSet<>();
        for (int k = 0; k < 3; k++) {
          s = sudoku.get(i + k);
          for (int l = 0; l < 3; l++) {
            x = s.charAt(j + l);
            if (!x.equals('.')) {
              a = Character.getNumericValue(x);
              if (a > 9 || a < 0) {
                return false;
              }
              if (!set.add(a)) {
                return false;
              }
            }
          }
        }
      }
    }

    return true;
  }
}
