public class RemoveFromSortedLL {

  public static void main(String[] args) {
    ListNode start = new ListNode(0);
    ListNode x = start;
    for (int i = 0; i < 10; i++) {
      if (i > 2 && i < 4) {
        x.next = new ListNode(3);
      } else if (i > 5 && i < 8) {
        x.next = new ListNode(7);
      } else {
        x.next = new ListNode(i + 1);
      }
      x = x.next;
    }
    int i = 5;
    while (i > 0) {
      x.next = new ListNode(10);
      x = x.next;
      i--;
    }

    ListNode curr = start.next;
    ListNode last = start;
    while (curr != null) {
      if (last.val != curr.val) {
        last.next = curr;
        last = curr;
      }
      curr = curr.next;
    }
    last.next = curr;
  }

}
