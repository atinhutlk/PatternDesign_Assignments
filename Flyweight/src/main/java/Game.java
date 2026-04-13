import factory.CityMap;
import factory.GameMap;
import flyweight.MapRenderer;
import flyweight.TileGraphicFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

    public GameMap createMap() {
        return new CityMap(10, 10);

    }

    @Override
    public void start(Stage stage) {
        GameMap map = createMap();
        map.generate();

        System.out.println("Generated text map:");
        map.displayTextMap();

        double tileSize = 50;
        double canvasWidth = map.getCols() * tileSize;
        double canvasHeight = map.getRows() * tileSize;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        TileGraphicFactory graphicFactory = new TileGraphicFactory();
        MapRenderer renderer = new MapRenderer(graphicFactory, tileSize);

        renderer.render(gc, map);

        System.out.println("Number of shared tile graphics created: " + graphicFactory.getGraphicCount());

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, canvasWidth, canvasHeight);

        stage.setTitle("RPG Map - Flyweight Rendering");
        stage.setScene(scene);
        stage.show();
    }

}