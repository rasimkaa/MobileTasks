package Animals.Predatory;

import Animals.Animal;
import Island.Location;

public class Eagle extends Animal {
    public Eagle() {
        super(6, 20, 4, 1, "🦅");
    }

    @Override public void eat() {
        System.out.println("Орёл охотится на мелких животных.");
    }

    @Override public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Орёл перелетел на координаты: (" + x + ", " + y + ")");
    }

    @Override public void reproduce() {
        System.out.println("Орёл размножается.");
    }
}
