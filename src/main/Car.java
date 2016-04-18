package main;

/**
 * Created by sharsh on 4/13/16.
 */
public class Car {

    private int carId;
    private CAR_TYPE type;

    public enum CAR_TYPE{
        NORMAL,
        LARGE,
        HANDICAPPED
    }

    public Car(int carId, CAR_TYPE type) {
        this.carId = carId;
        this.type = type;
    }

    public int getCarId(){
        return carId;
    }

}
