package com.pattern.singleton;

/**
 * 饿汉式单例模式
 */
public class HungrySinglePattern {

    private static final HungrySinglePattern instance = new HungrySinglePattern();

    private HungrySinglePattern(){}

    public static HungrySinglePattern getInstance(){
        return instance;
    }
}
