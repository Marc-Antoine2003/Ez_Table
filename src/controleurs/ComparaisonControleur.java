package controleurs;

import csv.Atome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.HashMap;

public class ComparaisonControleur {

    @FXML
    private AnchorPane anchorpane2;

    @FXML
    private Label numatom2;

    @FXML
    private Label abreviation2;

    @FXML
    private Label nom2;

    @FXML
    private Label masse2;

    @FXML
    private AnchorPane anchorpane1;

    @FXML
    private Label numatom1;

    @FXML
    private Label abreviation1;

    @FXML
    private Label nom1;

    @FXML
    private Label masse1;

    @FXML
    private Label famille1;

    @FXML
    private Label periode1;

    @FXML
    private Label bloc1;

    @FXML
    private Label radio1;

    @FXML
    private Label etat1;

    @FXML
    private Label rayon1;

    @FXML
    private Label fusion1;

    @FXML
    private Label vapo1;

    @FXML
    private Label electro1;

    @FXML
    private Label typeliaisonlabel;

    @FXML
    private Label famille2;

    @FXML
    private Label periode2;

    @FXML
    private Label bloc2;

    @FXML
    private Label radio2;

    @FXML
    private Label etat2;

    @FXML
    private Label rayon2;

    @FXML
    private Label fusion2;

    @FXML
    private Label vapo2;

    @FXML
    private Label electro2;

    private Stage fenetreComparaison;

    private Button atome1bouton;

    private Button atome2bouton;

    private Atome atome1;

    private Atome atome2;

    private HashMap<String, Atome> atomes;

    public void setLabelAtomes()
    {
        atome1 = atomes.get(atome1bouton.getText());
        atome2 = atomes.get(atome2bouton.getText());

        nom1.setText(atome1.getNom());
        abreviation1.setText(atome1.getAbreviation());
        nom2.setText(atome2.getNom());

    }




    public void setFenetreComparaison(Stage fenetreComparaison) {
        this.fenetreComparaison = fenetreComparaison;
    }

    public void setAtomesAComparer(Button atome1, Button atome2) {
        this.atome1bouton = atome1;
        this.atome2bouton = atome2;
    }

    public void setAtomes(HashMap<String, Atome> atomes)
    {
        this.atomes = atomes;
    }

}
