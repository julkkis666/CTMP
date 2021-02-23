package controller;

import model.Model;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
        model.setController(this);

        start();
    }

    private void start() {
        //readData();
    }
}
