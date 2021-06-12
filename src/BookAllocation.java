import java.util.Arrays;

public class BookAllocation {

  public static void main(String[] args) {
    int[] arr = {5, 17, 100, 11};

    int ans = -1;
    int x = 4;

    if (arr.length < x) {
      System.out.println(ans);
      System.exit(0);
    }

    int start = Arrays.stream(arr).max().getAsInt();
    int end = Arrays.stream(arr).sum();

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (isValid(arr, mid, x)) {
        ans = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    System.out.println(ans);
    System.exit(0);
  }

  static boolean isValid(int[] arr, int max, int noOfStudents) {
    int student = 1;
    int sumTillNow = 0;
    for (int i = 0; i < arr.length; i++) {
      sumTillNow += arr[i];
      if (sumTillNow > max) {
        student++;
        sumTillNow = arr[i];
      }
    }
    if (student <= noOfStudents) return true;
    return false;
  }
}
