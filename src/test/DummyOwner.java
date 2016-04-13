package test;

import main.Subscribers;
import main.Subscription;

/**
 * Created by sharsh on 4/13/16.
 */
public class DummyOwner implements Subscription {

    int notificationCount=0;

    @Override
    public void notifyAt80PerParking() {

    }

    @Override
    public void notifyParkingLotFull() {
        notificationCount++;
    }

    @Override
    public void notifyParkingLotNotFull() {
        notificationCount--;
    }

    @Override
    public void notifyCarNotFound() {

    }

    public int getNotificationCount(){
        return notificationCount;
    }



}