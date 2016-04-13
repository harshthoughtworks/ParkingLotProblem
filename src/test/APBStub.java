package test;

import main.APB;

/**
 * Created by sharsh on 4/13/16.
 */
public class APBStub extends APB{

    private boolean isApbSent;

    public boolean isApbSent() {
        return isApbSent;
    }

    public void submitReport(){
        System.out.print("Report Submitted");
        isApbSent = true;
    }
}
