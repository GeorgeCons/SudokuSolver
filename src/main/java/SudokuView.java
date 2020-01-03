import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class SudokuView {

    private FXMLLoadPair loadFromFxml(String resourceName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + resourceName + ".fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FXMLLoadPair(root, (IController)loader.getController());
    }
}
