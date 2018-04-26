package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.snakes.SnakeLaser;
import javafx.scene.layout.Pane;

import java.util.Random;

abstract class PowerUp extends GameEntity implements Interactable {


    protected PowerUp(Pane pane) {
        super(pane);

        do {
            Random rnd = new Random();
            setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH - 50));
            setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT - 50));
        }
        while(posChecker(Globals.head, getX(), getY()));
        pane.getChildren().add(this);
    }

    @Override
    public void apply(SnakeLaser laser) {
        destroy();
    }

}
