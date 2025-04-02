package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Deer extends Animal {
    public Deer() {
        super(300, 20, 4, 50, "🦌");
    }

    @Override
    public void eat() {
        System.out.println("Олень пасется");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Олень бежит на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Олень размножается");
    }
}
