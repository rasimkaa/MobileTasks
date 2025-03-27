package Animals.Predatory;

import Animals.Animal;
import Island.Location;

public class Wolf extends Animal {
    public Wolf() {
        super(50, 30, 3, 8, "🐺");
    }

    @Override
    public void eat() {
        System.out.println("Волк охотится");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Волк перемещается на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Волк размножается");
    }
}