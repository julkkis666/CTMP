package model;

import java.text.DecimalFormat;

/**
 * this class exists so that we can round money to pennies
 * currently only static usage.
 */
public class Money {
    private final static String name = "Duckburg Dollars";
    private final static String shortName = "D$";

    private final static int fractionSize = 2; //How many decimals of little monies make one big money
    private static final DecimalFormat decimalFormat;

    static {
        decimalFormat = decimalFormat();
    }

    /**
     * dynamically tie decimalFormat to fractionSize (how many decimals to show when talking about money).
     * @return returns correct DecimalFormat object for the fractionSize variable given in class field.
     */
    private static DecimalFormat decimalFormat() {
        return new DecimalFormat("#." + "#".repeat(fractionSize));
    }

    private long amount;

    public Money(double amount){
        this.amount = convertFromDouble(amount);
    }

    public static String getSymbol() {
        return shortName;
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

    /**
     * parse a double into a readable money format
     * @param d amount of money (double)
     * @return amount of money ("readable")
     */
    public static String parseMoney(double d){
        return decimalFormat.format(d);
    }

    public static int getFractions() {
        return fractionSize;
    }

    public void setAmount(double d){
        amount = convertFromDouble(d);
    }

    /**
     *
     * Convert double to long
     *
     * @param d double to convert to "money long"
     * @return converts double to an integer (long)
     */
    private long convertFromDouble(double d){
        for(int i = 0; i < fractionSize; i++){
            d = d*10;
        }
        return (long)d;
    }

}
