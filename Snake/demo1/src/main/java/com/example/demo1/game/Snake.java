package com.example.demo1.game;


import com.example.demo1.graphicInterface.SceneManager;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.util.LinkedList;
import java.util.List;


public class Snake {

    private final SceneManager scenemanager;
    private Board board;
    private Apple apple;
    private Direction direction;
    private int count = 3;
    private List<Rectangle> snakeBody = new LinkedList<>();


    public Snake(Board board, Apple apple, SceneManager sceneManager) {
        this.board = board;
        this.apple = apple;
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
            rectangle.setX(125 + i * -25);
            rectangle.setY(100);
            rectangle.setWidth(25);
            rectangle.setHeight(25);
            rectangle.setFill(Paint.valueOf("grey"));
            snakeBody.add(rectangle);
            this.scenemanager.addBefore(board.getTextBoard(), rectangle);
        }

    }

    public void onNextMove() {
        System.out.println(this.direction);
        if(snakeBody.isEmpty())
            return;
        if(this.direction == Direction.RIGHT) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX() + 25);
            tail.setY(head.getY());
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }
        if(this.direction == Direction.LEFT) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX() - 25);
            tail.setY(head.getY());
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }
        if(this.direction == Direction.TOP) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX());
            tail.setY(head.getY() - 25);
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }
        if(this.direction == Direction.BOTTOM) {
            Rectangle tail = snakeBody.get(snakeBody.size() - 1);
            Rectangle head = snakeBody.get(0);
            tail.setX(head.getX());
            tail.setY(head.getY() + 25);
            snakeBody.remove(tail);
            snakeBody.add(0, tail);
        }


    }

    public void checkCollision(){
        if(snakeBody.isEmpty())
            return;
        Rectangle head = snakeBody.get(0);
        Rectangle tail2 = snakeBody.get(snakeBody.size() -1);
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

        int circle_Y = (int) apple.getCircle().getCenterY();
        int circle_X = (int) apple.getCircle().getCenterX();
        int circle_radius = (int) apple.getCircle().getRadius();
        if(head.intersects(circle_X,circle_Y,circle_radius, circle_radius)){
            apple.takeApple();
            Rectangle rectangle = new Rectangle();
            rectangle.setX(tail2.getX() + count * -25);
            count++;
            rectangle.setY(tail2.getY() + count * 25);
            rectangle.setWidth(25);
            rectangle.setHeight(25);
            rectangle.setFill(Paint.valueOf("grey"));
            Platform.runLater(()-> {
                        snakeBody.add(rectangle);
                        this.scenemanager.addBefore(board.getTextBoard(), rectangle);

            });
            System.out.println("hhh");
   }
}
}

