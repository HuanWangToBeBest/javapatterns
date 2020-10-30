package com.pattern.productorconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 */
@SuppressWarnings("rawtypes")
public class Producer implements Runnable{

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 1;i <= 10;i++){
            System.out.println("生产：" + i);
            try {
                sharedQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
