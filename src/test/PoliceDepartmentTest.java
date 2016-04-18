package test;

import main.Car;
import main.Events;
import main.ParkingLot;
import main.PoliceDepartment;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sharsh on 4/13/16.
 */
public class PoliceDepartmentTest {

    @Test
    public void sendOutAPB() {
        APBStub stub = new APBStub();
        PoliceDepartment policeDepartment = new PoliceDepartment(stub);
        policeDepartment.notifyCarNotFound();

        assertTrue(stub.isApbSent());
    }
}