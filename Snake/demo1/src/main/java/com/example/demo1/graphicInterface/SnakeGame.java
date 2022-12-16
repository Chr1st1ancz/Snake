package com.example.demo1.graphicInterface;

import com.example.demo1.game.Board;
import com.example.demo1.game.Snake;
import javafx.application.Platform;
import javafx.scene.Scene;
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
    private boolean left = false;
    private boolean right = true;
    private boolean up= false;
    private boolean down = false;
    private boolean running = true;


    private KeyListener keyListener = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
           if(key == KeyEvent.VK_LEFT){
               left = true;
               right = false;
               up = false;
               down = false;
           }
            if(key == KeyEvent.VK_RIGHT){
                left = false;
                right = true;
                up = false;
                down = false;

            }
            if(key == KeyEvent.VK_UP){
                left = false;
                right = false;
                up = true;
                down = false;

            }
            if(key == KeyEvent.VK_DOWN){
                left = false;
                right = false;
                up = false;
                down = true;

            }


        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };



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


        if (left) {

        }

        if (right) {

        }

        if (up) {

        }

        if (down) {

        }



    }
}
