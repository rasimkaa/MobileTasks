class Matrix {
  List<List<int>> values;

  Matrix(this.values);

  Matrix operator +(Matrix other) {
    List<List<int>> result = [];

    for (int i = 0; i < values.length; i++) {
      List<int> row = [];
      for (int j = 0; j < values[i].length; j++) {
        row.add(values[i][j] + other.values[i][j]);
      }
      result.add(row);
    }

    return Matrix(result);
  }

  Matrix operator *(Matrix other) {
    List<List<int>> result = [];

    for (int i = 0; i < values.length; i++) {
      List<int> row = [];
      for (int j = 0; j < other.values[0].length; j++) {
        int sum = 0;
        for (int k = 0; k < values[i].length; k++) {
          sum += values[i][k] * other.values[k][j];
        }
        row.add(sum);
      }
      result.add(row);
    }

    return Matrix(result);
  }

  void printMatrix() {
    for (var row in values) {
      print(row);
    }
  }
}

void main() {
  Matrix m1 = Matrix([
    [1, 2],
    [3, 4]
  ]);

  Matrix m2 = Matrix([
    [5, 6],
    [7, 8]
  ]);

  Matrix m3 = m1 + m2;
  m3.printMatrix();

  Matrix m4 = m1 * m2;
  m4.printMatrix();
}
