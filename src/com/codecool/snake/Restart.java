package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Restart extends GameEntity {

    private EventHandler<MouseEvent> replayEventHandler = e -> {
        Globals.gameObjects.clear();
        Globals.gameLoop.stop();
        Globals.leftKeyDown = false;
        Globals.rightKeyDown = false;
        Globals.cKeyDown = false;
        Game.initGame(Globals.primaryStage);
    };

    public Restart(Pane pane){
        super(pane);
        Button buttonReplay = new Button("Restart");

        buttonReplay.setLayoutY(5);
        buttonReplay.setLayoutX(130);
        buttonReplay.setOnMouseClicked(replayEventHandler);
        pane.getChildren().add(buttonReplay);

    }
}
