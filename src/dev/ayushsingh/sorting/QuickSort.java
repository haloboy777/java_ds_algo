package dev.ayushsingh.sorting;

public class QuickSort {

  public static void main(String[] args) {
    
  }

  static void quicksort(int[] arr, int start, int end) {
    if (start < end) {
      int p = piviot(arr, start, end);
      quicksort(arr, start, p - 1);
      quicksort(arr, p + 1, end);
    }
  }

  static int piviot(int[] arr, int start, int end) {
    int piviot = arr[end];
    int p = start;

    for (int i = start; i < end; i++) {
      if (arr[i] < piviot) {
        swap(arr, i, p);
        p++;
      }
    }
    swap(arr, p, end);
    return p;
  }

  static void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }
}
