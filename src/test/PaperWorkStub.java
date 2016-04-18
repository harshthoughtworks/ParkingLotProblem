package test;

import main.PaperWork;

/**
 * Created by sharsh on 4/13/16.
 */
public class PaperWorkStub extends PaperWork{

    private boolean isPaperWorkDone;

    @Override
    public void doPaperWork(){
        System.out.print("Paper work done by FBI");
        isPaperWorkDone = true;
    }

    public boolean isPaperWorkDone() {
        return isPaperWorkDone;
    }
}
