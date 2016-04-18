package main.temp;

import main.ParkingLot;

/**
 * Created by sharsh on 4/14/16.
 */
public class Response {

    private ParkingLot parkingLot;
    private boolean hasParkingLot;


    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean isHasParkingLot() {
        return hasParkingLot;
    }

    public void setHasParkingLot(boolean hasParkingLot) {
        this.hasParkingLot = hasParkingLot;
    }
}
