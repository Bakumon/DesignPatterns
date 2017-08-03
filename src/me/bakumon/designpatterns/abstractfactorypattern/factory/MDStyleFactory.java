package me.bakumon.designpatterns.abstractfactorypattern.factory;

import me.bakumon.designpatterns.abstractfactorypattern.product.*;

/**
 * MD风格工厂：具体工厂
 * Created by bakumon on 17-8-4.
 */
public class MDStyleFactory implements StyleFactory {
    @Override
    public Button createButton() {
        return new MDButton();
    }

    @Override
    public EditText createEditText() {
        return new MDEditText();
    }

    @Override
    public TextView createTextView() {
        return new MDTextView();
    }
}
