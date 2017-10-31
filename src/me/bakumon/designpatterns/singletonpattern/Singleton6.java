package me.bakumon.designpatterns.singletonpattern;

/**
 * Initialization Demand Holder (IoDH)
 * 静态内部类
 */
public class Singleton6 {
    private Singleton6() {
    }

    private static class HolderClass {
        private final static Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return HolderClass.instance;
    }
}
