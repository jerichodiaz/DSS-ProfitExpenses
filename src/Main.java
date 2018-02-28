import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Diaz, Jericho Hans
 * On 2/28/2018
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));

        primaryStage.setTitle("Profit Expenses");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
