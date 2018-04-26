package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class SnakeHead extends GameEntity implements Animatable {

    private float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    private double health;
    private boolean immortal = false;
    private Pane gamePane;
    static boolean LaserShot = false;
    private int score = 0;
    private int shotsFired = 0;
    private int enemyKilled = 0;
    private boolean isHigh = false;

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        health = 100;
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);
        gamePane = pane;
        addPart(4);
    }

    public void step() {
        double dir = getRotate();
        if (Globals.leftKeyDown) {
            dir = dir - turnRate;
        }
        if (Globals.rightKeyDown) {
            dir = dir + turnRate;
        }
        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        if (Globals.cKeyDown){
            shootLaser();
        }

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds()) {
            health = 0;
        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
    }

    public void shootLaser(){
        if(!LaserShot) {
            new SnakeLaser(gamePane, getX(), getY(), getRotate());
            LaserShot = true;
        }
    }


    public void setImmortal(boolean immortal) {
        if(immortal){
            this.setImage(Globals.immortalHead);
        }else{
            this.setImage(Globals.snakeHead);
        }
        this.immortal = immortal;
    }

    public void setHigh(boolean high) {
        if(high) {
            this.setImage( Globals.high );
        }else{
            if (isImmortal()) {
                this.setImage( Globals.immortalHead );
            }else {
                this.setImage( Globals.snakeHead );
            }
        }
        this.isHigh = high;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isImmortal() {
        return immortal;
    }

    public double getHealthPercentage(){
        return health / 100;
    }

    public void changeHealth(int diff) {
        health += diff;
    }

    public int getScore(){
        return score;
    }

    public void changeScore(int plusScore){
        this.score += plusScore;
    }


    public List<Double> getRadius() {
        List<Double> pos = new ArrayList<>();
        pos.add(this.getX() - 100);
        pos.add(this.getX() + 100);
        pos.add(this.getY() - 100);
        pos.add(this.getY() + 100);
        return pos;
    }

    public int getShotsFired(){ return shotsFired;}

    public void changeShotsFired(int plusShots){
        this.shotsFired += plusShots;
    }

    public int getEnemyKilled(){ return enemyKilled;}

    public void changeEnemyKilled(int plusKilled){
        this.enemyKilled += plusKilled;

    }
}
