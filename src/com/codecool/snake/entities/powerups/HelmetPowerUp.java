package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Spawner;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class HelmetPowerUp extends PowerUp {

    static {
        Spawner.registerClass( HelmetPowerUp.class, 350 );
    }


    public HelmetPowerUp(Pane pane) {
        super(pane);
        setImage(Globals.helmet);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        destroy();
        snakeHead.setImmortal(true);
    }

    @Override
    public String getMessage() {
        return "Miki is fucken immortal";
    }
}
