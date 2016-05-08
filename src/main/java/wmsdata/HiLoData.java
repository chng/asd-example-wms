package wmsdata;

import java.io.Serializable;

/**
 * Created by chn on 16/5/8.
 */
public interface HiLoData extends Serializable {
    boolean currentReading(double value, long time);
    void newDay(double initial, long time);
    double getHighValue();
    double getHoghTime();
    double getLowValue();
    double getLowTime();

    void setType(String type);
}
