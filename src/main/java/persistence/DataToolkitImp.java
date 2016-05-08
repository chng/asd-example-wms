package persistence;

import api.PersistentImp;
import api.StationToolkit;
import persistence.HiLoDataProxy;
import wmsdata.DataToolkit;
import wmsdata.HiLoData;

import java.util.Date;

/**
 * Created by chn on 16/5/8.
 */
public class DataToolkitImp implements DataToolkit {

    public static StationToolkit st;
    public DataToolkitImp(StationToolkit st) {
        this.st = st;
    }

    public HiLoData getHiLoData() {
        PersistentImp pi = st.getPersistentImp();
        return new HiLoDataProxy(pi, "temperature", new Date(), 0, 0);
    }
}
