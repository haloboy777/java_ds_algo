public class ReversingALinkedList {

  public static void main(String[] args) {
    ListNode start = new ListNode(0);
    ListNode x = start;
    for (int i = 0; i < 10; i++) {
      ListNode n = new ListNode(i + 1);
      x.next = n;
      x = n;
    }
    // start = reverseLL(start);
    start = reverseLLWithRange(start, 3, 5);

    System.out.println();
    while (start != null) {
      System.out.print(start.val + "  ->  ");
      start = start.next;
    }
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

  static ListNode reverseLLWithRange(ListNode a, int m, int n) {
    if (m == n) return a;

    ListNode start = null, start_prev = null;
    ListNode end = null, end_next = null;

    int i = 1;
    ListNode curr = a;
    while (curr != null && i <= n) {
      if (i < m) start_prev = curr;

      if (i == m) start = curr;

      if (i == n) {
        end = curr;
        end_next = curr.next;
      }

      curr = curr.next;
      i++;
    }
    end.next = null;

    end = reverseLL(start);

    if (start_prev != null) start_prev.next = end; else a = end;

    start.next = end_next;
    return a;
  }

}
