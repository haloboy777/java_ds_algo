
public class Test2 {

  public static void main(String[] args) {
    // YOUR CODE GOES HERE
    // Please take input and print output to standard input/output (stdin/stdout)
    // DO NOT USE ARGUMENTS FOR INPUTS
    // E.g. 'Scanner' for input & 'System.out' for output
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    // for (int i = 0; i < n; i++) {
    //   array[i] = sc.nextInt();
    // }
    int i = 0;
    int j = array.length - 1;
    int temp;
    while (i < j) {
      temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i = i + 1;
      j = j - 1;
    }
    for (int k = 0; k < array.length; k++) {
      System.out.print(array[k] + "\t");
    }
    // sc.close();
  }
}
