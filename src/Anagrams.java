import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

  // https://www.interviewbit.com/problems/anagrams/
  public static void main(String[] args) {
    ArrayList<String> arr = new ArrayList<>();
    arr.add(
      "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba"
    );
    arr.add(
      "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa"
    );
    arr.add(
      "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab"
    );
    arr.add(
      "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb"
    );
    arr.add(
      "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab"
    );
    arr.add(
      "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba"
    );
    arr.add(
      "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa"
    );
    arr.add(
      "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"
    );
    System.out.println(anagrams(arr).toString());
  }

  static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < A.size(); i++) {
      String s = A.get(i);
      int hash = hash(s);

      if (map.containsKey(hash)) {
        map.get(hash).add(i + 1);
      } else {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(i + 1);
        map.put(hash, x);
      }
    }

    for (ArrayList<Integer> x : map.values()) {
      res.add(x);
    }
    Collections.sort(
      res,
      new Comparator<ArrayList<Integer>>() {
        @Override
        public int compare(
          ArrayList<Integer> first,
          ArrayList<Integer> second
        ) {
          int comp = 0;
          for (int i = 0; i < Math.min(first.size(), second.size()); i++) {
            comp = Integer.compare(first.get(i), second.get(i));
            if (comp != 0) {
              return comp;
            }
          }
          return Integer.compare(first.size(), second.size());
        }
      }
    );
    return res;
  }

  static int hash(String s) {
    int hash = 0;

    for (int x : s.toCharArray()) {
      hash += x % 3;
    }

    return hash;
  }
}
