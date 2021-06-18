public class RabinKarp {

  static int mod = 1000_000_007;
  // static int mod = 37;

  static long[] hashPrefixArr;

  public static void main(String[] args) {
    String haystack = "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
    String needle = "babaaa";

    int L, R;
    long p_power = 1;
    long p = 31;
    long needleHash = stringHash(needle);

    init(haystack);

    for (L = 0, R = needle.length() - 1; R < haystack.length(); L++, R++) {
      if (L == 48) ;
      if (
        (needleHash * p_power) % mod == substringHash(L, R)
      ) System.out.println(L);
      p_power = (p_power * p) % mod;
    }
  }

  // calculate substring hash array
  // function for string hash
  // power function

  static void init(String s) {
    long p = 31;
    long p_power = 1;

    hashPrefixArr = new long[s.length()];
    hashPrefixArr[0] = (s.charAt(0) - 'a' + 1);

    for (int i = 1; i < s.length(); i++) {
      p_power = (p_power * p) % mod;
      hashPrefixArr[i] =
        (hashPrefixArr[i - 1] + ((s.charAt(i) - 'a' + 1) * p_power)) % mod;
    }
  }

  static long substringHash(int L, int R) {
    long result = hashPrefixArr[R];

    if (L > 0) {
      result = (result - hashPrefixArr[L - 1] + mod) % mod;
    }

    return result;
  }

  static long stringHash(String s) {
    long hash = 0;
    int p = 31;
    long p_power = 1;
    int i = 0;

    while (i < s.length()) {
      hash = (hash + ((s.charAt(i) - 'a' + 1) * p_power)) % mod;
      p_power = (p_power * p) % mod;
      i++;
    }
    return hash;
  }

  static long power(int a, int b, int m) {
    long res = 1;
    long x = a;
    while (b > 0) {
      if ((b & 1) == 1) res = ((res % m) * (x % m)) % m;
      b >>= 1;
      x = ((x % m) * (x % m)) % m;
    }
    return res % m;
  }
}
