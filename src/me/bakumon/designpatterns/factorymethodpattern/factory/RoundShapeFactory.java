package me.bakumon.designpatterns.factorymethodpattern.factory;

import me.bakumon.designpatterns.factorymethodpattern.product.Round;
import me.bakumon.designpatterns.factorymethodpattern.product.Shape;

/**
 * 圆形图形工厂类：具体工厂
 * Created by bakumon on 17-8-1.
 */
public class RoundShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        Shape square = new Round();
        return square;
    }
}
