import controleurs.CalculMasseControleur;
import controleurs.TableauControleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EZ_Table_App extends Application {

    private TableauControleur controleurTableau;
    private CalculMasseControleur calculMasseControleur;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EZ Table");
        FXMLLoader loaderPrimary = new FXMLLoader(this.getClass().getResource("tableauPeriodique.fxml"));
        primaryStage.setScene(new Scene(loaderPrimary.load()));
        controleurTableau = loaderPrimary.getController();
        primaryStage.show();
    }

    public void afficherCalculateur(Stage masseMolStage) {
        FXMLLoader loaderMasseMol = new FXMLLoader(this.getClass().getResource("calculateurMasseMolaire.fxml"));
        try {
            masseMolStage.setScene(new Scene(loaderMasseMol.load()));
        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }
}
