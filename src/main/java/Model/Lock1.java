package Model;

import com.sun.deploy.util.SyncAccess;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Thuan Nguyen on 10/11/2016.
 */
public class Lock1 {
    private Lock myLock = new ReentrantLock();
    public void UpdateResource()
    {
        try {

            myLock.lock();
        }
        finally {

            myLock.unlock();
        }
    }
}
