package controleurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

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

    @FXML
    void initialize() {

        initialiserLabels();
        initialiserEvents();
    }

    private void initialiserEvents() {
        EventHandler<MouseEvent> gestionDessus = (MouseEvent me) -> {
            if (me.getTarget() instanceof Button) {
                Button bouton = (Button) me.getTarget();

                if (boutonSousSouris != null && bouton != boutonSousSouris)
                    enleverAnimation(boutonSousSouris);

                boutonSousSouris = bouton;

                bouton.setStyle("-fx-border-color: blue; -fx-border-width: 2; -fx-background-color: " + getBackgroundColor(bouton.getStyle()) + ";");
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
                    if (boutonSelectionne != null)
                        enleverAnimation(boutonSelectionne);

                    boutonSelectionne = bouton;
                    bouton.setStyle("-fx-border-color: blue; -fx-border-width: 3; -fx-background-color: " + getBackgroundColor(bouton.getStyle()) + ";");

                    grilleAtomesBase.removeEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
                    grilleAtomesBase.removeEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);

                    grilleAtomesArtificiels.removeEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, gestionDessus);
                    grilleAtomesArtificiels.removeEventFilter(MouseEvent.MOUSE_EXITED_TARGET, gestionParti);
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

    @FXML
    void calculerMasseMol(ActionEvent event) {

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
    

}
