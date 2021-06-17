
public class SingleNumber {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 2, 3, 1, 3, 11, 12, 11 };

    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      res = arr[i] ^ res;
    }
    System.out.println(res);
  }
}
