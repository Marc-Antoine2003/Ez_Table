package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CalculMasseControleur {

    @FXML
    private TextField textFieldMolecule;

    @FXML
    private Label masseMolecule;

    private Stage fenetrePrincipale;
    private Stage fenetreCalculateur;

    @FXML
    void calculerMasseMolaire(ActionEvent event) {

    }

    @FXML
    void retourFenetrePrincipale(MouseEvent event) {
        fenetreCalculateur.close();
        fenetrePrincipale.show();
    }

    public void setFenetrePrincipale(Stage fenetrePrincipale) {
        this.fenetrePrincipale = fenetrePrincipale;
    }

    public void setFenetreCalculateur(Stage fenetreCalculateur) {
        this.fenetreCalculateur = fenetreCalculateur;
    }
}
