class Student {
  String name;
  String group;
  double grade;

  Student(this.name, this.group, this.grade);
}

class University {
  List<Student> students = [];

  void addStudent(Student student) {
    students.add(student);
  }

  List<Student> getStudentsByGrade(double grade) {
    return students.where((student) => student.grade >= grade).toList();
  }
}

void main() {
  University university = University();
  university.addStudent(Student('Иван', 'Группа A', 4.5));
  university.addStudent(Student('Анна', 'Группа B', 3.8));

  var highGradeStudents = university.getStudentsByGrade(4.0);
  for (var student in highGradeStudents) {
    print('${student.name} имеет оценку ${student.grade}');
  }
}
