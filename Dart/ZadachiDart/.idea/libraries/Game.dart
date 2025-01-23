class Player {
  String name;
  int health;

  Player(this.name, this.health);

  void attack(Enemy enemy) {
    print("$name атакует ${enemy.name}");
    enemy.takeDamage(10);
  }

  void takeDamage(int damage) {
    health -= damage;
    print("$name получил $damage урона. Осталось здоровья: $health");
  }
}

class Enemy {
  String name;
  int health;

  Enemy(this.name, this.health);

  void takeDamage(int damage) {
    health -= damage;
    print("$name получил $damage урона. Осталось здоровья: $health");
  }
}

void main() {
  Player player = Player("Игрок", 100);
  Enemy enemy = Enemy("Враг", 50);

  player.attack(enemy);
  enemy.takeDamage(10);
}
