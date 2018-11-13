简单工厂模式由于工厂类中的方法为静态，所以又叫静态工厂模式。简单工厂模式并不属于 23 个经典设计模式，但是因为其设计思想简单，较为常用，所以作为学习其他工厂模式的基础。

简单工厂模式适用的场景是，但你需要某个对象，只需要传入一个正确的参数，就可以获取到所需对象，而不必知道该对象的创建细节，创建细节被简单工厂对外屏蔽。

简单工厂模式的使用流程如下：

首先会有几个相似的、可抽取出公共代码的类，称之为 **具体产品类**，如圆形和正方形，而将它们的公共代码抽象到一个 **抽象产品类** 中，每一个具体产品类都是抽象产品类的子类，然后提供一个 **工厂类**，该工厂类有一个可以根据传入的参数不同而创建不同的具体产品对象，并且该方法可为静态，客户端只需要调用工厂类的工厂方法并传入正确的参数即可得到一个具体产品对象。

下面以简单工厂模式设计一个可以创建不同图形的工具，每个图形都具有 draw() 绘制方法。

```java
/**
 * 抽象形状接口：抽象产品类
 * Created by bakumon on 17-7-31.
 */
public interface Shape {
    void draw();
}

/**
 * 圆形类：具体产品类
 * Created by bakumon on 17-7-31.
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
 * Created by bakumon on 17-7-31.
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

/**
 * 形状工厂类：工厂类
 * Created by bakumon on 17-7-31.
 */
public class ShapeFactory {
    public static Shape getShape(String type) throws UnSupportedShapeException {
        switch (type) {
            case "round":
                return new Round();
            case "square":
                return new Square();
            default:
                throw new UnSupportedShapeException();
        }
    }
}

/**
 * 不支持的图形异常
 * Created by bakumon on 17-7-31.
 */
public class UnSupportedShapeException extends Throwable {
    @Override
    public String getMessage() {
        return "Un support shape type";
    }
}
```

客户端调用：

```java
Shape shape = ShapeFactory.getShape("round");
shape.draw();
```

结果：

```
创建圆形！
绘制圆形！
```

**优点:**

1. 简单工厂模式对外屏蔽对象的创建过程，实现了对象的创建和使用的分离
2. 逻辑简单，便于理解，避免记忆过多复杂的类名

**缺点:**

1. 简单工厂拥有所有产品的创建逻辑，职责过重，一旦出现问题，整个系统将会收到较大影响
2. 扩展困难，一旦增加新的产品，就得修改工厂方法方法，增加判断逻辑

任何模式都不是完美的，只有适用的场景。

简单工厂模式适用于：

1. 工厂类负责创建的对象比较少，不会造成工厂方法中的业务逻辑太过复杂
2. 客户端不关心对象的创建

本文代码:[github 地址](https://github.com/Bakumon/DesignPatterns/tree/master/src/me/bakumon/designpatterns/simplefactorypattern)
