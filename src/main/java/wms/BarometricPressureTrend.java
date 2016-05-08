package wms;

import api.BarometricPressureTrendImp;
import api.Sensor;
import api.StationToolkit;
import observable.Subject;

/**
 * Created by chn on 16/5/8.
 */
public class BarometricPressureTrend extends Subject implements Sensor {

    private final long interval = 2000L;
    private BarometricPressureTrendImp itsImpl;

    public BarometricPressureTrend(AlarmClock ac, StationToolkit st) {
        itsImpl = st.makeBarometricPressureTrend();
        ac.register(interval, () -> notifyObservers(read()));
    }

    public void wakeup() {
        notifyObservers(read());
    }

    public double read() {
        return itsImpl.read();
    }
}
