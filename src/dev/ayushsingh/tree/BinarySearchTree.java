package dev.ayushsingh.tree;

import java.util.*;

public class BinarySearchTree {

  public static void main(String[] args) {
    BSTNode root = new BSTNode(8);
    root.insert(root, 3);
    root.insert(root, 10);
    root.insert(root, 1);
    root.insert(root, 6);
    root.insert(root, 14);
    root.insert(root, 4);
    root.insert(root, 7);
    root.insert(root, 13);
    BSTNode r2 = new BSTNode(8);
    r2.insert(r2, 3);
    r2.insert(r2, 10);
    r2.insert(r2, 1);
    r2.insert(r2, 6);
    r2.insert(r2, 14);
    r2.insert(r2, 4);
    r2.insert(r2, 7);
    r2.insert(r2, 13);
    r2.insert(r2, 2);
    // ArrayList<Integer> arr = new ArrayList<>();
    // arr.add(8);
    // arr.add(3);
    // arr.add(1);
    // arr.add(6);
    // arr.add(4);
    // arr.add(7);
    // arr.add(10);
    // arr.add(14);
    // arr.add(13);
    // levelOrder(root);
    // preOrder(root);
    // preOrderIterative(root);
    // inOrder(root);
    // find(root, 4);
    // System.out.println();
    // root = removeHalfNodes(root);
    // inOrder(root);
    // inOrderIterative(root);
    // postOrder(root);
    // displayEular(root);
    // maxVal(root);
    // levelOrderNewLine(root);
    // levelOrderZigZagPrint(root);
    // levelOrderNewLine2(root);
    // BSTNode x = mirrorTree(root);
    // System.out.println(countSize(root));
    // System.out.println(maxDepth(root));
    // System.out.println(levelOrderZigZag(root).toString());
    // System.out.println(reverseLevelOrder(root).toString());
    // System.out.println(arr.toString());
    // System.out.println(validBST(arr));
    // System.out.println(checkTwoSum(root, 21));
    // System.out.println(getPathBST(root, 13));
    // levelOrderNewLine(root);
    // root = removeLeaves(root);
    levelOrderNewLine(root);
    System.out.println("\n===========");
    // levelOrderNewLine(r2);
    // System.out.println("\n===========");
    // System.out.println(findInTree(root, 11));
    // System.out.println(nodeToRootPath(root, 1).toString());
    // System.out.println(lowestCommonAncestor(root, 7, 1));
    // System.out.println(distanceBetweenNodes(root, 7, 13));
    // System.out.println(areSimillar(root, r2));

    // predecessor = null;
    // successor = null;
    // state = 0;
    // predecessorAndSuccessor(root, 4);

    // System.out.println(predecessor.data);
    // System.out.println(successor.data);
    state = 0;
    ceil = Integer.MAX_VALUE;
    floor = Integer.MIN_VALUE;

    ceilAndFloor(root, 5);
    System.out.println(ceil);
    System.out.println(floor);
  }

  static int ceil, floor;
  static int state;

  // static BSTNode predecessor, successor;
  // static int state;

  static void ceilAndFloor(BSTNode x, int data) {
    if (x == null) return;

    if (x.data > data) {
      if (x.data < ceil) ceil = x.data;
    }

    if (x.data < data) {
      if (x.data > floor) floor = x.data;
    }

    if (x.left != null) ceilAndFloor(x.left, data);
    if (x.right != null) ceilAndFloor(x.right, data);
  }

  // static void predecessorAndSuccessor(BSTNode x, int data) {
  //   if (state == 0) {
  //     if (x.data == data) state = 1; else predecessor = x;
  //   } else if (state == 1) {
  //     successor = x;
  //     state = 2;
  //   }
  //   if (x.left != null) predecessorAndSuccessor(x.left, data);
  //   if (x.right != null) predecessorAndSuccessor(x.right, data);
  // }

  static Boolean areSimillar(BSTNode x, BSTNode y) {
    if (
      !(
        (x.left != null && y.left != null) || (x.left == null && y.left == null)
      )
    ) return false;
    if (
      !(
        (x.right != null && y.right != null) ||
        (x.right == null && y.right == null)
      )
    ) return false;

    Boolean res = false;
    if (x.left != null && y.left != null) {
      res = areSimillar(x.left, y.left);
      if (!res) return false;
    }
    if (x.right != null && y.right != null) {
      res = areSimillar(x.right, y.right);
      if (!res) return false;
    }

    return true;
  }

  static int distanceBetweenNodes(BSTNode x, int d1, int d2) {
    ArrayList<Integer> p1 = nodeToRootPath(x, d1);
    ArrayList<Integer> p2 = nodeToRootPath(x, d2);

    int i = p1.size() - 1;
    int j = p2.size() - 1;

    while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
      i--;
      j--;
    }

    i++;
    j++;

