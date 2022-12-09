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
    public static final int GAME_SPEED = 1_500;

    private final SceneManager sceneManager;
    private final Board board;
    private final Snake snake;

    public SnakeGame(SceneManager sceneManager) {
        super(sceneManager.getParentScene());
        this.sceneManager = sceneManager;
        this.board = new Board(sceneManager);
        this.snake = new Snake(board, sceneManager);
    }

    public void startGame() {
        board.init();
        snake.initSnake();
        new Thread(this::moveBegin).start();
    }

    private void moveBegin() {
        
    }
}
