package main;

/**
 * Created by sharsh on 4/13/16.
 */
public class PoliceDepartment implements Subscription {

    APB apb;
    public PoliceDepartment(APB apb){
        this.apb = apb;
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
        apb.submitReport();
    }
}
