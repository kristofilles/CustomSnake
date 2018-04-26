package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.Spawner;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.snakes.SnakeLaser;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class JointEnemy extends Enemy implements Animatable, Interactable {

    static {
        Spawner.registerClass( JointEnemy.class, 250 );
    }

    public JointEnemy(Pane pane) {
        super( pane );
        damage = 0;
        setImage( Globals.joint);
        speed = 1;
        Random rnd = new Random();
        do {
            setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH - 50));
            setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT - 50));
        }while(posChecker(Globals.head, getX(), getY()));

        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
    }



    @Override
    public void apply(SnakeHead player) {
        player.setHigh( true );
        destroy();
        player.setSpeed(0);
        new Timer().schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        player.setSpeed(2);
                        player.setHigh( false );
                    }
                }, 3000);
    }


    @Override
    public String getMessage() {
        return "420 yeye";
    }
}
