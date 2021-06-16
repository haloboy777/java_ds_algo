public class ReverseInt {

  public static void main(String[] args) {
    long res = 0;
    long a = 3;

    for (int i = 0; i < 63; i++) {
      if ((a & (1l << i)) == (1l << i)) {
        res = res | (1l << (62 - i));
      }
    }
    System.out.println(res);
  }
}
