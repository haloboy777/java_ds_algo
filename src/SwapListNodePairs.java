public class SwapListNodePairs {

  public static void main(String[] args) {
    ListNode a = new ListNode(0);
    ListNode x = a;
    a.add(1);
    // for (int i = 0; i < 10; i++) {
    //   if (i > 2 && i < 4) {
    //     x.next = new ListNode(3);
    //   } else if (i > 5 && i < 8) {
    //     x.next = new ListNode(7);
    //   } else {
    //     x.next = new ListNode(i + 1);
    //   }
    //   x = x.next;
    // }

    ListNode start = new ListNode(-1);
    start.next = a;
    x = start;
    x.print();
    while (x != null && x.next != null && x.next.next != null) {
      ListNode t = x.next;
      ListNode tt = x.next.next;
      t.next = tt.next;
      tt.next = t;
      x.next = tt;
      x = t;
    }

    start.print();
  }
}
