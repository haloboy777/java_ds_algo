import java.io.*;
import java.math.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {

  public static String getDay(String day, String month, String year) {
    return LocalDate
      .parse(
        day + "/" + month + "/" + year,
        DateTimeFormatter.ofPattern("dd/MM/yyyy")
      )
      .getDayOfWeek()
      .name();
  }

  public static void main(String[] args) {
    /****don't alter the code below*************************************/

    // Scanner in = new Scanner(System.in);
    // String month = in.next();
    // String day = in.next();
    // String year = in.next();

    System.out.println(getDay("05", "08", "2015"));
    /****************************************************/

  }
  // public static void main(String[] args) {
  //   // YOUR CODE GOES HERE
  //   // Please take input and print output to standard input/output (stdin/stdout)
  //   // DO NOT USE ARGUMENTS FOR INPUTS
  //   // E.g. 'Scanner' for input & 'System.out' for output
  //   Scanner sc = new Scanner(System.in);

  //   HashMap<String, Integer> map = new HashMap<>();

  //   int n = sc.nextInt();

  //   while (n-- > 0) {
  //     String s = sc.next();
  //     int m = sc.nextInt();

  //     map.put(s, m);
  //   }

  //   n = sc.nextInt();

  //   while (n-- > 0) {
  //     String s = sc.next();
  //     if (map.containsKey(s)) System.out.println(
  //       map.get(s)
  //     ); else System.out.println("Not Found");
  //   }
  //   sc.close();
  // }

  // public static void main(String[] args) {
  //   //Don't alter anything here.
  //   Scanner inp = new Scanner(System.in);
  //   String S = inp.nextLine();
  //   int L = inp.nextInt();
  //   inp.nextLine();
  //   int R = inp.nextInt();
  //   inp.nextLine();
  //   inp.close();

  //   System.out.println(solve(S, L, R));
  //   /**************************************/
  // }

  // //complete the function below

  // public static String solve(String s, int L, int R) {
  //   StringBuffer sb = new StringBuffer(s.substring(L, R + 1));

  //   return (
  //     s.substring(0, L) +
  //     sb.reverse().toString() +
  //     s.substring(R + 1, s.length())
  //   );
  // }

  // public static void main(String[] args) {
  //   // YOUR CODE GOES HERE
  //   // Please take input and print output to standard input/output (stdin/stdout)
  //   // DO NOT USE ARGUMENTS FOR INPUTS
  //   // E.g. 'Scanner' for input & 'System.out' for output
  //   Scanner sc = new Scanner(System.in);
  //   String a = sc.next();
  //   int x = sc.nextInt();
  //   int y = sc.nextInt();
  //   System.out.println(a.substring(x, y));
  //   sc.close();
  // }

  // public static void main(String[] args) {
  //   Scanner sc = new Scanner(System.in);
  //   int n = sc.nextInt();

  //   PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
  //   int i = 0;
  //   while (i < n) {
  //     int k = sc.nextInt();
  //     if (k != -1) {
  //       if (k == 1) {
  //         q.add(sc.nextInt());
  //       } else if (k == 3 && !q.isEmpty()) {
  //         q.poll();
  //       } else if (k == 2) {
  //         if (q.size() > 0) {
  //           System.out.println(q.peek());
  //         } else {
  //           System.out.println(-1);
  //         }
  //       }
  //       i++;
  //     }
  //   }
  //   sc.close();
  // }

  // public static void main(String[] args) {
  //   Scanner sc = new Scanner(System.in);
  //   int n = sc.nextInt();

  //   Deque<Integer> q = new ArrayDeque<>();
  //   int i = 0;
  //   while (i < n) {
  //     int k = sc.nextInt();
  //     if (k != -1) {
  //       if (k == 1) {
  //         q.addLast(sc.nextInt());
  //       } else if (k == 2) {
  //         q.addFirst(sc.nextInt());
  //       } else if (k == 3) {
  //         if (q.size() > 0) {
  //           System.out.println(q.peekFirst());
  //         } else {
  //           System.out.println(-1);
  //         }
  //       } else if (k == 4) {
  //         if (q.size() > 0) {
  //           System.out.println(q.peekLast());
  //         } else {
  //           System.out.println(-1);
  //         }
  //       } else if (k == 5 && !q.isEmpty()) {
  //         q.removeFirst();
  //       } else if (k == 6 && !q.isEmpty()) {
  //         q.removeLast();
  //       }
  //       i++;
  //     }
  //   }
  //   sc.close();
  // }

  // public static void main(String[] args) throws IOException {
  //   // YOUR CODE GOES HERE
  //   // Please take input and print output to standard input/output (stdin/stdout)
  //   // DO NOT USE ARGUMENTS FOR INPUTS
  //   // E.g. 'Scanner' for input & 'System.out' for output
  //   BufferedReader reader = new BufferedReader(
  //     new InputStreamReader(System.in)
  //   );
  //   BigInteger a = new BigInteger(reader.readLine());

  //   System.out.println(a.isProbablePrime(1) ? "prime" : "not prime");
  // }
  // public static void main(String[] args) {
  //   Scanner sc = new Scanner(System.in);
  //   int n = sc.nextInt();
  //   String[] s = new String[n + 2];
  //   for (int i = 0; i < n; i++) {
  //     s[i] = sc.next();
  //   }
  //   sc.close();

  //   //Write your code here
  //   BigDecimal A, B;
  //   for (int i = 0; i < n; i++) {
  //     int min_i = i;
  //     for (int j = i; j < n; j++) {
  //       A = new BigDecimal(s[j]);
  //       B = new BigDecimal(s[min_i]);
  //       if (A.compareTo(B) > 0) min_i = j;
  //     }
  //     swap(s, min_i, i);
  //   }

  //   //Output
  //   for (int i = 0; i < n; i++) {
  //     System.out.println(s[i]);
  //   }
  // }

  // static void swap(String[] s, int i, int j) {
  //   String temp = s[i];
  //   s[i] = s[j];
  //   s[j] = temp;
  // }
  // public static void main(String[] args) throws IOException {
  //   // YOUR CODE GOES HERE
  //   // Please take input and print output to standard input/output (stdin/stdout)
  //   // DO NOT USE ARGUMENTS FOR INPUTS
  //   // E.g. 'Scanner' for input & 'System.out' for output
  //   BufferedReader reader = new BufferedReader(
  //     new InputStreamReader(System.in)
  //   );
  //   int n = Integer.parseInt(reader.readLine());

  //   String[] arr = new String[n];
  //   for (int i = 0; i < n; i++) {
  //     arr[i] = reader.readLine();
  //   }
  //   for (int i = 0; i < n; i++) {
  //     System.out.println(areBracketsBalanced(arr[i]));
  //   }
  // }

  // static int areBracketsBalanced(String expr) {
  //   // Using ArrayDeque is faster than using Stack class
  //   Deque<Character> stack = new ArrayDeque<Character>();

  //   // Traversing the Expression
  //   for (int i = 0; i < expr.length(); i++) {
  //     char x = expr.charAt(i);

  //     if (x == '(') {
  //       // Push the element in the stack
  //       stack.push(x);
  //       continue;
  //     }

  //     // If current character is not opening
  //     // bracket, then it must be closing. So stack
  //     // cannot be empty at this point.
  //     if (stack.isEmpty()) return 0;

  //     if (x == ')') stack.pop();
  //   }

  //   // Check Empty Stack
  //   if (stack.isEmpty()) return 1; else return 0;
  // }
}
