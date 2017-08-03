package me.bakumon.designpatterns.abstractfactorypattern.factory;

import me.bakumon.designpatterns.abstractfactorypattern.product.Button;
import me.bakumon.designpatterns.abstractfactorypattern.product.EditText;
import me.bakumon.designpatterns.abstractfactorypattern.product.TextView;

/**
 * 控件风格工厂接口：抽象工厂
 * Created by bakumon on 17-8-4.
 */
public interface StyleFactory {
    Button createButton();
    EditText createEditText();
    TextView createTextView();
}
