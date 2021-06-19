public class PowerOfTwoBinary {

  public static void main(String[] args) {
    String a = "1000100";
    int count = 0;
    int i = a.length() - 1;
    while (i > -1) {
      if (a.charAt(i) == '1') ++count;
      --i;
    }
    System.out.println(count);
  }
}
