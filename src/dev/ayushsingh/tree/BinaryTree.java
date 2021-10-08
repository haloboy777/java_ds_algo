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

  static class PairLinkNode {

    public int state;
    public TreeLinkNode node;

    PairLinkNode(TreeLinkNode n) {
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
    // Integer[] pre2 = { 1, 2, 3, null, null, null, null };
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(pre));

    // Integer[] in = { 12, 25, 30, 37, 50, 62, 65, 75, 87 };
    // ArrayList<Integer> inArr = new ArrayList<>(Arrays.asList(in));
    // Integer[] post = { 12, 30, 37, 25, 65, 62, 87, 75, 50 };
    // ArrayList<Integer> postArr = new ArrayList<>(Arrays.asList(post));
    Integer[] pre2 = {
      622,
      284,
      289,
      302,
      7,
      301,
      554,
      103,
      202,
      25,
      359,
      171,
      40,
      191,
      324,
      184,
      609,
      618,
      649,
      380,
      106,
      386,
      417,
      495,
      400,
      70,
      31,
      197,
      419,
      199,
      482,
      214,
      437,
      489,
      275,
      652,
      485,
      616,
      21,
      636,
      544,
      604,
      404,
      89,
      60,
      436,
      205,
      506,
      521,
      248,
      389,
      221,
      402,
      638,
      182,
      204,
      635,
      532,
      287,
      352,
      395,
      229,
      370,
      582,
      325,
      203,
      20,
      110,
      426,
      319,
      473,
      439,
      156,
      251,
      178,
      28,
      411,
      88,
      381,
      526,
      2,
      580,
      527,
      50,
      536,
      349,
      640,
      486,
      317,
      11,
      396,
      172,
      230,
      22,
      258,
      135,
      373,
      549,
      26,
      606,
      133,
      247,
      66,
      206,
      315,
      577,
      650,
      413,
      113,
      327,
      322,
      641,
      628,
      658,
      175,
      165,
      430,
      81,
      335,
      438,
      356,
      424,
      475,
      257,
      45,
      209,
      155,
      620,
      34,
      460,
      585,
      643,
      41,
      351,
      391,
      484,
      80,
      510,
      261,
      101,
      348,
      189,
      550,
      152,
      571,
      589,
      563,
      338,
      127,
      190,
      210,
      505,
      1,
      72,
      333,
      595,
      579,
      164,
      279,
      42,
      340,
      614,
      262,
      594,
      654,
      503,
      401,
      44,
      516,
      523,
      368,
      456,
      421,
      259,
      3,
      556,
      472,
      524,
      117,
      457,
      508,
      541,
      27,
      512,
      337,
      241,
      93,
      299,
      515,
      231,
      588,
      255,
      459,
      379,
      487,
      292,
      339,
      453,
      442,
      537,
      23,
      423,
      33,
      621,
      418,
      160,
      548,
      161,
      446,
      146,
      511,
      578,
      124,
      68,
      632,
      568,
      61,
      252,
      173,
      90,
      445,
      95,
      539,
      374,
      94,
      384,
      104,
      211,
      343,
      157,
      547,
      543,
      83,
      490,
      131,
      200,
      97,
      274,
      10,
      92,
      67,
      342,
      639,
      276,
      290,
      243,
      64,
      390,
      87,
      552,
      365,
      597,
      102,
      303,
      644,
      56,
      266,
      596,
      320,
      326,
      91,
      86,
      448,
      567,
      561,
      566,
      392,
      656,
      344,
      99,
      477,
      646,
      509,
      358,
      298,
      234,
      85,
      613,
      629,
      311,
      458,
      84,
      406,
      213,
      364,
      465,
      120,
      651,
      434,
      224,
      305,
      52,
      177,
      466,
      530,
      451,
      534,
      514,
      237,
      569,
      236,
      653,
      633,
      8,
      377,
      617,
      452,
      316,
      447,
      573,
      435,
      555,
      385,
      648,
      306,
      397,
      296,
      612,
      96,
      76,
      218,
      17,
      625,
      119,
      176,
      615,
      15,
      166,
      492,
      519,
      478,
      367,
      517,
      657,
      558,
      366,
      584,
      278,
      403,
      62,
      121,
      198,
      345,
      71,
      240,
      440,
      4,
      283,
      138,
      293,
      313,
      463,
      112,
      159,
      314,
      491,
      378,
      141,
      409,
      238,
      48,
      383,
      272,
      630,
      399,
      215,
      462,
      599,
      219,
      341,
      601,
      422,
      232,
      188,
      222,
      201,
      470,
      216,
      429,
      264,
      270,
      321,
      74,
      151,
      256,
      281,
      297,
      29,
      474,
      412,
      168,
      323,
      336,
      46,
      494,
      245,
      350,
      123,
      59,
      30,
      542,
      394,
      253,
      269,
      444,
      581,
      645,
      332,
      347,
      273,
      174,
      6,
      393,
      185,
      19,
      98,
      431,
      49,
      369,
      169,
      553,
      310,
      128,
      126,
      58,
      471,
      170,
      608,
      57,
      47,
      282,
      583,
      137,
      520,
      181,
      295,
      100,
      235,
      260,
      538,
      626,
      12,
      132,
      647,
      499,
      330,
      39,
      461,
      268,
      249,
      469,
      250,
      36,
      154,
      372,
      602,
      18,
      196,
      300,
      427,
      162,
      631,
      420,
      223,
      454,
      360,
      129,
      528,
      564,
      312,
      55,
      443,
      405,
      69,
      280,
      187,
      513,
      497,
      233,
      304,
      498,
      122,
      500,
      375,
      570,
      116,
      109,
      607,
      139,
      493,
      9,
      488,
      153,
      271,
      531,
      363,
      194,
      180,
      634,
      408,
      655,
      82,
      455,
      557,
      125,
      560,
      354,
      163,
      619,
      331,
      388,
      600,
      239,
      226,
      14,
      108,
      145,
      294,
      576,
      586,
      450,
      291,
      107,
      410,
      136,
      115,
      546,
      496,
      318,
      54,
      502,
      415,
      416,
      334,
      611,
      179,
      13,
      193,
      140,
      242,
      559,
      533,
      545,
      220,
      111,
      134,
      637,
      75,
      37,
      150,
      592,
      267,
      382,
      53,
      158,
      483,
      590,
      212,
      605,
      208,
      479,
      603,
      143,
      167,
      407,
      642,
      227,
      529,
      562,
      480,
      535,
      522,
      142,
      246,
      217,
      627,
      414,
      78,
      357,
      572,
      38,
      432,
      51,
      328,
      387,
      309,
      565,
      228,
      518,
      183,
      587,
      551,
      428,
      105,
      308,
      5,
      244,
      464,
      77,
      79,
      574,
      263,
      285,
      225,
      130,
      24,
      286,
      355,
      593,
      192,
      362,
      398,
      376,
      144,
      598,
      346,
      118,
      307,
      16,
      591,
      624,
      149,
      623,
      207,
      148,
      65,
      501,
      575,
      610,
      481,
      353,
      186,
      540,
      73,
      449,
      476,
      254,
      504,
      43,
      525,
      467,
      32,
      265,
      425,
      441,
      433,
      288,
      195,
      63,
      361,
      35,
      371,
      147,
      114,
      507,
      329,
      277,
      468,
    };
    Integer[] in2 = {
      301,
      7,
      302,
      103,
      554,
      202,
      289,
      359,
      25,
      171,
      284,
      191,
      324,
      184,
      609,
      40,
      618,
      622,
      495,
      417,
      70,
      400,
      197,
      31,
      386,
      199,
      419,
      214,
      482,
      106,
      652,
      21,
      636,
      616,
      485,
      544,
      275,
      404,
      89,
      604,
      436,
      60,
      489,
      389,
      221,
      402,
      248,
      521,
      506,
      204,
      532,
      635,
      182,
      638,
      395,
      352,
      287,
      229,
      205,
      325,
      203,
      582,
      370,
      319,
      473,
      426,
      156,
      439,
      251,
      178,
      110,
      88,
      526,
      381,
      411,
      580,
      2,
      28,
      20,
      50,
      527,
      437,
      536,
      349,
      380,
      172,
      230,
      396,
      135,
      373,
      549,
      606,
      26,
      258,
      206,
      66,
      315,
      247,
      650,
      413,
      577,
      327,
      113,
      133,
      22,
      628,
      641,
      165,
      175,
      430,
      658,
      335,
      81,
      322,
      424,
      356,
      438,
      257,
      475,
      209,
      155,
      45,
      34,
      620,
      11,
      351,
      391,
      41,
      643,
      510,
      261,
      80,
      348,
      101,
      484,
      571,
      152,
      550,
      589,
      563,
      189,
      338,
      127,
      1,
      505,
      72,
      210,
      190,
      333,
      585,
      340,
      42,
      279,
      262,
      614,
      164,
      654,
      594,
      579,
      503,
      401,
      595,
      523,
      456,
      368,
      516,
      3,
      259,
      421,
      44,
      556,
      524,
      472,
      117,
      460,
      317,
      541,
      512,
      27,
      508,
      457,
      515,
      231,
      299,
      93,
      241,
      255,
      588,
      337,
      487,
      339,
      292,
      453,
      379,
      23,
      537,
      442,
      33,
      423,
      459,
      548,
      160,
      418,
      621,
      446,
      161,
      511,
      146,
      578,
      486,
      252,
      173,
      90,
      61,
      568,
      95,
      445,
      374,
      539,
      632,
      104,
      384,
      343,
      211,
      94,
      547,
      157,
      543,
      68,
      131,
      97,
      200,
      10,
      92,
      274,
      342,
      67,
      276,
      639,
      490,
      290,
      64,
      390,
      87,
      243,
      552,
      83,
      365,
      124,
      102,
      644,
      303,
      56,
      266,
      597,
      86,
      91,
      326,
      448,
      320,
      596,
      392,
      566,
      656,
      561,
      567,
      344,
      640,
      509,
      646,
      358,
      234,
      298,
      477,
      613,
      458,
      311,
      84,
      629,
      406,
      85,
      99,
      465,
      364,
      120,
      213,
      434,
      224,
      305,
      651,
      466,
      177,
      530,
      52,
      514,
      237,
      569,
      534,
      451,
      649,
      452,
      617,
      447,
      573,
      316,
      555,
      385,
      435,
      377,
      648,
      306,
      8,
      296,
      397,
      633,
      612,
      625,
      119,
      17,
      218,
      15,
      615,
      492,
      166,
      519,
      176,
      76,
      96,
      657,
      517,
      367,
      558,
      478,
      653,
      121,
      198,
      62,
      403,
      240,
      440,
      4,
      71,
      293,
      138,
      283,
      463,
      313,
      345,
      112,
      278,
      314,
      159,
      584,
      409,
      48,
      383,
      238,
      272,
      630,
      399,
      141,
      378,
      462,
      215,
      341,
      422,
      601,
      219,
      222,
      188,
      201,
      232,
      470,
      599,
      429,
      270,
      321,
      264,
      151,
      256,
      74,
      216,
      281,
      297,
      491,
      474,
      29,
      323,
      168,
      494,
      245,
      46,
      336,
      412,
      123,
      350,
      59,
      366,
      269,
      253,
      444,
      581,
      645,
      394,
      347,
      332,
      174,
      273,
      6,
      542,
      185,
      393,
      98,
      19,
      49,
      310,
      553,
      169,
      128,
      369,
      608,
      170,
      57,
      471,
      47,
      58,
      126,
      431,
      282,
      181,
      295,
      520,
      626,
      538,
      260,
      12,
      235,
      647,
      132,
      100,
      137,
      461,
      268,
      249,
      39,
      330,
      499,
      154,
      36,
      250,
      469,
      300,
      196,
      162,
      427,
      18,
      454,
      223,
      420,
      631,
      360,
      528,
      129,
      602,
      443,
      405,
      69,
      55,
      280,
      312,
      513,
      187,
      564,
      372,
      498,
      304,
      122,
      233,
      497,
      375,
      500,
      583,
      139,
      607,
      493,
      9,
      488,
      109,
      153,
      116,
      570,
      194,
      363,
      531,
      180,
      271,
      634,
      408,
      30,
      557,
      354,
      163,
      619,
      560,
      331,
      125,
      455,
      239,
      226,
      600,
      14,
      388,
      294,
      586,
      576,
      145,
      108,
      107,
      291,
      450,
      136,
      115,
      410,
      496,
      318,
      54,
      502,
      546,
      415,
      82,
      13,
      179,
      193,
      611,
      140,
      334,
      559,
      242,
      533,
      545,
      111,
      134,
      220,
      150,
      37,
      75,
      637,
      416,
      592,
      655,
      158,
      53,
      483,
      590,
      382,
      267,
      167,
      143,
      603,
      479,
      407,
      642,
      208,
      227,
      605,
      480,
      535,
      562,
      529,
      246,
      142,
      522,
      212,
      236,
      217,
      572,
      357,
      432,
      38,
      51,
      328,
      78,
      183,
      518,
      587,
      228,
      551,
      428,
      565,
      244,
      5,
      308,
      464,
      105,
      574,
      79,
      263,
      77,
      285,
      309,
      130,
      362,
      192,
      398,
      376,
      593,
      355,
      286,
      24,
      225,
      387,
      346,
      598,
      118,
      307,
      144,
      16,
      591,
      624,
      414,
      148,
      207,
      65,
      623,
      610,
      575,
      501,
      149,
      627,
      449,
      73,
      540,
      476,
      186,
      353,
      467,
      525,
      43,
      32,
      265,
      504,
      254,
      425,
      481,
      195,
      35,
      371,
      361,
      63,
      147,
      288,
      114,
      433,
      329,
      507,
      441,
      468,
      277,
    };
    ArrayList<Integer> inArr = new ArrayList<>(Arrays.asList(in2));
    ArrayList<Integer> preArr = new ArrayList<>(Arrays.asList(pre2));

    TreeNode x = createTreeUsingArrayList(arr);
    // TreeLinkNode x = createLinkTreeUsingArrayList(arr);
    // preorder(x);
    // System.out.println(size(x));
    // System.out.println(max(x));
    // System.out.println(sum(x));
    // System.out.println(height(x));
    // displayLevelOrder(x);
    // System.out.println("============================");
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

    // TreeNode k = createTreeUsingInorderAndPostOrder(
    //   inArr,
    //   postArr,
    //   0,
    //   postArr.size() - 1,
    //   0,
    //   inArr.size() - 1
    // );

    // TreeNode k = createTreeUsingInorderAndPreorder(
    //   inArr,
    //   preArr,
    //   0,
    //   inArr.size() - 1,
    //   0,
    //   preArr.size() - 1
    // );
    //     10 {data: 10, left: Node(12), right: Node(13)}
    //     /\
    //   12  13
    //   /\   /
    //  5  6 7

    // displayLevelOrder(k);
    // System.out.println(leastCommonAncestor(x, 87, 50));
    // System.out.println(getCousinsList(x, 12));
    // System.out.println(lca(x, 30, 12));
    // x = invert(x);
    // displayLevelOrder(k);
    // System.out.println("============================");
    // TreeNode l = mergeTrees(x, k);
    // displayLevelOrder(l);
    // System.out.println(minDepth(x));
    // System.out.println(isIdentical(x, k));
    // TreeLinkNode k = makeNextLinkTree(x);
    // inorderLinkTree(k);
    // System.out.println(rootToLeafPaths(x, 11));
  }

  static ArrayList<ArrayList<Integer>> rootToLeafPaths(TreeNode x, int sum) {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    if (x == null || sum < 0) return arr;

    if (sum == 0 && x.left == null && x.right == null) {
      ArrayList<Integer> k = new ArrayList<>();
      k.add(x.data);
      arr.add(k);
      return arr;
    }

    ArrayList<ArrayList<Integer>> l = rootToLeafPaths(x.left, sum - x.data);
    if (!l.isEmpty()) {
      for (int i = 0; i < l.size(); i++) {
        l.get(i).add(x.data);
      }
    }
    ArrayList<ArrayList<Integer>> r = rootToLeafPaths(x.right, sum - x.data);
    if (!r.isEmpty()) {
      for (int i = 0; i < r.size(); i++) {
        r.get(i).add(x.data);
      }
    }
    arr.addAll(l);
    arr.addAll(r);

    return arr;
  }

  // static TreeNode makeTreeUsingLevelorderArr(ArrayList<Integer> arr) {
  //   if (arr.isEmpty()) return null;
  //   TreeNode root = new TreeNode(arr.get(0));
  //   Queue<TreeNode> q = new ArrayDeque<>();
  //   q.add(root);
  //   TreeNode x;
  //   int k = 1;
  //   while(!q.isEmpty()) {
  //     int size = q.size();
  //     for (int i = 0; i < size; i++) {
  //       if()
  //     }
  //   }


  //   return root;
  // }

  static void inorderLinkTree(TreeLinkNode k) {
    if (k == null) return;
    inorderLinkTree(k.left);
    System.out.print(k.data + " ");
    inorderLinkTree(k.right);
  }

  static TreeLinkNode makeNextLinkTree(TreeLinkNode x) {
    if (x == null) return null;
    Queue<TreeLinkNode> q = new ArrayDeque<>();
    q.add(x);
    TreeLinkNode lastNode = null;
    while (!q.isEmpty()) {
      int c = q.size();
      for (int i = 0; i < c; i++) {
        TreeLinkNode k = q.remove();
        if (lastNode != null) lastNode.next = k;
        lastNode = k;
        System.out.print(k.data + " ");
        if (k.left != null) q.add(k.left);
        if (k.right != null) q.add(k.right);
      }
      lastNode = null;
      System.out.println();
    }
    return x;
  }

  static void connect(TreeLinkNode root) {
    // Main idea: we go level-by-level with 3 pointers:
    // a pointer for the current node on the current level, and two
    // pointers for the level below: the head and the last node.
    // We use the 'next' pointers to traverse level i, and
    // in the meantime we set the 'next' pointers on level i+1.
    TreeLinkNode current = root; // Current node processed
    TreeLinkNode nextHead = null; // Head of the level below
    TreeLinkNode nextLast = null; // Current rightmost on level below
    while (current != null) { // Traverse each level
      while (current != null) { // Traverse each node on the given level
        // Check first children
        if (current.left != null) {
          // If next head does not exist make new head
          if (nextHead == null) nextHead = current.left;
          // If next head exists, rightmost must also exist, connect to that
          else nextLast.next = current.left;
          // Overwrite rightmost regardless of head
          nextLast = current.left;
        }
        // Check second children
        if (current.right != null) {
          // If next head does not exist make new head
          if (nextHead == null) nextHead = current.right;
          // If next head exists, rightmost must also exist, connect to that
          else nextLast.next = current.right;
          // Overwrite rightmost regardless of head
          nextLast = current.right;
        }
        // Move node to its next (if it exists, it was set when processing
        // the level above)
        current = current.next;
      }
      // End of level

      // Start new level
      current = nextHead;
      // Clear next
      nextHead = nextLast = null;
    }
  }

  static int isIdentical(TreeNode x, TreeNode y) {
    if (x == null && y == null) return 1;
    if (x != null && y != null) {
      if (x.data != y.data) return 0;
      if (isIdentical(x.left, y.left) == 0) return 0;
      if (isIdentical(x.right, y.right) == 0) return 0;
      return 1;
    }
    return 0;
  }

  static TreeNode mergeTrees(TreeNode x, TreeNode y) {
    if (x == null && y == null) return null;
    TreeNode k = new TreeNode(-1);
    if (x == null && y != null) {
      k.data = y.data;
      k.left = mergeTrees(null, y.left);
      k.right = mergeTrees(null, y.right);
    } else if (x != null && y == null) {
      k.data = x.data;
      k.left = mergeTrees(x.left, null);
      k.right = mergeTrees(x.right, null);
    } else if (x != null && y != null) {
      k.data = x.data + y.data;
      k.left = mergeTrees(x.left, y.left);
      k.right = mergeTrees(x.right, y.right);
    }
    return k;
  }

  static TreeNode n = null;

  static int find(TreeNode root, int p, int q) {
    if (root == null) return 0;

    int i = 0;
    int l = find(root.left, p, q);
    int r = find(root.right, p, q);
    if (root.data == p) i++;
    if (root.data == q) i++;
    if (i + l + r >= 2 && n == null) n = root;

    return i + l + r;
  }

  static int lca(TreeNode root, int p, int q) {
    find(root, p, q);
    if (n == null) return -1;
    return n.data;
  }

  static TreeNode invert(TreeNode x) {
    if (x == null) return null;
    TreeNode t = invert(x.right);
    x.right = invert(x.left);
    x.left = t;
    return x;
  }

  static int minDepth(TreeNode x) {
    if (x == null) return 0;
    return Math.min(minDepth(x.left), minDepth(x.right)) + 1;
  }

  static int leastCommonAncestor(TreeNode x, int val1, int val2) {
    if (x == null) return -1;

    ArrayList<Integer> v1 = nodeToRootPath2(x, val1);
    ArrayList<Integer> v2 = nodeToRootPath2(x, val2);
    if (v1.isEmpty() || v2.isEmpty()) return -1;
    int i1 = v1.size() - 1;
    int i2 = v2.size() - 1;
    while ((i1 >= 0 && i2 >= 0) && v1.get(i1) == v2.get(i2)) {
      i1--;
      i2--;
    }
    return i1 >= i2 ? v2.get(i2 + 1) : v1.get(i1 + 1);
  }

  static ArrayList<Integer> nodeToRootPath2(TreeNode x, int target) {
    ArrayList<Integer> arr = new ArrayList<>();
    if (x == null) return arr;
    if (x.data == target) {
      arr.add(x.data);
      return arr;
    }
    ArrayList<Integer> l = nodeToRootPath2(x.left, target);
    if (!l.isEmpty()) {
      l.add(x.data);
      return l;
    }
    ArrayList<Integer> r = nodeToRootPath2(x.right, target);
    if (!r.isEmpty()) {
      r.add(x.data);
      return r;
    }
    return arr;
  }

  static TreeNode createTreeUsingInorderAndPreorder(
    ArrayList<Integer> in,
    ArrayList<Integer> pre,
    int in_s_i,
    int in_e_i,
    int pre_s_i,
    int pre_e_i
  ) {
    if (in_s_i > in_e_i || pre_s_i > pre_e_i) return null;
    int i = in_s_i;
    while (in.get(i).compareTo(pre.get(pre_s_i)) != 0) {
      i++;
      if (i == 658) {
        System.out.println(in.indexOf(pre.get(pre_s_i)));
        System.out.println("break");
      }
    }
    int tnel = i - in_s_i;
    TreeNode x = new TreeNode(pre.get(pre_s_i));

    x.left =
      createTreeUsingInorderAndPreorder(
        in,
        pre,
        in_s_i,
        i - 1,
        pre_s_i + 1,
        pre_s_i + tnel
      );
    x.right =
      createTreeUsingInorderAndPreorder(
        in,
        pre,
        i + 1,
        in_e_i,
        pre_s_i + tnel + 1,
        pre_e_i
      );
    return x;
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

  public static TreeLinkNode createLinkTreeUsingArrayList(
    ArrayList<Integer> arr
  ) {
    if (arr.isEmpty()) return null;
    TreeLinkNode root = new TreeLinkNode(arr.get(0));
    PairLinkNode rNode = new PairLinkNode(root);
    Stack<PairLinkNode> s = new Stack<>();
    s.push(rNode);
    int k = 0;
    while (!s.isEmpty()) {
      PairLinkNode top = s.peek();

      if (top.getState() == 1) { // add the child to left and increment the number
        ++k;
        if (arr.get(k) != null) {
          TreeLinkNode n = top.node;
          n.left = new TreeLinkNode(arr.get(k));
          s.push(new PairLinkNode(n.left));
        }
        top.incrementState();
      } else if (top.getState() == 2) {
        ++k;
        if (arr.get(k) != null) {
          TreeLinkNode n = top.node;
          n.right = new TreeLinkNode(arr.get(k));
          s.push(new PairLinkNode(n.right));
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

  static ArrayList<Integer> getCousinsList(TreeNode x, int a) {
    ArrayList<Integer> arr = new ArrayList<>();
    if (x == null) return arr;
    boolean found = false;
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(x);
    TreeNode k;
    while (!q.isEmpty()) {
      int size = q.size();
      if (found) {
        while (!q.isEmpty()) arr.add(q.remove().data);
        break;
      }
      for (int i = 0; i < size; i++) {
        k = q.remove();
        if (
          (k.left != null && k.left.data == a) ||
          (k.right != null && k.right.data == a)
        ) {
          found = true;
          continue;
        }
        if (k.left != null) q.add(k.left);
        if (k.right != null) q.add(k.right);
      }
    }

    return arr;
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
