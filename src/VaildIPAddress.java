public class VaildIPAddress {

  public static void main(String[] args) {
    String ip = "25525511135";
    if (ip.length() > 12) {
      System.out.println("Big boi");
      System.exit(0);
    }
    for (int i = 0; i < ip.length(); i++) {}
  }

  static String nextIPPart(String text, int start) {
    // ip
    int len = text.length();
    if (len - start - 1 > 0) {
      return "";
    } else {
      return "";
    }
  }
}
