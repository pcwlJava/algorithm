package com.handwrite.多个线程顺序打印;

import java.util.concurrent.Semaphore;

/**
 * @author pengcheng
 * @date 2019/4/21 - 11:20
 * @content: 使用信号量实现
 */
public class PrintABCUsingSemaphore {
    private int times;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public PrintABCUsingSemaphore(int times){
        this.times = times;
    }

    public void printA() {
        try {
            print("A", semaphoreA, semaphoreB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB(){
        try {
            print("B", semaphoreB, semaphoreC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC(){
        try {
            print("C", semaphoreC, semaphoreA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String name, Semaphore current, Semaphore next) throws InterruptedException {
        for(int i = 0; i < times; i++){
            current.acquire();
            System.out.println("线程：" + name + "，第 " + i + " 打印");
            next.release();
        }
    }

    public static void main(String[] args) {
        PrintABCUsingSemaphore printABC = new PrintABCUsingSemaphore(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}
