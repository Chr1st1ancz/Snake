package com.example.demo1.game;

import com.example.demo1.graphicInterface.SceneManager;
import com.example.demo1.graphicInterface.SnakeGame;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Board {
    private SceneManager sceneManager;

    public Board(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        initBoard();
        innerInitBoard();
    }

    private void initBoard() {
        Rectangle board = new Rectangle();
        board.setHeight(SnakeGame.BOARD_HEIGHT/2);
        board.setWidth(SnakeGame.BOARD_WIDTH);
        board.setX(0);
        board.setY(SnakeGame.BOARD_DIFFERENCE_HEIGHT*2);
        board.setFill(Paint.valueOf("white"));

        sceneManager.addBefore(board);
    }

    private void innerInitBoard(){
        Rectangle board2 = new Rectangle();
        board2.setHeight(SnakeGame.BOARD_HEIGHT);
        board2.setWidth(SnakeGame.BOARD_WIDTH);
        board2.setX(0);
        board2.setY(0);

        sceneManager.showOnlySceneCollection(board2);


    }
}
