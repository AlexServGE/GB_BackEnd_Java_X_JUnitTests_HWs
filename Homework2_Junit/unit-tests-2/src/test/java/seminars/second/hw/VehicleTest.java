package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
 * - проверка того, объект Car создается с 4-мя колесами
 * - проверка того, объект Motorcycle создается с 2-мя колесами
 * - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
 * - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
 * - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
 * - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
 */

class VehicleTest {

  Car car;
  Motorcycle motorcycle;

  @BeforeEach
  void setup() {
    car = new Car("Great Wall Motors", " Haval-F7", 2023);
    motorcycle = new Motorcycle("Honda", "Honda-CBR400R", 2020);

  }

  //  - проверка того, объект Car создается с 4-мя колесами
  @Test
  void carCreatedWith4Wheels() {
    assertEquals(4, car.getNumWheels());
  }

  //  - проверка того, объект Motorcycle создается с 2-мя колесами
  @Test
  void motorcycleCreatedWith2Wheels() {
    assertEquals(2, motorcycle.getNumWheels());
  }

  //  - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
  @ParameterizedTest
  @ValueSource(ints = {60})
  void carReachesSignifiedSpeedInTestDriveCycle(int speed) {
    car.testDrive();
    assertEquals(speed, car.getSpeed());
  }

  //  - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
  @ParameterizedTest
  @ValueSource(ints = {75})
  void motorcycleReachesSignifiedSpeedInTestDriveCycle(int speed) {
    motorcycle.testDrive();
    assertEquals(speed, motorcycle.getSpeed());
  }

  //  - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
  @Test
  void carParkingSpeedEqualsZero() {
    car.testDrive();
    car.park();
    assertEquals(0, car.getSpeed());
  }

  //  - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
  @Test
  void motorcycleParkingSpeedEqualsZero() {
    motorcycle.testDrive();
    motorcycle.park();
    assertEquals(0, motorcycle.getSpeed());
  }
}