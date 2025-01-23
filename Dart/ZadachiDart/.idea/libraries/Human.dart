class Person {
  String name;
  int age;
  String gender;

  Person(this.name, this.age, this.gender);

  void displayInfo() {
    print('Имя: $name, Возраст: $age, Пол: $gender');
  }

  void increaseAge() {
    age++;
  }

  void changeName(String newName) {
    name = newName;
  }
}

void main() {
  Person person = Person('Иван', 25, 'Мужской');
  person.displayInfo();
  person.increaseAge();
  person.displayInfo();
  person.changeName('Петр');
  person.displayInfo();
}
