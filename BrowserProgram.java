//Benny And The Jets
//Michelle Boscato
//Marcus Bonifas
//Freya Durst
//Albert Wright
//
// IMPORTS
// These are some classes that may be useful for completing the project.
// You may have to add others.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.stage.Stage;
import javafx.concurrent.Worker.State;
import javafx.concurrent.Worker;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

/**
 * The main class for BrowserProgram. BrowserProgram constructs the JavaFX window and
 * handles interactions with the dynamic components contained therein.
 */
public class BrowserProgram extends Application {
	// INSTANCE VARIABLES
	// These variables are included to get you started.
	private Stage stage = null;
	private BorderPane borderPane = null;
	private WebView view = null;
	private WebEngine webEngine = null;
	private TextField statusbar = null;
	private TextField addressBox = null;
	private String webPage = "https://google.com";
	//alternative starting address is https://migigan.tech
	private int historyIndex = 0;
    private WebHistory history = null;


	// HELPER METHODS
	/**
	 * Retrieves the value of a command line argument specified by the index.
	 *
	 * @param index - position of the argument in the args list.
	 * @return The value of the command line argument.
	 */
	private String getParameter( int index ) {
		Parameters params = getParameters();
		List<String> parameters = params.getRaw();
		return !parameters.isEmpty() ? parameters.get(index) : "";
	}

	/**
	 * Creates a WebView which handles mouse and some keyboard events, and
	 * manages scrolling automatically, so there's no need to put it into a ScrollPane.
	 * The associated WebEngine is created automatically at construction time.
	 *
	 * @return browser - a WebView container for the WebEngine.
	 */
	private WebView makeHtmlView( ) {
		view = new WebView();
		webEngine = view.getEngine();
        history = webEngine.getHistory();
        	webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    public void changed(ObservableValue ov, State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            addressBox.setText(webEngine.getLocation());
                            stage.setTitle(webEngine.getTitle());
                        }
                    }
                });
        	webEngine.setOnStatusChanged(e -> statusbar.setText( e.getData()));
		
		webEngine.load(webPage);
		return view;
	}

	/**
	 * Generates the status bar layout and text field.
	 *
	 * @return statusbarPane - the HBox layout that contains the statusbar.
	 */
	private HBox makeStatusBar( ) {
		HBox statusbarPane = new HBox();
		statusbarPane.setPadding(new Insets(5, 4, 5, 4));
		statusbarPane.setSpacing(10);
		statusbarPane.setStyle("-fx-background-color: #336699;");
		statusbar = new TextField( );
		statusbarPane.getChildren().addAll(statusbar);
		HBox.setHgrow(statusbar, Priority.ALWAYS);	
		return statusbarPane;
	}
	private void setWebPage (String page) {
		webPage = page;
	}
	public String getWebPage () {
		return webPage;
	}

	//Make ToolBar, including back and forward buttons, address box, and help button
	public HBox makeToolBar() {
		HBox toolbar = new HBox(10);
		toolbar.setStyle("-fx-background-color: #000000;");
		Button backArrow = new Button("<");
		backArrow.setOnAction(e -> {
            history.go(-1);
		});
		Button forwardArrow = new Button(">");
		forwardArrow.setOnAction(e -> {
            history.go(1);
		});
		TextField addressBar = new TextField();
		addressBar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle ( ActionEvent e ) {
				webEngine.load(addressBar.getText());
			}
		});
        	addressBox = addressBar;
		Button help = new Button("?");
		help.setOnAction(e -> {
			webEngine.loadContent("<html><body<h1>WebBrowser</H1><br/></body></html>You are using the web browser application developed by BennyAndTheJets, a team of students at Michigan Technological University. This was developed as part of the class CS1131 Accelerated Intro to Programming, Lab session L03. To use this program type a web address in the search bar at the top. If the address that you typed was invalid you will be routed to this screen. If you were routed here then it is likely that you made an error when typing the URL. Make sure that you remember to include https:// at the start of your URL, and .com at the end. If you are unable to remember the URL consider navigating to https://google.com to find the sight that way");
		
			}
		);
		toolbar.getChildren().addAll(backArrow, forwardArrow, addressBar, help);
	
		HBox.setHgrow(addressBar, Priority.ALWAYS);
		return toolbar;
	}

	// REQUIRED METHODS
	/**
	 * The main entry point for all JavaFX applications. The start method is
	 * called after the init method has returned, and after the system is ready
	 * for the application to begin running.
	 *
	 * NOTE: This method is called on the JavaFX Application Thread.
	 *
	 * @param primaryStage - the primary stage for this application, onto which
	 * the application scene can be set.
	 */
	@Override
	public void start(Stage primaryStage) {
		// Build your window here
        stage = primaryStage;
		primaryStage.setTitle(webPage);	
		BorderPane borderPane = new BorderPane();
		HBox statusbarPane = makeStatusBar();
		HBox makeToolBar = makeToolBar();
		WebView webView = makeHtmlView();
		borderPane.setTop(makeToolBar);
		borderPane.setCenter(webView);
		borderPane.setBottom(statusbarPane);
		Scene mainScene = new Scene(borderPane);
	
		primaryStage.setScene(mainScene);
		//mainScene.sizeToStage();
		
			

		stage.show();
	}
	/**
	 * The main( ) method is ignored in JavaFX applications.
	 * main( ) serves only as fallback in case the application is launched
	 * as a regular Java application, e.g., in IDEs with limited FX
	 * support.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
