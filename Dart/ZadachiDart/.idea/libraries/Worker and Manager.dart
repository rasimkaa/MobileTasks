class Person {
  String name;
  int age;
  String gender;

  Person(this.name, this.age, this.gender);

  void displayInfo() {
    print('Имя: $name, Возраст: $age, Пол: $gender');
  }
}

class Worker extends Person {
  double salary;

  Worker(String name, int age, String gender, this.salary) : super(name, age, gender);

  @override
  void displayInfo() {
    super.displayInfo();
    print('Зарплата: $salary');
  }
}

class Manager extends Worker {
  List<String> subordinates;

  Manager(String name, int age, String gender, double salary, this.subordinates) : super(name, age, gender, salary);

  @override
  void displayInfo() {
    super.displayInfo();
    print('Подчиненные: $subordinates');
  }
}

void main() {
  Manager manager = Manager('Ольга', 35, 'Женский', 50000, ['Сергей', 'Анна']);
  manager.displayInfo();
}
