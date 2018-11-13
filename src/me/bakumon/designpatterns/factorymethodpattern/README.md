# 工厂方法模式

简单（静态）工厂模式，虽然实现了图形对象的创建和使用的分离，但是缺存在两个问题：

1. 工厂类过于庞大，存在过多 if else 或 switch 语句，导致维护困难
2. 系统扩展不灵活，增加另外一种具体的图形类时，就不得不修改工厂类

有什么办法可以解决这两个问题呢？工厂三巨头之一的工厂方法模式就可以解决，也就是这篇文章介绍的设计模式。

简单工厂模式中，所有的产品都由同一个工厂创建，导致该工厂职责过重，更好的方式，自然能想到每一个产品使用一个特定的工厂来创建，建立具体产品类和具体工厂类的一一对应关系，工厂类也可以像产品类那样抽象出共同的父类。

>工厂方法模式(Factory Method Pattern)：定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。

工厂方法模式有四个角色：

1. **Product（抽象产品）**：定义产品共同的接口
2. **ConcreteProduct（具体产品）**：实现抽象产品接口，是一种具体的产品，实现抽象产品中定义共同方法
3. **Factory（抽象工厂）**：声明工厂方法，用于返回一个产品。
4. **ConcreteFactory（具体工厂）**：抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，供客户端直接使用，和一种具体的产品对应

以图形为例：

产品相关：

```java
/**
 * 抽象形状接口：抽象产品类
 * Created by bakumon on 17-8-1.
 */
public interface Shape {
    void draw();
}

/**
 * 圆形类：具体产品类
 * Created by bakumon on 17-8-1.
 */
public class Round implements Shape {

    public Round() {
        System.out.println("创建圆形！");
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形！");
    }
}

/**
 * 正方形类：具体产品类
 * Created by bakumon on 17-8-1.
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
```

工厂相关：

```java
/**
 * 图形工厂接口：抽象工厂
 * Created by bakumon on 17-8-1.
 */
public interface ShapeFactory {
    Shape createShape();
}

/**
 * 圆形图形工厂类：具体工厂
 * Created by bakumon on 17-8-1.
 */
public class RoundShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        Shape square = new Round();
        return square;
    }
}

/**
 * 正方形图形工厂类：具体工厂
 * Created by bakumon on 17-8-1.
 */
public class SquareShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        Shape square = new Square();
        return square;
    }
}
```

客户端调用：

```java
// 创建圆形具体工厂类，用于创建圆形图形
RoundShapeFactory roundShapeFactory = new RoundShapeFactory();
// 创建圆形图形
Shape roundShape = roundShapeFactory.createShape();
roundShape.draw();

// 创建圆形具体工厂类，用于创建圆形图形
SquareShapeFactory squareShapeFactory = new SquareShapeFactory();
// 创建圆形图形
Shape squareShape = squareShapeFactory.createShape();
squareShape.draw();
```

运行结果：

```
创建圆形！
绘制圆形！
创建正方形！
绘制正方形！
```

**优点:**

1. 引入工厂类的抽象层，使系统更容易扩展，当系统增加新的产品时，不用修改工厂类
2. 创建具体产品的细节完全封装在工厂中，客户端不需要知道具体的创建细节即可获取到一个具体的产品

**缺点:**

1. 增加新的产品时，需要增加对象的产品类和具体工厂类，在一定程度上增加了系统的复杂性
2. 工厂抽象层的引入，增加了系统的抽象性和理解难度

任何模式都不是完美的，只有适用的场景。

工厂方法模式适用于：

1. 客户端不知道它所需要的对象的类。客户端不知道具体的产品类的类名，只需要知道对应的工厂类即可。
2. 抽象工厂类通过其子类来指定创建哪个对象。

本文代码:[github 地址](https://github.com/Bakumon/DesignPatterns/tree/master/src/me/bakumon/designpatterns/factorymethodpattern)