package controleurs;


import com.sun.istack.internal.NotNull;
import csv.Atome;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.EZ_Table_App;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class TableauControleur {

    @FXML
    private GridPane grilleAtomesBase;

    @FXML
    private GridPane grilleAtomesArtificiels;

    @FXML
    private Label oxydationLabel;

    @FXML
    private Label electroLabel;

    @FXML
    private Label vapoLabel;

    @FXML
    private Label ioLabel;

    @FXML
    private Label etatLabel;

    @FXML
    private Label fusionLabel;

    @FXML
    private Label couchesLabel;

    @FXML
    private Label familleLabel;

    @FXML
    private Label periodeLabel;

    @FXML
    private Label blocLabel;

    @FXML
    private Label rayonLabel;

    @FXML
    private Label radioLabel;

    @FXML
    private Label symboleLabel;

    @FXML
    private Label masseMolLabel;

    @FXML
    private Label numAtomiqueLabel;

    @FXML
    private Label nomLabel;

    @FXML
    private AnchorPane afficheAtome;

    private Button boutonSousSouris;
    private Button boutonSelectionne;
    private HashMap<String, Atome> atomes = new HashMap<>();
    private Stage fenetrePrincipale;

    @FXML
    void initialize() {
        initialiserLabels();
        initialiserEvents();
        recupererAtome();
        assignerAtomes();
    }

    private void initialiserEvents() {
        EventHandler<MouseEvent> gestionDessus = (MouseEvent me) -> {
            if (me.getTarget() instanceof Button) {
                Button bouton = (Button) me.getTarget();

                if (boutonSousSouris != null && bouton != boutonSousSouris)
                    enleverAnimation(boutonSousSouris);

                boutonSousSouris = bouton;

                bouton.setStyle("-fx-border-color: blue; -fx-border-width: 2; -fx-background-color: " + getBackgroundColor(bouton.getStyle()) + ";");

                afficherProprietesAtome((Atome) bouton.getUserData());
                afficheAtome.setStyle("-fx-border-color: black; -fx-background-color: " + getBackgroundColor(bouton.getStyle()) + ";");
            }
        };

        EventHandler<MouseEvent> gestionParti =  (MouseEvent me) -> {
            if (me.getTarget() instanceof Button) {
                enleverAnimation((Button) me.getTarget());
            }
        };

        EventHandler<ActionEvent> gestionClic =  (ActionEvent me) -> {
            if (me.getTarget() instanceof Button) {
                Button bouton = (Button) me.getTarget();

                if (bouton != boutonSelectionne) {

                    // Animation
                    if (boutonSelectionne != null)
                        enleverAnimation(boutonSelectionne);

                    boutonSelectionne = bouton;
                    bouton.setStyle("-fx-border-color: blue; -fx-border-width: 3; -fx-background-color: " + getBackgroundColor(bouton.getStyle()) + ";");

                    grilleAtomesBase.removeEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
                    grilleAtomesBase.removeEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);

                    grilleAtomesArtificiels.removeEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
                    grilleAtomesArtificiels.removeEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);

                    afficherProprietesAtome((Atome) bouton.getUserData());
                    afficheAtome.setStyle("-fx-border-color: black; -fx-background-color: " + getBackgroundColor(bouton.getStyle()) + ";");
                }

                else {
                    enleverAnimation(bouton);

                    grilleAtomesBase.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
                    grilleAtomesBase.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);

                    grilleAtomesArtificiels.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
                    grilleAtomesArtificiels.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);
                }
            }
        };

        grilleAtomesBase.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
        grilleAtomesBase.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);
        grilleAtomesBase.addEventFilter(ActionEvent.ACTION, gestionClic);

        grilleAtomesArtificiels.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
        grilleAtomesArtificiels.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);
        grilleAtomesArtificiels.addEventFilter(ActionEvent.ACTION, gestionClic);
    }

    private void initialiserLabels() {
        oxydationLabel.setText("");
        electroLabel.setText("-");
        vapoLabel.setText("-");
        ioLabel.setText("-");
        etatLabel.setText("-");
        fusionLabel.setText("-");
        couchesLabel.setText("-");
        familleLabel.setText("-");
        periodeLabel.setText("-");
        blocLabel.setText("-");
        rayonLabel.setText("-");
        radioLabel.setText("-");
        symboleLabel.setText("");
        masseMolLabel.setText("");
        numAtomiqueLabel.setText("");
        nomLabel.setText("");
        afficheAtome.setStyle("-fx-border-color: black");
    }

    private void assignerAtomes() {
        for (Node atome : grilleAtomesBase.getChildren()) {
            if (atome instanceof Button)
                atome.setUserData(atomes.get(((Button) atome).getText()));
        }

        for (Node atome : grilleAtomesArtificiels.getChildren()) {
            if (atome instanceof Button)
                atome.setUserData(atomes.get(((Button) atome).getText()));
        }
    }

    @FXML
    void calculerMasseMol(ActionEvent event) {
        Stage masseMolStage = new Stage();
        masseMolStage.setTitle("EZ Table - Calculateur de masse molaire");

        FXMLLoader loaderMasseMol = new FXMLLoader(EZ_Table_App.class.getResource("calculateurMasseMolaire.fxml"));
        try {
            masseMolStage.setScene(new Scene(loaderMasseMol.load()));
        }
        catch (IOException io) {
            io.printStackTrace();
        }

        CalculMasseControleur calculateurControleur = loaderMasseMol.getController();
        calculateurControleur.setFenetrePrincipale(fenetrePrincipale);
        calculateurControleur.setFenetreCalculateur(masseMolStage);
        calculateurControleur.setAtomes(atomes);

        fenetrePrincipale.hide();
        masseMolStage.show();
    }


    @FXML
    void afficherAide(ActionEvent event) {
    }

    @FXML
    void afficherFamilles(ActionEvent event) {

    }

    @FXML
    void afficherLiaisons(ActionEvent event) {
    }

    @FXML
    void afficherSchemas(ActionEvent event) {
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

    private void enleverAnimation(@NotNull Button bouton) {
        bouton.setStyle("-fx-border-color: white; -fx-background-color: " + getBackgroundColor(bouton.getStyle()) + ";");
    }

    public void recupererAtome()
    {
        try
        {
            URL url = EZ_Table_App.class.getResource("csv/atomes.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] values = line.split(",");


                Atome atome = new Atome(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15]);
                atomes.put(atome.getAbreviation(), atome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void afficherProprietesAtome(Atome atome) {
        oxydationLabel.setText(formattageOxydations(atome));
        electroLabel.setText(String.valueOf(atome.getElectronegativite()));
        vapoLabel.setText(String.valueOf(atome.getEbullition()));
        fusionLabel.setText(String.valueOf(atome.getFusion()));
        couchesLabel.setText(String.valueOf(atome.getConfigElectroniqueText()));
        familleLabel.setText(String.valueOf(atome.getFamille()));
        periodeLabel.setText(String.valueOf(atome.getPeriode()));
        blocLabel.setText(String.valueOf(atome.getBlock()));
        rayonLabel.setText(String.valueOf(atome.getRayonAtomique()));
        symboleLabel.setText(String.valueOf(atome.getAbreviation()));
        masseMolLabel.setText(String.valueOf(atome.getMasse()));
        numAtomiqueLabel.setText(String.valueOf(atome.getNumeroAtomique()));
        nomLabel.setText(String.valueOf(atome.getNom()));
        etatLabel.setText(trouverEtat(atome));
        radioLabel.setText(atome.isRadioactivite());
    }

    private String formattageOxydations(Atome atome) {
        String oxy = "";
        List<String> oxydations = atome.getOxydations();
        int i = 0;
        if (oxydations.size() > 0) {
            while (i <= oxydations.size() - 1) {
                if (i == oxydations.size() - 1)
                    oxy += oxydations.get(i);

                else {
                    if (i % 2 == 1)
                        oxy += oxydations.get(i) + ",\n";
                    else
                        oxy += oxydations.get(i) + ", ";
                }
                i++;
            }
        }

        return oxy;
    }

    public void setFenetrePrincipale(Stage fenetrePrincipale) {
        this.fenetrePrincipale = fenetrePrincipale;
    }

}
