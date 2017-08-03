package me.bakumon.designpatterns.abstractfactorypattern;

import me.bakumon.designpatterns.abstractfactorypattern.factory.MDStyleFactory;
import me.bakumon.designpatterns.abstractfactorypattern.product.Button;
import me.bakumon.designpatterns.abstractfactorypattern.product.EditText;
import me.bakumon.designpatterns.abstractfactorypattern.product.TextView;

/**
 * 测试抽象工厂模式
 * Created by bakumon on 17-8-3.
 */
public class Main {
    public static void main(String[] args) {
        MDStyleFactory mdStyleFactory = new MDStyleFactory();
        Button mdButton = mdStyleFactory.createButton();
        EditText mdEditText = mdStyleFactory.createEditText();
        TextView mdTextView = mdStyleFactory.createTextView();

        mdButton.display();
        mdEditText.display();
        mdTextView.display();
    }
}
