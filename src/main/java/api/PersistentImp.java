package api;

import wms.RetrieveException;
import wms.StoreException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chn on 16/5/8.
 */
public interface PersistentImp {
    void store(String name, Serializable obj) throws StoreException;
    Object retrieve(String name) throws RetrieveException;
    List directory(String regExp);
}
