package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Sheep extends Animal {
    public Sheep() {
        super(70, 140, 3, 15, "🐑");
    }

    @Override
    public void eat() {
        System.out.println("Овца пасется на лугу");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Овца переходит на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Овца рожает ягненка");
    }
}