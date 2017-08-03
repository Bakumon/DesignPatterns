package me.bakumon.designpatterns.factorymethodpattern;

import me.bakumon.designpatterns.factorymethodpattern.factory.RoundShapeFactory;
import me.bakumon.designpatterns.factorymethodpattern.factory.SquareShapeFactory;
import me.bakumon.designpatterns.factorymethodpattern.product.Shape;

/**
 * 测试工厂方法模式
 * Created by bakumon on 17-8-1.
 */
public class Main {

    public static void main(String[] args) {
        RoundShapeFactory roundShapeFactory = new RoundShapeFactory();
        Shape roundShape = roundShapeFactory.createShape();
        roundShape.draw();

        SquareShapeFactory squareShapeFactory = new SquareShapeFactory();
        Shape squareShape = squareShapeFactory.createShape();
        squareShape.draw();
    }
}
