package controller;

public class MortageFormula {

    public static double calculateE(double interest, double TotalLoan, int numPayments){
        return TotalLoan*(interest*pow((1+interest),numPayments))/(pow((1+interest),numPayments)-1);
    }

    /**
     * custom power of function because no math libraries are allowed.
     * @param x x to the power of y
     * @param y x to the power of y
     * @return returns x^y
     */
    public static double pow(double x, int y){
        double pow = x;
        if (y == 0){
            return 1;
        }
        if (y == 1){
            return x;
        }
        y--;
        for(int i = 0; i < y; i++){ //TODO: sligth Float inacuaracy here prob.
            pow = pow * x;
        }
        return pow;
    }

}
