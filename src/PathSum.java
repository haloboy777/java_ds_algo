import dev.ayushsingh.tree.BinaryTree;
import dev.ayushsingh.tree.TreeNode;
import java.util.*;

public class PathSum {

  public static void main(String[] args) {
    Integer[] pre = {
      1,
      2,
      4,
      7,
      null,
      null,
      8,
      null,
      null,
      null,
      3,
      5,
      9,
      null,
      null,
      4,
      null,
      null,
      6,
      3,
      null,
      null,
      4,
      null,
      null,
    };
    // Integer[] pre2 = { 1000, 200, null, null, null };
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(pre));
    TreeNode x = BinaryTree.createTreeUsingArrayList(arr);

    System.out.println(pathToSum(x, 0, 18));
    System.out.println(hasPathSum(x, 18));
  }

  static int pathToSum(TreeNode x, int sum, int target) {
    if (x == null) return 0;
    if (x.data + sum == target && x.left == null && x.right == null) return 1;

    if (pathToSum(x.left, sum + x.data, target) == 1) return 1;
    if (pathToSum(x.right, sum + x.data, target) == 1) return 1;

    return 0;
  }

  static int hasPathSum(TreeNode A, int B) {
    if (A == null) return 0;
    if (A.data == B && A.left == null && A.right == null) return 1;
    if (hasPathSum(A.left, B - A.data) == 1) return 1;
    return hasPathSum(A.right, B - A.data);
  }
}
