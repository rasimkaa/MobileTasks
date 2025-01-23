abstract class PaymentSystem {
  void pay(double amount);
  void refund(double amount);
}

class CreditCard implements PaymentSystem {
  @override
  void pay(double amount) {
    print("Оплата через кредитную карту: \$${amount}");
  }

  @override
  void refund(double amount) {
    print("Возврат на кредитную карту: \$${amount}");
  }
}

class PayPal implements PaymentSystem {
  @override
  void pay(double amount) {
    print("Оплата через PayPal: \$${amount}");
  }

  @override
  void refund(double amount) {
    print("Возврат через PayPal: \$${amount}");
  }
}

void main() {
  PaymentSystem creditCard = CreditCard();
  creditCard.pay(100); // Оплата через кредитную карту: $100
  creditCard.refund(50); // Возврат на кредитную карту: $50

  PaymentSystem payPal = PayPal();
  payPal.pay(200); // Оплата через PayPal: $200
  payPal.refund(100); // Возврат через PayPal: $100
}
