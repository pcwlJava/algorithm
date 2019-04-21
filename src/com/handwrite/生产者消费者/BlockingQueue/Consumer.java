package com.handwrite.生产者消费者.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author pengcheng
 * @date 2019/4/21 - 13:45
 * @content:
 */
public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;     // 内存缓冲区

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("start consumer id = " + Thread.currentThread().getId());

        try{
            while(true){
                // 模拟延迟
                Thread.sleep(random.nextInt(1000));

                // 从阻塞队列中消费数据
                if(!queue.isEmpty()){
                    data = queue.take();
                    System.out.println("consumer " + Thread.currentThread().getId() + " consume data：" + data + ", size：" + queue.size());
                }else{
                    System.out.println("Queue is empty, consumer " + Thread.currentThread().getId() + " is waiting, size：" + queue.size());
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
