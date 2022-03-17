package controleurs;

import csv.Atome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
        nom2.setText(atome2.getNom());
        abreviation1.setText(atome1.getAbreviation());
        abreviation2.setText(atome2.getAbreviation());
        numatom1.setText(String.valueOf(atome1.getNumeroAtomique()));
        numatom2.setText(String.valueOf(atome2.getNumeroAtomique()));
        masse1.setText(String.valueOf(atome1.getMasse()));
        masse2.setText(String.valueOf(atome2.getMasse()));
        famille1.setText(String.valueOf(atome1.getFamille()));
        famille2.setText(String.valueOf(atome2.getFamille()));
        periode1.setText(String.valueOf(atome1.getPeriode()));
        periode2.setText(String.valueOf(atome2.getPeriode()));
        bloc1.setText(String.valueOf(atome1.getBlock()));
        bloc2.setText(String.valueOf(atome2.getBlock()));
        radio1.setText(atome1.isRadioactivite());
        radio2.setText(atome2.isRadioactivite());
        etat1.setText(trouverEtat(atome1));
        etat2.setText(trouverEtat(atome2));
        rayon1.setText((atome1.getRayonAtomique()));
        rayon2.setText((atome2.getRayonAtomique()));
        fusion1.setText(String.valueOf(atome1.getFusion()));
        fusion2.setText(String.valueOf(atome2.getFusion()));
        vapo1.setText(String.valueOf(atome1.getEbullition()));
        vapo2.setText(String.valueOf(atome2.getEbullition()));
        electro1.setText(String.valueOf(atome1.getElectronegativite()));
        electro2.setText(String.valueOf(atome2.getElectronegativite()));

        setCouleur();
        determinerLiaison();
    }

    private String trouverEtat(Atome atome) {
        String etat = "";

        if (atome.getFusion() > 25)
            etat = "Solide";
        else if (atome.getFusion() <= 25 && atome.getEbullition() > 25)
            etat = "Liquide";
        else if (atome.getEbullition() <= 25)
            etat = "Gazeux";

        return etat;
    }

    private void setCouleur()
    {
        anchorpane1.setStyle("-fx-background-color: " + getBackgroundColor(atome1bouton.getStyle()) + ";");
        anchorpane2.setStyle("-fx-background-color: " + getBackgroundColor(atome2bouton.getStyle()) + ";");
    }

    private void determinerLiaison()
    {
        double min;
        double max;

        max = Math.max(atome1.getElectronegativite(), atome2.getElectronegativite());
        min = Math.min(atome1.getElectronegativite(), atome2.getElectronegativite());

        if(max - min < 1.67)
        {
            typeliaisonlabel.setText("Covalente");
        }
        else
        {
            typeliaisonlabel.setText("Ionique");
        }
    }
    private String getBackgroundColor(String styleBouton) {
        String couleur;

        if (styleBouton.contains("lightgrey"))
            couleur = "lightgrey";
        else if (styleBouton.contains("lightgreen"))
            couleur = "lightgreen";
        else if (styleBouton.contains("lightblue"))
            couleur = "lightblue";
        else if (styleBouton.contains("lightyellow"))
            couleur = "lightyellow";
        else if (styleBouton.contains("lightpink"))
            couleur = "lightpink";
        else
            couleur = "yellow";

        return couleur;
    }

    public void setFenetreComparaison(Stage fenetreComparaison) {
        this.fenetreComparaison = fenetreComparaison;
    }

    public void setAtomesAComparer(Button atome1, Button atome2) {
        this.atome1bouton = atome1;
        this.atome2bouton = atome2;
    }

    @FXML
    void retour(MouseEvent event) {
        fenetreComparaison.close();
    }


    public void setAtomes(HashMap<String, Atome> atomes)
    {
        this.atomes = atomes;
    }
}
