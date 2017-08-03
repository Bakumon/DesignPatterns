package me.bakumon.designpatterns.abstractfactorypattern.factory;

import me.bakumon.designpatterns.abstractfactorypattern.product.*;

/**
 * 扁平风格工厂：具体工厂
 * Created by bakumon on 17-8-4.
 */
public class FlattenedStyleFactory implements StyleFactory {
    @Override
    public Button createButton() {
        return new FlattenedButton();
    }

    @Override
    public EditText createEditText() {
        return new FlattenedEditText();
    }

    @Override
    public TextView createTextView() {
        return new FlattenedTextView();
    }
}
