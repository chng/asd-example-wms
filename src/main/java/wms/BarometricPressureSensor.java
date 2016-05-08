package wms;

import api.BarometricPressureSensorImp;
import api.Sensor;
import api.StationToolkit;
import observable.Subject;

/**
 * Created by chn on 16/5/8.
 */
public class BarometricPressureSensor extends Subject implements Sensor, AlarmListener {

    private final long interval = 1000L;
    private BarometricPressureSensorImp itsImpl;

    public BarometricPressureSensor(AlarmClock ac, StationToolkit st) {
        itsImpl = st.makeBarometricPressureSensor();
        ac.register(interval, () -> notifyObservers(read()));
    }

    public void wakeup() {
        notifyObservers(read());
    }

    public double read() {
        return itsImpl.read();
    }
}
