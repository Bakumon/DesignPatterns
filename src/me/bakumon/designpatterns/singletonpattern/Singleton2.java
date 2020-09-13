package me.bakumon.designpatterns.singletonpattern;

/**
 * 懒汉模式
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {
    }

    /**
     * 使用时创建对象，避免空间浪费
     * 线程不安全：线程 1 和线程 2 同时访问到判空代码，之后就会各自创建新对象，导致前一个创建的对象被后一个覆盖，故不能保证多个线程使用的是同一个对象
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
