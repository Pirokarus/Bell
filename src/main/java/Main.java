package main.java;


import main.java.model.Model;
import main.java.view.View;

public class Main {

    public static void main(String[] args) {                //Основная main функция

        View view = new View();
        Model model = Model.getInstance();
        model.register(view);
        model.downloadData();
        
    }
}
