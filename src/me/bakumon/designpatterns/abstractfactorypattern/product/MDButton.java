package me.bakumon.designpatterns.abstractfactorypattern.product;

/**
 * MD风格按钮：具体产品
 * Created by bakumon on 17-8-3.
 */
public class MDButton implements Button {
    @Override
    public void display() {
        System.out.println("显示MD风格按钮");
    }
}
