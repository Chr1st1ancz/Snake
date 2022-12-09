package com.example.demo1.graphicInterface;

import com.example.demo1.game.Board;
import com.example.demo1.game.Snake;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class SnakeGame extends Scene {

    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 500;
    public static final int BOARD_DIFFERENCE_WIDTH = 10;
    public static final int BOARD_DIFFERENCE_HEIGHT = BOARD_HEIGHT / 2;

    private final SceneManager sceneManager;
    private final Board board;
    private final Snake snake;

    public SnakeGame(SceneManager sceneManager) {
        super(sceneManager.getParentScene());
        this.sceneManager = sceneManager;
        this.board = new Board(sceneManager);
        this.snake = new Snake(sceneManager);
    }

    public void startGame() {
        board.init();
        Rectangle rectangle = new Rectangle();
        rectangle.setX(0);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Paint.valueOf("red"));
        sceneManager.addBefore(board.getTextBoard(), rectangle);


       // super.setOnKeyPressed();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    rectangle.setX(rectangle.getX() + 1);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
