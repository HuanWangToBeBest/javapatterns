package com.pattern.productorconsumer.lock;

/**
 * 消费者
 */
public class Consumer {

    private CountNum countNum;

    private final Object lock;

    public Consumer(CountNum countNum, Object lock){
        super();
        this.countNum = countNum;
        this.lock = lock;
    }

    public void Consume(){
        synchronized (lock){
            if (countNum.getCount() > 0){
                try {
                    Thread.sleep(500);
                    countNum.setCount(countNum.getCount() - 1);
                    System.out.println(Thread.currentThread().getName() + "消费-1,当前count：" + countNum.getCount());
                    lock.notifyAll();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                try {
                    lock.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
