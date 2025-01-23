abstract class Animal {
  void makeSound();
}

class Dog implements Animal {
  @override
  void makeSound() {
    print('Гав!');
  }
}

class Cat implements Animal {
  @override
  void makeSound() {
    print('Мяу!');
  }
}

class Cow implements Animal {
  @override
  void makeSound() {
    print('Му!');
  }
}

void main() {
  List<Animal> animals = [Dog(), Cat(), Cow()];
  for (var animal in animals) {
    animal.makeSound();
  }
}
