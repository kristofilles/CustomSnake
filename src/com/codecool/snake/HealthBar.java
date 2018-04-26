package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class HealthBar extends GameEntity {

    Rectangle outerHealthRect;
    Rectangle innerHealthRect;

    public HealthBar(Pane pane){
        super(pane);

        double height = 40;

        double outerWidth = 100;
        double innerWidth = 100;

        double x=5.0;
        double y=5.0;

        outerHealthRect = new Rectangle( x, y, outerWidth, height);
        outerHealthRect.setStroke(Color.BLACK);
        outerHealthRect.setStrokeWidth(2);
        outerHealthRect.setStrokeType( StrokeType.OUTSIDE);
        outerHealthRect.setFill(Color.RED);

        innerHealthRect = new Rectangle( x, y, innerWidth, height);
        innerHealthRect.setStrokeType( StrokeType.OUTSIDE);
        innerHealthRect.setFill(Color.LIMEGREEN);

        this.pane.getChildren().addAll( outerHealthRect, innerHealthRect);
        pane.getChildren().add(this);
    }

    public void setValue( double value) {
        innerHealthRect.setWidth( outerHealthRect.getWidth() * value);
    }
}
