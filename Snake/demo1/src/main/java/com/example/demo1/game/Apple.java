package com.example.demo1.game;

import com.example.demo1.graphicInterface.SceneManager;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Apple {
    private SceneManager scenemanager;
    private Board board;
    public Circle circle;

    public Apple(SceneManager scenemanager, Board board) {
        this.scenemanager = scenemanager;
        this.board = board;
    }

    public void initApple() {
        circle = new Circle();
        int v = 25* (int) (Math.random() * (board.getPlayingBoard().getHeight()/25));
        int b = 25* (int) (Math.random() * (board.getPlayingBoard().getWidth()/25));
        circle.setCenterX(v);
        circle.setCenterY(b);
        circle.setFill(Paint.valueOf("red"));
        circle.setRadius(20);
        this.scenemanager.addBefore(board.getTextBoard(), circle);

    }


}
