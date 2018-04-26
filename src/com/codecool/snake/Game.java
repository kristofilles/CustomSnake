package com.codecool.snake;

import com.codecool.snake.entities.enemies.JointEnemy;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.enemies.TaxiEnemy;
import com.codecool.snake.entities.powerups.BicyclePowerUp;
import com.codecool.snake.entities.powerups.HelmetPowerUp;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Pane {

    public Game() {

        Globals.head = new SnakeHead(this, 500, 500);
        Globals.healthBar = new HealthBar(this);
        Globals.restartButton = new Restart(this);

        for (int i = 0; i<2 ; i++) {
            new JointEnemy(this);
            new TaxiEnemy(this);
            new HelmetPowerUp(this);
            new BicyclePowerUp(this);
            new SimplePowerup(this);
        }

    }

    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
                case C: Globals.cKeyDown = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
                case C: Globals.cKeyDown = false; break;
            }
        });
        Globals.gameLoop = new GameLoop(this);
        Globals.gameLoop.start();
    }

    public static void initGame(Stage primaryStage){
        Game game = new Game();
        Globals.primaryStage = primaryStage;
        primaryStage.setTitle("Snake Game");
        game.setBackground(new Background(Globals.myBI));
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        Globals.mediaPlayer.play();
        game.start();
    }
}
