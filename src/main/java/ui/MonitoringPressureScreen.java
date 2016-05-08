package ui;

/**
 * Created by chn on 16/5/8.
 */
public class MonitoringPressureScreen extends MonitoringScreen {

    @Override
    public void display(double val) {
        System.out.println("pressure = " + val);
    }
}
