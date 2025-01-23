abstract class Transport {
  void move();
}

class Car implements Transport {
  @override
  void move() {
    print('Машина едет по дороге');
  }
}

class Bike implements Transport {
  @override
  void move() {
    print('Велосипед едет по тротуару');
  }
}

void main() {
  Transport car = Car();
  Transport bike = Bike();
  car.move();
  bike.move();
}
