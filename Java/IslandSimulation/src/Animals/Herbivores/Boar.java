package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Boar extends Animal {
    public Boar() {
        super(400, 50, 2, 50, "🐗");
    }

    @Override
    public void eat() {
        System.out.println("Кабан ест коренья и желуди");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Кабан перемещается на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Кабан размножается");
    }
}