package controleurs;

import csv.Atome;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import main.EZ_Table_App;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class OrbitalesControleur {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private GridPane grilleAtomesBase;

    @FXML
    private Button b7s;

    @FXML
    private Button b6s;

    @FXML
    private Button b5s;

    @FXML
    private Button b4s;

    @FXML
    private Button b3s;

    @FXML
    private Button b2s;

    @FXML
    private Button b1s;

    @FXML
    private Button b2px;

    @FXML
    private Button b2py;

    @FXML
    private Button b2pz;

    @FXML
    private Button b3px;

    @FXML
    private Button b3py;

    @FXML
    private Button b3pz;

    @FXML
    private Button b4px;

    @FXML
    private Button b4py;

    @FXML
    private Button b4pz;

    @FXML
    private Button b5px;

    @FXML
    private Button b5py;

    @FXML
    private Button b5pz;

    @FXML
    private Button b6px;

    @FXML
    private Button b6py;

    @FXML
    private Button b6pz;

    @FXML
    private Button b7px;

    @FXML
    private Button b7py;

    @FXML
    private Button b7pz;

    @FXML
    private Button b3d1;

    @FXML
    private Button b3d2;

    @FXML
    private Button b3d3;

    @FXML
    private Button b4d1;

    @FXML
    private Button b4d2;

    @FXML
    private Button b4d3;

    @FXML
    private Button b5d1;

    @FXML
    private Button b5d2;

    @FXML
    private Button b5d3;

    @FXML
    private Button b6d1;

    @FXML
    private Button b6d2;

    @FXML
    private Button b6d3;

    @FXML
    private Button b6d4;

    @FXML
    private Button b5d4;

    @FXML
    private Button b6d5;

    @FXML
    private Button b4d4;

    @FXML
    private Button b5d5;

    @FXML
    private Button b3d4;

    @FXML
    private Button b4d5;

    @FXML
    private Button b3d5;

    @FXML
    private Button b4f1;

    @FXML
    private Button b5f1;

    @FXML
    private Button b5f2;

    @FXML
    private Button b4f2;

    @FXML
    private Button b5f3;

    @FXML
    private Button b4f3;

    @FXML
    private Button b5f4;

    @FXML
    private Button b4f4;

    @FXML
    private Button b5f5;

    @FXML
    private Button b4f5;

    @FXML
    private Button b5f6;

    @FXML
    private Button b4f6;

    @FXML
    private Button b5f7;

    @FXML
    private Button b4f7;

    @FXML
    private Label labelElectrons;



    TableauControleur tableauControleur;

    SubScene subScene;

    private Group model = new Group();

    PerspectiveCamera camera = new PerspectiveCamera(true);

    Translate pivot = new Translate();
    Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
    Rotate xRotate = new Rotate(0, Rotate.X_AXIS);

    private double ancreX, ancreY;
    private double angleAncreX = 0;
    private double angleAncreY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);


    @FXML
    void initialize() {

        grilleAtomesBase.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            model.getChildren().clear();
            if (me.getTarget() instanceof Button) {
                Button boutonClique = (Button) me.getTarget();
                String idBouton = boutonClique.getId().replace("b", "");
                lireFichiers("objets3D/" + idBouton + ".obj");
            }
        });

        //Création et position de la sous-scène
        subScene = new SubScene(model, 312, 305, true, SceneAntialiasing.DISABLED);
        subScene.setFill(Color.GRAY);
        anchorPane.getChildren().add(subScene);
        AnchorPane.setTopAnchor(subScene, 132.0);

        //Lumière
        PointLight lumiereBasse = new PointLight();
        lumiereBasse.getTransforms().add(new Translate(0, -1000, 0));
        PointLight lumiereHaute = new PointLight();
        lumiereHaute.getTransforms().add(new Translate(0, 1000, 0));
        model.getChildren().addAll(lumiereBasse, lumiereHaute);

        //Importation des objets 3D

        camera.getTransforms().addAll (
                pivot,
                yRotate,
                xRotate,
                new Translate(0, 0, -25)
        );
        initMouseControl(model, subScene);
        subScene.setCamera(camera);
    }

    private void initMouseControl(Group group, SubScene subScene) {
        Rotate xRotate;
        Rotate yRotate;
        group.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS)
        );
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        subScene.setOnMousePressed(event -> {
            ancreX = event.getSceneX();
            ancreY = event.getSceneY();
            angleAncreX = angleX.get();
            angleAncreY = angleY.get();
        });

        subScene.setOnMouseDragged(event -> {
            angleX.set(angleAncreX - (ancreY - event.getSceneY()));
            angleY.set(angleAncreY + ancreX - event.getSceneX());
        });

        subScene.setOnScroll(event -> {
            if (event.getDeltaY() > 0) {
                model.setScaleX(model.getScaleX()*1.25);
                model.setScaleY(model.getScaleY()*1.25);
                model.setScaleZ(model.getScaleZ()*1.25);
            }
            else {
                model.setScaleX(model.getScaleX()*0.80);
                model.setScaleY(model.getScaleY()*0.80);
                model.setScaleZ(model.getScaleZ()*0.80);
            }
        });
    }

    private void genererOrbitales(Atome atome)
    {
        atome = (Atome) tableauControleur.getBoutonSelectionne().getUserData();
    }

    private void lireFichiers(String... urls) {
        ObjModelImporter objModelImporter = new ObjModelImporter();

        for (String urlActuel : urls) {
            objModelImporter.read(EZ_Table_App.class.getResource(urlActuel));
            for (MeshView mv : objModelImporter.getImport()) {
                model.getChildren().add(mv);
            }
            objModelImporter.clear();
        }
    }

    public void setTableauControleur(TableauControleur tableauControleur) {
        this.tableauControleur = tableauControleur;
    }

    private void setCouleur(Atome atome) {
        Button[] listeButton = {b1s, b2s, b2px, b2py, b2pz, b3s, b3px, b3py, b3pz, b4s, b3d1,b3d2,b3d3,b3d4,b3d5,
                b4px, b4py, b4pz, b5s, b4d1,b4d2,b4d3,b4d5, b6s, b4f1, b4f2, b4f3, b4f5, b4f6, b4f7, b5d1, b5d2, b5d3, b5d4, b5d5, b6px, b6py, b6pz, b7s,
                b5f1, b5f2, b5f3, b5f4, b5f5, b5f6, b5f7, b6d1, b6d2, b6d3, b6d4, b6d5, b7px, b7py, b7pz};

        String derniere = atome.getConfigElectroniqueText().substring((atome.getConfigElectroniqueText().length() -3));
        String lettre = derniere.substring(1,2);
        System.out.println(lettre);
        int valeur =  Integer.parseInt(derniere.substring(2,3));
        System.out.println(valeur);
        int nbRegion = atome.getTabConfigElectronique().size();






        for(int i =0 ; i < nbRegion; i++)
        {
            listeButton[i].setStyle("-fx-background-color: lightgreen");
        }






    }

    public void initialiserAtome() {
        Atome atome = (Atome) tableauControleur.getBoutonSelectionne().getUserData();
        setCouleur(atome);

        ArrayList<String> config = atome.getTabConfigElectronique();
        String[] orbitales = new String[config.size()];

        for (int i = 0; i < config.size(); i++) {
            orbitales[i] = "objets3D/" + config.get(i) + ".obj";
        }

        lireFichiers(orbitales);
    }
}
