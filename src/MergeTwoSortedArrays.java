import java.util.ArrayList;

public class MergeTwoSortedArrays {

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>() {
      {
        add(2);
        add(3);
        add(20);
      }
    };
    ArrayList<Integer> b = new ArrayList<>() {
      {
        add(5);
        add(10);
        add(15);
        add(40);
      }
    };

    // start by iterating the a Array
    // if the current element in a is less than current element in b
    // insert it into a
    // and then increase the pointer in b also
    int i = a.size() - 1;
    int j = b.size() - 1;


    // Merge a and b, starting
    // from last element in each
    while (j >= 0) {
      /* End of a is greater than end of b */
      if (i >= 0 && a.get(i) > b.get(j)) {
        // Copy Element
        a.add(a.get(i));
        i--;
      } else {
        // Copy Element
        a.add(b.get(j));
        j--;
      }
    }

    System.out.println(a.toString());
  }
}
