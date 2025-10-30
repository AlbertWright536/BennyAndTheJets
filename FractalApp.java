import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import java.util.List;

public class FractalApp extends Application {
    @Override

    public void start(Stage stage) {
        List<String> args = getParameters().getRaw();

        Pane pane = new Pane();
        pane.setPrefSize(800, 600);
        Scene scene = new Scene(pane, 800, 600, Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("CS1131 Fractal");
        stage.show();

        drawFractal(pane, args);
    }

    private void drawFractal(Pane pane, List<String> args) {
        int depth = Integer.parseInt(args.get(0));
        double size = Double.parseDouble(args.get(1));
        sierpinskiIterate(pane, 0, 0, size, depth);
    }

    private void sierpinskiIterate(Pane pane, double x, double y, double side, int depth) {
        double half = side / 2;
        double h = Math.sqrt(3) * half;
        if (depth == 0) {
            Polygon triangle = new Polygon();
            triangle.getPoints().addAll(new Double[]{
                x, y + h,
                x + side, y + h,
                x + half, y
            });
            pane.getChildren().add(triangle);
            return;
        }

        sierpinskiIterate(pane, x + half/2, y, half, depth - 1);
        sierpinskiIterate(pane, x, y + h/2, half, depth - 1);
        sierpinskiIterate(pane, x + half, y + h/2, half, depth - 1);
    }
}
