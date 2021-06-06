
public class MaxUnsortedSubarray {

  public static void main(String[] args) {
    // int[] arr = { 1, 2, 10, 64, 6, 4, 3, 67, 8, 3, 5, 6, 7, 12 };
    int[] arr = { 1, 3, 2, 4, 5 }; // []
    // int[] arr = { 4, 15, 4, 4, 15, 18, 20 }; // [1, 3]
    // int[] arr = { 1, 2, 3, 6, 5, 4, 7, 8 };
    // int[] arr = { 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 };
    int front = 0;
    int front_max = arr[front];
    int back = arr.length - 1;
    int back_max = arr[back];
    while (front <= back) {
      if (arr[front] >= front_max && arr[back] > arr[front]) {
        front_max = arr[front];
        front++;
      } else if (arr[back] <= back_max && arr[back] > arr[front]) {
        back_max = arr[back];
        back--;
      } else {
        if (back_max <= front_max) {
          System.out.printf("[%d, %d]", front - 1, back);
        } else if (back_max > front_max) {
          System.out.printf("[%d, %d]", front - 1, back);
        }
        break;
      }
    }
    // System.out.printf("[%d, %d]", front, back);
  }
  
}
