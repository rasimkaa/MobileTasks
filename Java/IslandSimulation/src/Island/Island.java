package Island;

import Animals.*;
import Animals.Herbivores.*;
import Animals.Predatory.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


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
            addAnimal(new Bear(), random);
            addAnimal(new Boa(), random);
            addAnimal(new Buffalo(), random);
            addAnimal(new Duck(), random);
            addAnimal(new Sheep(), random);
            addAnimal(new Goat(), random);
            addAnimal(new Boar(), random);
            addAnimal(new Horse(), random);
        }
    }

    private void addAnimal(Animal animal, Random random) {
        animal.setPosition(random.nextInt(width), random.nextInt(height));
        locations[animal.x][animal.y].addAnimal(animal);
    }

    public void startSimulation() {
        executor.scheduleAtFixedRate(this::simulateCycle, 0, 5, TimeUnit.SECONDS);
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
        final String RESET = "\u001B[0m";
        final String GREEN_BG = "\u001B[42m";
        final String BLUE_BG = "\u001B[44m";
        final String BEJ_BG = "\u001B[48;5;180m";

        double centerX = width / 2.0;
        double centerY = height / 2.0;
        double radius = Math.min(width, height) * 0.4;

        System.out.println("\n" + BLUE_BG + " ".repeat(width + 4) + RESET);

        for (int y = 0; y < height; y++) {
            System.out.print(BLUE_BG + "  " + RESET);
            for (int x = 0; x < width; x++) {
                double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

                if (distance > radius) {
                    System.out.print(BLUE_BG + "  " + RESET);
                } else {
                    List<Animal> animals = locations[x][y].getAnimals();
                    String bg = (distance > radius * 0.9) ? BEJ_BG : GREEN_BG;

                    if (animals.isEmpty()) {
                        System.out.print(bg + "  " + RESET);
                    } else {
                        System.out.print(bg + " " + animals.get(0).getSymbol() + RESET);
                    }
                }
            }
            System.out.println(BLUE_BG + "  " + RESET);
        }

        System.out.println(BLUE_BG + " ".repeat(width + 4) + RESET);

        System.out.println("\nЛегенда:");
        System.out.println(GREEN_BG + "  " + RESET + " - Растительность");
        System.out.println(BEJ_BG + "  " + RESET + " - Побережье");
        System.out.println(BLUE_BG + "  " + RESET + " - Вода");
        System.out.println("Символы - животные");
    }
}
