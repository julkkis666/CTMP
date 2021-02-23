package model;

/**
 * this class exists so that we can round money to pennies
 */
public class Money {
    private final static String name = "Duckburgian Dollars";
    private final static String shortName = "D$";
    private final static int fractionSize = 2; //How many decimals of little monies make one big money

    private long amount;

    public Money(double amount){
        this.amount = convertfromDouble(amount);
    }

    public long getAmountLong(){
        return amount;
    }

    @Override
    public String toString(){
        return convertToDecimalString();
    }

    public String convertToDecimalString(){
        double d = (double)amount;
        for(int i = 0; i < fractionSize; i++){
            d = d/10;
        }
        return Double.toString(d);
    }

    public static int getFractions() {
        return fractionSize;
    }

    public void setAmount(double d){
        amount = convertfromDouble(d);
    }





    /**
     *
     * Convert double to long
     *
     * @param d double to convert to "money long"
     * @return converts double to an integer (long)
     */
    private long convertfromDouble(double d){
        for(int i = 0; i < fractionSize; i++){
            d = d*10;
        }
        return (long)d;
    }

}
