package dev.ayushsingh.codechef;

import java.util.*;
public class HS08TEST {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    double bb = scanner.nextDouble();
    System.out.println(withdrawCash(a, bb));
    scanner.close();
  }

  static double withdrawCash(int amount, double bb) {
    if (amount >= bb || amount % 5 != 0) return bb;
    return bb - amount - 0.5;
  }
}
