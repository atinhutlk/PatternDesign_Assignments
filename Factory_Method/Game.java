import java.util.Random;
interface Tile {
    char getCharacter();
    String getType();
}

class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "swamp";
    }
}
class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "water";
    }
}
class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "forest";
    }
}
class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "road";
    }
}
class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "building";
    }
}

abstract class GameMap {

    protected int rows;
    protected int cols;
    protected Tile[][] grid;
    private Random random = new Random();


    public GameMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Tile[rows][cols];
    }
    protected Tile random(Tile[] tiles) {
        int index = random.nextInt(tiles.length);
        return tiles[index];
    }
    public abstract Tile createTile();


    public void display() {
       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = createTile();
                System.out.print(grid[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
class CityMap extends GameMap {
    public CityMap(int rows, int cols) {
        super(rows, cols);
    }
    @Override
    public Tile createTile() {
        Tile[] tiles = {new BuildingTile(), new RoadTile(), new ForestTile()};
        return random(tiles);
    }
}

class WildernessMap extends GameMap {
    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }
    @Override
    public Tile createTile() {
        Tile[] tiles = {new ForestTile(), new SwampTile(), new WaterTile()};
        return random(tiles);
    }
}



public class Game{
    public GameMap createMap() {
        return new CityMap(5, 5);
    }
    public static void main(String[] args) {
        Game game = new Game();
        GameMap map = game.createMap();
        map.display();
    }

}