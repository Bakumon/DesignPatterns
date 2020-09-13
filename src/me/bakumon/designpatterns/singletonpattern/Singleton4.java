package me.bakumon.designpatterns.singletonpattern;

/**
 * 创建语句加锁的懒汉模式
 */
public class Singleton4 {
    private static Singleton4 instance = null;

    private Singleton4() {
    }

    /**
     * 相比给方法加锁，提高了效率
     * 但是线程不安全：线程 1 和线程 2 同时访问到了判空语句，之后线程 1 拿到锁，创建了对象，之后，线程 2 拿到锁同样也会创建对象，导致不同的线程得到的对象不是同一个
     * <p>
     * 此方法相较于简单的懒汉模式，没有任何优势，反而增加了迷惑性
     */
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                instance = new Singleton4();
            }
        }
        return instance;
    }
}
