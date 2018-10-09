package com.shao;

import java.util.concurrent.TimeUnit;

/**
 * Created by shaozhuquan on 2018/10/8.
 */

public class VolatileTest implements Runnable{
    private static volatile boolean flag = true ;
    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName() + "正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName() +"执行完毕");
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileTest aVolatile = new VolatileTest();
        new Thread(aVolatile,"thread A").start();
        System.out.println("main 线程正在运行") ;
        TimeUnit.MILLISECONDS.sleep(100) ;
        aVolatile.stopThread();
    }
    private void stopThread(){
        flag = false;
    }
}
