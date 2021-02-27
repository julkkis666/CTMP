package controller;

import model.Loan;
import model.Model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
        model.setController(this);
    }

    public void readData(File file) {
        model.addLoans(CSVReader.readLoansWithHeader(file));
    }

    /**
     * calculate fixed monthly payment and return list of answers for given loans
     * @param loans loans to calculate
     * @return string list of customer loan fixed monthly payment
     * */
    public List<String> calculateE(List<Loan> loans) {
        List<String> results = new LinkedList<>();
        for(Loan loan : loans){

            results.add(loan.getCustomer()+" "+loan.pluralHas()+" a loan that would have the following fixed monthly payment: "+MortageFormula.calculateE(loan.getInterest(),loan.getTotalLoan(),loan.getMonths()));
        }
        return results;
    }
}
