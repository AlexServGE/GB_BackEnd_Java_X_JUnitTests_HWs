package org.example;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Main {
  public static void main(String[] args) {
    assertThat(Calculator.calculateDiscount(100.0, 0.5)).isEqualTo(50.0);
    assertThatThrownBy(()->Calculator.calculateDiscount(100.0, 0)).isInstanceOf(ArithmeticException.class);
    assertThat(Calculator.calculateDiscount(100.0, 0.5)).isNotEqualTo(10.0);
    assertThatThrownBy(()->Calculator.calculateDiscount(100.0, 0)).isInstanceOf(NullPointerException.class);
  }
}