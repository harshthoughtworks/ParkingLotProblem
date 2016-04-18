package main;

/**
 * Created by sharsh on 4/13/16.
 */
public class FBIAgent implements Subscription {

    private PaperWork paperWork;

    public FBIAgent(PaperWork paperWork) {
        this.paperWork = paperWork;
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
        paperWork.doPaperWork();
    }
}
