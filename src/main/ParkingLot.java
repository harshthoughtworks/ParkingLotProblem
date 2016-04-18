package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by sharsh on 4/13/16.
 */
public class ParkingLot implements Comparable {
    private List<Car> parkedCars;
    private int noOfParkings;
    private HashMap<Events, List<Subscription>> map;

    public ParkingLot(int noOfParkings) {
        this.noOfParkings = noOfParkings;
        parkedCars = new ArrayList<Car>(noOfParkings);
        map = new HashMap<Events, List<Subscription>>();

    }

    public void subscribeForEvent(Events event, Subscription objectSubscriber) {
        if (map.containsKey(event)) {
            map.get(event).add(objectSubscriber);
        } else {
            List<Subscription> list = new ArrayList<Subscription>();
            list.add(objectSubscriber);
            map.put(event, list);
        }
    }

    public ParkingResponse parkTheCar(Car car) {

        if (isParkingFull()) {
            return ParkingResponse.FULL;
        }
        if (parkedCars.contains(car)) {
            return ParkingResponse.ALREADY_PARKED;
        }
        if (car != null) {
            parkedCars.add(car);
            if (isParkingFull()) {
                List<Subscription> list = map.get(Events.Full);
                if (list != null) {
                    for (Subscription sub : list) {
                        if (sub != null)
                            sub.notifyParkingLotFull();
                    }
                }
            }
            if (parkedCars.size() == 0.8 * noOfParkings) {
                List<Subscription> list = map.get(Events.EightyPercentFull);
                if (list != null) {
                    for (Subscription subs : list) {
                        subs.notifyAt80PerParking();
                    }
                }

            }
            return ParkingResponse.PARKED;
        }
        return null;
    }

    public Car unParkCar(Car car) {
        if (parkedCars.contains(car)) {
            int index = parkedCars.indexOf(car);
            parkedCars.remove(index);

            List<Subscription> list;
            if (parkedCars.size() == noOfParkings - 1) {
                list = map.get(Events.NotFull);
                if (list != null) {
                    for (Subscription subs : list) {
                        subs.notifyParkingLotNotFull();
                    }
                }
            }

            if (parkedCars.size() == 0.8 * noOfParkings) {
                list = map.get(Events.EightyPercentFull);
                if (list != null) {
                    for (Subscription subs : list) {
                        subs.notifyAt80PerParking();
                    }
                }
            }
            return car;
        } else {
            List<Subscription> list = map.get(Events.CarNotFound);
            if (list != null) {
                for (Subscription subs : list) {
                    subs.notifyCarNotFound();
                }
            }
        }
        return null;
    }

    public boolean isParkingFull() {
        return (parkedCars.size() == noOfParkings);
    }

    @Override
    public int compareTo(Object o) {
        int firstLotFreeSpace = this.noOfParkings - this.parkedCars.size();
        int secondLotFreeSpace = ((ParkingLot)o).noOfParkings - ((ParkingLot) o).parkedCars.size();
        if (firstLotFreeSpace == secondLotFreeSpace)
            return 0;
        else if (firstLotFreeSpace > secondLotFreeSpace)
            return 1;
        else return -1;
    }
}
