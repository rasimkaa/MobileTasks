package Animals.Predatory;

import Animals.Animal;
import Island.Location;

public class Boa extends Animal {
    public Boa() {
        super(15, 30, 1, 3, "🐍");
    }

    @Override public void eat() {
        System.out.println("Удав охотится на мелких животных");
    }

    @Override public void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].removeAnimal(this);
        moveToRandomLocation(width, height);
        locations[this.x][this.y].addAnimal(this);
        System.out.println("Удав ползет на координаты: (" + x + ", " + y + ")");
    }

    @Override public void reproduce() {
        System.out.println("Удав откладывает яйца");
    }
}