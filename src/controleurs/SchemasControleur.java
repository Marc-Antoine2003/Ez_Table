package controleurs;

import csv.Atome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Set;

public class SchemasControleur {

    @FXML
    private AnchorPane racine;

    @FXML
    private Group zoneDessin;

    @FXML
    private Label label;

    private Atome atome1, atome2;

    public void initialiser() {
        trouverLiaison();
    }

    public void setAtomes(Atome atome1, Atome atome2) {
        this.atome1 = atome1;
        this.atome2 = atome2;
    }

    private void trouverLiaison() {
        int nbElectronsManquants1 = 18 - atome1.getFamille();
        int nbElectronsManquants2 = 18 - atome2.getFamille();
        label.setText(String.valueOf(nbElectronsManquants1) + nbElectronsManquants2);
    }


}