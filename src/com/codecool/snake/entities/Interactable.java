package com.codecool.snake.entities;

import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.snakes.SnakeLaser;

// interface that all game objects that can be interacted with must implement.
public interface Interactable {

    void apply(SnakeHead snakeHead);
    void apply(SnakeLaser laser);
    default boolean posChecker(SnakeHead snakeHead, double X, double Y){
            if((snakeHead.getRadius().get(0) < X && snakeHead.getRadius().get(1) > X)
                    && (snakeHead.getRadius().get(2) < Y && snakeHead.getRadius().get(3) > Y)){
                return true;
            }
            return false;
        }

    String getMessage();

}
