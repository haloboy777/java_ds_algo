public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] arr = {  1, 20, 20, 1 };
    int i = 0;
    int j = arr.length - 1;
    int max = Integer.MIN_VALUE;

    while (i < j) {
      int height = Math.min(arr[i], arr[j]);
      int width = j - i;

      if (height * width > max) {
        max = height * width;
      }
      if (arr[i] < arr[j]) i++; else j--;
    }
    System.out.println(max);
  }
}
