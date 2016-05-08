package api;

/**
 * Created by chn on 16/5/8.
 */
public interface StationToolkit {
    TemperatureSensorImp makeTemperatureSensor();
    BarometricPressureSensorImp makeBarometricPressureSensor();
    BarometricPressureTrendImp makeBarometricPressureTrend();

    PersistentImp getPersistentImp();
}
