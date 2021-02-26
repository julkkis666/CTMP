package model;

public class Loan {


    private final String customer;
    private final double totalLoan;
    private final double interest;
    private final int months;

    public Loan(String customer, double totalLoan, double interest, int months) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.months = months;
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


}
