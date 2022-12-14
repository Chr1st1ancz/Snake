package com.example.demo1.graphicInterface;

import javafx.scene.Group;
import javafx.scene.Node;

import java.util.List;

public interface SceneManager {

    void add(Node node);

    void showOnlySceneCollection(List<Node> nodeList);

    void showOnlySceneCollection(Node... nodeArray);

    void replace(Node oldNode, Node newNode);

    Group getParentScene();

    void addBefore(Node beforeNode, Node... nodeArray);

    void remove(Node node);

    void update();
}