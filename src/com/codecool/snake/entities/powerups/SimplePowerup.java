package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Spawner;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.snakes.SnakeLaser;
import javafx.scene.layout.Pane;

public class SimplePowerup extends PowerUp {

    static {
        Spawner.registerClass( SimplePowerup.class, 200 );
    }


    public SimplePowerup(Pane pane) {
        super(pane);
        setImage(Globals.powerupBerry);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(1);
        snakeHead.changeScore(1);
        destroy();
    }


    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
