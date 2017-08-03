package me.bakumon.designpatterns.abstractfactorypattern.product;

/**
 * 扁平风格文本框：具体产品
 * Created by bakumon on 17-8-3.
 */
public class FlattenedEditText implements EditText {
    @Override
    public void display() {
        System.out.println("显示扁平风格文本框");
    }
}
