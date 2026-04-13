package factory;

import model.BuildingTile;
import model.ForestTile;
import model.RoadTile;
import model.Tile;

public class CityMap extends GameMap {

    public CityMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    public Tile createTile() {
        Tile[] tiles = {
                new BuildingTile(),
                new RoadTile(),
                new ForestTile()
        };
        return random(tiles);
    }
}