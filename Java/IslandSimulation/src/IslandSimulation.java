import java.util.*;
import java.util.concurrent.*;

// Абстрактный класс животного
abstract class Animal {
    protected double weight;
    protected int maxPopulation;
    protected int speed;
    protected double foodRequired;
    protected String symbol;
    protected int x;
    protected int y;

    public Animal(double weight, int maxPopulation, int speed, double foodRequired, String symbol) {
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.speed = speed;
        this.foodRequired = foodRequired;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveToRandomLocation(int width, int height) {
        Random random = new Random();
        this.x = random.nextInt(width);
        this.y = random.nextInt(height);
    }

    abstract void eat();
    abstract void move(int width, int height, Location[][] locations);
    abstract void reproduce();
}

// Хищники
class Wolf extends Animal {
    public Wolf() {
        super(50, 30, 3, 8, "🐺");
    }
    @Override void eat() { System.out.println("Волк охотится"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Волк перемещается на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Волк размножается"); }
}

class Boa extends Animal {
    public Boa() {
        super(15, 30, 1, 3, "🐍");
    }
    @Override void eat() { System.out.println("Удав ест"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Удав ползет на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Удав размножается"); }
}

class Fox extends Animal {
    public Fox() {
        super(8, 30, 2, 2, "🦊");
    }
    @Override void eat() { System.out.println("Лиса охотится"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Лиса перемещается на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Лиса размножается"); }
}

class Bear extends Animal {
    public Bear() {
        super(500, 5, 2, 80, "🐻");
    }
    @Override void eat() { System.out.println("Медведь ищет пищу"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Медведь бродит на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Медведь размножается"); }
}

class Eagle extends Animal {
    public Eagle() {
        super(6, 20, 3, 1, "🦅");
    }
    @Override void eat() { System.out.println("Орел охотится"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Орел летит на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Орел размножается"); }
}

// Травоядные
class Deer extends Animal {
    public Deer() {
        super(300, 20, 4, 50, "🦌");
    }
    @Override void eat() { System.out.println("Олень пасется"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Олень бежит на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Олень размножается"); }
}

class Rabbit extends Animal {
    public Rabbit() {
        super(2, 150, 2, 0.45, "🐇");
    }
    @Override void eat() { System.out.println("Кролик ест траву"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Кролик прыгает на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Кролик размножается"); }
}

class Mouse extends Animal {
    public Mouse() {
        super(0.05, 500, 1, 0.01, "🐁");
    }
    @Override void eat() { System.out.println("Мышь ест зерно"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Мышь шуршит на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Мышь размножается"); }
}

class Caterpillar extends Animal {
    public Caterpillar() {
        super(0.01, 1000, 0, 0, "🐛");
    }
    @Override void eat() { System.out.println("Гусеница ест листья"); }
    @Override void move(int width, int height, Location[][] locations) {
        locations[this.x][this.y].getAnimals().remove(this); // Удаляем животное с текущей позиции
        moveToRandomLocation(width, height); // Перемещаем животное
        locations[this.x][this.y].addAnimal(this); // Добавляем на новую позицию
        System.out.println("Гусеница ползет на координаты: (" + x + ", " + y + ")");
    }
    @Override void reproduce() { System.out.println("Гусеница размножается"); }
}

// Локация
class Location {
    private List<Animal> animals = new CopyOnWriteArrayList<>();
    public void addAnimal(Animal animal) { animals.add(animal); }
    public void removeAnimal(Animal animal) { animals.remove(animal); }
    public List<Animal> getAnimals() { return animals; }
}

// Остров с псевдографикой
class Island {
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
        // Добавляем случайных животных на карту
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Animal wolf = new Wolf();
            wolf.setPosition(random.nextInt(width), random.nextInt(height));
            locations[wolf.x][wolf.y].addAnimal(wolf);

            Animal deer = new Deer();
            deer.setPosition(random.nextInt(width), random.nextInt(height));
            locations[deer.x][deer.y].addAnimal(deer);

            Animal rabbit = new Rabbit();
            rabbit.setPosition(random.nextInt(width), random.nextInt(height));
            locations[rabbit.x][rabbit.y].addAnimal(rabbit);

            Animal mouse = new Mouse();
            mouse.setPosition(random.nextInt(width), random.nextInt(height));
            locations[mouse.x][mouse.y].addAnimal(mouse);

            Animal caterpillar = new Caterpillar();
            caterpillar.setPosition(random.nextInt(width), random.nextInt(height));
            locations[caterpillar.x][caterpillar.y].addAnimal(caterpillar);
        }
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
                if (!animals.isEmpty()) {
                    System.out.print(animals.get(0).getSymbol());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}

// Основной класс
public class IslandSimulation {
    public static void main(String[] args) {
        int gridWidth = 50; // Увеличиваем ширину острова
        int gridHeight = 40; // Увеличиваем высоту острова
        Island island = new Island(gridWidth, gridHeight);
        island.startSimulation();
    }
}
