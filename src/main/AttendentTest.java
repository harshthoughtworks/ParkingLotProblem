package main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by sharsh on 4/14/16.
 */
public class AttendentTest {

    @Test
    public void testIfAttendentProviesParkingLotThatIsFree(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(5));

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualParkingLot = null;
        try {
            actualParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(!actualParkingLot.isParkingFull());
    }


    @Test(expected = Exception.class)
    public void testIfAttendentGivesNoParkingLotWhenAllAreFull(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualParkingLot = null;
        try {
            actualParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        actualParkingLot.isParkingFull();
    }

    @Test
    public void testIfAttendentAssignsAFreeParkingLotEvenly(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot firstParking = new ParkingLot(0);
        ParkingLot secondParking = new ParkingLot(2);
        ParkingLot thirdParking = new ParkingLot(3);
        parkingLots.add(firstParking);
        parkingLots.add(secondParking);
        parkingLots.add(thirdParking);

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualParkingLot = null;
        try {
            attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL).parkTheCar(new Car(1, Car.CAR_TYPE.NORMAL));
            attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL).parkTheCar(new Car(2, Car.CAR_TYPE.NORMAL));
            actualParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(secondParking, actualParkingLot);
    }

    @Test
    public void testIfAttendentAssignsAParkingLotEvenlyWhenBothAreAvailable(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot firstParking = new ParkingLot(2);
        ParkingLot secondParking = new ParkingLot(1);

        parkingLots.add(firstParking);
        parkingLots.add(secondParking);

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualFirstParkingLot = null;
        ParkingLot actualSecondParkingLot = null;
        try {
            actualFirstParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL);
            actualFirstParkingLot.parkTheCar(new Car(1, Car.CAR_TYPE.NORMAL));
            actualSecondParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL);
            actualSecondParkingLot.parkTheCar(new Car(2, Car.CAR_TYPE.NORMAL));

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(firstParking, actualFirstParkingLot);
        assertEquals(secondParking, actualSecondParkingLot);
    }


    @Test
    public void testIfLargeCarIsGivenLargestFreeLotWhenOnlyLargeCars(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParking = new ParkingLot(2);
        ParkingLot secondParking = new ParkingLot(4);

        parkingLots.add(firstParking);
        parkingLots.add(secondParking);

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualFirstParkingLot = null;
        ParkingLot actualSecondParkingLot = null;

        try {
            actualFirstParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.LARGE);
            actualFirstParkingLot.parkTheCar(new Car(1, Car.CAR_TYPE.LARGE));
            actualSecondParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.LARGE);
            actualSecondParkingLot.parkTheCar(new Car(2, Car.CAR_TYPE.LARGE));

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(secondParking, actualFirstParkingLot);
        assertEquals(secondParking, actualSecondParkingLot);
    }

    @Test
    public void testIfLargeCarIsGivenLargestFreeLotWhenMixedCars(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParking = new ParkingLot(4);
        ParkingLot secondParking = new ParkingLot(3);
        ParkingLot thirdParking = new ParkingLot(3);

        parkingLots.add(firstParking);
        parkingLots.add(secondParking);
        parkingLots.add(thirdParking);

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualParkingLot = null;

        try {
            attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL).parkTheCar(new Car(1, Car.CAR_TYPE.NORMAL));
            attendent.getAvailableParkingLot(Car.CAR_TYPE.LARGE).parkTheCar(new Car(2, Car.CAR_TYPE.LARGE));
            attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL).parkTheCar(new Car(2, Car.CAR_TYPE.NORMAL));
            actualParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.LARGE);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(thirdParking, actualParkingLot);
    }

    @Test
    public void testIfFirstAvailableLotIsGivenForHandicapped(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParking = new ParkingLot(0);
        ParkingLot secondParking = new ParkingLot(4);
        ParkingLot thirdParking = new ParkingLot(3);

        parkingLots.add(firstParking);
        parkingLots.add(secondParking);
        parkingLots.add(thirdParking);

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualParkingLot = null;

        try {
            attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL).parkTheCar(new Car(1, Car.CAR_TYPE.NORMAL));
            attendent.getAvailableParkingLot(Car.CAR_TYPE.HANDICAPPED).parkTheCar(new Car(2, Car.CAR_TYPE.HANDICAPPED));
            actualParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.HANDICAPPED);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(secondParking, actualParkingLot);
    }

    @Test
    public void testIfFirstAvailableLotIsGivenForHandicappedWithMixedCars(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParking = new ParkingLot(2);
        ParkingLot secondParking = new ParkingLot(3);
        ParkingLot thirdParking = new ParkingLot(3);

        parkingLots.add(firstParking);
        parkingLots.add(secondParking);
        parkingLots.add(thirdParking);

        Attendent attendent = new Attendent(parkingLots);
        ParkingLot actualFirstParkingLot = null;
        ParkingLot actualSecondParkingLot = null;

        try {
            attendent.getAvailableParkingLot(Car.CAR_TYPE.LARGE).parkTheCar(new Car(1, Car.CAR_TYPE.LARGE));
            actualFirstParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.HANDICAPPED);
            actualFirstParkingLot.parkTheCar(new Car(2, Car.CAR_TYPE.HANDICAPPED));
            attendent.getAvailableParkingLot(Car.CAR_TYPE.NORMAL).parkTheCar(new Car(3, Car.CAR_TYPE.NORMAL));
            actualSecondParkingLot = attendent.getAvailableParkingLot(Car.CAR_TYPE.HANDICAPPED);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(firstParking, actualFirstParkingLot);
        assertEquals(secondParking, actualSecondParkingLot);
    }

}