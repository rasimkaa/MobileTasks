class Product {
  String name;
  double price;

  Product(this.name, this.price);
}

class Order {
  int orderId;
  List<Product> products;

  Order(this.orderId, this.products);

  double calculateTotal() {
    return products.fold(0, (total, product) => total + product.price);
  }
}

class Customer {
  String name;
  List<Order> orders = [];

  Customer(this.name);

  void addOrder(Order order) {
    orders.add(order);
  }

  void printOrders() {
    for (var order in orders) {
      print("Заказ ${order.orderId}: ${order.calculateTotal()}");
    }
  }
}

void main() {
  Product p1 = Product("Телефон", 500);
  Product p2 = Product("Ноутбук", 1000);

  Order order1 = Order(1, [p1, p2]);

  Customer customer = Customer("Иван");
  customer.addOrder(order1);

  customer.printOrders();
}
