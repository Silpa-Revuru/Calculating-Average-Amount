package averageamount;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class AverageAmountTest {

    //Positive Scenario
    //This test case expected to check
    @Test
    void test(){
        AverageAmount averageAmount  = new AverageAmount();
        ArrayList<String> infoFromFile = averageAmount.readFile();
        assertFalse(infoFromFile.size() == 0);

    }


    //Negative Scenario
    //This test case expected to throw FileNotFound Exception
    @Test
    void testFile()  {
        try {
            AverageAmount averageAmount  = new AverageAmount();
            ArrayList<String> infoFromFile = averageAmount.readFile();
        } catch (Exception e) {}
    }



}