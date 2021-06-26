public class AddTwoNumsAsLL {

  public static void main(String[] args) {
    ListNode a = new ListNode(9);
    a.add(9);
    a.add(9);
    a.add(9);
    ListNode b = new ListNode(1);
    b.add(0);
    b.add(0);
    b.add(0);
    b.add(0);
    b.add(0);

    int i = 0, j = 0;
    ListNode x = a;
    ListNode y = b;
    while (x != null || y != null) {
      if (x != null) {
        ++i;
        x = x.next;
      }
      if (y != null) {
        ++j;
        y = y.next;
      }
    }

    ListNode start = null;
    boolean flag = false;
    if (i > j) {
      start = a;
      flag = true;
    } else {
      start = b;
    }
    ListNode prev = null;
    int t = 0, A, B;
    boolean carry = false;
    while (true) {
      if (a != null || b != null) {
        A = a != null ? a.val : 0;
        B = b != null ? b.val : 0;
        t = A + B + (carry ? 1 : 0);
        carry = false;
        if (t > 9) {
          t = t % 10;
          carry = true;
        }
        if (flag) {
          a.val = t;
          prev = a;
        } else {
          b.val = t;
          prev = b;
        }
        if (a != null) a = a.next;
        if (b != null) b = b.next;
      } else {
        if (carry) {
          prev.next = new ListNode(1);
        }
        break;
      }
    }

    a = start;
    b = start;
    i = 0;
    while (a != null) {
      if (a.val != 0) b = a;
      a = a.next;
    }
    b.next = null;
    start.print();
  }
}
