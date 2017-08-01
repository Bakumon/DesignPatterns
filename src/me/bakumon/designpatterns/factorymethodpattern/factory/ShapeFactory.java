package me.bakumon.designpatterns.factorymethodpattern.factory;

import me.bakumon.designpatterns.factorymethodpattern.shape.Shape;

/**
 * 图形工厂接口：抽象工厂
 * Created by bakumon on 17-8-1.
 */
public interface ShapeFactory {
    Shape createShape();
}
