public class ListNode {

  public int val;
  public ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }

  void add(int x) {
    ListNode t = this;
    while (t.next != null) {
      t = t.next;
    }
    t.next = new ListNode(x);
  }

  void print() {
    ListNode t = this;
    while (t != null) {
      System.out.print(t.val + "  ->  ");
      t = t.next;
    }
    System.out.println();
  }
}
