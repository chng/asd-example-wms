import api.StationToolkit;
import org.junit.Test;
import ui.MonitoringPressureScreen;
import ui.MonitoringPressureTrendScreen;
import wms.*;

/**
 * Created by chn on 16/5/8.
 */
public class TestBarometricPressure {

    @Test
    public void test() throws InterruptedException {


        StationToolkit st = new MockStationToolkit();
        AlarmClock alarmClock = new AlarmClock();

        BarometricPressureSensor bps = new BarometricPressureSensor(alarmClock, st);
        BarometricPressureTrend bpt = new BarometricPressureTrend(alarmClock, st);

        MonitoringPressureScreen bpscreen = new MonitoringPressureScreen();
        MonitoringPressureTrendScreen bptscreen = new MonitoringPressureTrendScreen();
        bpscreen.addToSubject(bps);
        bptscreen.addToSubject(bpt);

        alarmClock.tic();
    }

}
