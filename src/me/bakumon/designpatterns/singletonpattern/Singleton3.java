package me.bakumon.designpatterns.singletonpattern;

/**
 * 方法带锁的懒汉模式
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {
    }

    /**
     * 解决了懒汉模式的线程安全问题
     * 由于给方法加了锁，导致该方法低效
     */
    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
