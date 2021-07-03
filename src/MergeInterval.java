import java.util.ArrayList;

public class MergeInterval {

  public static void main(String[] args) {
    Interval x = new Interval(4, 9);
    ArrayList<Interval> arr = new ArrayList<>();
    arr.add(new Interval(1, 2));
    arr.add(new Interval(3, 5));
    arr.add(new Interval(6, 7));
    arr.add(new Interval(8, 10));
    arr.add(new Interval(12, 16));
    System.out.println(mergeInterval(arr, x).toString());
  }

  static ArrayList<Interval> mergeInterval(
    ArrayList<Interval> arr,
    Interval x
  ) {
    if (arr == null || arr.size() == 0) {
      arr = new ArrayList<>();
      arr.add(x);
      return arr;
    }

    Interval toInsert = x;
    int i = 0;
    while (i < arr.size()) {
      Interval current = arr.get(i);
      if (current.end < toInsert.start) {
        i++;
        continue;
      } else if (current.start > toInsert.end) {
        arr.add(i, toInsert);
        break;
      } else {
        toInsert.start = Math.min(current.start, toInsert.start);
        toInsert.end = Math.max(current.end, toInsert.end);
        arr.remove(i);
      }
    }
    if (i == arr.size()) {
      arr.add(toInsert);
    }
    return arr;
  }

  static class Interval {

    public int start, end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "[" + this.start + " ," + this.end + "]";
    }
  }
}
