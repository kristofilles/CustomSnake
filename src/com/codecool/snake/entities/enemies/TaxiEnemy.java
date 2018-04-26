package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Spawner;
import javafx.scene.layout.Pane;

import java.util.Random;

public class TaxiEnemy extends Enemy {

    static {
        Spawner.registerClass( TaxiEnemy.class, 180 );
    }

    public TaxiEnemy(Pane pane) {
        super(pane);
        damage = 30;
        Random rnd = new Random();

        setImage(Globals.taxi);

        speed = 2;
        double direction = rnd.nextInt(2) * 180;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);

        do{
        if(direction == 0){
            setY(Globals.WINDOW_HEIGHT-10);
        }else{
            setY(10);
        }

        double xc;
        do {
            xc = (rnd.nextDouble() * Globals.WINDOW_WIDTH);
        }
        while(xc < 100 || xc > 900 || (470<xc && xc<550) );
        setX(xc);
        } while(posChecker(Globals.head, getX(), getY()));
    }
}
