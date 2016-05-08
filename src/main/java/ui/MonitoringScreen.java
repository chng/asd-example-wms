package ui;

import observable.Subject;

/**
 * Created by chn on 16/5/8.
 */
public abstract class MonitoringScreen {

//    PrintStream output;
//    public void setOutput(PrintStream output) {
//        this.output = output;
//    }

    public void addToSubject(Subject subject) {
        subject.addObserver((val) -> {display(val);});
    }
    public abstract void display(double val);
}
