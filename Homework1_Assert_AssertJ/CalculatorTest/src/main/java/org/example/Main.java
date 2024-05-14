package org.example;


import static org.assertj.core.api.Assertions.assertThat;

public class Main {
  public static void main(String[] args) {
    assertThat(Calculator.calculateDiscount(100.0, 0.5)).isEqualTo(50.0);
    assertThat(Calculator.calculateDiscount(100.0, 0.5)).isEqualTo(10.0);
  }
}