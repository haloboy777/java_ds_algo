package dev.ayushsingh.binarySearch;

public class FindInSortedRowAndColumn {

  public static void main(String[] args) {
    int[][] arr = {
      { 10, 20, 30, 40 },
      { 15, 25, 35, 45 },
      { 27, 29, 37, 48 },
      { 32, 33, 39, 50 },
    };
    int el = 30;

    int i = 0, ix = arr.length - 1;
    int j = 0, jx = arr[0].length - 1;

    while (i <= ix) {
      int mid = i + (ix - i) / 2;

      if (arr[mid][0] == el) {
        System.out.printf("A > [%d, %d]\n", mid, 0);
        break;
      } 
      else if (arr[mid][0] > el) ix = mid - 1; 
      else if (arr[mid][0] < el) i = mid + 1;
    }

    int row = ix;

    while (j <= jx) {
      int mid = j + (jx - j) / 2;

      if (arr[row][mid] == el) {
        System.out.printf("B > [%d, %d]\n", row, mid);
        break;
      } 
      else if (arr[row][mid] > el) jx = mid - 1; 
      else if (arr[row][mid] < el) j = mid + 1;
    }

    System.out.println("lol kuch nahi mila -1,-1");
  }
}
