package wms;

import observable.Observer;
import util.DateUtil;
import wmsdata.HiLoData;
import wmsdata.Scope;

import java.util.Date;

/**
 * Created by chn on 16/5/8.
 */
public class TemperatureHiLo implements Observer {

    private long startTime = DateUtil.startOfToday();
    private long interval = 1000L*60*60*24;
    private double itsRead;

    public long getInterval() {
        return this.interval;
    }

    //初始化hiLoData: 用工厂接口创建一个hiLoDataProxy代理, 将它绑定到hiLoData
    HiLoData hiLoData = Scope.itsDataToolkit.getHiLoData(); // 需要初始化

    public TemperatureHiLo(AlarmClock ac, TemperatureSensor ts) {
        //注册到定时任务调度器中, 每天凌晨将执行read和newDay
        ac.register(startTime, interval, () -> {
            itsRead = ts.read();
            hiLoData.newDay(itsRead, new Date().getTime());
        });
        //注册到Observer中, ts的每次读取都会通知TemperatureHiLo,
        //  然后调用currentReading存储最新值
        ts.addObserver(this);


    }

    @Override
    public void update(double val) {
        itsRead = val;
        hiLoData.currentReading(val, new Date().getTime());
    }
}
