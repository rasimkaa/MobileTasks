package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Buffalo extends Animal {
    public Buffalo() {
        super(700, 10, 3, 100, "🐃");
    }

    @Override
    public void eat() {
        System.out.println("Буйвол пасется на равнине");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Буйвол идет на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Буйвол рожает теленка");
    }
}