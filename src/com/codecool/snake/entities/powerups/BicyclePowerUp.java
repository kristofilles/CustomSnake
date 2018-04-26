package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Spawner;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Timer;
import java.util.TimerTask;

public class BicyclePowerUp extends PowerUp {


    static {
        Spawner.registerClass( BicyclePowerUp.class, 350);
    }

    public BicyclePowerUp(Pane pane){
        super(pane);
        setImage(Globals.bicycle);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        destroy();
        snakeHead.setSpeed(3);
        snakeHead.setHigh( false );
        new Timer().schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        snakeHead.setSpeed(2);
                    }
                }, 5000);
    }

    @Override
    public String getMessage() {
        return "Miki got a new fixie :)";
    }

}
