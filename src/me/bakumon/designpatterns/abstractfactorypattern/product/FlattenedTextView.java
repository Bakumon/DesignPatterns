package me.bakumon.designpatterns.abstractfactorypattern.product;

/**
 * 扁平风格文本标签：具体产品
 * Created by bakumon on 17-8-3.
 */
public class FlattenedTextView implements TextView {
    @Override
    public void display() {
        System.out.println("显示扁平风格文本标签");
    }
}
