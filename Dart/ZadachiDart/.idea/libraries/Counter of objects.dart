class Counter {
  static int count = 0;

  Counter() {
    count++;
  }

  static void displayCount() {
    print('Количество созданных объектов: $count');
  }
}

void main() {
  Counter obj1 = Counter();
  Counter obj2 = Counter();
  Counter obj3 = Counter();
  Counter.displayCount();
}
