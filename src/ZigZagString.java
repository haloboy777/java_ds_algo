
public class ZigZagString {

  public static void main(String[] args) {
    // String a = "PAYPALISHIRING";
    String a = "ABCD";
    int n = 1; // rows

    // if(n==1) return a;
    String x = "kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS";
    int i = 0;
    int k = 0;

    StringBuilder[] arr = new StringBuilder[n];

    for (int l = 0; l < arr.length; l++) {
      arr[l] = new StringBuilder("");
    }

    boolean flag = true;

    while (i < a.length()) {
      if (k == n - 1) flag = false;
      if (k == 0) flag = true;

      arr[k].append(a.charAt(i));
      if (flag) {
        k++;
      } else {
        k--;
      }
      i++;
    }

    for (int l = 0; l < n - 1; l++) {
      arr[0].append(arr[l + 1]);
    }

    System.out.println(arr[0].toString());
    System.out.println(x);
  }
}
