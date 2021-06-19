import java.util.HashSet;

public class PairWithGivenDifference {

  public static void main(String[] args) {
    int[] arr = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322 };
    int b = -42;
    // int[] arr = {-259, -825, 459, 825, 221, 870, 626, 934, 205, 783, 850, 398};

    int i = 0;
    HashSet<Integer> set = new HashSet<>();

    while (i < arr.length) {
      if (set.contains(arr[i] + b) || set.contains(arr[i] - b)) System.exit(0);
      set.add(arr[i]);
      i++;
    }

    System.out.println("not found");
  }
}
