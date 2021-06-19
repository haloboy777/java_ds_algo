public class ThreeSum {

  public static void main(String[] args) {
    int[] arr = {
      -259,
      -825,
      459,
      825,
      221,
      870,
      626,
      934,
      205,
      783,
      850,
      398,
    };
    int val = 500;
    int sum = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (Math.abs(arr[i] + arr[j] + arr[k] - val) < sum) {
            sum = Math.abs(arr[i] + arr[j] + arr[k] - val);
            System.out.println(
              arr[i] +
              " + " +
              arr[j] +
              " + " +
              arr[k] +
              " - " +
              val +
              " = " +
              sum
            );
          }
        }
      }
    }
    System.out.println(sum);
  }
}
