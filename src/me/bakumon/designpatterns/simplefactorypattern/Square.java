package me.bakumon.designpatterns.simplefactorypattern;

/**
 * 正方形类：具体产品类
 * Created by bakumon on 17-7-31.
 */
public class Square implements Shape {

    public Square() {
        System.out.println("创建正方形！");
    }

    @Override
    public void draw() {
        System.out.println("绘制正方形！");
    }
}
