package com.codecool.snake.entities;

import com.codecool.snake.Globals;
import javafx.scene.layout.Pane;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Spawner {

    private static int framesSinceStart = 0;

    private static List<SpawnData> spawnables = new ArrayList<>();

    public static void registerClass(Class spawnable, int frameInterval) {
        spawnables.add(new SpawnData(spawnable, frameInterval) );
    }

    public static void spawn(Pane pane) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        framesSinceStart++;

        for (SpawnData spawnable : spawnables) {
            if (framesSinceStart % spawnable.frameInterval == 0) {
                Constructor constr = spawnable.spawnableClass.getConstructor(Pane.class);
                constr.newInstance(pane);
            }
        }
    }
}


class SpawnData {

    Class spawnableClass;
    int frameInterval;
    int maxNumberOfEntities;


    public SpawnData(Class spawnableClass, int frameInterval) {
        this.spawnableClass = spawnableClass;
        this.frameInterval = frameInterval;

    }


}