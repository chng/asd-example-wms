package persistence;

import api.PersistentImp;
import wms.RetrieveException;
import wms.StoreException;
import wmsdata.HiLoData;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chn on 16/5/8.
 *
 * HiLoDataImp的持久化代理类 负责HiLoData持久化相关的操作. 其它操作则委托给HiLodataImp
 *
 */
public class HiLoDataProxy implements HiLoData {

    private final PersistentImp itsPI;
    private String itsStorageKey;
    private HiLoData hiLoDataImp;

    public HiLoDataProxy(PersistentImp pi, String type,
                         Date theDate, double init,
                         long initTime) {
        itsPI = pi;
        itsStorageKey = calculateStorageKey(theDate);
        try {
            hiLoDataImp = (HiLoData) itsPI.retrieve(itsStorageKey);
            hiLoDataImp.setType(type);
            currentReading(init, initTime);
        }catch(RetrieveException e) {
            // log
        }

    }

    private String calculateStorageKey(Date theDate) {
        return new SimpleDateFormat("yyyyMMdd").format(theDate);
    }

    @Override
    public boolean currentReading(double current, long time) {
        boolean change = hiLoDataImp.currentReading(current, time);
        if(change) {
            store();
        }
        return change;
    }

    private void store() {
        try {
            itsPI.store(itsStorageKey, hiLoDataImp);
        } catch (StoreException e) {
            // log
        }
    }

    @Override
    public void newDay(double initial, long time) {
        store();
        hiLoDataImp.newDay(initial, time);
        itsStorageKey = calculateStorageKey(new Date());
        store();
    }

    @Override
    public double getHighValue() {
        return hiLoDataImp.getHighValue();
    }

    @Override
    public double getHoghTime() {
        return hiLoDataImp.getHoghTime();
    }

    @Override
    public double getLowValue() {
        return hiLoDataImp.getLowValue();
    }

    @Override
    public double getLowTime() {
        return hiLoDataImp.getLowTime();
    }

    @Override
    public void setType(String type) {
        hiLoDataImp.setType(type);
    }
}
