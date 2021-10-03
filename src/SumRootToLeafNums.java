import dev.ayushsingh.tree.BinaryTree;
import dev.ayushsingh.tree.TreeNode;
import java.util.*;

public class SumRootToLeafNums {

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
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(pre));
    TreeNode x = BinaryTree.createTreeUsingArrayList(arr);
    BinaryTree.displayLevelOrder(x);
    System.out.println("============================");
    ArrayList<Double> nums = listOfNodesFromLeafNodes(x);
    System.out.println(nums);
    Double sum = 0.0;
    for (int i = 0; i < nums.size(); i++) sum += nums.get(i);
    System.out.println(sum.intValue());

    System.out.println(sumRootToLeafNums(x, 0) % 1003);
  }

  static int sumRootToLeafNums(TreeNode x, int val) {
    if (x == null) return 0;
    val = (val * 10) % 1003;
    val = (val + x.data) % 1003;
    if (x.left == null && x.right == null) {
      return val;
    }
    return (
      (
        sumRootToLeafNums(x.left, val) %
        1003 +
        sumRootToLeafNums(x.right, val) %
        1003
      ) %
      1003
    );
  }

  static ArrayList<Double> listOfNodesFromLeafNodes(TreeNode x) {
    ArrayList<Double> arr = new ArrayList<>();
    if (x == null) return arr;
    if (x.left == null && x.right == null) {
      arr.add(Double.valueOf(x.data));
      return arr;
    }

    ArrayList<Double> l = listOfNodesFromLeafNodes(x.left);
    ArrayList<Double> r = listOfNodesFromLeafNodes(x.right);

    for (int i = 0; i < l.size(); i++) l.set(
      i,
      ((x.data * (Math.pow(10, numLen(l.get(i))))) + l.get(i)) % 1003
    );

    for (int i = 0; i < r.size(); i++) r.set(
      i,
      ((x.data * (Math.pow(10, numLen(r.get(i))))) + r.get(i)) % 1003
    );

    arr.addAll(l);
    arr.addAll(r);

    return arr;
  }

  static int numLen(Double num) {
    int length = 0;
    long temp = 1;
    while (temp <= num) {
      length++;
      temp *= 10;
    }
    return length;
  }
}
