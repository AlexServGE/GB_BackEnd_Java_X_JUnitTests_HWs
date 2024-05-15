package org.example;

public class Calculator {
  public static double calculateDiscount(double purchaseAmount, double discountAmount) {
    if (purchaseAmount < 1) throw new ArithmeticException();
    if (discountAmount >= 1 || discountAmount <= 0) throw new ArithmeticException();
    return purchaseAmount * discountAmount;
  }
}
