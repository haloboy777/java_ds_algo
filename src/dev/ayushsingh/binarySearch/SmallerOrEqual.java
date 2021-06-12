package dev.ayushsingh.binarySearch;

public class SmallerOrEqual {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 4, 4, 6 };
    System.out.println(solve(arr, 4));
  }

  static int solve(int[] arr, int el) {
    int l = 0;
    int h = arr.length - 1;
    int count = 0, increase = 0;
    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (arr[mid] > el) {
        h = mid - 1;
      } else {
        increase = mid - l + 1;
        count = count + increase;
        l = mid + 1;
      }
    }
    return count;
  }
}
