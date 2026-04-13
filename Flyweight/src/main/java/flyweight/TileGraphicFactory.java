package flyweight;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private final Map<String, TileGraphic> graphicMap = new HashMap<>();

    public TileGraphic getTileGraphic(String tileType) {
        if (!graphicMap.containsKey(tileType)) {
            System.out.println("Creating new graphic for: " + tileType);

            switch (tileType) {
                case "forest":
                    graphicMap.put(tileType, new TileGraphic(tileType, Color.FORESTGREEN));
                    break;
                case "water":
                    graphicMap.put(tileType, new TileGraphic(tileType, Color.DEEPSKYBLUE));
                    break;
                case "swamp":
                    graphicMap.put(tileType, new TileGraphic(tileType, Color.DARKOLIVEGREEN));
                    break;
                case "road":
                    graphicMap.put(tileType, new TileGraphic(tileType, Color.LIGHTGRAY));
                    break;
                case "building":
                    graphicMap.put(tileType, new TileGraphic(tileType, Color.SANDYBROWN));
                    break;
                default:
                    graphicMap.put(tileType, new TileGraphic(tileType, Color.WHITE));
                    break;
            }
        }

        return graphicMap.get(tileType);
    }

    public int getGraphicCount() {
        return graphicMap.size();
    }
}