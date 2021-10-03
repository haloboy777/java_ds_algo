package dev.ayushsingh.tree;

import java.util.*;

public class BinaryTree {

  /**
   * 50 -> 25
   * 50 -> 75
   * 25 -> 12
   * 25 -> 37
   * 37 -> 30
   * 75 -> 62
   * 75 -> 87
   * 62 -> 70
   *
   * Preorder
   * 50 25 12 null null 37 30 null null null 75 62 null 70 null null 87 null null
   */
  static class PairNode {

    int state;
    TreeNode node;

    PairNode(TreeNode n) {
      this.node = n;
      this.state = 1;
    }

    public void incrementState() {
      this.state += 1;
    }

    public int getState() {
      return this.state;
    }
  }

  // create tree using preorder array
  public static void main(String[] args) {
    Integer[] pre = {
      50,
      25,
      12,
      null,
      null,
      37,
      30,
      null,
      null,
      null,
      75,
      62,
      null,
      65,
      null,
      null,
      87,
      null,
      null,
    };
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(pre));

    Integer[] in = { 12, 25, 30, 37, 50, 62, 65, 75, 87 };
    ArrayList<Integer> inArr = new ArrayList<>(Arrays.asList(in));
    Integer[] post = { 12, 30, 37, 25, 65, 62, 87, 75, 50 };
    ArrayList<Integer> postArr = new ArrayList<>(Arrays.asList(post));

    TreeNode x = createTreeUsingArrayList(arr);
    // preorder(x);
    // System.out.println(size(x));
    // System.out.println(max(x));
    // System.out.println(sum(x));
    // System.out.println(height(x));
    displayLevelOrder(x);
    System.out.println("============================");
    // System.out.println(iterative(x));
    // iterativePreorder1(x);
    // iterativePreorder2(x);
    // System.out.println(nodeToRootPath(x, 70));
    // displayKthLevel(x, 3);
    // printKLevelsDown(x, 2);
    // printNodesKLevelFar(x, 30, 2);
    // printPathFromRootToLeaf(x, " ", 0, 250, 200);

    // TreeNode t = leftClonedTree(x);
    // TreeNode k = cureLeftCloneTree(t);
    // preorder(k);

    // removeLeaves(x);
    // preorder(x);
    // printSingleChildNode(x);
    // System.out.println(calculateDiameter(x));
    // System.out.println(diameter1(x));
    // System.out.println(diameter2(x).ht + " " + diameter2(x).dia);
    // System.out.println(callCount);
    // TiltPair k = getTilt(x);
    // System.out.println(k.sum + " " + k.tilt);
    // System.out.println(diameter3ReturnsHeight(x) + " " + maxDia);
    // System.out.println(isBST(x).toString());
    // System.out.println(isBT(x).isBT);
    // displayInOrder(x);
    // System.out.println();
    // displayPostOrder(x);

    TreeNode k = createTreeUsingInorderAndPostOrder(
      inArr,
      postArr,
      0,
      postArr.size() - 1,
      0,
      inArr.size() - 1
    );

