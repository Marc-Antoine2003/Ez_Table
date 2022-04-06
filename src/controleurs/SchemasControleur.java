package controleurs;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javax.swing.event.ChangeEvent;
import javax.xml.soap.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class SchemasControleur {

    @FXML
    GridPane grilleBase;

    @FXML
    AnchorPane racine;

    @FXML
    void initialize() {
        TextField text1 = new TextField();
        text1.setText("ici");
        grilleBase.add(text1, 0, 2);
        ajouterEcouteur(text1);
    }

    private void ajouterEcouteur(TextField zoneActuelle) {
        zoneActuelle.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (!zoneActuelle.getText().isEmpty() && zoneActuelle.getUserData() == null) {
                        zoneActuelle.setUserData(new Object());
                        int nbTextField = grilleBase.getChildren().size();

                        for (int i = nbTextField - 1; i >= 0; i--) {
                            Node n = grilleBase.getChildren().get(i);
                            if (n instanceof TextField) {
                                int colonne = GridPane.getColumnIndex(n);
                                int rangee = GridPane.getRowIndex(n);
                                if (celluleVide(colonne, rangee) || GridPane.getRowIndex(zoneActuelle) == 0)
                                    GridPane.setRowIndex(n, rangee + 1);
                                else
                                    GridPane.setRowIndex(n, rangee);
                                GridPane.setColumnIndex(n, colonne);

                            }
                        }

                        for (int j = 0; j < 3; j++) {
                            TextField ajout = new TextField();
                            ajouterEcouteur(ajout);
                            switch (j) {
                                case 0:
                                    if (celluleVide(GridPane.getColumnIndex(zoneActuelle), GridPane.getRowIndex(zoneActuelle) - 1)) {
                                        grilleBase.add(ajout, GridPane.getColumnIndex(zoneActuelle), GridPane.getRowIndex(zoneActuelle) - 1);
                                    }
                                    break;
                                case 1:
                                    if (celluleVide(GridPane.getColumnIndex(zoneActuelle) + 2, GridPane.getRowIndex(zoneActuelle))) {
                                        grilleBase.add(ajout, GridPane.getColumnIndex(zoneActuelle) + 2, GridPane.getRowIndex(zoneActuelle));
                                    }
                                    break;
                                case 2:
                                    if (celluleVide(GridPane.getColumnIndex(zoneActuelle), GridPane.getRowIndex(zoneActuelle) + 1)) {
                                        grilleBase.add(ajout, GridPane.getColumnIndex(zoneActuelle), GridPane.getRowIndex(zoneActuelle) + 1);
                                    }
                                    break;

                            }
                        }
                    }
                }
            }

            private boolean celluleVide(int col, int row) {
                Node nodeDansCellule = null;
                for (Node node : grilleBase.getChildren()) {
                    if (node instanceof TextField && GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                        nodeDansCellule = node;
                    }
                }
                return nodeDansCellule == null;
            }
        });
    }
}
