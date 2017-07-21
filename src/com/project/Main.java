package com.project;

import com.project.model.Model;
import com.project.view.View;
import com.project.view.View2;

public class Main {

    public static void main(String[] args) {                //Основная com функция

        View view = new View();
        View2 view2 = new View2();
        Model model = Model.getInstance();
        model.register(view2);
        model.register(view);
        view.start();
        
    }
}
