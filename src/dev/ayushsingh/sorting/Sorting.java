package dev.ayushsingh.sorting;

// import java.util.Arrays;

public class Sorting {

  // public static void main(String[] args) {
  //   int[] arr = { 1, 2, 10, 64, 6, 4, 3, 67, 8, 3, 5, 6, 7, 12 };
  //   int[] aux = { 2, 3, 11, 65, 7, 5, 4, 68, 9, 3, 6, 7, 8, 13 };
  //   // selectionSort(arr);
  //   // insertionSort(arr);
  //   // bubbleSort(arr);
  //   // mergeSort(arr, 0, arr.length - 1);
  //   // quicksort(arr, aux, 0, arr.length - 1);
  //   System.out.println(Arrays.toString(arr));
  //   System.out.println(Arrays.toString(aux));
  // }

  private Sorting() {}

  public static void selectionSort(int[] arr) {
    int len = arr.length;
    int temp;
    for (int i = 0; i < len - 1; i++) {
      temp = i;
      for (int j = i; j < len; j++) {
        if (arr[j] < arr[temp]) {
          temp = j;
        }
      }
      swap(arr, temp, i);
    }
  }

  public static void insertionSort(int[] arr) {
    int temp, holePos;
    for (int i = 1; i < arr.length; i++) {
      holePos = i;
      temp = arr[i];
      while (arr[holePos - 1] > temp && holePos > 0) {
        arr[holePos] = arr[holePos - 1];
        holePos = holePos - 1;
      }
      arr[holePos] = temp;
    }
  }

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (arr[i] > arr[j]) swap(arr, i, j);
      }
    }
  }

  public static void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merger(arr, start, mid, end);
    }
  }

  private static void merger(int[] arr, int start, int mid, int end) {
    int i = start, j = mid + 1, k = 0;
    int[] temp = new int[end - start + 1];
    while (i <= mid && j <= end) {
      if (arr[i] > arr[j]) {
        temp[k] = arr[j];
        j++;
      } else {
        temp[k] = arr[i];
        i++;
      }
      k++;
    }
    while (i <= mid) {
      temp[k] = arr[i];
      i++;
      k++;
    }
    while (j <= end) {
      temp[k] = arr[j];
      j++;
      k++;
    }
    for (i = start; i <= end; i += 1) {
      arr[i] = temp[i - start];
    }
  }

  public static void quickSortTwo(int[] arr, int[] aux, int start, int end) {
    if (start < end) {
      int p = partitionTwo(arr, aux, start, end);
      quickSortTwo(arr, aux, start, p - 1);
      quickSortTwo(arr, aux, p + 1, end);
    }
  }

  private static int partitionTwo(int[] arr, int[] aux, int start, int end) {
    int p = start;
    int temp = arr[end];
    for (int i = start; i < end; i++) {
      if (arr[i] < temp) {
        swap(arr, i, p);
        swap(aux, i, p);
        p++;
      }
    }
    swap(arr, p, end);
    swap(aux, p, end);
    return p;
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int p = partition(arr, start, end);
      quickSort(arr, start, p - 1);
      quickSort(arr, p + 1, end);
    }
  }

  private static int partition(int[] arr, int start, int end) {
    int p = start;
    int temp = arr[end];
    for (int i = start; i < end; i++) {
      if (arr[i] < temp) {
        swap(arr, i, p);
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
