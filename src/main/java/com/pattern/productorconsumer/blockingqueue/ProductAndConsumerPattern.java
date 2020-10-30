package com.pattern.productorconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列实现 生产者消费者模式
 */
@SuppressWarnings("rawtypes")
public class ProductAndConsumerPattern {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue();

        Thread pThread = new Thread(new Producer(blockingQueue));
        Thread cThread = new Thread(new Consumer(blockingQueue));

        pThread.start();
        System.out.println("=============");
        cThread.start();

    }
}
