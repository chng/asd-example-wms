package wms;

import api.StationToolkit;
//import nimbus1_0.Nimbus1_0Toolkit;

/**
 * Created by chn on 16/5/8.
 */
public class WeatherStation {

    public void test() {


        StationToolkit st = null;// = new Nimbus1_0Toolkit();
        //StationToolkit是工厂类的接口, 不同版本的Nimbus可以实现自己的工厂类,用于创建自己的传感器组

        AlarmClock ac = new AlarmClock();


        TemperatureSensor ts = new TemperatureSensor(ac, st);
        BarometricPressureSensor bps = new BarometricPressureSensor(ac, st);
        BarometricPressureTrend bpt = new BarometricPressureTrend(ac, st);

        TemperatureHiLo temperatureHiLo = new TemperatureHiLo(ac, ts);
    }

}
