package com.shao.util.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by shaozhuquan on 2018/11/19.
 */
public class TimerTest {
    Timer timer;

    public TimerTest(){
        Date time = getTime();
        System.out.println("指定时间time=" + time);
        timer = new Timer();
        timer.schedule(new TimerTaskTest(), time);
    }

    public Date getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 39);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();

        return time;
    }
}