    displayLevelOrder(k);
  }

  static TreeNode createTreeUsingInorderAndPostOrder(
    ArrayList<Integer> in,
    ArrayList<Integer> post,
    int psi,
    int pei,
    int isi,
    int iei
  ) {
    if (psi > pei || isi > iei) return null;

    TreeNode root = new TreeNode(post.get(pei));
    // find next root
    int nextRootIndex = isi;
    while (in.get(nextRootIndex) != root.data) nextRootIndex++;

    root.left =
      createTreeUsingInorderAndPostOrder(
        in,
        post,
        psi,
        psi + nextRootIndex - isi - 1,
        isi,
        nextRootIndex - 1
      );
    root.right =
      createTreeUsingInorderAndPostOrder(
        in,
        post,
        psi + nextRootIndex - isi,
        pei - 1,
        nextRootIndex + 1,
        iei
      );

    return root;
  }

  static class BTPair {

    int ht;
    boolean isBT;
  }

  static BTPair isBT(TreeNode x) {
    BTPair k = new BTPair();
    if (x == null) {
      k.ht = -1;
      k.isBT = true;
      return k;
    }

    BTPair l = isBT(x.left);
    BTPair r = isBT(x.right);

    k.isBT = l.isBT && r.isBT && Math.abs(l.ht - r.ht) <= 1;
    k.ht = Math.max(l.ht, r.ht) + 1;

    return k;
  }

  // static int callCount = 0;
  static class BSTPair {

    int max;
    int min;
    boolean isBST;

    @Override
    public String toString() {
      return "isBST: " + isBST;
    }
  }

  static BSTPair isBST(TreeNode x) {
    BSTPair k = new BSTPair();
    if (x == null) {
      k.isBST = true;
      k.max = Integer.MIN_VALUE;
      k.min = Integer.MAX_VALUE;
      return k;
    }

    BSTPair l = isBST(x.left);
    BSTPair r = isBST(x.right);

    k.isBST = l.isBST && r.isBST && (l.max <= x.data) && (x.data <= r.min);
    k.min = Math.min(x.data, Math.min(l.min, r.min));
    k.max = Math.max(x.data, Math.max(l.max, r.max));

    return k;
  }

  static boolean isBinarySearchTree(TreeNode x) {
    // Trash, doesn't work
    // fails on a node containing a left node greater than its parent

    if (x == null) return true;

    boolean l = isBinarySearchTree(x.left);
    if (!l) return false;
    boolean r = isBinarySearchTree(x.right);
    if (!r) return false;

    if (x.left != null && x.right != null) {
      return (x.left.data <= x.data) && (x.data <= x.right.data);
    }
    if (x.left == null && x.right != null) {
      return x.data <= x.right.data;
    }
    if (x.left != null && x.right == null) {
      return x.left.data <= x.data;
    }

    return true;
  }

  static class TiltPair {

    int tilt;
    int sum;
  }

  static TiltPair getTilt(TreeNode x) {
    TiltPair k = new TiltPair();
    if (x == null) {
      k.sum = 0;
      k.tilt = 0;
      return k;
    }
    TiltPair l = getTilt(x.left);
    TiltPair r = getTilt(x.right);

    k.sum = l.sum + r.sum + x.data;
    k.tilt = Math.abs(l.sum - r.sum);

    return k;
  }

  static int diameter1(TreeNode x) {
    // callCount += 1;
    if (x == null) return -1;
    int ld = diameter1(x.left);
    int rd = diameter1(x.right);

    int h = height(x.left) + height(x.right) + 2;

    return Math.max(h, Math.max(ld, rd));
  }

  static class DiaPair {

    int dia;
    int ht;
  }

  static DiaPair diameter2(TreeNode x) {
    // callCount += 1;
    DiaPair k = new DiaPair();
    if (x == null) {
      k.dia = 0;
      k.ht = -1;
      return k;
    }

    DiaPair ln = diameter2(x.left);
    DiaPair rn = diameter2(x.right);

    int h = ln.ht + rn.ht + 2;

    k.dia = Math.max(h, Math.max(ln.dia, rn.dia));
    k.ht = Math.max(ln.ht, rn.ht) + 1;

    return k;
  }

  static int maxDia = Integer.MIN_VALUE;

  static int diameter3ReturnsHeight(TreeNode x) {
    if (x == null) return 0;

    int lh = diameter3ReturnsHeight(x.left);
    int rh = diameter3ReturnsHeight(x.left);

    int d = lh + rh + 2;

    maxDia = Math.max(d, maxDia);

    return Math.max(lh, rh) + 1;
  }

  static TreeNode removeLeaves(TreeNode x) {
    if (x == null) return null;
    if (x.left == null && x.right == null) return null;

    x.left = removeLeaves(x.left);
    x.right = removeLeaves(x.right);

    return x;
  }

  static void printSingleChildNode(TreeNode x) {
    if (x == null) return;
    if (
      (x.left == null && x.right != null) || (x.left != null && x.right == null)
    ) {
      System.out.println(x.data);
    }
    printSingleChildNode(x.left);
    printSingleChildNode(x.right);
  }

  static TreeNode cureLeftCloneTree(TreeNode x) {
    if (x == null) return null;
    x.left = cureLeftCloneTree(x.left.left);
    x.right = cureLeftCloneTree(x.right);
    return x;
  }

  static TreeNode leftClonedTree(TreeNode x) {
    if (x == null) return null;
    x.left = new TreeNode(x.data, leftClonedTree(x.left), null);
    x.right = leftClonedTree(x.right);
    return x;
  }

  static void printPathFromRootToLeaf(
    TreeNode x,
    String path,
    int sum,
    int hi,
    int lo
  ) {
    if (x == null) return;
    if (x.left == null && x.right == null) {
      sum += x.data;
      if (sum >= lo && sum <= hi) {
        System.out.println(path + x.data);
      }
      return;
    }
    printPathFromRootToLeaf(x.left, path + x.data + " ", sum + x.data, hi, lo);
    printPathFromRootToLeaf(x.right, path + x.data + " ", sum + x.data, hi, lo);
  }

  static void printNodesKLevelFar(TreeNode x, int data, int k) {
    ArrayList<TreeNode> arr = nodeToRootPath(x, data);
    for (int i = 0; i < arr.size(); i++) {
      printKLevelsDownWithBlocker(
        arr.get(i),
        k - i,
        i == 0 ? null : arr.get(i - 1)
      );
    }
  }

  static void printKLevelsDownWithBlocker(TreeNode x, int k, TreeNode blocker) {
    if (x == null || k < 0 || x == blocker) return;
    if (k == 0) System.out.println(x.data);

    printKLevelsDownWithBlocker(x.left, k - 1, blocker);
    printKLevelsDownWithBlocker(x.right, k - 1, blocker);
  }

  static void printKLevelsDown(TreeNode x, int k) {
    if (x == null || k < 0) return;
    if (k == 0) System.out.println(x.data);

    printKLevelsDown(x.left, k - 1);
    printKLevelsDown(x.right, k - 1);
  }

  static void displayKthLevel(TreeNode x, int k) {
    if (x == null) return;
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(x);
    TreeNode el;
    int level = 0;
    while (!q.isEmpty()) {
      int c = q.size();
      ++level;
      for (int i = 0; i < c; i++) {
        el = q.poll();
        if (level == k) System.out.print(el.data + " "); else {
          if (el.left != null) q.add(el.left);
          if (el.right != null) q.add(el.right);
        }
      }
    }
  }

  static ArrayList<TreeNode> nodeToRootPath(TreeNode x, int data) {
    ArrayList<TreeNode> list = new ArrayList<>();
    if (x == null) return list;
    if (x.data == data) {
      list.add(x);
      return list;
    }
    if (x.left != null) list = nodeToRootPath(x.left, data);
    if (!list.isEmpty()) {
      list.add(x);
      return list;
    }
    if (x.right != null) list = nodeToRootPath(x.right, data);
    if (!list.isEmpty()) list.add(x);
    return list;
  }

  static void iterativePreorder1(TreeNode x) {
    if (x == null) return;
    Stack<TreeNode> s = new Stack<>();
    s.add(x);
    TreeNode k;
    while (!s.isEmpty()) {
      k = s.pop();
      System.out.print(k.data + " ");
      if (k.right != null) s.add(k.right);
      if (k.left != null) s.add(k.left);
    }
    System.out.println();
  }

  static void iterativePreorder2(TreeNode x) {
    if (x == null) return;
    Stack<TreeNode> s = new Stack<>();
    TreeNode k = x;

    // the key to this algorithm is not to push left node and simply iterate over it.
    while (!s.isEmpty() || k != null) {
      while (k != null) {
        System.out.print(k.data + " ");
        if (k.right != null) s.push(k.right);
        k = k.left;
      }
      if (!s.isEmpty()) k = s.pop();
    }
  }

  static ArrayList<ArrayList<Integer>> iterative(TreeNode x) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    list.add(new ArrayList<>()); // pre
    list.add(new ArrayList<>()); // in
    list.add(new ArrayList<>()); // post
    if (x == null) return list;

    Stack<PairNode> s = new Stack<>();
    s.add(new PairNode(x));
    PairNode top;

    while (!s.isEmpty()) {
      top = s.peek();
      if (top.state == 1) {
        // add to pre list
        // then add it to stack top
        list.get(0).add(top.node.data);
        if (top.node.left != null) s.add(new PairNode(top.node.left));
        top.state += 1;
      } else if (top.state == 2) {
        // add to in list
        // then add it to stack top
        list.get(1).add(top.node.data);
        if (top.node.right != null) s.add(new PairNode(top.node.right));
        top.state += 1;
      } else if (top.state == 3) {
        // add to post list
        // then remove it from the stack
        list.get(2).add(top.node.data);
        s.pop();
      }
    }
    return list;
  }

  public static TreeNode createTreeUsingArrayList(ArrayList<Integer> arr) {
    if (arr.isEmpty()) return null;
    TreeNode root = new TreeNode(arr.get(0));
    PairNode rNode = new PairNode(root);
    Stack<PairNode> s = new Stack<>();
    s.push(rNode);
    int k = 0;
    while (!s.isEmpty()) {
      PairNode top = s.peek();

      if (top.getState() == 1) { // add the child to left and increment the number
        ++k;
        if (arr.get(k) != null) {
          TreeNode n = top.node;
          n.addLeftChild(new TreeNode(arr.get(k)));
          s.push(new PairNode(n.left));
        }
        top.incrementState();
      } else if (top.getState() == 2) {
        ++k;
        if (arr.get(k) != null) {
          TreeNode n = top.node;
          n.addRightChild(new TreeNode(arr.get(k)));
          s.push(new PairNode(n.right));
        }
        top.incrementState();
      } else {
        s.pop();
      }
    }

    return root;
  }

  public static void displayLevelOrder(TreeNode x) {
    if (x == null) return;
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(x);
    TreeNode k;
    while (!q.isEmpty()) {
      int c = q.size();
      for (int i = 0; i < c; i++) {
        k = q.remove();
        System.out.print(k.data + " ");
        if (k.left != null) q.add(k.left);
        if (k.right != null) q.add(k.right);
      }
      System.out.println();
    }
  }

  static void displayPostOrder(TreeNode x) {
    if (x == null) return;
    displayPostOrder(x.left);
    displayPostOrder(x.right);
    System.out.print(x.data + " ");
  }

  static void displayInOrder(TreeNode x) {
    if (x == null) return;
    displayInOrder(x.left);
    System.out.print(x.data + " ");
    displayInOrder(x.right);
  }

  static void preorder(TreeNode x) {
    if (x == null) return;
    System.out.println(
      (x.left != null ? x.left.data : ".") +
      " <- " +
      x.data +
      " -> " +
      (x.right != null ? x.right.data : ".")
    );
    preorder(x.left);
    preorder(x.right);
  }

  static int size(TreeNode x) {
    if (x == null) return 0;
    return size(x.left) + size(x.right) + 1;
  }

  static int max(TreeNode x) {
    if (x == null) return Integer.MIN_VALUE;
    return Math.max(max(x.left), Math.max(max(x.right), x.data));
  }

  static int sum(TreeNode x) {
    if (x == null) return 0;
    return sum(x.left) + sum(x.right) + x.data;
  }

  static int height(TreeNode x) {
    // callCount += 1;
    if (x == null) return -1; // -1 for edges and 0 for nodes
    return Math.max(height(x.left), height(x.right)) + 1;
  }
}
