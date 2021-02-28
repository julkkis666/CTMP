package model;

import controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Loan> loans = new ArrayList<>();

    public Model() {
    }


    public void addLoans(List<Loan> loans) {
        this.loans.addAll(loans);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
