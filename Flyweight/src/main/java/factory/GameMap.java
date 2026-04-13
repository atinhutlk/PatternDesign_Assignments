package factory;

import model.Tile;

import java.util.Random;

public abstract class GameMap {
    protected int rows;
    protected int cols;
    protected Tile[][] grid;
    private final Random random = new Random();

    public GameMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Tile[rows][cols];
    }

    protected Tile random(Tile[] tiles) {
        int index = random.nextInt(tiles.length);
        return tiles[index];
    }

    public abstract Tile createTile();

    public void generate() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = createTile();
            }
        }
    }

    public void displayTextMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}