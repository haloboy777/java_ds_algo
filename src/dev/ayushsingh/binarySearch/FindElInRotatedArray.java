package dev.ayushsingh.binarySearch;

public class FindElInRotatedArray {

  public static void main(String[] args) {
    int[] arr = { 15, 16,17, 18, 2, 3, 5, 6, 7, 9, 10, 11, 12, 13 };

    int start = 0;
    int end = arr.length - 1;
    int res = -1;
    while (start <= end) {
      if (arr[start] <= arr[end]) {
        res = start;
        break;
      }
      int mid = start + (end - start) / 2;
      int prev = (mid - 1 + arr.length) % arr.length;
      int next = (mid + 1) % arr.length;

      if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
        res = mid;
        break;
      } else if (arr[mid] >= arr[start]) {
        start = mid + 1;
      } else if (arr[mid] <= arr[end]) {
        end = mid - 1;
      }
    }
    System.out.println("Array is " + res + " times rotated clockwise.");
    System.out.println(
      "Array is " + (arr.length - res) + " times rotated clockwise."
    );
  }

  int findElInArr(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      if (arr[start] <= arr[end]) return start;

      int mid = start + (end - start) / 2;
      int prev = (mid - 1 + arr.length) % arr.length;
      int next = (mid + 1) % arr.length;

      if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) return mid; else if (
        arr[mid] <= arr[end]
      ) end = mid - 1; else if (arr[mid] >= arr[start]) start = mid + 1;
    }
    return -1;
  }
}
