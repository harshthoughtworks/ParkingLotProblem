package main;

/**
 * Created by sharsh on 4/13/16.
 */
public interface Subscription {

    public void notifyAt80PerParking();
    public void notifyParkingLotFull();
    public void notifyParkingLotNotFull();
    public void notifyCarNotFound();

}
