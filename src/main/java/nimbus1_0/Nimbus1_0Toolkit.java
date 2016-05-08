package nimbus1_0;

import api.*;

/**
 * Created by chn on 16/5/8.
 */
public class Nimbus1_0Toolkit implements StationToolkit {
    public TemperatureSensorImp makeTemperatureSensor() {
        return null;
    }

    public BarometricPressureSensorImp makeBarometricPressureSensor() {
        return null;
    }

    public BarometricPressureTrendImp makeBarometricPressureTrend() {
        return null;
    }

    @Override
    public PersistentImp getPersistentImp() {
        return null;
    }
}
