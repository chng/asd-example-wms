package wms;

import api.Sensor;
import api.StationToolkit;
import api.TemperatureSensorImp;
import observable.Subject;

/**
 * Created by chn on 16/5/8.
 */
public class TemperatureSensor extends Subject implements Sensor {

    private long interval = 1000L;
    public long getInterval() {
        return this.interval;
    }

    private TemperatureSensorImp itsImpl;

    public TemperatureSensor(AlarmClock ac, StationToolkit st) {
        itsImpl = st.makeTemperatureSensor();
        ac.register(interval, () -> {notifyObservers(read());});
    }

    public double read() {
        return itsImpl.read();
    }
}
