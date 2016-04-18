package test;

import main.FBIAgent;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by sharsh on 4/13/16.
 */
public class FBIAgentTest {

    @Test
    public void testIfPaperWorkIsDone(){

        PaperWorkStub stub = new PaperWorkStub();
        FBIAgent fbiAgent = new FBIAgent(stub);
        fbiAgent.notifyCarNotFound();

        assertTrue(stub.isPaperWorkDone());
    }

}
