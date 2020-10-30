package com.pattern.singleton;

/**
 * 懒汉单例模式
 */
public class LazySinglePattern {

    private static volatile LazySinglePattern instance = null;

    private LazySinglePattern(){}

    public static synchronized LazySinglePattern getInstance(){
        if (instance == null){
            instance = new LazySinglePattern();
        }
        return instance;
    }
}
