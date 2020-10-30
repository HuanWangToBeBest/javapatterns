package com.pattern.productorconsumer.lock;

/**
 * 生产者
 */
public class Product {

    private CountNum countNum;

    private final Object lock;

    public Product(CountNum countNum, Object lock){
        super();
        this.countNum = countNum;
        this.lock = lock;
    }

    public void Produce(){
        synchronized (lock){
            if (countNum.getCount() < 5){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                countNum.setCount(countNum.getCount() + 1);
                System.out.println(Thread.currentThread().getName() + "生产+1,当前count：" + countNum.getCount());
                lock.notifyAll();// 很重要
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
