public class ReverseLLRecursively {

  public static void main(String[] args) {
    ListNode start = new ListNode(0);
    ListNode x = start;
    for (int i = 0; i < 4; i++) {
      x.next = new ListNode(i + 1);
      x = x.next;
    }
    start.print();
    start = reverse(start);
    start.print();
  }

  static ListNode reverse(ListNode l) {
    ListNode head;
    if (l.next == null) {
      head = l;
      return head;
    }
    head = reverse(l.next);
    ListNode node = l.next;
    node.next = l;
    l.next = null;
    return head;
  }

  static ListNode reverseLL(ListNode l) {
    if (l.next == null) {
      return l;
    }
    ListNode head = l;
    ListNode node = reverseLL(l.next);
    head.next = null;
    insert(node, head);
    return node;
  }

  static void insert(ListNode l, ListNode t) {
    if (l.next == null) {
      l.next = t;
      return;
    }
    insert(l.next, t);
  }
}
