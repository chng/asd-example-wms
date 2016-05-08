package observable;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by chn on 16/5/8.
 */
public class Subject implements Observable {

    List<Observer> observers = Lists.newLinkedList();


    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(double val) {
        for(Observer o: observers) {
            o.update(val);
        }
    }
}
