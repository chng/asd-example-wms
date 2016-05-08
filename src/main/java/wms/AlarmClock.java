package wms;

import api.*;
import com.google.common.collect.Lists;

import java.util.Queue;

/**
 * Created by chn on 16/5/8.
 */
public class AlarmClock implements ClockListener {

    //ClockListener是各种传感器的适配器
    Queue<ClockListener> listeners = Lists.newLinkedList();

    public void tic() {
        while(!listeners.isEmpty()) {
            AlarmTask t = (AlarmTask) listeners.remove();

            long cur = System.currentTimeMillis();
            // 时间到
            if (t.getStartTime() + t.getInterval() < cur) {
                t.tic();
                t.setStartTime(System.currentTimeMillis());
            }
            listeners.offer(t);
        }
    }

    public void register(long interval, AlarmListener alarmListener) {
        listeners.add(new AlarmTask(interval, alarmListener));
    }

    public void register(long startTime, long interval, AlarmListener alarmListener) {
        listeners.add(new AlarmTask(startTime, interval, alarmListener));
    }
}
