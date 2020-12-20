package com.pattern.productorconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
@SuppressWarnings("rawtypes")
public class Consumer implements Runnable{

    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        for (int i = 1;i <= 10;i++){
            try {
                System.out.println("消费：" + sharedQueue.take());
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
