package me.bakumon.designpatterns.singletonpattern;

/**
 * 饿汉模式
 */
public class Singleton1 {

    /**
     * 可能造成空间浪费，因为对象在被初始化了之后，可能会一直不被使用
     * 构造方法如果存在过多的处理，会导致加载类会被拖慢
     */
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    /**
     * 线程安全，getInstance() 没有创建对象，对象在类加载时已经创建了，因此不存在线程安全问题
     */
    public static Singleton1 getInstance() {
        return instance;
    }
}
