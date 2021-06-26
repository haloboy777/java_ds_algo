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
}
