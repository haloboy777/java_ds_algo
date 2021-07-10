import java.util.ArrayList;
import java.util.List;

public class SubstringConcatination {

  public static void main(String[] args) {
    List<String> s = new ArrayList<>();
    // s.add("aa");
    // s.add("cc");
    // s.add("bb");
    // System.out.println(findSubstring("aabbccddccaabb", s).toString());
    // s.add("foo");
    // s.add("bar");
    // System.out.println(findSubstring("barfoothefoobarman", s).toString());
    // s.add("hel");
    // s.add("lo");
    // s.add("wo");
    // s.add("rld");
    // System.out.println(findSubstring("helloworld", s).toString());
    // s.add("aaa");
    // s.add("aaa");
    // s.add("aaa");
    // s.add("aaa");
    // System.out.println(findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", s).toString());
    s.add("cac");
    s.add("aaa");
    s.add("aba");
    s.add("aab");
    s.add("abc");
    System.out.println(findSubstringX("bcabaabaaaabcaabcacabaa", s).toString());
  }

  static ArrayList<Integer> findSubstringX(String A, final List<String> B) {
    ArrayList<Integer> res = new ArrayList<>();

    if (B == null) return res;

    int n = B.get(0).length();

    if (A.length() < n) return res;

    for (int i = 0; i <= A.length() - n; i++) {
      ArrayList<String> list = new ArrayList<>();
      list.addAll(B);

      String s = A.substring(i, i + n);
      int j = i;

      while (!list.isEmpty() && list.contains(s) && j <= A.length() - n) {
        list.remove(s);
        j = j + n;
        if (j > A.length() - n) break; else s = A.substring(j, j + n);
      }
      if (list.isEmpty()) res.add(i);
    }

    return res;
  }

  static ArrayList<Integer> findSubstring(String A, final List<String> B) {
    ArrayList<Integer> res = new ArrayList<>();
    int[] hashArr = rollingHash(A);
    StringBuilder sb = new StringBuilder();
    if (B.size() < 1) {
      return res;
    }
    int len = B.get(0).length();
    sb.append(B.get(0));
    for (int i = 1; i < B.size(); i++) {
      if (B.get(i).length() != len) return res;
      sb.append(B.get(i));
    }
    int hash = hash(sb.toString());

    int L, R;
    for (L = 0, R = sb.length() - 1; R < A.length(); L++, R++) {
      if (substringHash(hashArr, L - 1, R) == hash) {
        res.add(L);
      }
    }

    return res;
  }

  static int substringHash(int[] arr, int i, int j) {
    return i >= 0 ? arr[j] - arr[i] : arr[j];
  }

  static int[] rollingHash(String s) {
    int[] arr = new int[s.length()];
    arr[0] = (s.charAt(0) - 'a' + 1) % 31;
    for (int i = 1; i < s.length(); i++) {
      arr[i] = arr[i - 1] + ((s.charAt(i) - 'a' + 1) % 31);
    }
    return arr;
  }

  static int hash(String s) {
    int hash = 0;
    for (int i : s.toCharArray()) {
      hash += ((i - 'a' + 1) % 31);
    }
    return hash;
  }
}
