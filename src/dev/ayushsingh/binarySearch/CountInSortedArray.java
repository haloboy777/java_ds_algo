package dev.ayushsingh.binarySearch;
public class CountInSortedArray {

  public static void main(String[] args) {
    int[] arr = { 10, 10, 10, 10, 10, 10, 10, 10, 10 };
    int el = 5;
    int start = 0;
    int xstart = 0;
    int end = arr.length - 1;
    int xend = arr.length - 1;
    while (start <= end || xstart <= xend) {
      int mid1 = start + (end - start) / 2;
      int mid2 = xstart + (xend - xstart) / 2;
      if (arr[mid1] == el) end = mid1 - 1; else if (arr[mid1] > el) end =
        mid1 - 1; else start = mid1 + 1;

      if (arr[mid2] == el) xstart = mid2 + 1; else if (arr[mid2] > el) xend =
        mid2 - 1; else xstart = mid2 + 1;
    }
    System.out.println(xstart - start);
  }
}
