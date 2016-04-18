package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by sharsh on 4/14/16.
 */
public class Attendent {

    private ArrayList<ParkingLot> parkingLotList;
    private ArrayList<ParkingLot> parkingLotsBasedOnSizeList;
    Iterator<ParkingLot> parkingLotIterator;

    public Attendent(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        parkingLotIterator = parkingLotList.iterator();
        parkingLotsBasedOnSizeList = (ArrayList<ParkingLot>) parkingLotList.clone();
        Collections.sort(parkingLotsBasedOnSizeList, Collections.reverseOrder());

    }

    public void refreshParkingLotsBasedOnSizeList() {
        Collections.sort(parkingLotsBasedOnSizeList, Collections.reverseOrder());
    }


    public ParkingLot getAvailableParkingLot(Car.CAR_TYPE type) throws Exception {
        if (type == (Car.CAR_TYPE.LARGE)) {
            refreshParkingLotsBasedOnSizeList();
            return getParkingLot(parkingLotsBasedOnSizeList);
        }
        if (type == Car.CAR_TYPE.HANDICAPPED) {
            return getParkingLot(parkingLotList);

        } else {
            int parkingSlotsCounter = 0;
            if (!parkingLotIterator.hasNext()) parkingLotIterator = parkingLotList.iterator();
            while (parkingLotIterator.hasNext()) {
                parkingSlotsCounter++;
                ParkingLot pkLot = parkingLotIterator.next();
                if (!pkLot.isParkingFull()) {
                    ParkingLot availableParkingLot = pkLot;
                    return availableParkingLot;
                }
                if (!parkingLotIterator.hasNext()) parkingLotIterator = parkingLotList.iterator();

                if (parkingLotList.size() == parkingSlotsCounter) break;
            }
            throw new Exception();
        }

    }

    private ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLotList) throws Exception{
        for (ParkingLot pkLot : parkingLotList) {
            if (!pkLot.isParkingFull()) {
                ParkingLot availableParkingLot = pkLot;
                return availableParkingLot;
            }
        }
        throw new Exception();
    }
}
