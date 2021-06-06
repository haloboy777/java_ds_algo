public class ExcelDigit {

  public static void main(String[] args) {
    // System.out.println(excelColumn(943566));
    System.out.println(excelColumn(52));
  }

  static String excelColumn(int num) {
    StringBuilder s = new StringBuilder();
    int r;
    char x;
    while (num > 0) {
      r = num % 26;
      num /= 26;
      if (r != 0) x = (char) (r - 1 + (int) 'A'); else {
        x = 'Z';
        num--;
      }
      System.out.printf("%d %c %d\n", r, x, num);
      s.append(x);
    }
    return s.reverse().toString();
  }
}
