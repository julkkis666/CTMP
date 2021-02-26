package controller;

import model.Model;

import java.io.File;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
        model.setController(this);

        start();
    }

    private void start() {
        readData(new File("porisoects.txt"));
    }

    private void readData(File file) {
        model.addLoans(CSVReader.readLoansWithHeader(file));
    }
}
