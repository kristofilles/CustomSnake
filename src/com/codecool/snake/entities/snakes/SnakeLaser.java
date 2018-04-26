package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class SnakeLaser extends GameEntity implements Animatable {

    private float speed = 4;
    private final double dir;

    protected SnakeLaser(Pane pane, double xc, double yc, double dir) {
        super(pane);
        setX(xc);
        setY(yc);
        this.dir = dir;
        pane.getChildren().add(this);
        setImage(Utils.randomImage(Globals.lasers));
        // add to the main loop.
        Globals.head.changeShotsFired(1);
    }

    @Override
    public void step() {
        if(!isOutOfBounds()){
            for (GameEntity entity : Globals.getGameObjects()) {
                if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                    if (entity instanceof Interactable) {
                        Interactable interactable = (Interactable) entity;
                        interactable.apply(this);
                        System.out.println("laser collided with smth");
                        destroy();
                        SnakeHead.LaserShot = false;
                    }
                }
            }
            Point2D heading = Utils.directionToVector(dir, speed);
            setX(getX() + heading.getX());
            setY(getY() + heading.getY());
        }
        else{
            destroy();
            SnakeHead.LaserShot = false;
        }
    }
}
