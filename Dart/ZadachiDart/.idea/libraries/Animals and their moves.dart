abstract class Animal {
  void move();
}

class Fish extends Animal {
  @override
  void move() {
    print('Рыба плавает в воде');
  }
}

class Bird extends Animal {
  @override
  void move() {
    print('Птица летит в небе');
  }
}

class Dog extends Animal {
  @override
  void move() {
    print('Собака бегает по земле');
  }
}

void main() {
  Animal fish = Fish();
  Animal bird = Bird();
  Animal dog = Dog();
  fish.move();
  bird.move();
  dog.move();
}
