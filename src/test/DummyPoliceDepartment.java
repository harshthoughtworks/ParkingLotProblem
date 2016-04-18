package test;

import main.PoliceActions;
import main.Subscribers;
import main.Subscription;

/**
 * Created by sharsh on 4/13/16.
 */
public class DummyPoliceDepartment implements Subscription{

    int notificationCount=0;
    private boolean isApbSent;

    public boolean isApbSent() {
        return isApbSent;
    }

    public int getNotificationCount(){
        return notificationCount;
    }

    @Override
    public void notifyAt80PerParking() {

    }

    @Override
    public void notifyParkingLotFull() {

    }

    @Override
    public void notifyParkingLotNotFull() {

    }

    @Override
    public void notifyCarNotFound() {
        notificationCount++;
    }

}