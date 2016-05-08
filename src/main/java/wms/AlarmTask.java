package wms;

import api.ClockListener;

/**
 * Created by chn on 16/5/8.
 */
public class AlarmTask implements ClockListener {
    long startTime = System.currentTimeMillis();
    long interval = 0;

    AlarmListener alarmListener;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getInterval() {
        return interval;
    }

    public void tic() {
        alarmListener.wakeup();
    }

    public AlarmTask(long interval, AlarmListener listener) {
        this.interval = interval;
        this.alarmListener = listener;
    }

    public AlarmTask(long startTime, long interval, AlarmListener listener) {
        this.startTime = startTime;
        this.interval = interval;
        this.alarmListener = listener;
    }
}
