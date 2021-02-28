package main;

import controller.Controller;
import model.Model;

import javax.swing.*;
import java.io.File;
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

        List<String> results = controller.calculateE(model.getLoans());
        String seperatorString = "\n****************************************************************************************************\n";
        StringBuilder myString = new StringBuilder(seperatorString);
        for(String result : results){
            myString.append(result).append(seperatorString);
        }


        JOptionPane.showMessageDialog(null, myString.toString());


    }
}
