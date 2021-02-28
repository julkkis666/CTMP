package controller;

import model.Loan;
import model.Model;
import model.Money;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
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
        int prospectNum = 1;
        for(Loan loan : loans){

            results.add("Prospect "+prospectNum++ +": "+loan.getCustomer()+" "+loan.pluralWants()+
                    " to borrow "+
                    Money.parseMoney(
                            loan.getTotalLoan()
                                     )+
                    " "+Money.getSymbol()+" for a period of "+loan.getYears()+" years and pay "
                    +Money.parseMoney(
                            MortageFormula.calculateE(loan.getInterest(),loan.getTotalLoan(),loan.getMonths())
                                      )+
                    " "+Money.getSymbol()+" each month");
        }
        return results;
    }



}
