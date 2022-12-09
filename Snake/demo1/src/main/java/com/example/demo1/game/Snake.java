package com.example.demo1.game;


import com.example.demo1.graphicInterface.SceneManager;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Snake {

    private final SceneManager scenemanager;
    private SceneManager sceneManager;
    private Board board;
    private List<Rectangle> snakeBody = new LinkedList<>();


    public Snake(SceneManager sceneManager) {
        this.scenemanager = sceneManager;
        this.board = new Board(sceneManager);
    }

    public void initSnake(){
        snakeBody();

        this.sceneManager.addBefore(board.getPlayingBoard(), snakeBody.get(0));

    }

    private void snakeBody(){
        for (int i = 0; i<4; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(100);
            rectangle.setY(100);
            rectangle.setWidth(50);
            rectangle.setHeight(50);
            rectangle.setFill(Paint.valueOf("green"));
            snakeBody.add(rectangle);
        }


    }

}
