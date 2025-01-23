class Point {
  int x, y;

  Point(this.x, this.y);
}

class Rectangle {
  Point topLeft;
  Point bottomRight;

  Rectangle(this.topLeft, this.bottomRight);

  int getArea() {
    return (bottomRight.x - topLeft.x) * (bottomRight.y - topLeft.y);
  }
}

void main() {
  Point p1 = Point(0, 0);
  Point p2 = Point(5, 5);
  Rectangle rect = Rectangle(p1, p2);

  print("Площадь прямоугольника: ${rect.getArea()}"); // Площадь прямоугольника: 25
}
