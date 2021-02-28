package model;

public class Loan {


    private final String customer;
    private final double totalLoan;
    private final double interest;
    private final int months;
    private final boolean plural;

    /**
     * Loan object for this use-case
     * @param customer name or names (with "and" seperating) of customer(s)
     * @param totalLoan size of loan
     * @param interest monthly (or "N") interest in decimal format (0.05 = 5%)
     * @param months amount of payments (in months/N)
     * @param plural should we use plural or singular verb when discussing the customer(s)?
     */
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


    public String pluralWants() {
        if(plural){
            return "want";
        }
        return "wants";
    }

    /* example
    public String pluralHas() {
        if(plural){
            return "have";
        }
        return "has";
    }*/

    public double getYears() {
        return months/((double)12);
    }
}
