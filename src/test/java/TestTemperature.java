import api.StationToolkit;
import org.junit.Test;
import wms.AlarmClock;
import ui.MonitoringTemperatureScreen;
import wms.TemperatureSensor;

/**
 * Created by chn on 16/5/8.
 */
public class TestTemperature {

    @Test
    public void test() throws InterruptedException {

        StationToolkit st = new MockStationToolkit();
        AlarmClock alarmClock = new AlarmClock();

        TemperatureSensor ts = new TemperatureSensor(alarmClock, st);

        MonitoringTemperatureScreen screen = new MonitoringTemperatureScreen();
        screen.addToSubject(ts);

        alarmClock.tic();
    }

}
