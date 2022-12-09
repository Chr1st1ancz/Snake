package com.example.demo1.game;

import com.example.demo1.graphicInterface.SceneManager;
import com.example.demo1.graphicInterface.SnakeGame;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Board {
    private SceneManager sceneManager;
    private Rectangle playingBoard;
    private Rectangle textBoard;
    private Snake snake;

    public Board(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void init() {
        initBoard();
        innerInitBoard();
        this.sceneManager.showOnlySceneCollection(textBoard);
        this.sceneManager.addBefore(textBoard, playingBoard );
    }

    private void initBoard() {
        textBoard = new Rectangle();
        textBoard.setHeight(SnakeGame.BOARD_HEIGHT/2);
        textBoard.setWidth(SnakeGame.BOARD_WIDTH);
        textBoard.setX(0);
        textBoard.setY(SnakeGame.BOARD_HEIGHT);
        textBoard.setFill(Paint.valueOf("red"));
    }

    private void innerInitBoard(){
        playingBoard = new Rectangle();
        playingBoard.setHeight(SnakeGame.BOARD_HEIGHT);
        playingBoard.setWidth(SnakeGame.BOARD_WIDTH);
        playingBoard.setFill(Paint.valueOf("blue"));
        playingBoard.setX(0);
        playingBoard.setY(0);
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public Rectangle getPlayingBoard() {
        return playingBoard;
    }

    public void setPlayingBoard(Rectangle playingBoard) {
        this.playingBoard = playingBoard;
    }

    public Rectangle getTextBoard() {
        return textBoard;
    }

    public void setTextBoard(Rectangle textBoard) {
        this.textBoard = textBoard;
    }
}
