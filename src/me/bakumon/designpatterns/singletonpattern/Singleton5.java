package me.bakumon.designpatterns.singletonpattern;

public class Singleton5 {
    private volatile static Singleton5 instance = null;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (Singleton5.class) {
                //第二重判断
                if (instance == null) {
                    instance = new Singleton5(); //创建单例实例
                }
            }
        }
        return instance;
    }
}
