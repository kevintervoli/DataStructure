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
    // declare border pane to update from fxml file
    public BorderPane bp;
    public int i = 0;
    // declare two array deque to store the data
    ArrayDeque<Sphere> sphereQueue = new ArrayDeque<>();
    ArrayDeque<Label> labelQueue = new ArrayDeque<>();
    // declare a hbox to insert the sphere and label
    HBox pane = new HBox();
    @FXML
    public void AddFirstButtonClicked(ActionEvent event) throws IOException {
        // create a material from the image file
        Material mat = new PhongMaterial();
        FileInputStream imgStream = null;
        imgStream = new FileInputStream("Images/color.jpg");
        Image img = new Image(imgStream);
        ((PhongMaterial) mat).setDiffuseMap(img);
        // set the material to the sphere
        ((PhongMaterial) mat).setSpecularColor(Color.AQUAMARINE);
        // create a sphere
        Sphere circle = new Sphere();
        circle.setRadius(70);
        // create a label
        Label label = new Label();
        label.setFont(new Font("Forte", 18));
        label.setText(((int) (Math.random() * 13) + ""));
        // set the material to the sphere
        circle.setMaterial(mat);
        circle.setCullFace(CullFace.BACK);
        circle.setDrawMode(DrawMode.FILL);
        // add them to queue
        sphereQueue.addFirst(circle);
        labelQueue.addFirst(label);
        int i = 0;
        int j = 0;
        // add them to the pane which will updated after every new addition
        while (i < sphereQueue.size()) {
            StackPane temp = new StackPane();
            temp.getChildren().addAll(sphereQueue.getFirst(), labelQueue.getFirst());
            i++;
            j++;
            // add nodes before the first node in the pane
            pane.getChildren().add(0, temp);
        }
        // update border pane in order not to show a new pop up window
        bp.setCenter(pane);
    }

    public boolean isEmpty() {
        return (sphereQueue.size() == 0 && labelQueue.size() == 0);
    }

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

    public void removeFirst() {
        // remove the first node from the pane
        if (sphereQueue.isEmpty()) {
            return;
        } else if (sphereQueue.size() == 1) {
            // if the size of the queue is 1, remove the first node from the pane
            pane.getChildren().remove(0);
            sphereQueue.removeFirst();
            labelQueue.removeFirst();
        } else {
            // if the size of the queue is more than 1, remove the first node from the pane
            pane.getChildren().remove(0);
            sphereQueue.removeFirst();
            labelQueue.removeFirst();
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        } else if (sphereQueue.size() == 1) {
            // if the size of the queue is 1, remove th last  node from the pane
            pane.getChildren().remove(pane.getChildren().size() - 1);
            sphereQueue.removeLast();
            labelQueue.removeLast();
        } else {
            pane.getChildren().remove(pane.getChildren().size() - 1);
            sphereQueue.removeLast();
            labelQueue.removeLast();
        }
    }
    public void clearQueue() {
        // it clears all the elements from the queue and the pane
        sphereQueue.clear();
        labelQueue.clear();
        // update pane
        pane.getChildren().clear();

    }

}