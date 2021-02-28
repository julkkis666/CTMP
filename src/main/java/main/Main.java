package main;

import controller.CSVReader;
import controller.Controller;
import controller.MortageFormula;
import model.Loan;
import model.Model;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args){



        Model model = new Model();
        Controller controller = new Controller(model);

        String pathname = "src\\main\\resources\\prospects.txt";
        if (args.length >= 1){
            pathname = args[0];
        }
        controller.readData(new File(pathname));

        List<Loan> myLoans = new ArrayList<>();
        myLoans.add(new Loan("bob tester 1", 30000, 0.2, 30, false));


        model.addLoans(myLoans);

        List<String> results = controller.calculateE(model.getLoans());
        String seperatorString = "\n****************************************************************************************************\n";
        String myString = seperatorString;
        for(String result : results){
            myString += result+seperatorString;
        }


        JOptionPane.showMessageDialog(null,myString);


    }
}
