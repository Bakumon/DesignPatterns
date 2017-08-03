package me.bakumon.designpatterns.abstractfactorypattern.product;

/**
 * MD风格文本框：具体产品
 * Created by bakumon on 17-8-3.
 */
public class MDEditText implements EditText {
    @Override
    public void display() {
        System.out.println("显示MD风格文本框");
    }
}
