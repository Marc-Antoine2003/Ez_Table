package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class menuAideControleur {

    @FXML
    private Label description;

    @FXML
    void afficherDescriptionActinide(ActionEvent event)
    {
        description.setText("Les actinides sont des éléments radioactifs. En effet, ils libèrent tous de l'énergie par désintégration radioactive. L'uranium, le thorium et le plutonium sont les actinides les plus abondants sur Terre, les deux premiers étant des éléments primordiaux tandis que le troisième est synthétisé par l'industrie nucléaire ; ces trois éléments sont utilisés dans les réacteurs nucléaires ainsi que dans la production d'armes nucléaires.");
    }

    @FXML
    void afficherDescriptionFusion(ActionEvent event) {
        description.setText("Le point de fusion est une propriété caractéristique d'une substance cristalline solide. Il s'agit de la température de passage de l'état solide à l'état liquide. Ce phénomène se produit lorsque la substance est chauffée.");
    }

    @FXML
    void afficherDescriptionLanthanide(ActionEvent event) {
        description.setText("Ce sont des métaux brillants avec un éclat argenté qui ternit rapidement lorsqu'ils sont exposés à l'air libre. Ils sont de moins en moins mous au fur et à mesure que leur numéro atomique augmente. Leur température de fusion et leur température d'ébullition sont plus élevées que la plupart des métaux, hormis les métaux de transition. Ils réagissent violemment avec la plupart des non-métaux et brûlent dans l'air. Cette propriété est exploitée dans les pierres à briquet, qui sont constituées d'un alliage de lanthanides, le mischmétal.");
    }

    @FXML
    void afficherDescriptionMasse(ActionEvent event) {
        description.setText("Aussi appelé masse molaire, la masse atomique d'une substance est la masse d'une mole de cette substance. La mole étant l'unité de mesure pour la quantité de matière d'une substance");
    }

    @FXML
    void afficherDescriptionMetalloide(ActionEvent event) {
        description.setText("Un métalloïde est un élément chimique dont les propriétés sont intermédiaires entre celles des métaux et des non-métaux ou sont une combinaison de ces propriétés.");
    }

    @FXML
    void afficherDescriptionRayon(ActionEvent event) {
        description.setText("Le rayon atomique d'un élément chimique est une mesure de la taille de ses atomes, d'habitude la distance moyenne entre le noyau et la frontière du nuage électronique qui l'entoure. Comme cette frontière n'est pas une entité physique bien définie, il y a plusieurs définitions non équivalentes du rayon atomique.");
    }

    @FXML
    void afficherDescriptionVapo(ActionEvent event) {
        description.setText("Aussi appelé point d'ébullition, le point de vaporisation est la température, à une pression donnée où un élément passe de l'état liquide à gazeux.");
    }



}
