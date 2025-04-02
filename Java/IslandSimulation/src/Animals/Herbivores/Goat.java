package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Goat extends Animal {
    public Goat() {
        super(60, 140, 3, 10, "🐐");
    }

    @Override
    public void eat() {
        System.out.println("Коза ест траву и кустарники");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Коза переходит на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Коза рожает козленка");
    }
}