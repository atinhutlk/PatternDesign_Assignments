package flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TileGraphic {
    private final String tileType;
    private final Color color;

    public TileGraphic(String tileType, Color color) {
        this.tileType = tileType;
        this.color = color;
    }

    public String getTileType() {
        return tileType;
    }

    public void draw(GraphicsContext gc, double x, double y, double size) {
        gc.setFill(color);
        gc.fillRect(x, y, size, size);

        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, size, size);

        gc.setFill(Color.BLACK);
        gc.fillText(tileType.substring(0, 1).toUpperCase(), x + size / 2 - 4, y + size / 2 + 4);
    }
}