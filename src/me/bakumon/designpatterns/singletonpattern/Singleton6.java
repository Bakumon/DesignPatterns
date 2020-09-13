package me.bakumon.designpatterns.singletonpattern;

/**
 * 静态内部类
 */
public class Singleton6 {
    private Singleton6() {
    }

    /**
     * 外部类加载时，内部类还不会被加载
     */
    private static class HolderClass {
        private final static Singleton6 instance = new Singleton6();
    }

    /**
     * getInstance() 被调用时，才会加载内部类，创建单例对象
     * 这里不能传递参数给 instance
     */
    public static Singleton6 getInstance() {
        return HolderClass.instance;
    }
}
