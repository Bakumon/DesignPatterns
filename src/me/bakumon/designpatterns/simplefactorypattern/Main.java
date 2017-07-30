package me.bakumon.designpatterns.simplefactorypattern;

public class Main {

    public static void main(String[] args) {
        try {
            Shape shape = ShapeFactory.getShape("round");
            shape.draw();
        } catch (UnSupportedShapeException e) {
            e.printStackTrace();
        }
    }
}
