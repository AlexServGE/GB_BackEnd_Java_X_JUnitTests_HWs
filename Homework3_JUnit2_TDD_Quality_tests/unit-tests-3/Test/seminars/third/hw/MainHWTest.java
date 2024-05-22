package seminars.third.hw;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
  // HW 3.1. Нужно покрыть тестами метод на 100%
  // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).


  // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
  // покрыть тестами метод на 100%
  MainHW mainHW;

  @BeforeEach
  void setup() {
    this.mainHW = new MainHW();
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 4, -2, -4})
  void isEvenReturnsTrueWhenNumberIsEven(Integer testEvenNumber) {
    assertTrue(mainHW.isEven(testEvenNumber));
  }

  @Test
  void isEvenReturnsTrueWhenNumberIsZero() {
    assertTrue(mainHW.isEven(0));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, -1, -3})
  void isEvenReturnsTrueWhenNumberIsNOTEven(Integer testNotEvenNumber) {
    assertFalse(mainHW.isEven(testNotEvenNumber));
  }


  @ParameterizedTest
  @ValueSource(ints = {25, 40, 50, 75})
  void isNumberWithinIntervalReturnsTrueWhenNumberIsFrom25To100(Integer testNumber) {
    assertTrue(mainHW.isNumberWithinInterval(testNumber));
  }

  @ParameterizedTest
  @ValueSource(ints = {25, 100})
  void isNumberWithinIntervalReturnsTrueWhenNumberIs25OR100(Integer testNumber) {
    assertTrue(mainHW.isNumberWithinInterval(testNumber));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 24, 101, 200})
  void isNumberWithinIntervalReturnsTrueWhenNumberIs24AndLessAnd100AndMore(Integer testNumber) {
    assertFalse(mainHW.isNumberWithinInterval(testNumber));
  }
}
