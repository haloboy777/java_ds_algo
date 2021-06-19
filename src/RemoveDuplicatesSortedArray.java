import java.util.ArrayList;

/*
  I don't understand how that is faster than this.
  To be honest no one actually told me to remove the elements
  Actually I know what happened the cost of removing the element is so high that its just better to insert the element before
*/
public class RemoveDuplicatesSortedArray {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<Integer>() {
      // {
      //   add(1);
      //   add(1);
      //   add(1);
      //   add(1);
      //   add(1);
      //   add(1);
      //   add(2);
      //   add(3);
      //   add(4);
      //   add(4);
      //   add(4);
      //   add(4);
      //   add(4);
      //   add(5);
      //   add(6);
      //   add(6);
      //   add(6);
      //   add(7);
      //   add(8);
      //   add(8);
      //   add(8);
      //   add(8);
      //   add(9);
      //   add(9);
      //   add(9);
      // }
      {
        add(0);
        add(1);
        add(1);
        add(2);
        add(2);
        add(3);
        add(3);
        add(3);
        add(3);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(0);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(1);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(2);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(3);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
        // add(4);
      }
    };

    System.out.println(remove(arr));
    // int i = 0;
    // int count = 0;
    // int total = 0;
    // while (i < arr.size() - 1) {
    //   if (arr.get(i) == arr.get(i + 1)) {
    //     count++;
    //     arr.remove(i);
    //     continue;
    //   } else {
    //     total += count;
    //     count = 0;
    //   }
    //   ++i;
    // }
    // total += count;
    // System.out.println(arr.toString());
    // System.out.println(total);
  }

  static int remove(ArrayList<Integer> arr) {
    int i = 0;
    int j = 1;

    while (j < arr.size() - 1) {
      if (!arr.get(i).equals(arr.get(j))) {
        arr.set(++i, arr.get(j));
      }
      j++;
    }
    System.out.println(arr.toString());
    return i + 1;
  }
}
