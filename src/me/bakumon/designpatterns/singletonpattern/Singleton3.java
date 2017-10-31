package me.bakumon.designpatterns.singletonpattern;

/**
 * 方法带锁的懒汉模式
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {
    }

    synchronized public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
