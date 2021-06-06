import java.util.Arrays;

public class WaveArrays {

  public static void main(String[] args) {
    // int[] arr = { 1, 2, 3, 4, 62, 1, 5, 6, 89, 1, 2, 3, 6, 45, 2 };
    int[] arr = { 1, 2, 3, 4 };
    Arrays.sort(arr);
    int temp;
    for (int i = 0; i < arr.length-1; i = i + 2) {
      temp = arr[i];
      arr[i] = arr[i + 1];
      arr[i + 1] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }
}
