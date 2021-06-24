public class SwapListNodePairs {

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

    
  }

  static class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}