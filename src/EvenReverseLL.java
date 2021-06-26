public class EvenReverseLL {

  public static void main(String[] args) {
    ListNode x = new ListNode(-1);
    ListNode res = x;
    for (int i = 0; i < 10; i++) {
      x.next = new ListNode(i + 1);
      x = x.next;
    }
    res.next.print();

    evenReverse(res.next);
    // res.next.print();
  }

  static void evenReverse(ListNode node) {
    // extract even list in new var
    // reverse is
    // insert it in remaining list
    ListNode x = node;
    ListNode evenList = null;
    while (x != null && x.next != null) {
      evenList = x.next;
      x = x.next.next;
      // evenList = evenList.next;
    }
    evenList.print();
    node.print();
  }

  static ListNode reverseLL(ListNode a) {
    ListNode node = a;
    ListNode prev = null;
    ListNode next = null;
    while (node != null) {
      next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    a = prev;
    return a;
  }

}
