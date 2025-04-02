package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Duck extends Animal {
    public Duck() {
        super(1, 200, 4, 0.15, "🦆");
    }

    @Override
    public void eat() {
        System.out.println("Утка ест растения и насекомых");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Утка летит на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Утка откладывает яйца");
    }
}