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
    private Board board;
    private List<Rectangle> snakeBody = new LinkedList<>();



    public Snake(Board board, SceneManager sceneManager) {
        this.board = board;
        this.scenemanager = sceneManager;
    }

    public void initSnake(){
        snakeBody();
    }

    private void snakeBody(){
        for (int i = 0; i<2; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(100 + i * 50);
            rectangle.setY(100);
            rectangle.setWidth(50);
            rectangle.setHeight(50);
            rectangle.setFill(Paint.valueOf("green"));
            snakeBody.add(rectangle);
            this.scenemanager.addBefore(board.getTextBoard(), rectangle);
        }


    }

    }

