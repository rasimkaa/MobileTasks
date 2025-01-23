class UniqueID {
  static int _counter = 0;

  static String generateID() {
    _counter++;
    return "ID_$_counter";
  }
}

void main() {
  print(UniqueID.generateID()); // ID_1
  print(UniqueID.generateID()); // ID_2
  print(UniqueID.generateID()); // ID_3
}
