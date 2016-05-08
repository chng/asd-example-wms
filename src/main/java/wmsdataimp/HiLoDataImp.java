package wmsdataimp;

import wmsdata.HiLoData;

/**
 * Created by chn on 16/5/8.
 */
public class HiLoDataImp implements HiLoData {

    private double itsHighTime;
    private double itsHighValue;
    private double itsLowTime;
    private double itsLowValue;
    private String itsType;

    public void setType(String type) {
        itsType = type;
    }

    @Override
    public boolean currentReading(double current, long time) {
        boolean change = false;
        if(current > getHighValue()) {
            itsHighValue = current;
            itsHighTime = time;
            change = true;
        } else if(current < getLowValue()) {
            itsLowValue = current;
            itsLowTime = time;
            change = true;
        }
        return change;
    }

    @Override
    public void newDay(double initial, long time) {
        itsHighValue = itsLowValue = initial;
        itsHighTime = itsLowTime = time;
    }


    @Override
    public double getHighValue() {
        return itsHighValue;
    }

    @Override
    public double getHoghTime() {
        return itsHighTime;
    }

    @Override
    public double getLowValue() {
        return itsLowValue;
    }

    @Override
    public double getLowTime() {
        return itsLowTime;
    }
}
