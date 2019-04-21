package com.handwrite.多个线程顺序打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengcheng
 * @date 2019/4/21 - 11:08
 * @content: 使用LOCK和Condition实现
 */
public class PrintABCUsingLockCondition {

    private int times;
    private int state;
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public PrintABCUsingLockCondition(int times){
        this.times = times;
    }

    public void printA(){
        print("A", 0, conditionA, conditionB);
    }

    public void printB(){
        print("B", 1, conditionB, conditionC);
    }

    public void printC(){
        print("C", 2, conditionC, conditionA);
    }

    private void print(String name, int targetState, Condition current, Condition next){
        for(int i = 0; i < times;){
            lock.lock();
            try {
                while(state % 3 != targetState) {
                    // 当前线程等待
                    current.await();
                }
                state++;
                i++;
                System.out.println("线程：" + name + "，第 " + i + " 打印");
                // 通知下一个
                next.signal();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingLockCondition printABC = new PrintABCUsingLockCondition(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}
