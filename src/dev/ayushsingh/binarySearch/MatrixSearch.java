package dev.ayushsingh.binarySearch;

// import java.util.Arrays;

public class MatrixSearch {

  public static void main(String[] args) {
    int[][] arr = { { 1, 4, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
    // int[][] arr = {
    //   { 3, 3, 11, 12, 14 },
    //   { 16, 17, 30, 34, 35 },
    //   { 45, 48, 49, 50, 52 },
    //   { 56, 59, 63, 63, 65 },
    //   { 67, 71, 72, 73, 79 },
    //   { 80, 84, 85, 85, 88 },
    //   { 88, 91, 92, 93, 94 },
    // };
    int el = 51;
    // find i
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid][0] == el) {
        System.out.println(mid);
        System.out.println(0);
        throw new Error("the element was found");
      } else if (arr[mid][0] > el) end = mid - 1; else start = mid + 1;
    }

    if (end >= 0 && start <= arr.length) {
      int low = 0;
      int high = arr[end].length - 1;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[end][mid] == el) {
          System.out.println(end);
          System.out.println(mid);
          break;
        } else if (arr[end][mid] > el) high = mid - 1; else low = mid + 1;
      }
    } else {
      System.out.println("not found");
    }
  }
}
