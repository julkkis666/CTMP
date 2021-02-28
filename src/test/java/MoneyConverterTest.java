import model.Money;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class MoneyConverterTest {

    @Test
    @DisplayName("Money should work")
    public void money_rounder_works_test(){
        double amount = 1000.69006;
        Money money = new Money(amount);

        for(int i = 0; i < Money.getFractions(); i++){
            amount = amount*10;
        }
        long amountL = (long)amount;
        Assertions.assertEquals(money.getAmountLong(), amountL);
    }


}
