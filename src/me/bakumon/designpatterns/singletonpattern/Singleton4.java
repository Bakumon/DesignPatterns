package me.bakumon.designpatterns.singletonpattern;

/**
 * 创建语句加锁的懒汉模式
 */
public class Singleton4 {
    private static Singleton4 instance = null;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                instance = new Singleton4();
            }
        }
        return instance;
    }
}
