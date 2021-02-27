package model;

public class Loan {


    private final String customer;
    private final double totalLoan;
    private final double interest;
    private final int months;
    private final boolean plural;

    public Loan(String customer, double totalLoan, double interest, int months, boolean plural) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.months = months;
        this.plural = plural;
    }

    public String getCustomer() {
        return customer;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public int getMonths() {
        return months;
    }


    public String pluralHas() {
        if(plural){
            return "have";
        }
        return "has";
    }
}
