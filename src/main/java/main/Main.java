package main;

import controller.CSVReader;
import controller.Controller;
import controller.MortageFormula;
import model.Model;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class Main {



    public static void main(String[] args){



        Model model = new Model();
        Controller controller = new Controller(model);



        controller.readData(new File("src\\main\\resources\\prospects.txt"));



        List<String> results = controller.calculateE(model.getLoans());
        String myString = "";
        for(String result : results){
            myString += result+"\n";
        }


        JOptionPane.showMessageDialog(null,myString);


    }
}
