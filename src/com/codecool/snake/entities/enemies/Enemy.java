package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.snakes.SnakeLaser;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public abstract class Enemy extends GameEntity implements Animatable, Interactable {

    protected Point2D heading;
    protected int damage;
    protected int speed;

    protected Enemy(Pane pane) {
        super(pane);
        pane.getChildren().add(this);
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        if(player.isImmortal()) {
            player.setImmortal(false);
        } else{
            player.changeHealth(-damage);
        }
        destroy();
    }

    @Override
    public void apply(SnakeLaser laser) {
        destroy();
        Globals.head.changeEnemyKilled(1);
    }

    @Override
    public String getMessage() {
        return damage + "damage";
    }
}
