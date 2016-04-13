package test;

import main.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {


    @Test
    public void testForCarParking(){
        Car c = new Car(1);

        ParkingLot parkingLot = new ParkingLot(10);

        ParkingResponse actual = parkingLot.parkTheCar(c);
        ParkingResponse expected = ParkingResponse.PARKED;

        assertEquals(expected, actual);
    }


    @Test
    public void testIfAllreadyParked(){
        Car c = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);

        parkingLot.parkTheCar(c);
        ParkingResponse actual = parkingLot.parkTheCar(c);

        ParkingResponse expected = ParkingResponse.ALREADY_PARKED;

        assertEquals(expected, actual);
    }

    @Test
    public void testIfParkingLotIsFull(){
        Car carFirst = new Car(1);
        Car carSecond = new Car(2);
        Car carThird = new Car(3);
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.parkTheCar(carFirst);
        parkingLot.parkTheCar(carSecond);


        ParkingResponse actual = parkingLot.parkTheCar(carThird);

        ParkingResponse expected = ParkingResponse.FULL;

        assertEquals(expected, actual);
    }

    @Test
    public void testUnParkingOfCar(){
        Car carFirst = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);

        parkingLot.parkTheCar(carFirst);

        Car expected = parkingLot.unParkCar(carFirst);

        assertEquals(expected, carFirst);
    }

    @Test
    public void testOwnerIsNotifiedWhenParkingIsFull() {
        DummyOwner dummyOwner = new DummyOwner();

        Car carFirst = new Car(1);
        Car carSecond = new Car(2);
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.subscribeForEvent(Events.Full, dummyOwner);
        parkingLot.parkTheCar(carFirst);
        parkingLot.parkTheCar(carSecond);

        int expected = 1;
        int actual = dummyOwner.getNotificationCount();
        assertEquals(expected, actual);

    }

    @Test
    public void testOwnerIsNotifiedWhenParkingIsNotFull() {
        DummyOwner dummyOwner = new DummyOwner();

        Car carFirst = new Car(1);
        Car carSecond = new Car(2);
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.subscribeForEvent(Events.NotFull, dummyOwner);

        parkingLot.parkTheCar(carFirst);
        parkingLot.parkTheCar(carSecond);
        parkingLot.unParkCar(carSecond);


        int expected = -1;
        int actual = dummyOwner.getNotificationCount();
        assertEquals(expected, actual);
    }

     @Test
    public void testFbiIsNotifiedWhenParking80percentFull() {
         TestFBIagent testFBIagent = new TestFBIagent();

         Car carFirst = new Car(1);
         Car carSecond = new Car(2);
         Car carThird = new Car(3);
         Car carFourth = new Car(4);
         ParkingLot parkingLot = new ParkingLot(5);
         parkingLot.subscribeForEvent(Events.EightyPercentFull, testFBIagent);

         parkingLot.parkTheCar(carFirst);
         parkingLot.parkTheCar(carSecond);
         parkingLot.parkTheCar(carThird);
         parkingLot.parkTheCar(carFourth);

         int expected = 1;
         int actual = testFBIagent.getNotificationCount();
         assertEquals(expected, actual);
     }

    @Test
    public void testPoliceIsNotifiedWhenCarNotFound() {
        DummyPoliceDepartment dummyPoliceDepartment = new DummyPoliceDepartment();

        Car carFirst = new Car(1);
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.subscribeForEvent(Events.CarNotFound, dummyPoliceDepartment);

        parkingLot.unParkCar(carFirst);

        int expected = 1;
        int actual = dummyPoliceDepartment.getNotificationCount();
        assertEquals(expected, actual);
    }

 }