public class StrStr {

  static int mod = 1000_000_007;
  static long[] arr;

  public static void main(String[] args) {
    String a =
      "aabaaaababaabbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb";
    String match = "bbaaa";
    // I need to solve this problem with string hashing
    initalize(a);
    long p_power = 1;
    long p = 31;
    long needleHash = stringHash(match);
    int L, R;
    for (L = 0, R = match.length() - 1; R < a.length(); L++, R++) {
      if (
        (needleHash * p_power) % mod == substringHash(L, R)
      ) System.out.println(L);
      p_power = (p * p_power) % mod;
    }
  }

  static long substringHash(int L, int R) {
    long hash = arr[R];

    if (L > 0) hash = (arr[R] - arr[L - 1] + mod) % mod;

    return hash;
  }

  static long stringHash(String a) {
    long hash = 0;
    int i = 0;
    int p = 31;
    long p_power = 1;
    while (i < a.length()) {
      hash = (hash + (a.charAt(i) - 'a' + 1) * p_power) % mod;
      p_power = (p_power * p) % mod;
      ++i;
    }
    return hash;
  }

  static void initalize(String a) {
    arr = new long[a.length()];
    int p = 31;
    long p_power = 1;
    arr[0] = a.charAt(0) - 'a' + 1;
    int i = 1;
    while (i < a.length()) {
      p_power = (p_power * p) % mod;

      arr[i] = (arr[i - 1] + (a.charAt(i) - 'a' + 1) * p_power) % mod;
      ++i;
    }
  }

  static long power(long a, int b) {
    long res = 1;
    while (b > 0) {
      if ((b & 1) == 1) res = ((res % mod) * (a % mod)) % mod;
      a = ((a % mod) * (a % mod)) % mod;
      b >>= 1;
    }
    return res;
  }
}
