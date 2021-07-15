import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class LRUCache {

  public static void main(String[] args) {
    LRUCache x = new LRUCache(4);
    // S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3
    x.set(5, 13);
    x.set(9, 6);
    x.set(4, 1);
    System.out.println(x.get(4));
    x.set(6, 1);
    x.set(8, 11);
    System.out.println(x.get(13));
    System.out.println(x.get(1));
    x.set(12, 12);
    System.out.println(x.get(10));
    x.set(15, 13);
    x.set(2, 13);
    x.set(7, 5);
    x.set(10, 3);
    System.out.println(x.get(6));
    System.out.println(x.get(10));
    x.set(15, 14);
    x.set(5, 12);
    System.out.println(x.get(5));
    System.out.println(x.get(7));
    System.out.println(x.get(15));
    System.out.println(x.get(5));
    System.out.println(x.get(6));
    System.out.println(x.get(10));
    x.set(7, 13);
    System.out.println(x.get(14));
    x.set(8, 9);
    System.out.println(x.get(4));
    x.set(6, 11);
    System.out.println(x.get(9));
    x.set(6, 12);
    System.out.println(x.get(3));
  }

  HashMap<Integer, Integer> map;
  Deque<Integer> q;

  int MAX_CAP;

  int curr;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    this.q = new ArrayDeque<>();
    this.MAX_CAP = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      q.removeFirstOccurrence(key);
      q.addLast(key);
      return map.get(key);
    }
    return -1;
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      q.removeFirstOccurrence(key);
      q.addLast(key);
      map.put(key, value);
    } else if (map.size() < this.MAX_CAP) {
      map.put(key, value);
      q.addLast(key);
    } else {
      int first = q.removeFirst();
      map.remove(first);
      q.addLast(key);
      map.put(key, value);
    }
  }
}
