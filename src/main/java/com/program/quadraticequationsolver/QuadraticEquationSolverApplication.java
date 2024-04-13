package com.program.quadraticequationsolver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class QuadraticEquationSolverApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        QuadraticEquationSolverCalculator quadraticEquationSolverCalculator = new QuadraticEquationSolverCalculator();
        QuadraticEquationSolverView quadraticEquationSolverView = new QuadraticEquationSolverView();
        QuadraticEquationSolverController quadraticEquationSolverController = new QuadraticEquationSolverController(quadraticEquationSolverCalculator, quadraticEquationSolverView);
        quadraticEquationSolverController.initView();
        quadraticEquationSolverController.initController();
        Scene scene = new Scene(quadraticEquationSolverView.getRoot());
        stage.setTitle("Quadratic Equation");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}