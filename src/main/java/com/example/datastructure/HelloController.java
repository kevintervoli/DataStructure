package com.example.datastructure;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;


public class HelloController {
    @FXML
    public BorderPane bp;
    public int i = 0;
    ArrayDeque<Sphere> sphereQueue = new ArrayDeque<>();
    ArrayDeque<Label> labelQueue = new ArrayDeque<>();
    HBox pane = new HBox();
    Sphere[] spheres = new Sphere[13];
    Label[] manyLabels = new Label[13];

    @FXML
    public void AddFirstButtonClicked(ActionEvent event) throws IOException {
        Material mat = new PhongMaterial();
        FileInputStream imgStream = null;
        imgStream = new FileInputStream("Images/color.jpg");
        Image img = new Image(imgStream);
        ((PhongMaterial) mat).setDiffuseMap(img);
        ((PhongMaterial) mat).setSpecularColor(Color.AQUAMARINE);
        Sphere circle = new Sphere();
        Label label = new Label();
        label.setFont(new Font("Forte", 18));
        circle.setRadius(70);
        label.setText(((int) (Math.random() * 13) + ""));
        circle.setMaterial(mat);
        circle.setCullFace(CullFace.BACK);
        circle.setDrawMode(DrawMode.FILL);
        ;
        sphereQueue.addFirst(circle);
        labelQueue.addFirst(label);
        int i = 0;
        int j = 0;
        while (i < sphereQueue.size()) {
            StackPane temp = new StackPane();
            temp.getChildren().addAll(sphereQueue.getFirst(), labelQueue.getFirst());
            i++;
            j++;
            pane.getChildren().add(temp);
        }
        bp.setCenter(pane);
    }

    public boolean isEmpty() {
        return spheres.length == 0;
    }

    @FXML
    public void AddLastButtonClicked() throws FileNotFoundException {
        Material mat = new PhongMaterial();
        FileInputStream imgStream = null;
        imgStream = new FileInputStream("Images/color.jpg");
        Image img = new Image(imgStream);
        ((PhongMaterial) mat).setDiffuseMap(img);
        ((PhongMaterial) mat).setSpecularColor(Color.AQUAMARINE);
        Sphere circle = new Sphere();
        Label label = new Label();
        label.setFont(new Font("Forte", 18));
        label.setText(((int) (Math.random() * 13) + ""));
        circle.setRadius(70);
        circle.setMaterial(mat);
        circle.setCullFace(CullFace.BACK);
        circle.setDrawMode(DrawMode.FILL);
        ;
        sphereQueue.addLast(circle);
        labelQueue.addLast(label);
        int i = 0;
        while (i < sphereQueue.size()) {
            StackPane temp = new StackPane();
            temp.getChildren().addAll(sphereQueue.getLast(), labelQueue.getLast());
            i++;
            pane.getChildren().add(temp);
        }
        bp.setCenter(pane);

    }

    @FXML
    public void removeFirst(ActionEvent event) {
        if (sphereQueue.isEmpty()) {
            return;
        } else if (sphereQueue.size() == 1) {
            pane.getChildren().remove(0);
            sphereQueue.removeFirst();
            labelQueue.removeFirst();
        } else {
            pane.getChildren().remove(0);
            sphereQueue.removeFirst();
            labelQueue.removeFirst();
        }
    }

    @FXML
    public void removeLast(ActionEvent event) {
        if (isEmpty()) {
            return;
        } else if (sphereQueue.size() == 1) {
            pane.getChildren().remove(pane.getChildren().size() - 1);
            sphereQueue.removeLast();
            labelQueue.removeLast();
        } else {
            pane.getChildren().remove(pane.getChildren().size() - 1);
            sphereQueue.removeLast();
            labelQueue.removeLast();
        }
    }
}