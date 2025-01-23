class ComplexNumber {
  double real, imaginary;

  ComplexNumber(this.real, this.imaginary);

  ComplexNumber operator +(ComplexNumber other) {
    return ComplexNumber(real + other.real, imaginary + other.imaginary);
  }

  ComplexNumber operator -(ComplexNumber other) {
    return ComplexNumber(real - other.real, imaginary - other.imaginary);
  }

  ComplexNumber operator *(ComplexNumber other) {
    double realPart = real * other.real - imaginary * other.imaginary;
    double imaginaryPart = real * other.imaginary + imaginary * other.real;
    return ComplexNumber(realPart, imaginaryPart);
  }

  ComplexNumber operator /(ComplexNumber other) {
    double denominator = other.real * other.real + other.imaginary * other.imaginary;
    double realPart = (real * other.real + imaginary * other.imaginary) / denominator;
    double imaginaryPart = (imaginary * other.real - real * other.imaginary) / denominator;
    return ComplexNumber(realPart, imaginaryPart);
  }

  @override
  String toString() {
    return "${real} + ${imaginary}i";
  }
}

void main() {
  ComplexNumber c1 = ComplexNumber(2, 3);
  ComplexNumber c2 = ComplexNumber(1, 4);

  print("Сложение: ${c1 + c2}"); // Сложение: 3.0 + 7.0i
  print("Вычитание: ${c1 - c2}"); // Вычитание: 1.0 - 1.0i
  print("Умножение: ${c1 * c2}"); // Умножение: -10.0 + 11.0i
  print("Деление: ${c1 / c2}"); // Деление: 0.6470588235294118 + -0.4117647058823529i
}
