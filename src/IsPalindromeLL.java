public class IsPalindromeLL {

  public static void main(String[] args) {
    ListNode x = new ListNode(-1);
    ListNode res = x;
    for (int i = 0; i < 10; i++) {
      x.next = new ListNode(i + 1);
      x = x.next;
    }
    for (int i = 10; i >= 0; i--) {
      x.next = new ListNode(i + 1);
      x = x.next;
    }
    res.next.print();
    System.out.println(lPalin(res.next));
  }

  public static int lPalin(ListNode a) {
    ListNode res = a;
    int i = 0;
    ListNode b = a;
    if (b.next == null) return 1;
    while (b != null) {
      b = b.next;
      i++;
      if (i % 2 == 0) a = a.next;
    }
    ListNode y = reverseLL(a);
    while (y != null) {
      if (res.val != y.val) {
        return 0;
      }
      res = res.next;
      y = y.next;
    }
    return 1;
  }

  static ListNode reverseLL(ListNode a) {
    ListNode node = a;
    ListNode prev = null;

    while (node != null) {
      ListNode next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    a = prev;
    return a;
  }
}
