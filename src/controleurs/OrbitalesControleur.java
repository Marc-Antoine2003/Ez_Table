package controleurs;

import csv.Atome;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import main.EZ_Table_App;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;


public class OrbitalesControleur {

    @FXML
    AnchorPane anchorPane;

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
    private Button b2p1;

    @FXML
    private Button b2p2;

    @FXML
    private Button b2p3;

    @FXML
    private Button b3p1;

    @FXML
    private Button b3p2;

    @FXML
    private Button b3p3;

    @FXML
    private Button b4p1;

    @FXML
    private Button b4p2;

    @FXML
    private Button b4p3;

    @FXML
    private Button b5p1;

    @FXML
    private Button b5p2;

    @FXML
    private Button b5p3;

    @FXML
    private Button b6p1;

    @FXML
    private Button b6p2;

    @FXML
    private Button b6p3;

    @FXML
    private Button b7p1;

    @FXML
    private Button b7p2;

    @FXML
    private Button b7p3;

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
        //Craétion et position de la sous-scène
        subScene = new SubScene(model, 312, 305, true, SceneAntialiasing.DISABLED);
        subScene.setFill(Color.GRAY);
        anchorPane.getChildren().add(subScene);
        AnchorPane.setTopAnchor(subScene, 132.0);

        //Lumière
        PointLight lumiereBasse = new PointLight();
        lumiereBasse.getTransforms().add(new Translate(0, -50, 0));
        PointLight lumiereHaute = new PointLight();
        lumiereHaute.getTransforms().add(new Translate(0, 50, 0));
        PointLight lumiereAngle = new PointLight();
        lumiereAngle.getTransforms().add(new Translate(100, -100, 0));
        model.getChildren().addAll(lumiereBasse, lumiereHaute);

        //Importation des objets 3D
        ObjModelImporter objModelImporter1 = new ObjModelImporter();
        ObjModelImporter objModelImporter2 = new ObjModelImporter();
        objModelImporter1.read(EZ_Table_App.class.getResource("objets3D/orbitales/S/1s.obj"));
        objModelImporter2.read(EZ_Table_App.class.getResource("objets3D/orbitales/S/2s.obj"));

        camera.getTransforms().addAll (
                pivot,
                yRotate,
                xRotate,
                new Translate(0, 0, -25)
        );

        for (MeshView mv : objModelImporter1.getImport()) {
            model.getChildren().add(mv);
        }

        for (MeshView mv : objModelImporter2.getImport()) {
            model.getChildren().add(mv);
        }

        model.autosize();

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

    public void setTableauControleur(TableauControleur tableauControleur) {
        this.tableauControleur = tableauControleur;
    }
}
