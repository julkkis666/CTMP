package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final List<Loan> loans = new ArrayList<>();

    public Model() {
    }


    public void addLoans(List<Loan> loans) {
        this.loans.addAll(loans);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
