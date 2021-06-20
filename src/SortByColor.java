import java.util.ArrayList;

public class SortByColor {

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(0);
    a.add(1);
    a.add(0);
    a.add(0);
    a.add(1);
    a.add(0);
    a.add(0);
    a.add(2);
    a.add(1);
    a.add(2);
    a.add(0);
    a.add(0);
    a.add(0);
    a.add(0);
    a.add(1);
    a.add(1);
    a.add(1);
    a.add(2);
    a.add(2);
    a.add(1);
    a.add(1);
    a.add(2);
    a.add(0);
    a.add(0);
    a.add(2);
    quickSort(a, 0, a.size() - 1);
  }

  static void quickSort(ArrayList<Integer> arr, int start, int end) {
    if (start < end) {
      int p = partition(arr, start, end);
      quickSort(arr, start, p - 1);
      quickSort(arr, p + 1, end);
    }
  }

  static int partition(ArrayList<Integer> arr, int start, int end) {
    int piviot = arr.get(end);
    int p = start;

    for (int i = start; i < end; i++) {
      if (arr.get(i) < piviot) {
        swap(arr, i, p);
        p++;
      }
    }

    swap(arr, p, end);
    return p;
  }

  static void swap(ArrayList<Integer> arr, int i, int j) {
    int temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }
}
