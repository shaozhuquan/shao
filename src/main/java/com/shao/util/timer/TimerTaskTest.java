package com.shao.util.timer;

/**
 * Created by shaozhuquan on 2018/11/19.
 */
public class TimerTaskTest extends java.util.TimerTask {
    @Override
    public void run() {
        System.out.println("指定时间执行线程任务...");
    }
}
