package com.handwrite.生产者消费者.wait_notify;

import java.util.Random;
import java.util.Vector;

/**
 * @author pengcheng
 * @date 2019/4/21 - 11:50
 * @content:
 */
public class Consumer implements Runnable {

    // 公共资源
    private final Vector sharedQueue;

    public Consumer(Vector sharedQueue){
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {

        Random random = new Random();
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        try{
            while(true){
                // 模拟延迟
                Thread.sleep(1000);
                // 当队列为空时，阻塞等待生产者生产新的数据
                while(sharedQueue.isEmpty()){
                    synchronized(sharedQueue){
                        System.out.println("Queue is empty, consumer " + Thread.currentThread().getId() + " is waiting, size：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }
                // 队列不为空时，直接消费
                synchronized(sharedQueue){
                    System.out.println("consumer consume data：" + sharedQueue.remove(0) + ", size：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
