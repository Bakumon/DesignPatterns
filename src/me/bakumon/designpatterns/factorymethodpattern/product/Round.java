package me.bakumon.designpatterns.factorymethodpattern.product;

/**
 * 圆形类：具体产品类
 * Created by bakumon on 17-8-1.
 */
public class Round implements Shape {

    public Round() {
        System.out.println("创建圆形！");
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形！");
    }
}
