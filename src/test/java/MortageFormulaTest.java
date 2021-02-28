import controller.MortageFormula;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


/**
 * I used the math library to conduct my unit tests.
 */
public class MortageFormulaTest {


    @Test
    @DisplayName("power of zero is zero")
    public void test(){
        double number = MortageFormula.pow(123,0);
        Assertions.assertEquals(number, 1);
    }







    @Test
    @DisplayName("power of zero is zero")
    public void power_of_0_is_1(){
        double number = MortageFormula.pow(123,0);
        Assertions.assertEquals(number, 1);
    }

    @Test
    @DisplayName("Power of one is x")
    public void power_of_1_is_x(){
        double x = Math.random()*10;
        double number = MortageFormula.pow(x,1);
        Assertions.assertEquals(number, x);
    }


}
