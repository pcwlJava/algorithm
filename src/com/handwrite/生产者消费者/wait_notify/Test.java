package com.handwrite.生产者消费者.wait_notify;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pengcheng
 * @date 2019/4/21 - 11:50
 * @content:
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        // 1. 建立内存缓冲区
        Vector sharedQueue = new Vector();
        int size = 4;

        // 2. 构建线程池和线程
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer1 = new Producer(sharedQueue,size);
        Producer producer2 = new Producer(sharedQueue,size);
        Producer producer3 = new Producer(sharedQueue,size);
        Consumer consumer1 = new Consumer(sharedQueue);
        Consumer consumer2 = new Consumer(sharedQueue);
        Consumer consumer3 = new Consumer(sharedQueue);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        // 3. 睡一会儿，然后尝试停止生产者（结束循环）
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        // 4. 再睡一会儿，关闭线程池
        Thread.sleep(3000);

        // 5. shutdown() 等待任务执行完才中断线程(消费者线程未停止，所以其实程序是无法结束的)
        service.shutdown();
    }
}
