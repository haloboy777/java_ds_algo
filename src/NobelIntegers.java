import java.util.Arrays;

public class NobelIntegers {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 62, 1, 5, 6, 89, 1, 2, 3, 6, 45, 2 };
    sort(arr, 0, arr.length - 1);
    for (int i = arr.length - 1; i > -1; i--) {
      if (arr.length - i == arr[i]) {
        System.out.println(String.format("num %d %d", arr[i], i));
        break;
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr, int start, int end) {
    if (start < end) {
      int p = piviotIndex(arr, start, end);
      sort(arr, start, p - 1);
      sort(arr, p + 1, end);
    }
  }

  private static int piviotIndex(int[] arr, int start, int end) {
    // piviotIndex always work between the start and end index;
    int p = start;
    int temp = arr[end];
    for (int i = start; i < end; i++) {
      if (arr[i] <= temp) {
        swap(arr, p, i);
        p++;
      }
    }
    swap(arr, p, end);
    return p;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
