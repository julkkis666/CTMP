package main;

import controller.Controller;
import controller.MortageFormula;
import model.Model;

public class Main {



    public static void main(String[] args){



        Model model = new Model();
        Controller controller = new Controller(model);


        System.out.println("calcing power");
        double power = MortageFormula.pow(-10.5, 2);

        System.out.println(power);

/*      Move this to an unit test
        System.out.println("calcing power");
        double power = MortageFormula.pow(10.5, 2);

        System.out.println(power);
*/
    }
}
