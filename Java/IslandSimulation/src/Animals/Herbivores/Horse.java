package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Horse extends Animal {
    public Horse() {
        super(400, 20, 4, 60, "🐎");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь пасется на лугу");
    }

    @Override
    public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Лошадь скачет на координаты: (" + x + ", " + y + ")");
    }

    @Override
    public void reproduce() {
        System.out.println("Лошадь рожает жеребенка");
    }
}
