package me.bakumon.designpatterns.simplefactorypattern.factory;

/**
 * 不支持的图形异常
 * Created by bakumon on 17-7-31.
 */
public class UnSupportedShapeException extends Throwable {
    @Override
    public String getMessage() {
        return "不支持的图形类型";
    }
}
