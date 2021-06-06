import dev.ayushsingh.sorting.Sorting;
public class HotelRooms {

  public static void main(String[] args) {
    // int[] ari = { 1, 2, 6, 4, 3, 8, 3, 6, 6, 7 };
    // int[] dep = { 2, 3, 7, 5, 4, 9, 3, 7, 7, 8 };
    int[] ari = { 40, 18 };
    int[] dep = { 40, 43 };
    Sorting.quickSortTwo(ari, dep, 0, ari.length - 1);

    int totalRooms = 1;
    int i = 0;
    int availableRooms = totalRooms - 1;
    while (i < ari.length) {
      if (dep[i] == ari[i]) {
        System.out.printf(" %d,", availableRooms);
        ++i;
        continue;
      } else if (dep[i] > ari[i + 1] && ari[i + 1] != dep[i + 1]) {
        --availableRooms;
      } else if (availableRooms > -1 && availableRooms < totalRooms - 1) {
        ++availableRooms;
      }
      if (availableRooms < 0) {
        System.out.println("Not enough rooms.");
        break;
      }
      System.out.printf(" %d,", availableRooms);
      ++i;
    }
    System.out.println("everyone got a room.");
  }
}
