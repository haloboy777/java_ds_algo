public class MergeTwoSortedLL {

  public static void main(String[] args) {
    ListNode b = new ListNode(0);
    b.add(1);
    b.add(3);
    b.add(6);
    b.add(7);
    b.add(8);
    b.add(11);
    b.add(12);
    b.add(13);
    b.add(14);
    b.print();
    ListNode a = new ListNode(2);
    a.add(4);
    a.add(5);
    a.add(9);
    a.add(10);
    a.print();

    ListNode x = new ListNode(-1);
    ListNode res = x;

    while (true) {
      if (a != null && b != null) {
        if (a.val < b.val) {
          x.next = a;
          a = a.next;
        } else {
          x.next = b;
          b = b.next;
        }
        x = x.next;
      } else if (a != null && b == null) {
        x.next = a;
        break;
      } else if (a == null && b != null) {
        x.next = b;
        break;
      }
    }
    res.next.print();
  }
}
