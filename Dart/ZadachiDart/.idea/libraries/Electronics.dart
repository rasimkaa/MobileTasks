class Device {
  String brand;

  Device(this.brand);

  void turnOn() {
    print("$brand включен.");
  }

  void turnOff() {
    print("$brand выключен.");
  }
}

class Smartphone extends Device {
  Smartphone(String brand) : super(brand);

  void takePhoto() {
    print("$brand делает фото.");
  }
}

class Laptop extends Device {
  Laptop(String brand) : super(brand);

  void openBrowser() {
    print("$brand открывает браузер.");
  }
}

void main() {
  Smartphone phone = Smartphone("Samsung");
  phone.turnOn();
  phone.takePhoto();

  Laptop laptop = Laptop("Dell");
  laptop.turnOn();
  laptop.openBrowser();
}
