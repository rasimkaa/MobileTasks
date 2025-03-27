package Island;

import Animals.*;
import Animals.Herbivores.*;
import Animals.Predatory.*;
import java.util.Random;
import java.util.concurrent.*;
import java.util.List;


public class Island {
    private final int width;
    private final int height;
    private final Location[][] locations;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        locations = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                locations[i][j] = new Location();
            }
        }
        initializeAnimals();
    }

    private void initializeAnimals() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            addAnimal(new Wolf(), random);
            addAnimal(new Deer(), random);
            addAnimal(new Rabbit(), random);
            addAnimal(new Mouse(), random);
            addAnimal(new Caterpillar(), random);
            addAnimal(new Eagle(), random);
            addAnimal(new Fox(), random);
        }
    }

    private void addAnimal(Animal animal, Random random) {
        animal.setPosition(random.nextInt(width), random.nextInt(height));
        locations[animal.x][animal.y].addAnimal(animal);
    }

    public void startSimulation() {
        executor.scheduleAtFixedRate(this::simulateCycle, 0, 1, TimeUnit.SECONDS);
    }

    private void simulateCycle() {
        System.out.println("\nНовый такт симуляции");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (Animal animal : locations[i][j].getAnimals()) {
                    animal.eat();
                    animal.move(width, height, locations);
                    animal.reproduce();
                }
            }
        }
        draw();
    }

    public void draw() {
        System.out.println("\nКарта острова:");
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                List<Animal> animals = locations[i][j].getAnimals();
                System.out.print(animals.isEmpty() ? "." : animals.get(0).getSymbol());
            }
            System.out.println();
        }
    }
}
