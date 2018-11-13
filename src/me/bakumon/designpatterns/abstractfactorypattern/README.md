# 抽象工厂模式

工厂方法模式通过引入工厂等级结构，解决了简单(静态)工厂模式中工厂类职责太重的问题，但是也存在一个问题：

1. 工厂方法模式中的每个工厂只生产一类产品，可能会导致系统中存在大量的工厂类。

此时，我们可以考虑将一些相关的产品组成一个“产品族”，由同一个工厂来统一生产，这就是抽象工厂模式的基本思想。

> 抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，它是一种对象创建型模式。

理解抽象工厂必须先理解以下几个角色：

1. **产品等级结构**：即产品的继承结构，如按钮（Button），子类有扁平风格按钮（FlattenedButton）、MD风格按钮（MDButton），文本标签（TextView），子类有扁平风格文本标签（FlattenedTextView）、MD风格文本标签（MDTextView），各自构成一个产品等级结构。
2. **产品族**：产品族是指位于不同产品结构中的一组产品。如，扁平风格工厂生产的扁平风格按钮、扁平风格文本标签，扁平风格按钮位于按钮产品等级结构中，扁平风格文本标签位于文本标签等级结构中。而扁平风格按钮和扁平风格文本标签构成了一个产品族，可以叫做扁平产品族。

直观的体验看下图：

![产品族和产品结构.png](https://i.loli.net/2017/08/10/598b381ebf557.png)

从上图可以看出**产品等级结构**和**产品族**是相互交叉的，如上例，第一列正方形可认为是按钮（Button），第二列椭圆可认为是文本标签（TextView），各自为一个产品等级结构，第一行的正方形、椭圆和三角形可认为是扁平风格产品族，第二行的正方形、椭圆和三角形可认为是MD风格控件产品族。

具体代码如下：

```java
/**
 * 按钮接口：抽象产品
 * Created by bakumon on 17-8-3.
 */
public interface Button {
    void display();
}
```

```java
/**
 * 扁平风格按钮：具体产品
 * Created by bakumon on 17-8-3.
 */
public class FlattenedButton implements Button {
    @Override
    public void display() {
        System.out.println("显示扁平风格按钮");
    }
}
```

```java
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
```

```java
/**
 * 文本标签接口：抽象产品
 * Created by bakumon on 17-8-3.
 */
public interface TextView {
    void display();
}
```

```java
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
```

```java
/**
 * MD风格文本标签：具体产品
 * Created by bakumon on 17-8-3.
 */
public class MDTextView implements TextView {
    @Override
    public void display() {
        System.out.println("显示MD风格文本标签");
    }
}
```

```java
/**
 * 控件风格工厂接口：抽象工厂
 * Created by bakumon on 17-8-4.
 */
public interface StyleFactory {
    Button createButton();
    TextView createTextView();
}
```

```java
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
    public TextView createTextView() {
        return new FlattenedTextView();
    }
}
```

```java
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
    public TextView createTextView() {
        return new MDTextView();
    }
}
```

客户端：

```java
/**
 * 测试抽象工厂模式
 * Created by bakumon on 17-8-3.
 */
public class Main {
    public static void main(String[] args) {
        MDStyleFactory mdStyleFactory = new MDStyleFactory();
        Button mdButton = mdStyleFactory.createButton();
        TextView mdTextView = mdStyleFactory.createTextView();

        mdButton.display();
        mdTextView.display();
    }
}
```

```
显示MD风格按钮
显示MD风格文本标签
```

**优点:**

1. 只需要改变具体工厂的实例，就可以改变系统的行为。
2. 方便增加新的产品族，符合“开闭原则”。

**缺点:**

1. 增加新的产品结构，也需要改变原有的工厂。

任何模式都不是完美的，只有适用的场景。

抽象工厂模式适用于：

1. 使用具体的产品不依赖于如何创建产品的细节。
2. 系统中需要存在多个产品族，而只能使用其中某一个产品族。
3. 约束同一产品族的产品只能一同作用于系统，不得混和使用。

本文更详细代码:[github 地址](https://github.com/Bakumon/DesignPatterns/tree/master/src/me/bakumon/designpatterns/abstractfactorypattern)