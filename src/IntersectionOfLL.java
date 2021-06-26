public class IntersectionOfLL {

  public static void main(String[] args) {
    ListNode a = new ListNode(5), b = new ListNode(10);
    int len_a = length(a);
    int len_b = length(b);

    int d = len_b - len_a;

    if (len_a > len_b) {
      d = len_a - len_b;
      ListNode t = a;
      a = b;
      b = t;
    }

    while (d > 0) {
      b = b.next;
      d--;
    }

    while (a != null && b != null) {
      if (a == b) {
        System.out.println(a.val);
        System.exit(0);
      }
      a = a.next;
      b = b.next;
    }
    
  }

  static int length(ListNode x) {
    int l = 0;
    while (x != null) {
      l++;
      x = x.next;
    }
    return l;
  }

}
