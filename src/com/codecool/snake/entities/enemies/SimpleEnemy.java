package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.*;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SimpleEnemy extends Enemy {


    static {
        Spawner.registerClass( SimpleEnemy.class, 180 );
    }


    public SimpleEnemy(Pane pane) {
        super(pane);
        damage = 10;
        setImage(Globals.simpleEnemy);

        Random rnd = new Random();
        do {
            setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH - 50));
            setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT - 50));
        }while(posChecker(Globals.head, getX(), getY()));

        speed = 1;
        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
    }
}
