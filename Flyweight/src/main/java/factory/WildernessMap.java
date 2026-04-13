package factory;

import model.ForestTile;
import model.SwampTile;
import model.Tile;
import model.WaterTile;

public class WildernessMap extends GameMap {

    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    public Tile createTile() {
        Tile[] tiles = {
                new ForestTile(),
                new SwampTile(),
                new WaterTile()
        };
        return random(tiles);
    }
}