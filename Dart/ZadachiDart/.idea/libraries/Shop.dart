class Product {
  String name;
  double price;
  int quantity;

  Product(this.name, this.price, this.quantity);

  // Для удобства создадим пустого продукта
  Product.empty() : name = '', price = 0.0, quantity = 0;
}

class Store {
  List<Product> products = [];

  void addProduct(Product product) {
    products.add(product);
  }

  void removeProduct(String name) {
    products.removeWhere((product) => product.name == name);
  }

  Product findProduct(String name) {
    // Возвращаем пустой продукт, если не найден
    return products.firstWhere(
          (product) => product.name == name,
      orElse: () => Product.empty(), // Пустой продукт, если не найден
    );
  }
}

void main() {
  Store store = Store();
  store.addProduct(Product('Яблоко', 1.0, 100));
  store.addProduct(Product('Банан', 0.5, 150));

  // Пример поиска продукта
  Product product = store.findProduct('Яблоко');
  if (product.name.isEmpty) {
    print('Продукт не найден');
  } else {
    print('Найден продукт: ${product.name}');
  }
}
