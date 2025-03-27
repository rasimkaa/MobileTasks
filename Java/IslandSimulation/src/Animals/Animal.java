package Animals;

import Island.Location;
import java.util.Random;

public abstract class Animal {
    protected double weight;
    protected int maxPopulation;
    protected int speed;
    protected double foodRequired;
    protected String symbol;
    public int x;
    public int y;

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

    public abstract void eat();
    public abstract void move(int width, int height, Location[][] locations);
    public abstract void reproduce();
}
