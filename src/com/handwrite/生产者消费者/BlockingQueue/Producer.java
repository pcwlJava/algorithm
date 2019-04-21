package com.handwrite.生产者消费者.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengcheng
 * @date 2019/4/21 - 13:31
 * @content:
 */
public class Producer implements Runnable{

    private volatile boolean needProduce = true;
    private BlockingQueue<Integer> queue;                       // 内存缓冲区
    private static AtomicInteger count = new AtomicInteger();   // 总数，原子操作

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("start producer id = " + Thread.currentThread().getId());
        try{
            while(needProduce){
                // 模拟延迟
                Thread.sleep(random.nextInt(1000));

                // 往阻塞队列中添加数据
                data = count.incrementAndGet();
                System.out.println("producer " + Thread.currentThread().getId() + " create data：" + data + ", size：" + queue.size());
                if(!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.err.println("failed to put data：" + data);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupted();
        }
    }

    // 停止生产者线程
    public void stop(){
        needProduce = false;
    }
}
