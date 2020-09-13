package me.bakumon.designpatterns.singletonpattern;

import java.io.ObjectStreamException;

/**
 * 双重检查加锁
 */
public class Singleton5 {
    /**
     * java 创建一个对象大致经过以下步骤：
     * <p>
     * 1.在堆内存开辟内存空间。
     * 2.在堆内存中实例化SingleTon里面的各个参数。
     * 3.把对象指向堆内存空间。
     * <p>
     * 但是，由于 jvm 存在乱序执行功能，导致第三步比第二步早执行了，这样在一个线程正在 new Singleton5() 操作时，
     * 另一个线程进入第一重判空，会得到 true，而返回一个尚未完全初始化完成的对象，导致出错
     * <p>
     * volatile 可以保证对象真正初始化完成后，才会赋值给 instance
     * 但是 java 5 之前，volatile 存在 bug
     */
    private volatile static Singleton5 instance = null;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        // 第一重判空，避免不必要的锁
        if (instance == null) {
            // 创建对象的过程加锁
            synchronized (Singleton5.class) {
                // 如果线程 1 和线程 2 同时进入第一层判空，线程 1 首先拿到锁，创建了对象，释放锁
                // 线程 2 拿到锁，如果线程 2 不判空的话，就同样也会创建对象
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
