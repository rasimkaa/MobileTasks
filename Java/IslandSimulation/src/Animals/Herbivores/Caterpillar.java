package Animals.Herbivores;

import Animals.Animal;
import Island.Location;

public class Caterpillar extends Animal {
    public Caterpillar() {
        super(0.01, 1000, 0, 0, "🐛");
    }
    @Override public  void eat() { System.out.println("Гусеница ест листья"); }
    @Override public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Гусеница ползет на координаты: (" + x + ", " + y + ")");
    }
    @Override public void reproduce() { System.out.println("Гусеница размножается"); }
}
