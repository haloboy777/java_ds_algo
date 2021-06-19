import java.math.BigInteger;
import java.util.Arrays;

public class CompareVersionString {

  public static void main(String[] args) {
    String a = "13.0";
    String b = "13.0.8";

    System.out.println(whoIsBig(a, b));
  }

  static int whoIsBig(String a, String b) {
    int i = 0;
    int j = 0;

    String[] aArr = a.split("\\.");
    String[] bArr = b.split("\\.");

    System.out.println(Arrays.toString(aArr));
    System.out.println(Arrays.toString(bArr));

    while (i < aArr.length || j < bArr.length) {
      // comapre a level
      int res = compareLevel(
        (i < aArr.length) ? aArr[i] : "0",
        (j < bArr.length) ? bArr[j] : "0"
      );
      // if 0 continue to next level
      if (res == 0) {
        if (i < aArr.length) ++i;
        if (j < bArr.length) ++j;
        continue;
      } else {
        return res;
      }
      // if !0 return the result right then and there
    }

    return 0;
  }

  public static int compareLevel(String a, String b) {
    // if a > b return 1
    // else if b > a  return -1
    // else return 0
    BigInteger x = new BigInteger(a);
    BigInteger y = new BigInteger(b);
    return x.compareTo(y);
  }
}
