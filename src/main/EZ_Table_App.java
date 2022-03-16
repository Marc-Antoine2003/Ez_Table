package main;

import controleurs.TableauControleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EZ_Table_App extends Application {

    private TableauControleur controleurTableau;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EZ Table");
        FXMLLoader loaderPrimary = new FXMLLoader(this.getClass().getResource("tableauPeriodique.fxml"));
        primaryStage.setScene(new Scene(loaderPrimary.load()));
        controleurTableau = loaderPrimary.getController();
        controleurTableau.setFenetrePrincipale(primaryStage);
        primaryStage.show();
    }

}
