import java.util.ArrayList;
import java.util.Stack;

public class LargestAreaInHistogram {

  public static void main(String[] args) {
    int[] aa = {
      94,
      47,
      69,
      67,
      97,
      86,
      34,
      98,
      16,
      65,
      95,
      66,
      69,
      18,
      1,
      99,
      56,
      35,
      9,
      48,
      72,
      49,
      47,
      1,
      72,
      87,
      52,
      13,
      23,
      95,
      55,
      21,
      92,
      36,
      88,
      48,
      39,
      84,
      16,
      15,
      65,
      7,
      58,
      2,
      21,
      54,
      2,
      71,
      92,
      96,
      100,
      28,
      31,
      24,
      10,
      94,
      5,
      81,
      80,
      43,
      35,
      67,
      33,
      39,
      81,
      69,
      12,
      66,
      87,
      86,
      11,
      49,
      94,
      38,
      44,
      72,
      44,
      18,
      97,
      23,
      11,
      30,
      72,
      51,
      61,
      56,
      41,
      30,
      71,
      12,
      44,
      81,
      43,
      43,
      27,
    };
    // int[] a = { 2, 1, 5, 6, 2, 3 };
    ArrayList<Integer> arr = new ArrayList<>();
    for (int x : aa) {
      arr.add(x);
    }
    System.out.println(areaOfHistogramFast(arr));
  }

  static int areaOfHistogram(ArrayList<Integer> arr) {
    int maxArea = Integer.MIN_VALUE;
    int n = arr.size();
    int minHeight, len;
    for (int i = n - 1; i >= 0; i--) {
      minHeight = arr.get(i);
      for (int j = i - 1; j >= 0; j--) {
        minHeight = Math.min(minHeight, arr.get(j));
        len = i - j + 1;
        if (minHeight * len > maxArea) {
          maxArea = minHeight * len;
        }
      }
    }

    return maxArea;
  }

  static int areaOfHistogramFast(ArrayList<Integer> arr) {
    Stack<Integer> s = new Stack<>();
    int maxArea = 0;

    s.push(-1);
    for (int i = 0; i < arr.size(); i++) {
      while (s.peek() != -1 && arr.get(s.peek()) >= arr.get(i)) {
        maxArea = Math.max(maxArea, arr.get(s.pop()) * (i - s.peek() - 1));
      }
      s.push(i);
    }
    while (s.peek() != -1) {
      maxArea =
        Math.max(maxArea, arr.get(s.pop()) * (arr.size() - s.peek() - 1));
    }

    return maxArea;
  }

  static class Pair {

    public int index;
    public int height;

    Pair(int height, int index) {
      this.height = height;
      this.index = index;
    }
  }
}
