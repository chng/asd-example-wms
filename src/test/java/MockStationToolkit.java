import api.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import wms.RetrieveException;
import wms.StoreException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by chn on 16/5/8.
 */
public class MockStationToolkit implements StationToolkit {
    public TemperatureSensorImp makeTemperatureSensor() {
        return new TemperatureSensorImp() {
            public double read() {
                return 1;
            }

        };
    }

    public BarometricPressureSensorImp makeBarometricPressureSensor() {
        return new BarometricPressureSensorImp() {
            public double read() {
                return 0;
            }
        };
    }

    public BarometricPressureTrendImp makeBarometricPressureTrend() {
        return new BarometricPressureTrendImp() {
            public double read() {
                return 2;
            }

        };
    }

    @Override
    public PersistentImp getPersistentImp() {
        return new PersistentImp() {
            Map<String, Serializable> dict = Maps.newHashMap();
            @Override
            public void store(String name, Serializable obj) throws StoreException {
                dict.put(name, obj);
            }

            @Override
            public Object retrieve(String name) throws RetrieveException {
                return dict.get(name);
            }

            @Override
            public List directory(String regExp) {
                List ret = Lists.newLinkedList();
                // find and insert
                return ret;
            }
        };
    }
}
