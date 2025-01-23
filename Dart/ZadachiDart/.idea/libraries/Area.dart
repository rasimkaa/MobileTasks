abstract class Shape {
  double getArea();
}

class Circle implements Shape {
  double radius;

  Circle(this.radius);

  @override
  double getArea() {
    return 3.14 * radius * radius;
  }
}

class Rectangle implements Shape {
  double width;
  double height;

  Rectangle(this.width, this.height);

  @override
  double getArea() {
    return width * height;
  }
}

void main() {
  Shape circle = Circle(5);
  Shape rectangle = Rectangle(4, 6);
  print('Площадь круга: ${circle.getArea()}');
  print('Площадь прямоугольника: ${rectangle.getArea()}');
}
