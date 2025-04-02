package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Rabbit extends Animal {
    public Rabbit() {
        super(2, 150, 2, 0.45, "🐇");
    }

    @Override public void eat() {
        System.out.println("Кролик ест траву");
    }
    @Override public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Кролик прыгает на координаты: (" + x + ", " + y + ")");
    }
    @Override public void reproduce() {
        System.out.println("Кролик размножается");
    }
}
