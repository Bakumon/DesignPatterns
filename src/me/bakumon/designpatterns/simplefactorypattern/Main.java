package me.bakumon.designpatterns.simplefactorypattern;

import me.bakumon.designpatterns.simplefactorypattern.factory.ShapeFactory;
import me.bakumon.designpatterns.simplefactorypattern.factory.UnSupportedShapeException;
import me.bakumon.designpatterns.simplefactorypattern.shape.Shape;

/**
 * 测试简单工厂模式
 * Created by bakumon on 17-7-31.
 */
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
