package flyweight;

import factory.GameMap;
import javafx.scene.canvas.GraphicsContext;
import model.Tile;

public class MapRenderer {
    private final TileGraphicFactory graphicFactory;
    private final double tileSize;

    public MapRenderer(TileGraphicFactory graphicFactory, double tileSize) {
        this.graphicFactory = graphicFactory;
        this.tileSize = tileSize;
    }

    public void render(GraphicsContext gc, GameMap map) {
        Tile[][] grid = map.getGrid();

        for (int row = 0; row < map.getRows(); row++) {
            for (int col = 0; col < map.getCols(); col++) {
                Tile tile = grid[row][col];

                TileGraphic graphic = graphicFactory.getTileGraphic(tile.getType());

                double x = col * tileSize;
                double y = row * tileSize;

                graphic.draw(gc, x, y, tileSize);
            }
        }
    }
}