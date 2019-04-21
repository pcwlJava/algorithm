package com.handwrite.生产者消费者.wait_notify;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengcheng
 * @date 2019/4/21 - 11:50
 * @content:
 */
public class Producer implements Runnable {

    // 为 true 时，生产者生产，为 false 时停止生产
    private volatile boolean needRpoduce = true;

    // 公共资源
    private final Vector sharedQueue;

    // 公共资源的最大数量
    private final int SIZE;

    // 生产数据
    private static AtomicInteger count = new AtomicInteger();

    public Producer(Vector sharedQueue, int SIZE){
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }


    @Override
    public void run() {
        int data;
        Random random = new Random();

        System.out.println("start producer id = " + Thread.currentThread().getId());
        try{
            while(needRpoduce){
                // 模拟延迟
                Thread.sleep(1000);
                // 当队列已经满了的时候，就阻塞等待
                while(sharedQueue.size() == SIZE){
                    synchronized(sharedQueue){
                        System.out.println("Queue is full, producer " + Thread.currentThread().getId() + " is waiting, size：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }

                // 阻塞队列不满时就继续生产
                synchronized(sharedQueue){
                    // 生产数据
                    data = count.incrementAndGet();
                    sharedQueue.add(data);
                    System.out.println("producer create data:" + data + ", size：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }

            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    // 停止生产
    public void stop(){
        needRpoduce = false;
    }
}
