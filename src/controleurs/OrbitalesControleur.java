package controleurs;

import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.EZ_Table_App;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class OrbitalesControleur {

    private Group model = new Group();

    PerspectiveCamera camera = new PerspectiveCamera(true);

    Translate pivot = new Translate();
    Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
    Rotate xRotate = new Rotate(0, Rotate.X_AXIS);

    public void faireTest(Stage fenetre) {
        ObjModelImporter objModelImporter1 = new ObjModelImporter();
        ObjModelImporter objModelImporter2 = new ObjModelImporter();
        objModelImporter1.read(EZ_Table_App.class.getResource("objets3D/s1/s1.obj"));
        objModelImporter2.read(EZ_Table_App.class.getResource("objets3D/p2y/p2y.obj"));


        camera.getTransforms().addAll (
                pivot,
                yRotate,
                xRotate,
                new Translate(0, 0, -50)
        );

        for (MeshView mv : objModelImporter1.getImport()) {
            model.getChildren().add(mv);
        }

        for (MeshView mv : objModelImporter2.getImport()) {
            model.getChildren().add(mv);
        }

        fenetre.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case Q:
                    yRotate.angleProperty().setValue(yRotate.getAngle() - 10);
                    break;
                case E:
                    yRotate.angleProperty().setValue(yRotate.getAngle() + 10);
                    break;
                case D:
                    xRotate.angleProperty().setValue(xRotate.getAngle() + 10);
                    break;
                case A:
                    xRotate.angleProperty().setValue(xRotate.getAngle() - 10);
                    break;
            }
        });

        fenetre.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.W) {
                model.setScaleX(model.getScaleX() + 0.5);
                model.setScaleY(model.getScaleY() + 0.5);
                model.setScaleZ(model.getScaleZ() + 0.5);
            }

            else if (event.getCode() == KeyCode.S) {
                model.setScaleX(model.getScaleX() - 0.5);
                model.setScaleY(model.getScaleY() - 0.5);
                model.setScaleZ(model.getScaleZ() - 0.5);
            }
        });

        Scene scene = new Scene(model, 1280, 720, true);
        scene.setCamera(camera);
        fenetre.setScene(scene);
        fenetre.show();
    }
}
