import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class BinomailCoeffients {

  static HashMap<Integer, BigInteger> map;

  public static void main(String[] args) {
    map = new HashMap<>();
    ArrayList<BigInteger> arr = new ArrayList<>();
    ArrayList<Integer> aux = new ArrayList<>();
    int k = 100;
    int i = k + 1, c = 1;
    for (int j = 1; j <= i; j++) {
      aux.add(c);
      c = c * (i - j) / j;
    }
    for (i = 0; i <= k; i++) {
      arr.add(
        (factorial(k).divide(factorial(i))).divide(factorial(k - i))
      );
    }
    System.out.println(arr);
    System.out.println(aux);
  }

  static BigInteger factorial(Integer num) {
    if (num <= 1) return new BigInteger("1");
    if (!map.containsKey(num)) {
      BigInteger fact = factorial(num - 1)
        .multiply(new BigInteger(num.toString()));
      map.put(num, fact);
      return fact;
    } else return map.get(num);
  }
}
