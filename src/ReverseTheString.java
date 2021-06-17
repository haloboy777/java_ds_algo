import java.util.ArrayList;

/**
 * ReverseTheString
 */
public class ReverseTheString {

  public static void main(String[] args) {
    String a = " fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq ";
    ArrayList<String> arr = new ArrayList<>();

    int i = 0;
    StringBuilder tmp = new StringBuilder();
    boolean putString = true;
    while (i < a.length()) {
      if (i > 0 && a.charAt(i - 1) == ' ' && a.charAt(i) != ' ') {
        putString = true;
        tmp.append(a.charAt(i));
      } else if (putString && a.charAt(i) != ' ') {
        tmp.append(a.charAt(i));
      } else if (a.charAt(i) == ' ') {
        if(!tmp.isEmpty()) arr.add(tmp.toString());
        tmp.setLength(0);
      }
      i++;
    }
    if (!tmp.toString().isEmpty()) arr.add(tmp.toString());
    tmp.setLength(0);

    for (i = 0; i < arr.size(); i++) {
      tmp.append(arr.get(arr.size() - i - 1));
      if (i != arr.size() - 1) tmp.append(" ");
    }
    System.out.println(tmp.toString());
  }
}
