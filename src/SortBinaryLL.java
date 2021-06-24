public class SortBinaryLL {

  public static void main(String[] args) {
    ListNode start = new ListNode(5);

    ListNode a = start;
    int countZero = 0;

    while (a != null) {
      if (a.val == 0) ++countZero;
      a = a.next;
    }

    a = start;
    while (a != null) {
      if (countZero > 0) {
        a.val = 0;
        countZero--;
      } else {
        a.val = 1;
      }
      a = a.next;
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
