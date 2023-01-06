package com.example.demo1.game;


import com.example.demo1.graphicInterface.SceneManager;
import com.example.demo1.graphicInterface.SnakeGame;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Snake {

    private final SceneManager scenemanager;
    private Board board;
    private Direction direction;
    private List<Rectangle> snakeBody = new LinkedList<>();


    public Snake(Board board, SceneManager sceneManager) {
        this.board = board;
        this.direction = Direction.RIGHT;
        this.scenemanager = sceneManager;
    }

    public void initSnake(){
        snakeBody();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void snakeBody(){
        for (int i = 0; i<4; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(150 + i * -50);
            rectangle.setY(100);
            rectangle.setWidth(50);
            rectangle.setHeight(50);
            rectangle.setFill(Paint.valueOf("grey"));
            snakeBody.add(rectangle);
            this.scenemanager.addBefore(board.getTextBoard(), rectangle);
        }

    }

    public void onNextMove() {
        System.out.println(this.direction);
        if(this.direction == Direction.RIGHT) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX() + 50);
            tail.setY(head.getY());
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }
        if(this.direction == Direction.LEFT) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX() - 50);
            tail.setY(head.getY());
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }
        if(this.direction == Direction.TOP) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX());
            tail.setY(head.getY() - 50);
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }
        if(this.direction == Direction.BOTTOM) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX());
            tail.setY(head.getY() + 50);
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }


    }

    public void checkCollision(){
        Rectangle head = snakeBody.get(0);
        Rectangle2D head2d = new Rectangle2D(head.getX(), head.getY(), head.getWidth(), head.getHeight());
        if(head.getX() <= board.getPlayingBoard().getX() || head.getY() <= board.getPlayingBoard().getY()){
            System.exit(0);
        }

        if(head.getX() >= board.getPlayingBoard().getWidth() || head.getY() == board.getPlayingBoard().getHeight()){
            System.exit(0);
        }

        for (int i = 1; i < snakeBody.size(); i++){
            Rectangle2D tail = new Rectangle2D(snakeBody.get(i).getX(), snakeBody.get(i).getY(), snakeBody.get(i).getWidth(), snakeBody.get(i).getHeight());
            if(head2d.intersects(tail)) {
                System.exit(0);
            }

        }


    }
}