    return i + j;
  }

  static int lowestCommonAncestor(BSTNode x, int d1, int d2) {
    ArrayList<Integer> p1 = nodeToRootPath(x, d1);
    ArrayList<Integer> p2 = nodeToRootPath(x, d2);

    int i = p1.size() - 1;
    int j = p2.size() - 1;
    while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
      i--;
      j--;
    }
    return p1.get(i + 1);
  }

  static ArrayList<Integer> nodeToRootPath(BSTNode x, int nodeData) {
    ArrayList<Integer> k = new ArrayList<>();
    if (x == null) return k;

    if (x.data == nodeData) {
      k.add(x.data);
      return k;
    }

    if (x.left != null) k = nodeToRootPath(x.left, nodeData);
    if (!k.isEmpty()) {
      k.add(x.data);
      return k;
    }
    if (x.right != null) k = nodeToRootPath(x.right, nodeData);
    if (!k.isEmpty()) {
      k.add(x.data);
    }
    return k;
  }

  static Boolean findInTree(BSTNode x, int data) {
    if (x == null) return false;

    if (x.data == data) return true;
    Boolean res = false;
    if (x.left != null) res = findInTree(x.left, data);
    if (res) return true;
    if (x.right != null) res = findInTree(x.right, data);

    return res;
  }

  static BSTNode removeLeaves(BSTNode x) {
    /**
     * Need to remove the leaves in pre recursion part cause if we remove the leaf after comming out of recurrsion then
     * the parent whoes children were recently deleted will also be considered as a leaf and
     * it will also get removed in the post prossessing.
     */
    if (x == null) return x;
    if (x.left == null && x.right == null) {
      return null;
    }
    if (x.left != null) x.left = removeLeaves(x.left);
    if (x.right != null) x.right = removeLeaves(x.right);
    return x;
  }

  static BSTNode mirrorTree(BSTNode x) {
    if (x == null) return x;

    if (x.left != null) x.left = mirrorTree(x.left);
    if (x.right != null) x.right = mirrorTree(x.right);

    BSTNode a = x.right;
    x.right = x.left;
    x.left = a;

    return x;
  }

  static void levelOrderZigZagPrint(BSTNode x) {
    if (x == null) return;
    Stack<BSTNode> s1 = new Stack<>();
    Stack<BSTNode> s2 = new Stack<>();
    s1.add(x);
    int level = 1;
    while (!s1.isEmpty() || !s2.isEmpty()) {
      if (!s1.isEmpty()) {
        BSTNode a = s1.pop();
        System.out.print(a.data + " ");
        if (level % 2 == 0) {
          if (a.left != null) s2.push(a.left);
          if (a.right != null) s2.push(a.right);
        } else {
          if (a.right != null) s2.push(a.right);
          if (a.left != null) s2.push(a.left);
        }
      } else {
        System.out.println();
        s1 = s2;
        s2 = new Stack<>();
        level++;
      }
    }
  }

  static void levelOrderNewLine2(BSTNode x) {
    if (x == null) return;
    Deque<BSTNode> q = new ArrayDeque<>();
    q.add(x);
    q.add(new BSTNode(Integer.MIN_VALUE));
    while (q.size() > 1) {
      BSTNode a = q.pop();
      if (Integer.compare(a.data, Integer.MIN_VALUE) != 0) {
        System.out.print(a.data + " ");
        if (a.left != null) q.add(a.left);
        if (a.right != null) q.add(a.right);
      } else {
        q.add(new BSTNode(Integer.MIN_VALUE));
        System.out.println();
      }
    }
  }

  static void levelOrderNewLine(BSTNode x) {
    if (x == null) return;
    Deque<BSTNode> q1 = new ArrayDeque<>();
    Deque<BSTNode> q2 = new ArrayDeque<>();
    q1.add(x);
    while (!q1.isEmpty() || !q2.isEmpty()) {
      if (!q1.isEmpty()) {
        BSTNode a = q1.pop();
        System.out.print(a.data + " ");
        if (a.left != null) q2.add(a.left);
        if (a.right != null) q2.add(a.right);
      } else {
        System.out.println("\n---");
        q1 = q2;
        q2 = new ArrayDeque<>();
      }
    }
  }

  static void maxVal(BSTNode x) {
    while (x.right != null) x = x.right;

    System.out.println(x.data);
  }

  static int countSize(BSTNode x) {
    int s = 0;

    if (x.left != null) s += countSize(x.left);
    if (x.right != null) s += countSize(x.right);

    s += 1;
    return s;
  }

  static void displayEular(BSTNode x) {
    String val = x.data + " --> ";
    if (x.left != null) val += x.left.data;
    if (x.right != null) val += " , " + x.right.data;
    val += ".";

    System.out.println(val);

    if (x.left != null) displayEular(x.left);
    if (x.right != null) displayEular(x.right);
  }

  static int maxDepth(BSTNode x) {
    if (x == null) return 0;
    if (x.left == null && x.right == null) {
      return 1;
    } else {
      return Math.max(maxDepth(x.left), maxDepth(x.right)) + 1;
    }
  }

  static ArrayList<Integer> reverseLevelOrder(BSTNode x) {
    ArrayList<Integer> res = new ArrayList<>();
    if (x == null) return res;
    Queue<BSTNode> q = new ArrayDeque<>();
    q.add(x);
    BSTNode a;
    while (!q.isEmpty()) {
      a = q.poll();
      res.add(a.data);
      if (a.right != null) q.add(a.right);
      if (a.left != null) q.add(a.left);
    }
    Collections.reverse(res);
    return res;
  }

  static ArrayList<ArrayList<Integer>> levelOrderZigZag(BSTNode x) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (x == null) return res;
    ArrayList<Integer> r = new ArrayList<>();
    Stack<BSTNode> s1 = new Stack<>();
    Stack<BSTNode> s2 = new Stack<>();

    s1.add(x);
    BSTNode a;
    int level = 0;
    while (!s1.isEmpty()) {
      ++level;
      r = new ArrayList<>();
      while (!s1.isEmpty()) {
        a = s1.pop();
        r.add(a.data);
        if (level % 2 == 0) {
          if (a.right != null) s2.push(a.right);
          if (a.left != null) s2.push(a.left);
        } else {
          if (a.left != null) s2.push(a.left);
          if (a.right != null) s2.push(a.right);
        }
      }
      s1 = s2;
      res.add(r);
      s2 = new Stack<>();
    }
    return res;
  }

  static BSTNode inOrderSuccessor(BSTNode node, int data) {
    if (node == null) return node;

    BSTNode x = find(node, data);

    if (x.right != null) {
      x = findMin(x.right);
    } else {
      // Case 2:  when no right subtree is avaliable
      // go to the nearest ancestor for which give node would be in left subtree.
    }

    return x;
  }

  static BSTNode findMin(BSTNode x) {
    if (x == null) return null;
    while (x.left != null) {
      x = x.left;
    }
    return x;
  }

  static BSTNode find(BSTNode x, int data) {
    if (x == null) return null;
    while (x != null) {
      if (x.data == data) {
        break;
      } else if (x.data > data) {
        x = x.left;
      } else {
        x = x.right;
      }
    }
    return x;
  }

  static BSTNode removeHalfNodes(BSTNode root) {
    if (root == null) return root;

    if (root.left != null && root.right != null) {
      root.left = removeHalfNodes(root.left);
      root.right = removeHalfNodes(root.right);
    } else if (root.left == null && root.right == null) {
      return root;
    } else if (root.left == null) {
      return removeHalfNodes(root.right);
    } else {
      return removeHalfNodes(root.left);
    }

    return root;
  }

  static boolean checkTwoSum(BSTNode node, int sum) {
    if (node == null) return false;

    Stack<BSTNode> s = new Stack<>();
    HashSet<Integer> set = new HashSet<>();
    s.push(node);
    set.add(node.data);
    while (!s.isEmpty()) {
      BSTNode x = s.pop();
      if (set.contains(sum - x.data)) return true;
      set.add(x.data);
      if (x.right != null) s.push(x.right);
      if (x.left != null) s.push(x.left);
    }

    return false;
  }

  static void inOrderIterative(BSTNode root) {
    if (root == null) return;

    Stack<BSTNode> s = new Stack<BSTNode>();
    BSTNode x = root;

    while (x != null || !s.isEmpty()) {
      while (x != null) {
        s.push(x);
        x = x.left;
      }
      x = s.pop();
      System.out.print(x.data + " ");
      x = x.right;
    }
  }

  static ArrayList<Integer> getPathBST(BSTNode root, int val) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null) return res;
    BSTNode x = root;
    while (x != null) {
      res.add(x.data);
      if (x.data == val) {
        break;
      } else if (x.data < val) {
        x = x.right;
      } else if (x.data > val) {
        x = x.left;
      }
    }
    return res;
  }

  static void preOrderIterative(BSTNode node) {
    if (node == null) return;
    Stack<BSTNode> s = new Stack<>();
    s.push(node);
    while (!s.isEmpty()) {
      BSTNode x = s.pop();
      System.out.print(x.data + " ");
      if (x.right != null) s.push(x.right);
      if (x.left != null) s.push(x.left);
    }
  }

  static boolean validBST(ArrayList<Integer> arr) {
    Stack<Integer> s = new Stack<Integer>();
    int root = Integer.MIN_VALUE;
    for (int x : arr) {
      if (x < root) {
        return false;
      }
      while (!s.empty() && s.peek() < x) {
        root = s.pop();
      }
      s.push(x);
    }
    return true;
  }

  static void levelOrder(BSTNode node) {
    if (node == null) return;
    Deque<BSTNode> q = new LinkedList<>();
    q.push(node);
    while (!q.isEmpty()) {
      BSTNode cur = q.pop();
      System.out.println(cur.data);
      if (cur.left != null) q.addLast(cur.left);
      if (cur.right != null) q.addLast(cur.right);
    }
  }

  static void preOrder(BSTNode node) {
    if (node == null) return;
    System.out.println(node.data);
    preOrder(node.left);
    preOrder(node.right);
  }

  static void inOrder(BSTNode node) {
    if (node == null) return;
    inOrder(node.left);
    System.out.print(node.data + " ");
    inOrder(node.right);
  }

  static void postOrder(BSTNode node) {
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.data);
  }
}
