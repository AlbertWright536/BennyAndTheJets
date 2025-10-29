import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import java.util.List;

public class FractalApp extends Application {
	
	public void start(Stage stage) {
		List<String> args = getParameters.getRaw()
		//get variables from main here
		
		Pane pane = new Pane();
		pane.setPrefSize(800, 600);
		Scene scene = new Scene(pane, 800, 600, Color.WHITE);
		stage.setScene(scene);
		stage.setTitle("CS1131 Fractal -- " +cfg.typetoUpperCase());
		stage.show();

		drawFractal(pane, args)
	}

	private void drawFractal(Pane pane, List<String>args) {
		//Code to draw the fractal goes here
		//TODO: impliment ONE fractal
		//unless your feeling wild
		//personally I'm leaning towards sierpinki's triangle cause it looks nice
	}

}
