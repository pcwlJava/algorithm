package com.handwrite.多个线程顺序打印;

/**
 * @author pengcheng
 * @date 2019/4/21 - 10:52
 * @content: 使用 wait/notify 实现
 */
public class PrintABCUsingWaitNotify {

    private int times;
    private int state;
    private Object objectA = new Object();
    private Object objectB = new Object();
    private Object objectC = new Object();

    public PrintABCUsingWaitNotify(int times){
        this.times = times;
    }

    public void printA(){
        try {
            print("A", 0, objectA, objectB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB(){
        try {
            print("B", 1, objectB, objectC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC(){
        try {
            print("C", 2, objectC, objectA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print(String name, int targetState, Object current, Object next) throws InterruptedException {
        for(int i = 0; i < times;){
            // 锁定当前线程
            synchronized(current){
                while(state % 3 != targetState){
                    current.wait();
                }
                state++;
                i++;
                System.out.println("线程：" + name + "，第 " + i + " 打印");
                synchronized(next){
                    // 通知下一个线程
                    next.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABC = new PrintABCUsingWaitNotify(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}
