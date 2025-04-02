package Island;

import Animals.Animal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private List<Animal> animals = new CopyOnWriteArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
