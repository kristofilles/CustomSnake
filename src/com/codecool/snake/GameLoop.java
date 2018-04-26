package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Spawner;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.objects.Global;

import java.lang.reflect.InvocationTargetException;

public class GameLoop extends AnimationTimer {
    private Pane pane;

    public GameLoop(Pane pane) {
        this.pane = pane;
    }

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {

        for (GameEntity gameObject : Globals.gameObjects) {
            if (gameObject instanceof Animatable) {
                Animatable animObject = (Animatable)gameObject;
                animObject.step();
            }
        }

        try {
            Spawner.spawn(pane);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        Globals.healthBar.setValue(Globals.head.getHealthPercentage());
        if (Globals.head.getHealthPercentage() <= 0){
            System.out.println("Game over");
            Globals.gameLoop.stop();
            Alert gameOver = new Alert( Alert.AlertType.INFORMATION );
            gameOver.setTitle("Game over!");
            gameOver.setHeaderText( "Gels collected: " + Globals.head.getScore() + "\n" +
                                    "Shots fired: " + Globals.head.getShotsFired() + "\n" +
                                    "Enemy killed: " + Globals.head.getEnemyKilled());
            gameOver.show();

        }
        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();

        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();
    }
}
