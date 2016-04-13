package test;

import main.Subscribers;
import main.Subscription;

/**
 * Created by sharsh on 4/13/16.
 */
public class TestFBIagent implements Subscription {

    int notificationCount=0;
    @Override
    public void notifyParkingLotFull() {

    }

    @Override
    public void notifyParkingLotNotFull() {
    }

    @Override
    public void notifyCarNotFound() {

    }

    public int getNotificationCount(){
        return notificationCount;
    }


    @Override
    public void notifyAt80PerParking() {
        notificationCount++;
    }
}