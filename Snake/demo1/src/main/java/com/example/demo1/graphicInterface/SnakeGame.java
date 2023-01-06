package com.example.demo1.graphicInterface;

import com.example.demo1.game.Board;
import com.example.demo1.game.Direction;
import com.example.demo1.game.Snake;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeGame extends Scene {
    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 500;
    public static final int BOARD_DIFFERENCE_WIDTH = 10;
    public static final int BOARD_DIFFERENCE_HEIGHT = BOARD_HEIGHT / 2;
    public static final int GAME_SPEED = 1_500;

    private final SceneManager sceneManager;
    private final Board board;
    private final Snake snake;
    private boolean running = true;






    public SnakeGame(SceneManager sceneManager) {
        super(sceneManager.getParentScene());
        this.sceneManager = sceneManager;
        this.board = new Board(sceneManager);
        this.snake = new Snake(board, sceneManager);
    }

    public void startGame() {
        board.init();
        snake.initSnake();
        setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.DOWN) {
                    snake.setDirection(Direction.BOTTOM);
                }
                if (keyEvent.getCode() == KeyCode.UP) {
                    snake.setDirection(Direction.TOP);
                }
                if (keyEvent.getCode() == KeyCode.LEFT) {
                    snake.setDirection(Direction.LEFT);
                }
                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    snake.setDirection(Direction.RIGHT);
                }
            }
        });

        new Thread(this::moveBegin).start();
    }

    private void moveBegin() {
        while (true) {
            try {
                this.snake.checkCollision();
                this.snake.onNextMove();
                Thread.sleep(200);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
