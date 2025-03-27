package Island;


public class IslandSimulation {
    public static void main(String[] args) {
        int gridWidth = 50;
        int gridHeight = 40;
        Island island = new Island(gridWidth, gridHeight);
        island.startSimulation();
    }
}
