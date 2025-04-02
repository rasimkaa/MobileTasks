package Animals.Predatory;

import Animals.Animal;
import Island.Location;

public class Bear extends Animal {
    public Bear() {
        super(300, 5, 2, 30, "🐻");
    }

    @Override public void eat() {
        System.out.println("Медведь поедает рыбу и ягоды.");
    }

    @Override public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Медведь переместился на координаты: (" + x + ", " + y + ")");
    }

    @Override public  void reproduce() {
        System.out.println("Медведь размножается.");
    }
}
