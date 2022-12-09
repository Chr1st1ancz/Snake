package com.example.demo1.graphicInterface;

import com.example.demo1.game.Snake;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SnakeGame snakeGame = new SnakeGame(new SimpleViewManager());
        snakeGame.startGame();

        stage.setScene(snakeGame);
        stage.setResizable(false);
        stage.setWidth(SnakeGame.BOARD_WIDTH);
        stage.setHeight(SnakeGame.BOARD_HEIGHT+SnakeGame.BOARD_DIFFERENCE_HEIGHT);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
