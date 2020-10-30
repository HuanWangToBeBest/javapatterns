package com.pattern.productorconsumer.lock;

/**
 * lock 实现 生产者 消费者 模式
 */
public class ProductAndConsumerPattern {

    public static void main(String[] args) {
        CountNum countNum = new CountNum();
        countNum.setCount(0);
        Object lock = new Object();
        Product product = new Product(countNum,lock);
        Consumer consumer = new Consumer(countNum,lock);
        Thread[] pThread = new Thread[2];
        Thread[] cThread = new Thread[2];
        for (int i = 0; i < 2; i++) {
            pThread[i] = new Thread(() -> {
                while (true) {
                    product.Produce();
                }
            }, "生产者：" + (i + 1));
            cThread[i] = new Thread(() -> {
                while (true) {
                    consumer.Consume();
                }
            }, "消费者：" + (i + 1));
        }

        for (int i = 0;i < 2;i++){
            pThread[i].start();
            cThread[i].start();
        }
    }
}
