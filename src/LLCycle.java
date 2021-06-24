import java.util.HashMap;

public class LLCycle {

  public static void main(String[] args) {
    ListNode a = new ListNode(5);
    HashMap<ListNode, Integer> map = new HashMap<>();
    while (a != null) {
      if (map.containsKey(a)) {
        System.out.println(a.val);
        System.exit(0);
      }

      map.put(a, 1);
      a = a.next;
    }

    System.out.println("null");
  }

  static class ListNode {

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
}
