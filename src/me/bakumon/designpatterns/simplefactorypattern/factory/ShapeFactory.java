package me.bakumon.designpatterns.simplefactorypattern.factory;

import me.bakumon.designpatterns.simplefactorypattern.shape.Round;
import me.bakumon.designpatterns.simplefactorypattern.shape.Shape;
import me.bakumon.designpatterns.simplefactorypattern.shape.Square;

/**
 * 形状工厂类：工厂类
 * Created by bakumon on 17-7-31.
 */
public class ShapeFactory {
    public static Shape getShape(String type) throws UnSupportedShapeException {
        switch (type) {
            case "round":
                return new Round();
            case "square":
                return new Square();
            default:
                throw new UnSupportedShapeException();
        }
    }
}
