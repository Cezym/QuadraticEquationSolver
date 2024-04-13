package com.program.quadraticequationsolver;

import javafx.event.ActionEvent;

public class QuadraticEquationSolverController {
    private final QuadraticEquationSolverView view;
    private final QuadraticEquationSolverCalculator quadraticEquationSolverCalculator;

    public QuadraticEquationSolverController(QuadraticEquationSolverCalculator quadraticEquationSolverCalculator, QuadraticEquationSolverView view) {
        this.view = view;
        this.quadraticEquationSolverCalculator = quadraticEquationSolverCalculator;
    }

    public void initView() {
        view.getSolve().setText("_Solve");
        view.getSolve().setMnemonicParsing(true);

        view.getClear().setText("_Clear");
        view.getClear().setMnemonicParsing(true);
    }

    public void initController() {

        quadraticEquationSolverCalculator.initEqCalculator(view.getA().textProperty(), view.getB().textProperty(), view.getC().textProperty());

        view.getA().setText("");
        view.getB().setText("");
        view.getC().setText("");

        view.getSolve().addEventHandler(ActionEvent.ACTION, actionEvent -> {
            String numReg = "^(-|)\\d+$";

            if (!view.getA().getText().matches(numReg) || !view.getB().getText().matches(numReg) || !view.getC().getText().matches(numReg)) {

                view.getControls().setText("Number format error!");
                view.getControls().setStyle("-fx-text-fill: black; -fx-background-color: red;");
                return;
            }

            if (view.getA().getText().matches("^(-|)0+$")) {
                view.getControls().setText("Not a quadratic equation!");
                view.getControls().setStyle("-fx-text-fill: black; -fx-background-color: red;");
                return;
            }

            view.getControls().setStyle("-fx-text-fill: blue; -fx-background-color: white;");
            view.getControls().setText(quadraticEquationSolverCalculator.getAnswers());

        });

        view.getClear().addEventHandler(ActionEvent.ACTION, actionEvent -> {
            view.getA().setText("");
            view.getB().setText("");
            view.getC().setText("");
            view.getControls().setText("");
            view.getControls().setStyle("-fx-text-fill: black; -fx-background-color: white;");
        });

    }

}
