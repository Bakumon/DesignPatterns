package me.bakumon.designpatterns.factorymethodpattern.factory;

import me.bakumon.designpatterns.factorymethodpattern.product.Shape;
import me.bakumon.designpatterns.factorymethodpattern.product.Square;

/**
 * 正方形图形工厂类：具体工厂
 * Created by bakumon on 17-8-1.
 */
public class SquareShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        Shape square = new Square();
        return square;
    }
}
