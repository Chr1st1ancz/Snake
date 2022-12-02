package com.example.demo1.graphicInterface;

import com.example.demo1.game.Board;
import javafx.scene.Scene;

public class SnakeGame extends Scene {

    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 500;
    public static final int BOARD_DIFFERENCE_WIDTH = 10;
    public static final int BOARD_DIFFERENCE_HEIGHT = 10;

    private SceneManager sceneManager;
    private Board board;

    public SnakeGame(SceneManager sceneManager) {
        super(sceneManager.getParentScene());
        this.sceneManager = sceneManager;
        this.board = new Board(sceneManager);
    }

    public void startGame() {
        /*Rectangle rectangle = new Rectangle();
        rectangle.setX(150.0f);
        rectangle.setY(75.0f);
        rectangle.setWidth(300.0f);
        rectangle.setHeight(150.0f);*/

        //   sceneManager.showOnlySceneCollection(rectangle);

       /* new Thread(new Runnable() {
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
        }).start();*/
    }
}
