package controleurs;

import csv.Atome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CalculMasseControleur {

    @FXML
    private TextField textFieldMolecule;

    @FXML
    private Label masseMolecule;

    private Stage fenetrePrincipale;
    private Stage fenetreCalculateur;

    private HashMap<String, Atome> atomes;

    @FXML
    void calculerMasseMolaire(ActionEvent event) {
        double masseMolaire = 0;
        boolean trouve;
        Set<String> symbAtomes = atomes.keySet();

        if (!textFieldMolecule.getText().isEmpty()) {
            String test = textFieldMolecule.getText() + " ";
            char[] arrayChar = test.toCharArray();

            for (int i = 0; i < arrayChar.length; i++) {
                char temp = arrayChar[i];
                if (temp != ' ') {
                    trouve = false;
                    if (!Character.isDigit(arrayChar[i + 1])) {
                        if (!Character.isLowerCase(arrayChar[i + 1])) {
                            Iterator<String> iterAtomes = symbAtomes.iterator();

                            while (iterAtomes.hasNext() && !trouve) {
                                String symbAtomeActuel = iterAtomes.next();
                                if (Character.toString(temp).equals(symbAtomeActuel)) {
                                    masseMolaire += atomes.get(symbAtomeActuel).getMasse();
                                    trouve = true;
                                }
                            }
                            if (trouve == false) {
                                alertPerso();
                                i = arrayChar.length;
                                masseMolaire = 0.0;
                            }


                        } else {
                            String tempo = Character.toString(arrayChar[i]) + arrayChar[i + 1];
                            Iterator<String> iterAtomes = symbAtomes.iterator();

                            while(iterAtomes.hasNext() && !trouve) {
                                String symbAtomeActuel = iterAtomes.next();

                                if (tempo.equals(symbAtomeActuel)) {
                                    trouve = true;
                                    if (Character.isDigit(arrayChar[i + 2])) {
                                        if(!Character.isDigit(arrayChar[i + 3])) {
                                            masseMolaire += atomes.get(symbAtomeActuel).getMasse() * Double.parseDouble(Character.toString(arrayChar[i + 2]));
                                            i += 2;
                                        }
                                        else
                                        {
                                            String temporaire = Character.toString(arrayChar[i + 2]) + arrayChar[i + 3];
                                            masseMolaire += atomes.get(symbAtomeActuel).getMasse() * Double.parseDouble(temporaire);
                                            i += 3;
                                        }
                                    }
                                    else {
                                        masseMolaire += atomes.get(symbAtomeActuel).getMasse();
                                        i++;
                                    }
                                }
                            }
                            if (trouve == false) {
                                alertPerso();
                                i = arrayChar.length;
                                masseMolaire = 0.0;
                            }

                        }
                    } else {
                        Iterator<String> iterAtomes = symbAtomes.iterator();

                        while(iterAtomes.hasNext() && !trouve) {
                            String symbAtomeActuel = iterAtomes.next();

                            if (Character.toString(temp).equals(symbAtomeActuel)) {
                                trouve = true;

                                if (!Character.isDigit(arrayChar[i + 2])) {
                                    masseMolaire += atomes.get(symbAtomeActuel).getMasse() * Double.parseDouble(Character.toString(arrayChar[i + 1]));
                                    i++;
                                } else {
                                    String temporaire = Character.toString(arrayChar[i + 1]) + arrayChar[i + 2];
                                    masseMolaire += atomes.get(symbAtomeActuel).getMasse() * Double.parseDouble(temporaire);
                                    i += 2;
                                }
                            }
                        }
                        if (trouve == false) {
                            alertPerso();
                            i = arrayChar.length;
                            masseMolaire = 0.0;
                        }
                    }
                } else {
                    break;
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erreur!");
            alert.setContentText("La zone de texte est vide!");
            alert.showAndWait();

        }
        masseMolecule.setText(Double.toString(masseMolaire));

    }

    private void alertPerso() {
        Alert alerte = new Alert(Alert.AlertType.ERROR);
        alerte.setContentText("Le ou les atomes saisi(s) n'existent pas!");
        alerte.setHeaderText("Erreur!");
        alerte.showAndWait();
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

    public void setAtomes(HashMap<String, Atome> atomes) {
        this.atomes = atomes;
    }
}
