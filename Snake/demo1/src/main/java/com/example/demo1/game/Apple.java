package com.example.demo1.game;

import com.example.demo1.graphicInterface.SceneManager;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Apple {
    private SceneManager scenemanager;
    private Board board;
    private Circle circle;

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
        circle.setRadius(15);
        this.scenemanager.addBefore(board.getTextBoard(), circle);

    }

    public SceneManager getScenemanager() {
        return scenemanager;
    }

    public void setScenemanager(SceneManager scenemanager) {
        this.scenemanager = scenemanager;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public synchronized Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
   private int randomWithRange(int min, int max){

        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public void takeApple() {
        int calculate = randomWithRange((int) (board.getPlayingBoard().getX() + 50), (int) (board.getPlayingBoard().getWidth() -50));
        circle.setCenterX(calculate);
        circle.setCenterY(calculate);
        circle.setFill(Paint.valueOf("red"));
        circle.setRadius(15);
    }
}
