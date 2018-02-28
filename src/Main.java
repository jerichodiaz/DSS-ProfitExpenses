import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Created by Diaz, Jericho Hans
 * On 2/28/2018
 */
public class Main extends Application{
    Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));

        controller = new Controller();
        loader.setControllerFactory( c -> controller);
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Profit Expenses");
        primaryStage.setScene(scene);
        primaryStage.show();
        addShortcuts(scene);
    }

    private void addShortcuts(Scene scene){
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            final KeyCombination keyCombRun = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
            @Override
            public void handle(KeyEvent ke) {
                if(keyCombRun.match(ke)){
                    controller.calculate();
                    ke.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
