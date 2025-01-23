class BankAccount {
  String accountNumber;
  double balance;

  BankAccount(this.accountNumber, this.balance);

  void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      print('Пополнение на сумму: $amount');
    } else {
      print('Сумма пополнения должна быть больше нуля');
    }
  }

  void withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      print('Снятие суммы: $amount');
    } else {
      print('Недостаточно средств на счете');
    }
  }
}

void main() {
  BankAccount account = BankAccount('123456', 1000);
  account.deposit(500);
  account.withdraw(200);
  account.withdraw(1500);
}
