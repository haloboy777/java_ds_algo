public class AmazingSubarray {

  public static void main(String[] args) {
    String A = "ABEC";
    int n = A.length(), count = 0;
    for (int i = 0; i < n; i++) {
      if ("aeiouAEIOU".indexOf(A.charAt(i)) != -1) {
        count += n - i;
      }
    }
    System.out.println(count % 10003);
  }
}
