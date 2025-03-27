package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Mouse extends Animal {
    public Mouse() {
        super(0.05, 500, 1, 0.01, "🐁");
    }

    @Override
    public void eat() {
        System.out.println("Мышь ест зерно");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Мышь шуршит на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Мышь размножается");
    }
}
