package Animals.Predatory;

import Animals.Animal;
import Island.Location;

public class Fox extends Animal {
    public Fox() {
        super(8, 30, 2, 2, "🦊");
    }

    @Override public void eat() {
        System.out.println("Лиса охотится на мышей.");
    }

    @Override public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Лиса переместилась на координаты: (" + x + ", " + y + ")");
    }

    @Override public void reproduce() {
        System.out.println("Лиса размножается.");
    }
}
