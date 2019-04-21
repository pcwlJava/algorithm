package com.handwrite.多个线程顺序打印;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengcheng
 * @date 2019/4/21 - 10:07
 * @content: 方法一：用锁实现
 */
public class PrintABCUsingLock {

    private int times;   // 控制打印次数
    private int state;   // 当前状态值：保证三个线程之间交替打印
    private Lock lock = new ReentrantLock();   // 保证每次只有一个线程能够拿到资源

    public PrintABCUsingLock(int times){
        this.times = times;
    }

    public void printA(){
        print("A", 0);
    }

    public void printB(){
        print("B", 1);
    }

    public void printC(){
        print("C", 2);
    }

    private void print(String name, int targetState){
        for(int i = 0; i < times;){
            lock.lock();
            // 控制交替打印
            if(state % 3 == targetState){
                state++;
                i++;
                System.out.println("线程：" + name + "，第 " + i + " 打印");
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABCUsingLock printABC = new PrintABCUsingLock(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}
