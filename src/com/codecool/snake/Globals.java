package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;

    public static BackgroundImage myBI= new BackgroundImage(new Image("background.jpg",WINDOW_WIDTH,WINDOW_HEIGHT,false,true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    public static Image snakeHead = new Image("miki_normal.png");
    public static Image immortalHead = new Image("miki_immortal.png");
    public static Image snakeBody = new Image("mikiBody.png");
    public static Image simpleEnemy = new Image("simple_enemy.png");
    public static Image powerupBerry = new Image("energygel.png");
    public static Image bicycle = new Image("bicycle_2.png");
    public static Image helmet = new Image("helmet.png");
    public static Image high = new Image("high.png");
    public static Image joint = new Image("joint.png");
    public static Image taxi = new Image("taxi.png");
    public static Media music = new Media(new File("resources/Loop_Cartel_Drum_n_Bass_Demo.mp3").toURI().toString());
    public static MediaPlayer mediaPlayer = new MediaPlayer(music);


    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static boolean cKeyDown;
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static List<Image> lasers ;
    public static GameLoop gameLoop;
    public static HealthBar healthBar;
    public static SnakeHead head;
    public static Restart restartButton;
    public static Stage primaryStage;

    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
        lasers = new ArrayList<>();
        for(int i = 1; i<4 ; i++) {
            lasers.add(new Image("bubble_" + i + ".png"));
        }
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }
}
