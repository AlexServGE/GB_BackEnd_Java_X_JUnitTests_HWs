package org.example;

public class Calculator {
  public static double calculateDiscount(double purchaseAmount, double discountAmount) {
    if (discountAmount > 1 || discountAmount < 0 || purchaseAmount < 1) throw new ArithmeticException();
    return purchaseAmount * discountAmount;
  }
}
