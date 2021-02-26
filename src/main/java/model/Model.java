package model;

import controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private Controller controller;
    private List<Loan> loans = new ArrayList<>();

    public Model() {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void addLoans(List<Loan> loans) {
        this.loans.addAll(loans);
    }
}
